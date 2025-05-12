package com.vcube.controller;
import java.io.IOException;
import com.vcube.DAO.StudentDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteStudent")
public class DeleteStudent extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        StudentDAO dao = new StudentDAO();
        dao.deleteStudent(id);

        // Redirect back to the student list page
        resp.sendRedirect("getallstudents");
    }
}
