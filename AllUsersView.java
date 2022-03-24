package com.alom.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alom.model.Employee;

@WebServlet("/AllUsersView")
public class AllUsersView extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		List<Employee> list = (ArrayList<Employee>) req.getAttribute("usersList");
		Iterator<Employee> itr = list.iterator();
		out.println("<h1 align='center'>User Names List</h1>");
		out.println("<table align='center' border='1'><tr><th>Username</th><th>Password</th>");
		while(itr.hasNext()) {
			Employee employee = itr.next();
			out.println("<tr><td>"+employee.getUserName()+"</td>");
			out.println("<td>"+employee.getUserPassword()+"</td></tr><br>");
		}
		out.println("</table>");
		out.println("<a href='AllUsersController'>Refresh Users</a>");
	}
	
//ServletAttribute
}
