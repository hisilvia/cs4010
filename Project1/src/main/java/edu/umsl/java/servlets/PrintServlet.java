package edu.umsl.java.servlets;

//import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
//import java.math.BigInteger;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class PrintServlet
 */    
@WebServlet("/printServlet")
public class PrintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrintServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// String mybig1 = request.getParameter("myresult");
        // out.println("mybig is: " + mybig1);
			
		// String mybig2 = (String)session.getAttribute("originalmybig");	
		// out.print("mybig1 is: " + mybig2);
		
		
	    // response.setContentType("text/html");
        // PrintWriter out = response.getWriter();
 
		      
           HttpSession session = request.getSession(false);
           Double sc = (Double) session.getAttribute("sc");
           
        // out.println("The Service Cost = " + sc);   
           
        // out.println("<br />");
        
           ServletContext ctx = this.getServletContext();

		   String cities = ctx.getInitParameter("cities");
		   String rates = ctx.getInitParameter("tax rates");
		
		   String city_index = request.getParameter("city");
		    
           List<Double> list = (ArrayList<Double>) session.getAttribute("ratelist1");
     
        //Get the current tax rate "ctr"
           double ctr=0.0;
           try {
        	  int idx = Integer.parseInt(city_index);
       	      ctr = list.get(idx);
           }catch (Exception e) {
        	     e.printStackTrace();
            }
           
        
        // out.println("The Tax Rate = " + ctr);
        // out.println("<br />");
        
           //Calculate the total service charge including the tax rate
           double tsc = sc + ctr;
           request.setAttribute("tsc", tsc);
        
        // out.println("The Total Service Charge = " + tsc);
			 	
	       //Store data in JavaBean
		// primeData.setServiceCost(sc);
	 	// primeData.setServiceCharge(tsc);
	 	
		   //Store them in the request scope
	 	//   request.setAttribute("primeData", primeData);
	 	   
	 	 
        // out.flush();
        // out.close();
          	  	
	 	   //Do Forward in a servlet to display the data
	 	   RequestDispatcher view = request.getRequestDispatcher("display.jsp");
	 			
	 	   view.forward(request, response);
	
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

    		doGet(request, response);
	}

}
