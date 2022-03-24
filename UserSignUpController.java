package com.alom.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alom.dao.EmployeeDao;
import com.alom.model.Employee;


@WebServlet("/SignUpPage")
public class UserSignUpController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		
		String	username = req.getParameter("suUsername");
		String	password = req.getParameter("suPassword");
		if(username.isEmpty() || password.isEmpty()) {
			RequestDispatcher rd = req.getRequestDispatcher("ErrorPage");
			rd.forward(req, res);
		}
		else {
			Employee employee = new Employee();
			employee.setUserName(username);
			employee.setUserPassword(password);
			
			try {
				EmployeeDao employeeDao = new EmployeeDao();
			int x = employeeDao.addRecord(employee);
			if(x !=0)
				out.println("<h1>"+x+" Account Created Successfully</h1><br>");
				out.println("<a href='singuppage.html'>Create Another Account</a>");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	}


