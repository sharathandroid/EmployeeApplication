package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.EmployeeDAO.Employee;
import org.EmployeeService.EmployeeService;

/**
 * Servlet implementation class EmployeeGet
 */
public class EmployeeGet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeService service;
    HttpSession session ; 

       
    /**
     * @throws SQLException 
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeGet() throws SQLException {
        super();
        // TODO Auto-generated constructor stub
        service=new EmployeeService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			session=request.getSession();
		     String employeeId=request.getParameter("employeeId"); 
		    Employee employee=service.getEmployeeInfo(Integer.parseInt(employeeId));		   
		    request.getSession().setAttribute("Employee", employee);
		    RequestDispatcher rd = request.getRequestDispatcher("EmployeeDetails.jsp");
		    rd.forward(request, response);

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	     int employeeId=Integer.parseInt(request.getParameter("EmployeeId")); 
	     String FirstName=request.getParameter("FirstName");
	     String LastName=request.getParameter("LastName");
	     String Gender=request.getParameter("Gender");
	     String BirthDate=request.getParameter("BirthDate");
	     String HireDate=request.getParameter("HireDate");
	     int salary=Integer.parseInt(request.getParameter("Salary"));
	     
	     java.util.Date bd = null;
	     java.util.Date hd = null;
		try {
			bd = format.parse(BirthDate);
			hd = format.parse(HireDate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	     java.sql.Date birthDate = new java.sql.Date(bd.getTime());
	     java.sql.Date hireDate = new java.sql.Date(hd.getTime());
		if (request.getParameter("Add") != null) {
		    // Add button pressed.
		try {
			service.addEmpInfo(employeeId,FirstName,LastName,Gender,birthDate,hireDate,salary);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session=request.getSession();
	    Employee employee = null;
		try {
			employee = service.getEmployeeInfo(employeeId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		   
	    request.getSession().setAttribute("Employee", employee);
	    RequestDispatcher rd = request.getRequestDispatcher("EmployeeDetails.jsp");
	    rd.forward(request, response);    
		} 
		else if (request.getParameter("Update") != null) {
		    try {
				service.updateEmpInfo(employeeId,FirstName,LastName,Gender,birthDate,hireDate);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			session=request.getSession();
		    Employee employee = null;
			try {
				employee = service.getEmployeeInfo(employeeId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		   
		    request.getSession().setAttribute("Employee", employee);
		    RequestDispatcher rd = request.getRequestDispatcher("EmployeeDetails.jsp");
		    rd.forward(request, response); 
		}
	}
}
