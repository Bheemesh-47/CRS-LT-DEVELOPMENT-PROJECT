package com.lt.crs.application.service;


import java.util.List;

import com.lt.crs.application.dto.ProfessorDto;
import com.lt.crs.application.entity.Course;
import com.lt.crs.application.entity.Professor;
import com.lt.crs.application.entity.Student;
import com.lt.crs.application.entity.StudentGrade;
/**
 * @author deepika, Shiva, Shiva Amancha, Dinesh, Rajneesh, Bheemesh
 */
public interface AdminService {
/**
 * 
 * @param course
 * @return
 */
	Course saveCourse(Course course);
/**
 * 
 * @param id
 */
	void deleteCourseById(int id);
	/**
	 * 
	 * @param professorDto
	 * @return
	 */

	Professor saveProfessor(ProfessorDto professorDto);
/**
 * 
 * @param professorId
 */
	void deleteProfessorById(int professorId);
	/**
	 * 
	 * @param studentId
	 * @return
	 */

	Student approveStudent(int studentId);
	/**
	 * 
	 * @param studentId
	 * @return
	 */

	Student rejectStudent(int studentId);

/**
 * 
 * @return
 */
	List<StudentGrade> generateReportCard();

}
