package com.vcube.controller;
import java.io.IOException;
import com.vcube.DAO.StudentDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/checkadminlogin")
public class AdminLogin extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		if (email.equals("a1b2") && password.equals("12345")) {
			RequestDispatcher rd = req.getRequestDispatcher("AdminHome.html");
			rd.forward(req, resp);
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("AdminLoginpage.html");
			rd.forward(req, resp);
		}
	}
}
