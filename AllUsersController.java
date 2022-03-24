package com.alom.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alom.dao.EmployeeDao;
import com.alom.model.Employee;

@WebServlet("/AllUsersController")
public class AllUsersController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out= res.getWriter();
		
		try {
			EmployeeDao employeeDao = new EmployeeDao();
			List<Employee> employees = employeeDao.findAllRecord();
			if(employees !=null) {
				req.setAttribute("usersList", employees);
				RequestDispatcher rd = req.getRequestDispatcher("AllUsersView");
				rd.forward(req, res);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

}
