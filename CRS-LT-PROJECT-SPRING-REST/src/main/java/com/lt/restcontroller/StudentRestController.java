/**
 * 
 */
package com.lt.restcontroller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lt.DAO.ProfessorDAOImpl;
import com.lt.DAO.StudentDAOImpl;
import com.lt.bean.Professor;
import com.lt.bean.Student;
import com.lt.exceptions.StudentCoursePayementFailException;
import com.lt.exceptions.StudentCourseRegistrationFailException;
import com.lt.exceptions.StudentDropCourseFailException;
import com.lt.exceptions.StudentLoginFailException;
import com.lt.exceptions.StudentRegistrationFailException;
import com.lt.exceptions.StudentViewReportFailException;

/**
 * @author Deepikareddy , Bheem , Shiva Amancha, Shiva, Dinesh, Rajnish
 * @category StudentRestController
 */
@RestController
@CrossOrigin
public class StudentRestController {


	@Autowired
	private StudentDAOImpl studentDAO;
	@Autowired
	private ProfessorDAOImpl professorDAO;

	/**
	 * All Exception are declared here
	 */
	@Autowired
	StudentLoginFailException loginfailexcp;
	
	@Autowired
	StudentCoursePayementFailException paymentfailexcp;
	
	@Autowired
	StudentRegistrationFailException studregfailexcp;
	
	@Autowired
	StudentCourseRegistrationFailException cousregfailexcp;
	
	@Autowired
	StudentDropCourseFailException dropcouexcp;
	
	@Autowired
	StudentViewReportFailException reportcardexcp;

	/**
	 * This method will  check the URL and call the studentLogin() method
	 * @author G2
	 * @category GET  
	 * @param id is Student ID
	 * @param pwd is Student Password
	 * URL Pattern:/slogin
	 *
	 */
	@RequestMapping( method = RequestMethod.GET,value = "/slogin/{id}/{pwd}")
	@ResponseBody
	public ResponseEntity<String> getStudents(@PathVariable("id") int id,@PathVariable("pwd") String pwd) {

		boolean student = studentDAO.studentLogin(id, pwd);
		if (student == false) {
			return new ResponseEntity<String>(loginfailexcp.getMessage(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>("Login Successful !", HttpStatus.OK);
	}


	/**
	 * This method will check the URL and call the registerStudent() method
	 * @author G2
	 * @category PUT  
	 * @param sname is Student Name
	 * @param email is Student Mail
	 * @param dob is Student Date of Birth (DD-MM-YYYY)
	 * URL Pattern:/put/regstudentdb
	 *
	 */
	@RequestMapping(method = RequestMethod.PUT,value = "/put/regstudentdb")
	@ResponseBody
	public ResponseEntity<String> createStudentr(
			@RequestParam("sname") String sname,@RequestParam("email") String email,@RequestParam("dob") String dob) {
		boolean x=studentDAO.registerStudent(sname,email,dob);
		if(x==false) {
			return new ResponseEntity<String>(studregfailexcp.getMessage() ,HttpStatus.NOT_FOUND);}
		else {
			return new ResponseEntity<String>("Student Registered Successfully. Your default password is: password. Please change your password after login.",HttpStatus.OK);}
	}
	

	/**
	 * This method will check the URL and calls the addCourse() method 
	 * @author G2
	 * @category PUT  
	 * @param sid is Student ID
	 * @param cid is Course ID
	 * URL Pattern:/addcourse/{sid}/{cid}
	 *
	 */
	@RequestMapping( method = RequestMethod.PUT,value = "/addcourse/{sid}/{cid}")
	@ResponseBody
	public ResponseEntity<String> addCourses(@PathVariable("sid") int sid,@PathVariable("cid") int cid) {
		boolean student = studentDAO.enrollCourse(sid, cid);
		if (student==false) {
			return new ResponseEntity<String>(cousregfailexcp.getMessage(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>("Course added successfully.", HttpStatus.OK);
	}  
	

	/**
	 * This method will check the URL and calls the dropCourse() method 
	 * @author G2
	 * @category PUT  
	 * @param sid is Student ID
	 * @param cid is Course ID
	 * URL Pattern:/dropcourse/{sid}/{cid}
	 *
	 */
	@RequestMapping( method = RequestMethod.PUT,value = "/dropcourse/{sid}/{cid}")
	@ResponseBody
	public ResponseEntity<String> dropCourse(@PathVariable("sid") int sid,@PathVariable("cid") int cid) {
		boolean student = studentDAO.dropCourse(sid, cid);
		if (student==false) {
			return new ResponseEntity<String>(dropcouexcp.getMessage(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>("Course droped successfully.", HttpStatus.OK);
	}  


	/**
	 * This method will call viewReportCard() method 
	 * @author Deepikareddy , Bheem , Shiva Amancha, Shiva, Dinesh, Rajnish
	 * @category GET  
	 * @param sid is Student ID
	 * URL Pattern:/viewreportcard/{sid}
	 *
	 */
	@RequestMapping( method = RequestMethod.GET,value = "/viewreportcard/{sid}")
	@ResponseBody
	public ResponseEntity getreport(@PathVariable("sid") int sid) {

		List list = studentDAO.viewReportCard(sid);
		if (list == null) {
			return new ResponseEntity(reportcardexcp.getMessage(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(list, HttpStatus.OK);

	}
	
	/**
	 * This method will call makePayment() method 
	 * @author Deepikareddy , Bheem , Shiva Amancha, Shiva, Dinesh, Rajnish
	 * @category PUT  
	 * @param sid is Student ID
	 * URL Pattern:/viewreportcard/{sid}
	 *
	 */
	@RequestMapping( method = RequestMethod.PUT,value = "/makepay")
	@ResponseBody
	public ResponseEntity makePayment(@RequestParam("sid") int sid,@RequestParam("cid") int cid,@RequestParam("cardtype") String cardtype,@RequestParam("cardnumber") int cardnumber,
			@RequestParam("nameoncard") String nameoncard, @RequestParam("expiry") String expiry) {
		System.out.println("Hello");
		boolean list = studentDAO.makePayment(sid,cid,cardtype,cardnumber,nameoncard,expiry);
		if (list == false) {
			return new ResponseEntity(paymentfailexcp.getMessage(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity("Payment success", HttpStatus.OK);

	}
}
