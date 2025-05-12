<%@ page import="java.util.List"%>
<%@ page import="com.vcube.Model.Book"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Books</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
<style>
body {
	background-image:
		url('https://as2.ftcdn.net/v2/jpg/08/95/43/61/1000_F_895436137_hD7GnBmQDRr62aormlLmX29HHQwEdcfm.jpg');
	background-size: cover;
	background-position: center;
	background-repeat: no-repeat;
	background-attachment: fixed;
	font-family: Arial, sans-serif;
}

.container {
	background: rgba(255, 255, 255, 0.9);
	/* Light background for readability */
	padding: 20px;
	border-radius: 10px;
	margin-top: 50px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
}

h2 {
	text-align: center;
	color: #343a40;
}

.table {
	background: white;
	border-radius: 10px;
	overflow: hidden;
}

.table th {
	background: #343a40;
	color: white;
	text-align: center;
}

.table td {
	text-align: center;
	vertical-align: middle;
}

.action-icons a {
	text-decoration: none;
	margin: 0 8px;
	font-size: 20px;
}

.edit-icon {
	color: green;
}

.delete-icon {
	color: red;
}

.edit-icon:hover {
	color: darkgreen;
}

.delete-icon:hover {
	color: darkred;
}
</style>
</head>
<body>

	<div class="container">
		<h2>📚 All Books</h2>

		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th>#</th>
					<th>Book Name</th>
					<th>Book ID</th>
					<th>Author</th>
					<th>Subject</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<%
                List<Book> books = (List<Book>) request.getAttribute("allstu");
                if (books != null && !books.isEmpty()) {
                    int count = 1;
                    for (Book book : books) {
                %>
				<tr>
					<td><%= count++ %></td>
					<td><%= book.getBookname() %></td>
					<td><%= book.getBookid() %></td>
					<td><%= book.getBookauthor() %></td>
					<td><%= book.getBooksubject() %></td>
					<td class="action-icons">
						<!-- Edit (Update) Icon --> <a href="#" class="edit-icon"
						title="Edit" onclick="editBook(<%= book.getId() %>)"> <i
							class="fa-solid fa-pen-to-square"></i>
					</a> <!-- Delete Icon with JavaScript confirmation --> <a href="#"
						class="delete-icon" title="Delete"
						onclick="confirmDelete(<%= book.getId() %>)"> <i
							class="fa-solid fa-trash"></i>
					</a>
					</td>
				</tr>
				<%
                    }
                } else {
                %>
				<tr>
					<td colspan="6" class="text-center text-danger fw-bold">No
						Books Found!</td>
				</tr>
				<%
                }
                %>
			</tbody>
		</table>
	</div>
	<script>
        function editBook(bookId) {
            window.location.href = "editBook?id=" + bookId; // Redirect to Edit Page
        }

        function confirmDelete(bookId) {
            if (confirm("Are you sure you want to delete this book?")) {
                window.location.href = "deleteBook?id=" + bookId; // Redirect to Delete URL
            }
        }
    </script>

</body>
</html>
