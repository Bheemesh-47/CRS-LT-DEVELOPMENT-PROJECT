package com.lt.crs.service;

import java.util.List;

import com.lt.crs.dto.StudentCourseDetailsDto;
import com.lt.crs.model.StudentGrade;
/**
 * @author deepika, Shiva, Shiva Amancha, Dinesh, Rajneesh, Bheemesh
 */
public interface ProfessorService {
	/**
	 * 
	 * @param studentGrade
	 * @return
	 */
	public String addGradeForStudent(StudentGrade studentGrade);
	/**
	 * 
	 * @param professorId
	 * @return
	 */
	public List<StudentCourseDetailsDto> viewEnrolledStudents(int professorId);

}
