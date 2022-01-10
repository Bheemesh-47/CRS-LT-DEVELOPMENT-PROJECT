/**
 * 
 */
package com.lt.DAO;

import java.util.List;

/**
 * @author Deepikareddy , Bheem , Shiva Amancha, Shiva, Dinesh, Rajnish
 * @category Student Interface 
 */
public interface StudentDAO {
	public boolean registerStudent(String sname,String email,String dob);
	public boolean studentLogin(int id, String pwd);
	public boolean enrollCourse(int sid,int cid);
	public boolean dropCourse(int sid,int cid);
	public List viewReportCard(int sid);
	
}
