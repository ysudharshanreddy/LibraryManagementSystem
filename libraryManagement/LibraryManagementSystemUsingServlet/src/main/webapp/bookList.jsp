<%@page import="com.vcube.DAO.BookDAO"%>
<%@ page import="com.vcube.Model.Book"%>
<%@ page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Book List</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
<style>
body {
	background-image:
		url('https://as2.ftcdn.net/v2/jpg/08/95/43/61/1000_F_895436137_hD7GnBmQDRr62aormlLmX29HHQwEdcfm.jpg');
	/* Replace with your image path */
	background-size: cover;
	background-position: center;
	background-repeat: no-repeat;
	background-attachment: fixed;
	font-family: Arial, sans-serif;
}

.container {
	/*         background: rgba(255, 255, 255, 0.8); /* Light background for readability */
	*/
	padding: 20px;
	border-radius: 10px;
	margin-top: 50px;
}

h2 {
	text-align: center;
}
</style>
</head>
<body>

	<div class="container">
		<h2>Books List</h2>
		<table class="table">
			<thead>
				<tr>
					<th>Book Name</th>
					<th>Book ID</th>
					<th>Author</th>
					<th>Subject</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<%
				BookDAO dao = new BookDAO();
				List<Book> books = dao.getAllBooks();
				for (Book book : books) {
				%>
				<tr>
					<td><%=book.getBookname()%></td>
					<td><%=book.getBookid()%></td>
					<td><%=book.getBookauthor()%></td>
					<td><%=book.getBooksubject()%></td>
					<td><a href="editBook?id=<%=book.getId()%>">Edit</a> | <a
						href="deleteBook?id=<%=book.getId()%>">Delete</a></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>

</body>
</html>
