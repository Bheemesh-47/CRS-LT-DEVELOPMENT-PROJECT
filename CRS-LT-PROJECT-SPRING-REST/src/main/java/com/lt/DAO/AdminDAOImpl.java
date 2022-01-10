/**
 * 
 */
package com.lt.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lt.constants.Constants;
import com.lt.constants.SQLConstants;

/**
 * @author Deepikareddy , Bheem , Shiva Amancha, Shiva, Dinesh, Rajnish
 * @category Admin
 * @implSpec AdminDAO
 */

@Repository
public class AdminDAOImpl implements AdminDAO{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * This method performs Admin Login Operation
	 * @param ADMIN_LOGIN is an SQL Constant 
	 * 
	 */
	public boolean adminLogin(int id, String pwd) {
		try{
			Integer max = jdbcTemplate.queryForObject(SQLConstants.ADMIN_LOGIN,new Object[]{id,pwd},Integer.class);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	/**
	 * This method performs professor registration by admin
	 * @param ADD_USER is an SQL Constant used to add professor to user table in DB
	 * @param ADD_PROFESSOR is an SQL Constant used to add professor to professor table DB
	 */
	public boolean addProfessor(String name,String cname,int cid,String dept) {
		try {
			String password = "password";
			int roleid = 2;
			int max = jdbcTemplate.queryForObject(SQLConstants.SELECT_MAX_USER_ID, Integer.class);
			int x = jdbcTemplate.update(SQLConstants.ADD_USER,new Object[] {name,password,++max,roleid});
			if(x>=0) {
				int y=jdbcTemplate.update(SQLConstants.ADD_PROFESSOR,new Object[]{name,max,cname,cid,dept});		
				if(y>=0) {
					return true;}
			}
			return false;
		}
		catch (Exception e) {
			return false;
		}
	}

	/**
	 * This method performs professor deletion by admin
	 * @param DELETE_USER is an SQL Constant used to delete professor from user table in DB
	 * @param DELETE_PROFESSOR is an SQL Constant used to delete professor from professor table DB
	 */

	public boolean deleteProfessor(int pid) {
		try {
			// TODO Auto-generated method stub
			int roleid=2;
			int x = jdbcTemplate.update(SQLConstants.DELETE_USER,new Object[]{pid,roleid});
			if(x>0) {
				int y = jdbcTemplate.update(SQLConstants.DELETE_PROFESSOR,new Object[]{pid});
				if(y>=0) {
					return true;
				}
			}
			return false;
		}
		catch (Exception e) {
			return false;
		}

	}

	/**
	 * This method performs course addition by admin
	 * @param MAX_COURSE_ID is an SQL Constant used to get max course id from course table
	 * @param ADD_COURSE is an SQL Constant used to add course to course table 
	 */

	public boolean addCourse(String cname,int cfee) {
		try {
		int max = jdbcTemplate.queryForObject(SQLConstants.COUNT_COURSES, Integer.class);
		int y = jdbcTemplate.update(SQLConstants.ADD_COURSE,new Object[]{cname,++max,cfee});
		if(y>=0) {
			return true;
		}
		return false;
		}
		catch (Exception e) {
			return false;
		}
	}

	/**
	 * This method performs professor registration by admin
	 * @param DELETE_COURSE is an SQL Constant used to delete course from course table in DB
	 */

	public boolean deleteCourse(int cid) {
		try {
		int y = jdbcTemplate.update(SQLConstants.DELETE_COURSE,new Object[]{cid});
		if(y>=0) {
			jdbcTemplate.update(SQLConstants.DELETE_COURSE_STUD,new Object[]{cid});
			return true;
		}
		return false;
		}
		catch (Exception e) {
			return false;
		}
	}

	/**
	 * This method performs student payment status updation by admin
	 * @param UPDATE_PAYMENT is an SQL Constant used to update student payment status in student table 
	 */

	public boolean updatePaymentStatus(int sid,int cid) {
		try {
		//String oldstatus="Pending";
		//String newstatus="Completed";
		int y = jdbcTemplate.update(SQLConstants.UPDATE_PAYMENT,new Object[]{Constants.NEW_PAYMENT_STATUS,cid,Constants.OLD_PAYMENT_STATUS,sid});
		if(y>=0) {
			return true;
		}
		return false;
		}
		catch (Exception e) {
			return false;
		}

	}

	/**
	 * This method performs student payment status updation by admin
	 * @param APPROVE_STUDENT is an SQL Constant used to Approve student Registration status in student table 
	 * @param APPROVED is a Constant to Approve Student Status to APPROVED
	 * @param APPROVAL_PENDING is a constant which means the student APPROVAL is PENDING
	 */

	public boolean approveStudent(int sid) {
		try {
		//String oldstatus="Approval Pending";
		//String newstatus="Approved";
		int y = jdbcTemplate.update(SQLConstants.APPROVE_STUDENT,new Object[]{Constants.APPROVED,sid,Constants.APPROVAL_PENDING});
		if(y>=0) {
			return true;
		}
		return false;
		}
		catch (Exception e) {
			return false;
		}

	}
	
	/**
	 * This method performs user password updationn
	 * @param UPDATE_PASSWORD is an SQL Constant used to update student payment status in student table 
	 */

	public boolean updateUserPassword(String newpassword,int id,String oldpassword) {
		try {
		int y = jdbcTemplate.update(SQLConstants.UPDATE_PASSWORD,new Object[]{newpassword,id,oldpassword});
		if(y>=0) {
			return true;
		}
		return false;
		}
		catch (Exception e) {
			return false;
		}

	}

}
