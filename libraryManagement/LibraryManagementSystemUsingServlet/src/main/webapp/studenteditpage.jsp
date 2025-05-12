 <!-- Update with your package name -->
<%@page import="com.vcube.Model.Student"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Student</title>
    <!-- Add Bootstrap for styling -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    
    <style>
        body {
            background-color: #f8f9fa;
        }
        .container {
            max-width: 600px;
            margin-top: 50px;
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        .btn-container {
            display: flex;
            justify-content: space-between;
        }
    </style>
</head>
<body>

<%
    Student student = (Student) request.getAttribute("student");
%>

<div class="container">
    <h2 class="text-center text-primary">Edit Student</h2>
    <form action="updateStudent" method="post">
        <!-- Hidden ID Field -->
        <input type="hidden" name="id" value="<%= student.getId() %>">
        
        <div class="mb-3">
            <label class="form-label">Name:</label>
            <input type="text" class="form-control" name="name" value="<%= student.getName() %>" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Email:</label>
            <input type="email" class="form-control" name="email" value="<%= student.getEmail() %>" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Course:</label>
            <input type="text" class="form-control" name="course" value="<%= student.getCourse() %>" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Phone No:</label>
            <input type="text" class="form-control" name="phoneno" value="<%= student.getPhoneno() %>" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Enrollment No:</label>
            <input type="text" class="form-control" name="enrollmentNo" value="<%= student.getEnrollmentNo() %>" required>
        </div>

        <div class="btn-container">
            <button type="submit" class="btn btn-primary">Update</button>
            <a href="getallstudents" class="btn btn-secondary">Cancel</a>
        </div>
    </form>
</div>

</body>
</html>
