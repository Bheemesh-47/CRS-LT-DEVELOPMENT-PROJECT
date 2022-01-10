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
import com.lt.bean.StudentGrades;
import com.lt.constants.Constants;
import com.lt.constants.SQLConstants;



/**
 * @author Deepikareddy , Bheem , Shiva Amancha, Shiva, Dinesh, Rajnish
 * @category Student
 *
 */
@Repository
public class StudentDAOImpl {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * This method is used for Student Registration 
	 * Returns boolean value indicating the insertion status
	 * 
	 * @return true if the insertion is successful
	 * @return false if the insertion has failed
	 * @param ADD_STUDENT is an SQL Constant 
	 * @param APPROVAL_PENDING is a Constant
	 */
	public boolean registerStudent(String sname,String email,String dob) {
		//String approval_pending="Approval Pending";
		//String default_pwd="password";
		int roleID=3;
		int max = jdbcTemplate.queryForObject(SQLConstants.SELECT_MAX_USER_ID, Integer.class);		
		int x=jdbcTemplate.update(SQLConstants.ADD_USER,new Object[]{sname,Constants.DEFAULT_PWD,++max,roleID});	
		if(x>=0) {
			int y=jdbcTemplate.update(SQLConstants.ADD_STUDENT,new Object[]{max, sname,email,dob,Constants.APPROVAL_PENDING});		
			if(y>=0) {
				return true;}
		}
		return false;
	}

	/**
	 * This method performs Student Login Operation
	 * @param USER_LOGIN is an SQL Constant 
	 * @param STUDENT_APPROVAL_STATUS is an SQL Constant
	 * @APPROVE is a Constant 
	 */
	public boolean studentLogin(int id, String pwd) {
		try {
			//String status = "Approved";
			//System.out.println(status);
			List l= jdbcTemplate.queryForList(SQLConstants.STUDENT_APPROVAL_STATUS,new Object[]{id,Constants.APPROVED}); 
			System.out.println(l);
			if(l.isEmpty()==false) {
				Integer max = jdbcTemplate.queryForObject(SQLConstants.USER_LOGIN,new Object[]{id,pwd},Integer.class); 
				return true;
			}
			else {
				return false;
			}

		}catch (Exception e){
			//e.printStackTrace();
			return false;
		}
		//return false;
	}
	/**
	 * This method adds the course to Student_Course Table 
	 * @param Course_Check1 is an SQL Constant
	 * @param Course_Check is an SQL Constant
	 * @param Course_Count is an SQL Constant
	 * @param STUD_COU_INS is an SQL Constant
	 * @param OLD_PAYMENT_STATUS is a Constant to set the Payment status as Pending
	 * @param DEFAULT_GRADE is a Constant which is used to Set the Default Grade to the Student
	 * @param sid is Student ID
	 * @param cid is Course ID
	 * 
	 */
	public boolean enrollCourse(int sid,int cid) { // 1 condition pending, can't opt for same course twice
		try {
			//System.out.println("Inside 1");
			String cname = jdbcTemplate.queryForObject(SQLConstants.Course_Check1,new Object[]{cid},String.class);
			//checking course in Course table		
			if(cname.isEmpty()==false) {
				//System.out.println("Inside 2");
				//Integer c1 = 0;
				//c1=jdbcTemplate.queryForObject(SQLConstants.Course_Check,new Object[]{cid, sid}, Integer.class); 
				//if(c1==0) {
				//System.out.println("Inside 3");
				Integer c2 = jdbcTemplate.queryForObject(SQLConstants.Course_Count,new Object[]{sid}, Integer.class);
				//System.out.println("Course count "+c2);
				if(c2<4) {
					//System.out.println("Inside 4");
					//String payment_status ="Pending";
					//String grade="Yet to be added";						
					Integer c3 = jdbcTemplate.update(SQLConstants.STUD_COU_INS,new Object[]{sid, cid, Constants.OLD_PAYMENT_STATUS});	

					String sname=jdbcTemplate.queryForObject(SQLConstants.STUDENT_NAME,new Object[]{sid},String.class);
					jdbcTemplate.update(SQLConstants.STUDENT_GRADE,new Object[]{sname,sid,cname,cid,Constants.DEFAULT_GRADE});

					return true;
				}
				//} 
			}}catch(Exception e) {
				return false;
			} return false;
	}

	/**
	 * This method drops the course from Student_Course Table 
	 * @param sid is Student ID
	 * @param cid is Course ID
	 * @param STUD_COU_DROP is an SQL Constant
	 * 
	 */
	public boolean dropCourse(int sid,int cid) {
		try {
			Integer drop = jdbcTemplate.update(SQLConstants.STUD_COU_DROP,new Object[]{sid, cid});
			if(drop>0) {
				return true;}
		}catch(Exception e) {
			return false;
		}return false;
	}

	/**
	 * This method views the grades from Student_Grades Table 
	 * @param sid is Student ID
	 * @param REPORT_CARD is an SQL Constant
	 * 
	 */
	public List viewReportCard(int sid) {

		List<StudentGrades> list = null;
		String sql = SQLConstants.REPORT_CARD;
		list=new ArrayList<>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql,new Object[] {sid});	
		if(rows.isEmpty()!=true) {
			for (Map row : rows) {
				StudentGrades obj = new StudentGrades();
				obj.setSname((String) row.get("SName"));
				obj.setSid((int) row.get("SID"));
				obj.setCname((String) row.get("CName")); 
				obj.setGrade((String) row.get("Grade"));
				list.add(obj);
			}
			return list;
		}else {
			return null;}

	}

	/**
	 * This method makes the payment for the enrolled course
	 * @param sid is Student ID
	 * @param cid is course ID
	 * @param cardtype is Debit/credit card
	 * @param cardnumber is card number
	 * @param nameoncard is Card holder name
	 * @param expirydate is last active day of the card
	 * @param MAKE_PAYMENT is an SQL Constant
	 * 
	 */

	public boolean makePayment(int sid,int cid,String cardtype,int cardnumber,String nameoncard,String expirydate) {
		Integer fee= jdbcTemplate.queryForObject(SQLConstants.GET_FEE,new Object[] {cid},Integer.class);
		//System.out.println(data.get(0));
		//int fee = (int) data.get(0);
		int x = jdbcTemplate.update(SQLConstants.MAKE_PAYMENT,new Object[]{sid, cardtype,cardnumber,nameoncard,expirydate,fee});
		if(x>0) {
			return true;
		}
		return false;
	}


}
