/**
 * 
 */
package com.lt.DAO;

/**
 * @author Deepikareddy , Bheem , Shiva Amancha, Shiva, Dinesh, Rajnish
 * @category Admin Interface 
 */
public interface AdminDAO {
	public boolean adminLogin(int id, String pwd);
	public boolean addProfessor(String name,String cname,int cid,String dept);
	public boolean deleteProfessor(int pid);
	public boolean addCourse(String cname,int cfee);
	public boolean deleteCourse(int cid);
	public boolean updatePaymentStatus(int sid,int cid);
	public boolean approveStudent(int sid);
	public boolean updateUserPassword(String newpassword,int id,String oldpassword);
}
