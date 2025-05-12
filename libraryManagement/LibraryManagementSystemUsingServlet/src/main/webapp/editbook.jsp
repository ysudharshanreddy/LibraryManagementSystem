<!-- Update with your package name -->
<%@page import="com.vcube.Model.Book"%>
<%@page import="com.vcube.Model.Student"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Edit Book</title>
<!-- Add Bootstrap for styling -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">

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
	Book book = (Book) request.getAttribute("book");
	%>

	<div class="container">
		<h2 class="text-center text-primary">Edit Book</h2>
		<form action="updateBook" method="post">
			<!-- Hidden ID Field -->
			<input type="hidden" name="id" value="<%=book.getId()%>">
			<div class="mb-3">
				<label class="form-label"> Book Name:</label> <input type="text"
					class="form-control" name="name" value="<%=book.getBookname()%>"
					required>
			</div>

			<div class="mb-3">
				<label class="form-label">Book id</label> <input type="text"
					class="form-control" name="bookid" value="<%=book.getBookid()%>"
					required>
			</div>

			<div class="mb-3">
				<label class="form-label">Author</label> <input type="text"
					class="form-control" name="bookauthor"
					value="<%=book.getBookauthor()%>" required>
			</div>

			<div class="mb-3">
				<label class="form-label">Subject</label> <input type="text"
					class="form-control" name="booksubject"
					value="<%=book.getBooksubject()%>" required>
			</div>

			<div class="btn-container">
				<button type="submit" class="btn btn-primary">Update</button>
				<a href="bookList.jsp" class="btn btn-secondary">Cancel</a>
			</div>
		</form>
	</div>

</body>
</html>
