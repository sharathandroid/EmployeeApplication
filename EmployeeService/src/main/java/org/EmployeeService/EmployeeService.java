package org.EmployeeService;

import java.sql.Date;
import java.sql.SQLException;

import org.EmployeeDAO.Employee;
import org.EmployeeDAO.EmployeeOperations;
import org.EmployeeDAO.EmployeeOperationsImpl;

public class EmployeeService{
	EmployeeOperations employeeOperations;
	public EmployeeService() throws SQLException{
		employeeOperations	=new EmployeeOperationsImpl();

	}
	
	public Employee getEmployeeInfo(int empNo) throws SQLException{
		Employee emp=employeeOperations.getEmployee(empNo );
		return emp;
		
	}

	public void addEmpInfo(int employeeId, String firstName, String lastName, String gender, Date birthDate,
			Date hiredDate, int salary) throws SQLException {
		// TODO Auto-generated method stub
		employeeOperations.addEmployee(employeeId, firstName, lastName, gender, birthDate, hiredDate, salary);
		
	}

	public void updateEmpInfo(int employeeId, String firstName, String lastName, String gender, Date birthDate,
			Date hireDate) throws SQLException {
		// TODO Auto-generated method stub
		employeeOperations.updateEmployee(employeeId,firstName,lastName,gender,birthDate,hireDate );
	}

}
