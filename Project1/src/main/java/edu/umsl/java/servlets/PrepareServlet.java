package edu.umsl.java.servlets;

import java.io.IOException;
//import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PrepareServlet
 */
@WebServlet("/prepare")
public class PrepareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrepareServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
      

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		//creating ServletContext object 
	    ServletContext ctx = this.getServletContext();
	    
	    
	    //Getting the value of the initialization parameter and printing it  
	    String cityName = ctx.getInitParameter("cities");  
	    String taxRate = ctx.getInitParameter("tax rates");
	    
	    //All Param-value in web.xml file are in the cityArr and taxArr
	    String[] cityArr = cityName.split(",");
	    String[] taxArr = taxRate.split(",");
	    
	   
		List<String> citylist = new ArrayList<String>();
		List<Double> ratelist = new ArrayList<Double>();
		
		 
		
		//JavaBean constructor.Can call constructor directly since they are in the same package
		CityBean cityRate = new CityBean();
		
		for (int i = 0; i < cityArr.length; i++) {
			citylist.add(cityArr[i]);
			
			try {
				
				//returns the double value represented by the string argument
				double rates = Double.parseDouble(taxArr[i]);
				ratelist.add(rates);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//Store two list objects in the JavaBean
	 	cityRate.setCities(citylist);
		cityRate.setTaxRates(ratelist);
		
		HttpSession session = request.getSession();
		 session.setAttribute("citylist1", citylist);
         session.setAttribute("ratelist1", ratelist);
        
		
		//Store them in the request scope
		request.setAttribute("cityRate", cityRate);
		
		//Check what version the user's operating system is
		String clientOS = request.getHeader("User-Agent");
		String os = "";
			
     	response.setContentType("text/html");
		
		if (clientOS.contains("Windows"))
			os = "Windows";
		else
			os = "Mac";
		
		request.setAttribute("client", os);
		
		
		//Do Forward in a servlet to display the data
		RequestDispatcher view = request.getRequestDispatcher("input.jsp");
		
		view.forward(request, response);
	
	}

  
	

}


