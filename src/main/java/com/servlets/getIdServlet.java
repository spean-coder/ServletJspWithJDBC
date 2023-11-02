package com.servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.jdbc.Employee;
import com.jdbc.EmployeeDao;

import jakarta.servlet.RequestDispatcher;

/**
 * Servlet implementation class getIdServlet
 */
@WebServlet("/getId")
public class getIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		int empId = Integer.parseInt(req.getParameter("empid"));
		
		EmployeeDao dao = new EmployeeDao();
		Employee e = dao.getEmployee(empId);
		
		req.setAttribute("employeeDetails", e);
		
		RequestDispatcher rd = req.getRequestDispatcher("showdetails.jsp");
		rd.forward(req, res);
		
		
		
		
		
		
	}

}
