/**
 * 
 */
package com.lt.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.lt.bean.Course;
import com.lt.bean.Professor;
import com.lt.bean.Student;
import com.lt.bean.StudentGrades;
import com.lt.constants.SQLConstants;

/**
 * @author Deepikareddy , Bheem , Shiva Amancha, Shiva, Dinesh, Rajnish
 * @category Professor
 */
@Repository
public class ProfessorDAOImpl implements ProfessorDAO{


	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * This method performs Professor Login Operation
	 * @param USER_LOGIN is an SQL Constant 
	 * 
	 */
	public boolean professorLogin(int id, String pwd) {
		try{Integer max = jdbcTemplate.queryForObject(SQLConstants.USER_LOGIN,new Object[]{id,pwd},Integer.class);
		return true;
		}catch(Exception e) {
			return false;
		}
	}


	/**
	 * This method is used to View Enrolled Students
	 * Returns boolean value indicating the query status
	 * 
	 * @return true if the query is successful
	 * @param ADD_STUDENT is an SQL Constant 
	 * @param PROFESSOR_ID is an SQL Constant 
	 * @param sid is Student ID
	 * @param cid is Course ID
	 */
	public List viewEnrolledStudents(int cid) {
		try {
			Integer pid = jdbcTemplate.queryForObject(SQLConstants.PROFESSOR_ID,new Object[]{cid},Integer.class);
			List<StudentGrades> list = null;
			if(pid!=null) {
				String sql = SQLConstants.EN_STUD_DTL;			 
				list=new ArrayList<>();
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql,new Object[] {cid});
				for (Map row : rows) {
					StudentGrades obj = new StudentGrades();
					obj.setSname((String) row.get("SName"));
					obj.setSid((int) row.get("SID"));
					obj.setCname((String) row.get("CName")); 
					obj.setGrade((String) row.get("Grade"));
					list.add(obj);
				}
			}
			return list;
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	/**
	 * This method is used for Adding grades to the student 
	 * Returns boolean value indicating the update status
	 * 
	 * @return true if the update is successful
	 * @return false if the update has failed
	 * @param ADD_STUDENT is an SQL Constant 
	 * @param PROFESSOR_ID is an SQL Constant 
	 * @param sid is Student ID
	 * @param cid is Course ID
	 * @param grade is Grade given to student by professor
	 */
	public boolean addGrades(int sid,int cid, String grade) {
		try {
			Integer pid = jdbcTemplate.queryForObject(SQLConstants.PROFESSOR_ID,new Object[]{cid},Integer.class);
			if(pid!=null) {
				int y=jdbcTemplate.update(SQLConstants.ADD_GRADE,new Object[]{grade,sid,cid});
				if(y>0) {
					return true;}}
		}catch(Exception e) {
			return false;}
		return false;
	}

}
