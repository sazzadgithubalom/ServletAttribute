package com.alom.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alom.dao.EmployeeDao;
import com.alom.model.Employee;
import com.alom.view.ErrorPage;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

@WebServlet("/SetAttributeController")
public class SetAttributeController extends HttpServlet{
	
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		
	
		
		String userName = req.getParameter("userName");
		String userPassword = req.getParameter("userPassword");
		
		Employee employee = new Employee();
		employee.setUserName(userName);
		employee.setUserPassword(userPassword);
		
		try {
			EmployeeDao employeeDao = new EmployeeDao();
			Employee emp = employeeDao.findRecord(employee);
		
			if(userName.equals(emp.getUserName()) && userPassword.equals(emp.getUserPassword())) {
			//	req.setAttribute("userName", userName);
			//	res.sendRedirect("GetAttributeView");
			//	ServletContext sc = getServletContext();
			//	sc.setAttribute("userName", userName);
				HttpSession hs = req.getSession(true);
				hs.setAttribute("userName",userName);
				RequestDispatcher rd = req.getRequestDispatcher("GetAttributeView");
				rd.forward(req, res);
				
			}else {
				
				RequestDispatcher rd = req.getRequestDispatcher("ErrorPage");
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
