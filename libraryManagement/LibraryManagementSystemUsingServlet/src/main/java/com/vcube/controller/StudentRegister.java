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

@WebServlet("/studentRegister")
public class StudentRegister  extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
		System.out.println("hello");
		String Name=request.getParameter("name");
		System.out.println(Name);
		String Email=request.getParameter("email");
		System.out.println(Email);
		String Course=request.getParameter("course");
		System.out.println(Course);
		String Phoneno=request.getParameter("phoneno");
		System.out.println(Phoneno);
		String Password=request.getParameter("password");
		System.out.println(Password);
		int EnrollmentNo=Integer.parseInt(request.getParameter("EnrollmentNo"));
		Student student = new Student(Name, Email, Course, Phoneno, Password, EnrollmentNo);
		System.out.println(EnrollmentNo);
		
		StudentDAO d= new StudentDAO();
		boolean status=d.insert(student);
		if(status) {
			System.out.println("Data inserted successfully");
			RequestDispatcher s=request.getRequestDispatcher("AdminHome.html");
			s.forward(request, responce);
			
		}else {
			System.out.println("Query failed");
			RequestDispatcher s=request.getRequestDispatcher("StudentLoginfor.html");
			s.forward(request, responce);
			
		}
	}
}
