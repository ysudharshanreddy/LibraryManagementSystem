package com.vcube.controller;
import java.io.IOException;
import java.util.List;

import com.vcube.DAO.BookDAO;
import com.vcube.DAO.StudentDAO;
import com.vcube.Model.Book;
import com.vcube.Model.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/checkstudentlogin")
public class StudentLogincontroller extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("name");
		String password = req.getParameter("password");
		StudentDAO dao=new StudentDAO();
		 Student student = dao.select(email, password);
		BookDAO bookDAO = new BookDAO();
		if(student!=null) {
			RequestDispatcher rd = req.getRequestDispatcher("Userhome.jsp");
			List<Book> allBooks = bookDAO.getAllBooks();
			req.setAttribute("allbooks",allBooks);
			req.setAttribute("student",student);
			
			rd.forward(req, resp);
		}
		else {
			RequestDispatcher rd = req.getRequestDispatcher("StudentLoginfor.html");
			rd.forward(req, resp);
		}
	}
}
