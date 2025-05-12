package com.vcube.controller;

import java.io.IOException;

import com.vcube.DAO.BookDAO;
import com.vcube.Model.Book;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/editBook")
public class BookEdit extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		BookDAO dao=new BookDAO();
		Book book = dao.getBookById(id);
		req.setAttribute("book", book);
		RequestDispatcher rd = req.getRequestDispatcher("editbook.jsp");
		rd.forward(req, resp);
	}
	
}
