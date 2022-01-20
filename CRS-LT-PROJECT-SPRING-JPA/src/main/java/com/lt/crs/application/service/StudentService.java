package com.lt.crs.application.service;

import java.util.List;

import com.lt.crs.application.dto.CourseProfessorDto;
import com.lt.crs.application.dto.EnrolledCourseDto;
import com.lt.crs.application.dto.PaymentDto;
import com.lt.crs.application.entity.Payment;
import com.lt.crs.application.entity.StudentCourse;
import com.lt.crs.application.entity.StudentGrade;
/**
 * @author deepika, Shiva, Shiva Amancha, Dinesh, Rajneesh, Bheemesh
 */
public interface StudentService {
	/**
	 * 
	 * @param student
	 */
	public void addCourseToTheStudent(StudentCourse student) ;
	/**
	 * 
	 * @param studentId
	 * @param courseId
	 */
	public void dropCourse(int studentId, int courseId);
	/**
	 * 
	 * @param studentId
	 * @return
	 */
	public List<EnrolledCourseDto> viewEnrolledCourses(int studentId) ;
	/**
	 * 
	 * @param studentId
	 * @return
	 */
	public List<StudentGrade> viewReportCard(int studentId);
	/**
	 * 
	 * @param paymentDto
	 * @return
	 */
	public Payment makePayment(PaymentDto paymentDto);
	/**
	 * 
	 * @return
	 */
	public List<CourseProfessorDto> getAllCourses();
	

}
