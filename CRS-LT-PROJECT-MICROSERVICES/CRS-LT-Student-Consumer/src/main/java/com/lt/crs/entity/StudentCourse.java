package com.lt.crs.entity;



import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author Deepika,Shiva Amancha, Shiva, Rajneesh, Dinesh, Bheemesh
 */

public class StudentCourse {
	
	@JsonIgnore
	private int id;
	private int studentId;
	private int courseId;
	private int professorId;
	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "Student_Course [id=" + id + ", studentId=" + studentId + ", courseId=" + courseId + ", professorId="
				+ professorId + "]";
	}

	/**
	 * @return the studentId
	 */
	public int getStudentId() {
		return studentId;
	}

	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	/**
	 * @return the courseId
	 */
	public int getCourseId() {
		return courseId;
	}

	/**
	 * @param courseId the courseId to set
	 */
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	/**
	 * @return the professorId
	 */
	public int getProfessorId() {
		return professorId;
	}

	/**
	 * @param professorId the professorId to set
	 */
	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	
}
