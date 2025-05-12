package com.vcube.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vcube.Model.Student;
import com.vcube.Utility.MyConnection;

public class StudentDAO {

	public static List<Student> getAllStudents() {
		List<Student> list = new ArrayList<>();
		try (Connection con = MyConnection.getConnection();
				PreparedStatement ps = con.prepareStatement("SELECT * FROM addstudent");
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				list.add(new Student(rs.getInt("id"), rs.getString("name"), rs.getString("email"),
						rs.getString("course"), rs.getString("phoneno"), rs.getString("password"),
						rs.getInt("enrollmentNo")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static Student getStudentById(int id) {
		Student student = null;
		try (Connection con = MyConnection.getConnection();
				PreparedStatement ps = con.prepareStatement("SELECT * FROM addstudent WHERE id = ?")) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				student = new Student(rs.getInt("id"), rs.getString("name"), rs.getString("email"),
						rs.getString("course"), rs.getString("phoneno"), rs.getString("password"),
						rs.getInt("enrollmentNo"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}
	
	public static void deleteStudent(int id) {
		try (Connection con = MyConnection.getConnection();
				PreparedStatement ps = con.prepareStatement("DELETE FROM addstudent WHERE id = ?")) {
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Student select(String email, String password) {
		try {
			Connection con = MyConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from addstudent where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				 return new Student(rs.getInt("id"), rs.getString("name"), rs.getString("email"),
						rs.getString("course"), rs.getString("phoneno"), rs.getString("password"),
						rs.getInt("enrollmentNo"));
			}
		} catch (Exception e) {
			System.out.println(e);

		}
		return null;
	}

	public boolean insert(Student r) {
		try {
			Connection con = MyConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"insert into addstudent (name,email,course,phoneno,password,enrollmentno)values(?,?,?,?,?,?)");
			ps.setString(1, r.getName());
			ps.setString(2, r.getEmail());
			ps.setString(3, r.getCourse());
			ps.setString(4, r.getPhoneno());
			ps.setString(5, r.getPassword());
			ps.setInt(6, r.getEnrollmentNo());
			int h = ps.executeUpdate();
			if (h > 0) {
				return true;
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	public static boolean updateStudent(Student student) {
	    boolean rowUpdated = false;
	    try (Connection con =MyConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(
	                 "UPDATE addstudent SET name=?, email=?, course=?, phoneno=?, enrollmentNo=? WHERE id=?")) {
	        ps.setString(1, student.getName());
	        ps.setString(2, student.getEmail());
	        ps.setString(3, student.getCourse());
	        ps.setString(4, student.getPhoneno());
	        ps.setInt(5, student.getEnrollmentNo());
	        ps.setInt(6, student.getId());

	        rowUpdated = ps.executeUpdate() > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return rowUpdated;
	}
	
	
//	public static boolean updateStudent(Student student) {
//	    boolean success = false;
//	    try (Connection conn =MyConnection.getConnection()) {
//	        String sql = "UPDATE student SET name=?, email=?, phoneno=?, course=?, EnrollmentNo=?, password=? WHERE id=?";
//	        PreparedStatement ps = conn.prepareStatement(sql);
//	        ps.setString(1, student.getName());
//	        ps.setString(2, student.getEmail());
//	        ps.setString(3, student.getPhoneno());
//	        ps.setString(4, student.getCourse());
//	        ps.setInt(5, student.getEnrollmentNo());
//	        ps.setString(6, student.getPassword());
//	        ps.setInt(7, student.getId());
//
//	        success = ps.executeUpdate() > 0;
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
//	    return success;
//	}
	public static boolean updateStudentss(Student student) {
	    boolean success = false;
	    try (Connection conn = MyConnection.getConnection()) {
	        String sql = "UPDATE student SET name = ?, email = ?, phoneno = ?, course = ?, EnrollmentNo = ?, password = ? WHERE id = ?";
	        PreparedStatement ps = conn.prepareStatement(sql);

	        ps.setString(1, student.getName());
	        ps.setString(2, student.getEmail());
	        ps.setString(3, student.getPhoneno());
	        ps.setString(4, student.getCourse());
	        ps.setInt(5, student.getEnrollmentNo());
	        ps.setString(6, student.getPassword());
	        ps.setInt(7, student.getId());

	        int rowsAffected = ps.executeUpdate();
	        success = (rowsAffected > 0);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return success;
	}



}
