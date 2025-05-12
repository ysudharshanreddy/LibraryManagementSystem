package com.vcube.controller;

import java.io.IOException;
import java.util.List;

import com.vcube.DAO.BookDAO;
import com.vcube.Model.Book;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/gettallbooks")

public class GetAllBooks extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BookDAO dao = new BookDAO();
		List<Book> allbooks = dao.getAllBooks();
		req.setAttribute("allstu", allbooks);
		RequestDispatcher rd = req.getRequestDispatcher("showallbooks.jsp");
		rd.forward(req, resp);
	}

}
