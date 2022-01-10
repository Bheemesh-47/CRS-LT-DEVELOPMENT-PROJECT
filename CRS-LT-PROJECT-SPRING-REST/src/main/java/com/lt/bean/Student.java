
package com.lt.bean;

/**
 * @author Deepikareddy , Bheem , Shiva Amancha, Shiva, Dinesh, Rajnish
 * @category Student Bean Class 
 */

public class Student  {
	private String studentName;
	private int studentId;
	private String department;
	private String courseName;
	private int courseId;
	private char grade;
	private String credential;

	public Student() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the credential
	 */
	public String getCredential() {
		return credential;
	}
	/**
	 * @param credential the credential to set
	 */
	public void setCredential(String credential) {
		this.credential = credential;
	}
	//public Student( Long studentId,String studentName, String department, String credential,String courseName,int courseId) {
		public Student( int studentId,String studentName, String department, String credential) {

		super();
		this.studentName = studentName;
		this.studentId = studentId;
		this.department = department;
		//this.courseName = courseName;
		//this.courseId = courseId;
		this.credential=credential;
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}


}

