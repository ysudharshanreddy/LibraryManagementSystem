package com.vcube.controller;
import java.io.IOException;
import com.vcube.DAO.BookDAO;import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteBook")
public class DeleteBookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        // Call DAO to delete the book
        BookDAO dao = new BookDAO();
        dao.deleteBook(id);

        // Redirect to the book list page after deletion
        resp.sendRedirect("gettallbooks");
    }
}
