package com.lt.crs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lt.crs.model.Student;

/**
 * @author deepika, Shiva, Shiva Amancha, Dinesh, Rajneesh, Bheemesh
 */

public interface StundentRepository extends JpaRepository<Student, Integer> {
}