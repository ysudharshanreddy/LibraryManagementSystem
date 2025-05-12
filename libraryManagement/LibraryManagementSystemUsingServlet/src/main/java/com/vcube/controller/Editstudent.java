package com.vcube.controller;

import java.io.IOException;

import com.vcube.DAO.StudentDAO;
import com.vcube.Model.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/editStudent")
public class Editstudent extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		StudentDAO dao=new StudentDAO();
		
		Student student = StudentDAO.getStudentById(id);
		req.setAttribute("student", student);
		RequestDispatcher rd = req.getRequestDispatcher("studenteditpage.jsp");
		rd.forward(req, resp);
	}
}
