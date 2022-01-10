/**
 * 
 */
package com.lt.constants;

/**
 * @author Deepikareddy , Bheem , Shiva Amancha, Shiva, Dinesh, Rajnish
 * @category SQL Constants Class  
 */

public class SQLConstants {

	/**
	 * @author Deepikareddy , Bheem , Shiva Amancha, Shiva, Dinesh, Rajnish
	 * These constants are used for Registering the student 
	 * @param ADD_STUDENT used for inserting Student Data into Student Table
	 */
	public static final String ADD_STUDENT = "insert into student values(?,?,?,?,?)";


	/**
	 * @author Deepikareddy , Bheem , Shiva Amancha, Shiva, Dinesh, Rajnish
	 * These constants are used for User login 
	 * @param SELECT_MAX_USER_ID used for auto incrementing the ID
	 * @param ADD_USER for inserting user data in User Table
	 * @param USER_LOGIN used for checking the User credentials for login 
	 * @param STUDENT_APPROVAL_STATUS for checking the status of student approval
	 */
	public static final String SELECT_MAX_USER_ID = "SELECT MAX(ID) as ID from user";
	public static final String ADD_USER="Insert into User values(?,?,?,?)";
	public static final String USER_LOGIN= "Select ID From User where ID=? AND Password = ?";
	public static final String STUDENT_APPROVAL_STATUS= "Select ID From STUDENT where ID=? AND STATUS=?";

	/**
	 * @author Deepikareddy , Bheem , Shiva Amancha, Shiva, Dinesh, Rajnish
	 * These constants are used for Student Course Enrollment 
	 * @param STUD_COU_INS is used for insert Course details in StudentCourse Table
	 * @param Course_Count Used for getting the Course Count from Course Table
	 * @param Course_Check is used for checking is the Student has already enrolled for the course 
	 * @param Course_Check1 is used for checking if the Course already exists in the Course Table
	 * @param LIST_COURSE is used for Viewing the list of courses
	 */	
	public static final String STUD_COU_INS="insert into StudentCourse values(?,?,?)";
	public static final String Course_Count="Select count(CID) As cid_count From StudentCourse where SID=?";
	public static final String Course_Check="select CID From StudentCourse where CID=? AND SID=?";
	public static final String Course_Check1="select CourseName From Course where CourseID=?";
	public static final String LIST_COURSE="select * from course";


	/**
	 * @author Deepikareddy , Bheem , Shiva Amancha, Shiva, Dinesh, Rajnish
	 * These constants are used for dropping course to student
	 * @param STUD_COU_DROP is used to delete the Course details from StudentCourse 
	 */
	public static final String STUD_COU_DROP=" Delete from StudentCourse where sid=? AND cid=?";


	/**
	 * @author Deepikareddy , Bheem , Shiva Amancha, Shiva, Dinesh, Rajnish
	 * @param STUDENT_GRADE is used to Insert Student and Course Details into StudentGrades table
	 * @param STUDENT_NAME is used to fetch the Student Name from Student Table 
	 */
	public static final String STUDENT_GRADE=" Insert into StudentGrades values(?,?,?,?,?)";
	public static final String STUDENT_NAME=" Select Name from Student where id=?";

	/**
	 * Below constants are used for Professor Operations
	 * @author Deepikareddy , Bheem , Shiva Amancha, Shiva, Dinesh, Rajnish
	 * @param PROFESSOR_ID is used to Fetch Professor ID Professor table
	 * @param EN_STUD_DTL is used to fetch the list of enrolled Students from StudentGrades Table 
	 */
	public static final String PROFESSOR_ID=" Select ID from Professor where CourseID=?";
	public static final String EN_STUD_DTL=" Select * from StudentGrades where CID=?";
	public static final String ADD_GRADE = "Update StudentGrades set grade=? Where sid=? AND cid=?";

	/**
	 * Below constant is used to View Student Report Card
	 * @author Deepikareddy , Bheem , Shiva Amancha, Shiva, Dinesh, Rajnish
	 * @param REPORT_CARD is used to fetch the Students details from StudentGrades Table 
	 */
	public static final String REPORT_CARD = " Select * from StudentGrades where SID=?";

	/**
	 * Below constant is used for admin login
	 * @author Deepikareddy , Bheem , Shiva Amancha, Shiva, Dinesh, Rajnish
	 * @param ADMIN_LOGIN is used to fetch the ID  from user Table 
	 */

	public static final String ADMIN_LOGIN = " Select ID from user where id=? and password=?";

	/**
	 * Below constant is used for adding the professor
	 * @author Deepikareddy , Bheem , Shiva Amancha, Shiva, Dinesh, Rajnish
	 * @param ADD_PROFESSOR is used to add data to the professor Table 
	 * @param ADD_USER will also be used here to add the entry to user 
	 */

	public static final String ADD_PROFESSOR = "Insert into professor values(?,?,?,?,?)";

	/**
	 * Below constant is used for deleting the professor
	 * @author Deepikareddy , Bheem , Shiva Amancha, Shiva, Dinesh, Rajnish
	 * @param DELETE_PROFESSOR is used to delete professor from professor Table 
	 * @param DELETE_USER will is used to delete professor from user Table  
	 */

	public static final String DELETE_PROFESSOR = "delete from professor where id=?";
	public static final String DELETE_USER = "delete from user where id=? and roleid=?";

	/**
	 * Below constant is used for adding the course
	 * @author Deepikareddy , Bheem , Shiva Amancha, Shiva, Dinesh, Rajnish
	 * @param ADD_COURSE is used to add course to course Table
	 * @param MAX_COURSE_ID is used to get max course id from course table
	 */

	public static final String ADD_COURSE = "insert into course values(?,?,?)";
	public static final String COUNT_COURSES = "select max(courseid) as maxid from course";

	/**
	 * Below constant is used for deleting the course
	 * @author Deepikareddy , Bheem , Shiva Amancha, Shiva, Dinesh, Rajnish
	 * @param DELETE_COURSE is used to delete course from course Table 
	 */

	public static final String DELETE_COURSE = "delete from course where courseid=?";
	public static final String DELETE_COURSE_STUD = "delete from studentcourse where courseid=?";


	/**
	 * Below constant is used for approving the student registration status
	 * @author Deepikareddy , Bheem , Shiva Amancha, Shiva, Dinesh, Rajnish
	 * @param APPROVE_STUDENT is used to approve student registration status in student Table 
	 */

	public static final String APPROVE_STUDENT = "update student set status=? where id=? and status=?";


	/**
	 * Below constant are used for making the payment for courses
	 * @author Deepikareddy , Bheem , Shiva Amancha, Shiva, Dinesh, Rajnish
	 * @param MAKE_PAYMENT is used for inserting the values in Payment table 
	 * @param GET_FEE is used to get the Course Fee from the Course Table
	 * @param UPDATE_PAYMENT is used to update student payment status in studentcourse Table 

	 */
	public static final String UPDATE_PAYMENT = "update studentcourse set paymentstatus=? where (cid=? and paymentstatus=? and sid=?)";
	public static final String MAKE_PAYMENT = "insert into payment values(?,?,?,?,?,?)";  
	public static final String GET_FEE = "select coursefee from course where courseid=? ";

	/**
	 * Below constant is used for Updating the user password
	 * @author Deepikareddy , Bheem , Shiva Amancha, Shiva, Dinesh, Rajnish
	 * @param UPDATE_PASSWORD is used for Updating the user password in user table
	 */

	public static final String UPDATE_PASSWORD = "UPDATE USER SET PASSWORD=? WHERE ID=? AND PASSWORD=?";
}
