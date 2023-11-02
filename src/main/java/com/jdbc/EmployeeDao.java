package com.jdbc;

import java.sql.*;

public class EmployeeDao {
	String url = "jdbc:mysql://localhost:3306/companyemployee";
	String username = "root";
	String password = "Shubham@0498";

	
	public Employee getEmployee(int id) {
		Employee emp = new Employee();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement("select * from employeedetails where empId="+id);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				emp.setEmpId(rs.getInt(1));
				emp.setEmpName(rs.getString(2));
				emp.setEmpDoj(rs.getString(3));
				emp.setEmpDepartment(rs.getString(4));
				emp.setEmpSalary(rs.getInt(5));
			}
			
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		
		return emp;
		
		
		
	}

}
