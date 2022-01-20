package com.lt.crs.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lt.crs.application.entity.Student;

/**
 * @author deepika, Shiva, Shiva Amancha, Dinesh, Rajneesh, Bheemesh
 */

public interface StundentRepository extends JpaRepository<Student, Integer> {
}
