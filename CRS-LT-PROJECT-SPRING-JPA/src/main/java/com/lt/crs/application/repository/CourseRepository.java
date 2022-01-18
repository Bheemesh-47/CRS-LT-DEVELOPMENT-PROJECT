package com.lt.crs.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lt.crs.application.entity.Course;

/**
 * @author deepika, Shiva, Shiva Amancha, Dinesh, Rajneesh, Bheemesh
 */

public interface CourseRepository extends JpaRepository<Course, Integer> {

	Course findByCourseName(String courseName);

}
