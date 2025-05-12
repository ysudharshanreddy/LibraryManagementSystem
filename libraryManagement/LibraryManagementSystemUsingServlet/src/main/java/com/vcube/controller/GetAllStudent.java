package com.vcube.controller;

import java.io.IOException;
import java.util.List;

import com.vcube.DAO.StudentDAO;
import com.vcube.Model.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/getallstudents")
public class GetAllStudent extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StudentDAO dao=new StudentDAO();
		List<Student> allstudents = StudentDAO.getAllStudents();
		req.setAttribute("allstu", allstudents);
		RequestDispatcher rd = req.getRequestDispatcher("ShowallStudents.jsp");
		rd.forward(req, resp);
	}
}
