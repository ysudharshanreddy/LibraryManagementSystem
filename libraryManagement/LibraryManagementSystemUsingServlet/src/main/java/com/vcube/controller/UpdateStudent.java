package com.vcube.controller;

import java.io.IOException;
import com.vcube.DAO.StudentDAO;
import com.vcube.Model.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateStudent")
public class UpdateStudent extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String course = req.getParameter("course");
		String phoneno = req.getParameter("phoneno");
		int enrollmentNo = Integer.parseInt(req.getParameter("enrollmentNo"));
		Student updatedStudent = new Student(id, name, email, course, phoneno, phoneno, enrollmentNo);

		StudentDAO dao = new StudentDAO();
		dao.updateStudent(updatedStudent);

		// Redirect back to the student list page
		resp.sendRedirect("getallstudents");
	}
}
