<%@ page import="java.util.List" %>
<%@ page import="com.vcube.Model.Book" %>
<%@ page import="com.vcube.Model.Student" %>
<%
    List<Book> books = (List<Book>) request.getAttribute("allbooks");
    Student student = (Student) request.getAttribute("student");
    if (student == null) {
        student = (Student) session.getAttribute("student");  // Attempt to get from session if not found in request
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>User Home</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    <style>
        body {
            background: linear-gradient(to right, #e0f7fa, #e1bee7);
            font-family: 'Segoe UI', sans-serif;
        }
        .navbar {
            background: linear-gradient(to right, #007bff, #6610f2);
        }
        .card {
            border: none;
            border-radius: 16px;
            transition: all 0.3s ease;
        }
        .card:hover {
            transform: translateY(-8px) scale(1.03);
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.3);
            background: linear-gradient(to bottom right, #f8bbd0, #e1bee7);
        }
        .modal-content {
            border-radius: 15px;
            background: linear-gradient(to bottom, #ffffff, #f0f0f0);
        }
        .btn-profile, .btn-edit {
            background-color: #fff;
            color: #333;
            border: none;
        }
        .btn-profile:hover, .btn-edit:hover {
            background-color: #e6e6e6;
        }
    </style>
</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#"><i class="fas fa-book-reader"></i> Library Portal</a>
        <div class="ms-auto d-flex align-items-center">
            <% if (student != null) { %>
                <span class="text-white me-3"><i class="fas fa-user"></i> <%= student.getName() %></span>
                <button class="btn btn-profile me-2" data-bs-toggle="modal" data-bs-target="#profileModal">
                    <i class="fas fa-id-card"></i> Profile
                </button>
            <% } else { %>
                <span class="text-white me-3">No user logged in</span>
            <% } %>
            <a class="btn btn-danger" href="StudentLoginfor.html"><i class="fas fa-sign-out-alt"></i> Logout</a>
        </div>
    </div>
</nav>

<!-- Profile Modal -->
<% if (student != null) { %>
<div class="modal fade" id="profileModal" tabindex="-1">
  <div class="modal-dialog modal-dialog-end">
    <div class="modal-content shadow">
      <div class="modal-header">
        <h5 class="modal-title"><i class="fas fa-user-circle"></i> Your Profile</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>
      <div class="modal-body">
        <p><strong>Name:</strong> <%= student.getName() %></p>
        <p><strong>Email:</strong> <%= student.getEmail() %></p>
        <p><strong>Phone:</strong> <%= student.getPhoneno() %></p>
        <p><strong>Course:</strong> <%= student.getCourse() %></p>
        <p><strong>Enrollment No:</strong> <%= student.getEnrollmentNo() %></p>
        <button class="btn btn-edit mt-3" data-bs-toggle="modal" data-bs-target="#editModal">
            <i class="fas fa-edit"></i> Edit Profile
        </button>
      </div>
    </div>
  </div>
</div>
<% } %>

<!-- Edit Profile Modal -->
<% if (student != null) { %>
<div class="modal fade" id="editModal" tabindex="-1">
  <div class="modal-dialog">
    <div class="modal-content shadow">
      <div class="modal-header bg-primary text-white">
        <h5 class="modal-title"><i class="fas fa-user-edit"></i> Edit Your Profile</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>
      <form action="updatestudent" method="post">
        <div class="modal-body">
          <input type="hidden" name="id" value="<%= student.getId() %>">
          <div class="mb-3">
            <label class="form-label">Name</label>
            <input name="name" class="form-control" value="<%= student.getName() %>" required>
          </div>
          <div class="mb-3">
            <label class="form-label">Email</label>
            <input name="email" class="form-control" value="<%= student.getEmail() %>" required>
          </div>
          <div class="mb-3">
            <label class="form-label">Phone</label>
            <input name="phoneno" class="form-control" value="<%= student.getPhoneno() %>" required>
          </div>
          <div class="mb-3">
            <label class="form-label">Course</label>
            <input name="course" class="form-control" value="<%= student.getCourse() %>" required>
          </div>
          <div class="mb-3">
            <label class="form-label">Enrollment No</label>
            <input name="enrollment" class="form-control" value="<%= student.getEnrollmentNo() %>" required>
          </div>
          <div class="mb-3">
            <label class="form-label">Password</label>
            <input name="password" class="form-control" type="password" value="<%= student.getPassword() %>" required>
          </div>
        </div>
        <div class="modal-footer">
          <button type="submit" class="btn btn-success"><i class="fas fa-save"></i> Save Changes</button>
        </div>
      </form>
    </div>
  </div>
</div>
<% } %>

<!-- Book List -->
<div class="container mt-5">
    <div class="row">
        <% if (books != null && !books.isEmpty()) { %>
            <% for(Book book : books) { %>
            <div class="col-md-4 col-lg-3 mb-4">
                <div class="card shadow-sm">
                    <div class="card-body">
                        <h5 class="card-title text-primary"><i class="fas fa-book"></i> <%= book.getBookname() %></h5>
                        <p class="card-text">Author: <%= book.getBookauthor() %></p>
                        <p class="card-text">Subject: <%= book.getBooksubject() %></p>
                        <span class="badge bg-dark">Book ID: <%= book.getBookid() %></span>
                    </div>
                </div>
            </div>
            <% } %>
        <% } else { %>
            <div class="col-12">
                <p>No books available.</p>
            </div>
        <% } %>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
