/**
 * 
 */
package com.lt.DAO;

import java.util.List;

/**
 * @author Deepikareddy , Bheem , Shiva Amancha, Shiva, Dinesh, Rajnish
 * @category Professor Interface 
 */
public interface ProfessorDAO {

	public boolean professorLogin(int id, String pwd);
	public List viewEnrolledStudents(int cid);
	public boolean addGrades(int sid,int cid, String grade);
}
