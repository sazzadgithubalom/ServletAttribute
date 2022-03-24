package com.alom.view;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

@WebServlet("/GetAttributeView")
public class GetAttributeView extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		
		//String userName = (String) req.getAttribute("userName");
	//	ServletContext sc = getServletContext();
	//	String userName =(String) sc.getAttribute("userName");
		HttpSession hs = req.getSession(false);
		String userName = (String) hs.getAttribute("userName");
		
		out.println("<h1>Hello "+userName+" Greating for You</h1>");
		out.println("<a href='index.html'>Logout</a><br>");
		out.println("<a href='AllUsersController'>Show All Users</a>");
	}
}
