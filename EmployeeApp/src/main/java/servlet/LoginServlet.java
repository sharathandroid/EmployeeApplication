package servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {

 HashMap<String,String> userMap=new HashMap<String, String>(); 
public void doPost(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, java.io.IOException {

	try
	{	    
		userMap.put("sharath", "sharath7");
		userMap.put("test", "test1234");
		userMap.put("test2", "test1234");

	     String user=request.getParameter("username"); 
	     String password=request.getParameter("pwd");

		   		    
	     if (userMap.get(user) != null && userMap.get(user).equals(password))
	     {
		        
	          HttpSession session = request.getSession(true);	    
	      //    session.setAttribute("currentSessionUser",user); 
	          response.sendRedirect("EmployeeGet.jsp"); //logged-in page      		
	     }
		        
	     else 
	    	 response.setContentType("text/html");
			response.getWriter()
				.append("<html> <body>")
				.append("Invalid User")
				.append("</body></html>"); //error page 
	} 
			
			
	catch (Throwable theException) 	    
	{
	     System.out.println(theException); 
	}
       }
	}