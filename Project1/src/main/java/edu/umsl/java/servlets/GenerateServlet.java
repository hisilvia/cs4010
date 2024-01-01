package edu.umsl.java.servlets;

import java.io.IOException;
import java.math.BigInteger;
import java.io.PrintWriter;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/generate")
public class GenerateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GenerateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");
		PrintWriter out = response.getWriter();
    	
    	BigInteger crtbig = generateBigIntegerWithNumberofDigits(16);
		
    	// Create a Session object and store it
    	 
    	  HttpSession session = request.getSession();
    	  session.setAttribute("originalmybig", crtbig);
    	
    	
    	
		
		
		out.println(crtbig);
		out.flush();
		out.close();
		
	}

	private BigInteger generateBigIntegerWithNumberofDigits(int n) {
		BigInteger mybigint = null;
		
		//Generate the first digit random number from 1 to 9
		int fdigitrand = (int) (Math.random() * 9 + 1);
		
		if ( n > 0) {
			mybigint = new BigInteger("" + fdigitrand);
			
			//Generate the remain digit random numbers
			for (int i = 1; i < n; i++) {
				int rdigitrand = (int) (Math.random() * 10);
				
				BigInteger big1 = new BigInteger("" + rdigitrand);
				
				//Every digit of displacement
				mybigint = mybigint.multiply(new BigInteger("10"));
				mybigint = mybigint.add(big1);
			}
		}else {
			mybigint = new BigInteger("0");
		}		
		
		return mybigint;
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
