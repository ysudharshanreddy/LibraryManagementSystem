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
@WebServlet("/update")
public class UpdateStudentServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
		//	 1. Get parameters from form
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String phone = request.getParameter("phoneno");
			String course = request.getParameter("course");
			int enrollmentNo = Integer.parseInt(request.getParameter("enrollment"));
			String password = request.getParameter("password");

			// 2. Create updated student object
			Student student = new Student();
			student.setId(id);
			student.setName(name);
			student.setEmail(email);
			student.setPhoneno(phone);
			student.setCourse(course);
			student.setEnrollmentNo(enrollmentNo);
			student.setPassword(password);

			// 3. Update student in DB
			StudentDAO std = new StudentDAO();
			boolean updated = std.updateStudent(student);

			if (updated) {
			    // 4. Fetch updated student + books and set session attribute
			    Student updatedStudent = StudentDAO.getStudentById(id);

			    // ✅ Store updated student in session
			    request.getSession().setAttribute("student", updatedStudent);

			    // Optionally, fetch books here and set it as a request attribute
			    request.setAttribute("allbooks", StudentDAO.updateStudent(updatedStudent)); // or a separate BookDAO

			    // 5. Forward to updated User Home
			    RequestDispatcher rd = request.getRequestDispatcher("Userhome.jsp");
			    rd.forward(request, response);
			}


		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("Userhome.jsp");
		}
	}
}
