<%@page import="com.vcube.Model.Student"%>
<%@ page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Student List</title>
<!-- Bootstrap for styling -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
<!-- Font Awesome for icons -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">

<style>
body {
	background-color: #f8f9fa;
	background-image: url('https://as2.ftcdn.net/v2/jpg/12/32/12/27/1000_F_1232122776_b5Aza3sbMTUsi4q8jshLR6HfeZIRENb3.jpg'); /* Add your image URL here */
	background-size: cover; /* Ensures the image covers the whole page */
	background-position: center center; /* Centers the image */
	background-attachment: fixed; /* Makes the background image fixed while scrolling */
}

.table-container {
	margin: 50px auto;
	width: 80%;
}

table {
	background: white;
	border-radius: 10px;
	overflow: hidden;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

th {
	background: #007bff;
	color: white;
	text-align: center;
}

td {
	text-align: center;
	vertical-align: middle;
}

.action-icons i {
	cursor: pointer;
	padding: 5px;
	font-size: 18px;
}

.edit-icon {
	color: #ffc107;
}

.delete-icon {
	color: #dc3545;
}

.no-data {
	text-align: center;
	font-size: 18px;
	color: #6c757d;
	padding: 20px;
}
</style>

<script>
	function confirmDelete(url) {
		if (confirm("Do you really want to delete this student?")) {
			window.location.href = url;
		}
	}
</script>
</head>
<body>

	<div class="table-container">
		<h2 class="text-center text-primary">Student List</h2>
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>Name</th>
					<th>Email</th>
					<th>Course</th>
					<th>Phone No</th>
					<th>Enrollment No</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<%
				List<Student> students = (List<Student>) request.getAttribute("allstu");
				if (students == null || students.isEmpty()) {
				%>
				<tr>
					<td colspan="6" class="no-data">No students available</td>
				</tr>
				<%
				} else {
				for (Student stu : students) {
					String deleteUrl = "deleteStudent?id=" + stu.getId();
				%>
				<tr>
					<td><%=stu.getName()%></td>
					<td><%=stu.getEmail()%></td>
					<td><%=stu.getCourse()%></td>
					<td><%=stu.getPhoneno()%></td>
					<td><%=stu.getEnrollmentNo()%></td>
					<td class="action-icons">
						<!-- Edit Button --> <a href="editStudent?id=<%=stu.getId()%>"
						class="edit-icon"><i class="fas fa-edit"></i></a> <!-- Delete Button with Correct URL -->
						<a href="javascript:void(0);" class="delete-icon"
						onclick="confirmDelete('<%=deleteUrl%>')"> <i
							class="fas fa-trash"></i>
					</a>
					</td>
				</tr>
				<%
				}
				}
				%>
			</tbody>
		</table>
	</div>

</body>
</html>
