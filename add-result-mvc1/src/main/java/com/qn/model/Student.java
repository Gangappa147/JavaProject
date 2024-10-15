package com.qn.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Student {

	
	private int id;
	private String name;
	private int marks1;
	private int marks2;
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
	public int getMarks1() {
		return marks1;
	}
	public void setMarks1(int marks1) {
		this.marks1 = marks1;
	}
	public int getMarks2() {
		return marks2;
	}
	public void setMarks2(int marks2) {
		this.marks2 = marks2;
	}
	public Student(int id, String name, int marks1, int marks2) {
		super();
		this.id = id;
		this.name = name;
		this.marks1 = marks1;
		this.marks2 = marks2;
	}
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", marks1=" + marks1 + ", marks2=" + marks2 + "]";
	}
	
	
	public int addResult() {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2028", "root", "Gangappa@123");
			
			String s="insert into student values(?,?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(s);
			pstmt.setInt(1, id);
			pstmt.setString(2,name);
			pstmt.setInt(3, marks1);
			pstmt.setInt(4, marks2);
			int res=pstmt.executeUpdate();
			return res;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
		
	}
}
