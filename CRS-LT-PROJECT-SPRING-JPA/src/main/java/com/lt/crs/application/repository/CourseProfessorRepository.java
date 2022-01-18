/**
 * 
 */
package com.lt.crs.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lt.crs.application.entity.CourseProfessor;

/**
 * @author deepika, Shiva, Shiva Amancha, Dinesh, Rajneesh, Bheemesh
 */
public interface CourseProfessorRepository extends JpaRepository<CourseProfessor, Integer> {

	List<CourseProfessor> findByCourseIdAndProfessorId(int courseId, int professorId); //And indicates the Logical AND operation 

	List<CourseProfessor> findByProfessorId(int professorId);

}
// select * from student where id=? --> findById(int id);
