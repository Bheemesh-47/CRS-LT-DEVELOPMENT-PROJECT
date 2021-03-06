package com.lt.crs.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lt.crs.application.entity.StudentGrade;

/**
 * @author deepika, Shiva, Shiva Amancha, Dinesh, Rajneesh, Bheemesh
 */

@Repository
public interface StudentGradeRepository extends JpaRepository<StudentGrade, Integer> {

	List<StudentGrade> findByStudentId(int studentId);
	

}
