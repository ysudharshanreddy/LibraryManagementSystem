package com.vcube.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.vcube.Model.Book;
import com.vcube.Utility.MyConnection;
public class BookDAO {
	private Connection conn;

	public BookDAO() {
		conn = MyConnection.getConnection();
	}

	// Add a new book
	public boolean addBook(Book book) {
		String query = "INSERT INTO book (bookname, bookid, bookauthor, booksubject) VALUES (?, ?, ?, ?)";
		try (PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setString(1, book.getBookname());
			ps.setString(2, book.getBookid());
			ps.setString(3, book.getBookauthor());
			ps.setString(4, book.getBooksubject());
			int res = ps.executeUpdate();
			return res > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// Retrieve all books
	public List<Book> getAllBooks() {
		List<Book> books = new ArrayList<>();
		try {
			String query = "SELECT * FROM book";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("booksid"));
				book.setBookname(rs.getString("bookname"));
				book.setBookid(rs.getString("bookid"));
				book.setBookauthor(rs.getString("bookauthor"));
				book.setBooksubject(rs.getString("booksubject"));
				books.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}

	// Retrieve a book by ID
	public Book getBookById(int id) {
		String query = "SELECT * FROM book WHERE booksid=?";
		try (PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new Book(rs.getInt("booksid"), rs.getString("bookname"), rs.getString("bookid"),
						rs.getString("bookauthor"), rs.getString("booksubject"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// Update a book
	public boolean updateBook(Book book) {
		String query = "UPDATE book SET bookname=?, bookid=?, bookauthor=?, booksubject=? WHERE booksid=?";
		try (PreparedStatement ps = conn.prepareStatement(query)) {
			System.out.println(book);
			ps.setString(1, book.getBookname());
			ps.setString(2, book.getBookid());
			ps.setString(3, book.getBookauthor());
			ps.setString(4, book.getBooksubject());
			ps.setInt(5, book.getId());
			int res = ps.executeUpdate();
			System.out.println("======================================================");
			System.out.println(res);
			return res > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// Delete a book
	public boolean deleteBook(int id) {
		String query = "DELETE FROM book WHERE booksid=?";
		try (PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setInt(1, id);
			int res = ps.executeUpdate();
			return res > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
