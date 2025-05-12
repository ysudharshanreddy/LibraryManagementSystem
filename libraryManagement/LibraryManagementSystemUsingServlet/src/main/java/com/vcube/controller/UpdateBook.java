package com.vcube.controller;

import java.io.IOException;
import com.vcube.DAO.BookDAO;
import com.vcube.Model.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateBook")
public class UpdateBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bookname = req.getParameter("name");
		String bookid = req.getParameter("bookid");
		String bookauthor = req.getParameter("bookauthor");
		String booksubject = req.getParameter("booksubject");
		int id = Integer.parseInt(req.getParameter("id"));
		// Create Book object and set data
		Book book = new Book(id, bookname, bookid, bookauthor, booksubject);

		// Call DAO to insert the book
		BookDAO dao = new BookDAO();
		boolean res = dao.updateBook(book);

		resp.sendRedirect("gettallbooks");

	}
}
