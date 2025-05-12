package com.vcube.Model;

public class Student {

	private int id;
	private String name;
	private String email;
	private String course;
	private String phoneno;
	private String password;
	private int EnrollmentNo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getEnrollmentNo() {
		return EnrollmentNo;
	}
	public void setEnrollmentNo(int enrollmentNo) {
		EnrollmentNo = enrollmentNo;
	}
	public Student(int id, String name, String email, String course, String phoneno, String password,
			int enrollmentNo) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.course = course;
		this.phoneno = phoneno;
		this.password = password;
		EnrollmentNo = enrollmentNo;
	}
	public Student() {}
	public Student(String name2, String email2, String course2, String phoneno2, String password2, int enrollmentNo2) {
		this.name = name2;
		this.email = email2;
		this.course = course2;
		this.phoneno = phoneno2;
		this.password = password2;
		EnrollmentNo = enrollmentNo2;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", course=" + course + ", phoneno="
				+ phoneno + ", password=" + password + ", EnrollmentNo=" + EnrollmentNo + "]";
	}
	
	
}
