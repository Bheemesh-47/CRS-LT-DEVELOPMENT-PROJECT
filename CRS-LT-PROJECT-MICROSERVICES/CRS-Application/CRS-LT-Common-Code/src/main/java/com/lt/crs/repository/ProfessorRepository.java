package com.lt.crs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lt.crs.model.Professor;
/**
 * 
 * @author saikumar
 *
 */
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

}
