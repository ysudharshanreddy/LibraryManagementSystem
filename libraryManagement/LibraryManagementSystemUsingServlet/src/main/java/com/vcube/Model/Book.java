package com.vcube.Model;

public class Book {
	private	int id;
	private String Bookname;
	private	String Bookid;
	private	String Bookauthor;
	private	String Booksubject;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookname() {
		return Bookname;
	}
	public void setBookname(String bookname) {
		Bookname = bookname;
	}
	public String getBookid() {
		return Bookid;
	}
	public void setBookid(String bookid) {
		Bookid = bookid;
	}
	public String getBookauthor() {
		return Bookauthor;
	}
	public void setBookauthor(String bookauthor) {
		Bookauthor = bookauthor;
	}
	public String getBooksubject() {
		return Booksubject;
	}
	public void setBooksubject(String booksubject) {
		Booksubject = booksubject;
	}
	public Book(int id, String bookname, String bookid, String bookauthor, String booksubject) {
		super();
		this.id = id;
		Bookname = bookname;
		Bookid = bookid;
		Bookauthor = bookauthor;
		Booksubject = booksubject;
	}
	public Book(String name2, String bookid2, String bookauthor2, String booksubject2) {
		Bookname = name2;
		Bookid = bookid2;
		Bookauthor = bookauthor2;
		Booksubject = booksubject2;
		// TODO Auto-generated constructor stub
	}
	public Book() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", Bookname=" + Bookname + ", Bookid=" + Bookid + ", Bookauthor=" + Bookauthor
				+ ", Booksubject=" + Booksubject + "]";
	}
	
}
