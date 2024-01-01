package edu.umsl.java.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/decompose")
public class DecomposeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DecomposeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String mybig = request.getParameter("bigint");
    	Map<BigInteger,Integer> pf = factorizeprime(new BigInteger(mybig));
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
			
		// Get a set of the entries
	    Set set = pf.entrySet();
	      
	    // Get an iterator	      
	    Iterator i = set.iterator();
	      
	    // Display elements
	    out.print(mybig + "= ");
	      
	    int count = 1;
	    while(i.hasNext()) {
	       Map.Entry me = (Map.Entry)i.next();
	         out.println("(" + me.getKey() + ",");
	     	 out.println(me.getValue() + ")-");
	      }
		
	    // convert keySet into ArrayList
	    List<BigInteger> ranks = new ArrayList<BigInteger>(pf.keySet());
	 
	    String firstEntry = null, lastEntry = null;
	        
	    // get firstEntry & lastEntry
	    if(!ranks.isEmpty() && ranks.size() > 0) {
	 
	       // find first entry
	       firstEntry = ranks.get(0) + "=" + pf.get(ranks.get(0)); 
	       // find last entry
	       lastEntry = ranks.get(ranks.size() - 1) + "="
	                    + pf.get(ranks.get(ranks.size() - 1));
	        }
	        out.println('\n');
	     
	     //	out.println("First entry in the Map is " + firstEntry);
         // out.println("Last entry in the Map is " + lastEntry);
	        
	     String lastvalue =lastEntry.substring(0, lastEntry.indexOf("="));
         // out.println("lastvalue = " + lastvalue);
	        
	     String lasttwodigit = lastvalue.substring(lastvalue.length()-2);
	      
	     //Convert two last digits to double
	     double sc = Double.parseDouble(lasttwodigit);
	                  
	     HttpSession session = request.getSession();
	     session.setAttribute("sc", sc);
	      	          
	   //  request.setAttribute("sc", sc);
	     out.println("sc=" + sc);
	         
		out.flush();
		out.close();
		
		
		
	}
	
	private Map<BigInteger,Integer> factorizeprime(BigInteger n) {
		
		Map<BigInteger,Integer> factors = new LinkedHashMap<>();
	        
	    System.out.print(n + "= (");
	    
		BigInteger squareroot = n.sqrt();
		BigInteger three = BigInteger.valueOf(3);
		BigInteger two = BigInteger.valueOf(2);
		BigInteger one = BigInteger.valueOf(1);
		
		int power = 0;
		while (n.mod(two).compareTo(BigInteger.ZERO) == 0) {
			power++;
			n = n.divide(two);
		}
		
		if ( power >= 1 ) {
	     	factors.put(two,power);
	    }
		
		for (BigInteger i = three; i.compareTo(squareroot) <= 0; i = i.add(two)) {
			power = 0;
			if (n.mod(i).compareTo(BigInteger.ZERO) == 0) {
				while (n.mod(i).compareTo(BigInteger.ZERO) == 0) {
					power++;
					n = n.divide(i);
				}
		//	    System.out.print(i);
			
			    if ( power >= 1 ) {
			     	factors.put(i,power);
			    }
			}
		}
	//   if (BigInteger.valueOf(n).isProbablePrime()) {	
			if (n.compareTo(one) == 1) {
			    factors.put(n,1);
		//	    break;
			}
			
			return factors;
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
