package com.alom.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ErrorPage")
public class ErrorPage extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		 PrintWriter out = res.getWriter();
		 out.println("<h1>Error: Check your Username or Password!</h1>");
		 RequestDispatcher rd = req.getRequestDispatcher("index.html");
			rd.include(req, res);
	}
}
