package com.vcube.controller;

import java.io.IOException;

import com.vcube.DAO.BookDAO;
import com.vcube.Model.Book;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/savebook12")
public class BookRegister extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String bookname = req.getParameter("name");
		String bookid = req.getParameter("bookid");
		String bookauthor = req.getParameter("bookauthor");
		String booksubject = req.getParameter("booksubject");

		// Create Book object and set data
		Book book = new Book(bookname, bookid, bookauthor, booksubject);
		
		// Call DAO to insert the book
		BookDAO dao = new BookDAO();
		boolean result = dao.addBook(book);

		// Redirect or show success message based on result 
		if (result) {
			resp.sendRedirect("gettallbooks"); // Redirect to list of books after successful registration
		} else {
			resp.getWriter().println("Error registering book.");
		}
	}
}
