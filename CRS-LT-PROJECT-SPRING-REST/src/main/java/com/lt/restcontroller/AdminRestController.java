/**
 * 
 */
package com.lt.restcontroller;

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

import com.lt.DAO.AdminDAOImpl;
import com.lt.DAO.ProfessorDAOImpl;
import com.lt.bean.Professor;
import com.lt.exceptions.AdminAddCourseFailException;
import com.lt.exceptions.AdminAddProfessorFailException;
import com.lt.exceptions.AdminDeleteCourseFailException;
import com.lt.exceptions.AdminDeleteProfessorFailException;
import com.lt.exceptions.AdminLoginFailException;
import com.lt.exceptions.AdminPaymentStatusUpdationFailException;
import com.lt.exceptions.UserPasswordUpdationFailException;

/**
 * @author Deepikareddy , Bheem , Shiva Amancha, Shiva, Dinesh, Rajnish
 * @category AdminRestController
 */


@RestController
@CrossOrigin
public class AdminRestController {
	@Autowired
	private AdminDAOImpl adminDAOImpl;
	

	/*	@Autowired
	private ProfessorDAOImpl professorDAO;

	//@PostMapping(value = "/post/professors")
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST,value = "/post/professors")
	@ResponseBody
	public ResponseEntity createProfessor(@RequestBody Professor Professor) {

		professorDAO.insert(Professor);

		return new ResponseEntity(Professor, HttpStatus.OK);
	}


	//@DeleteMapping("/delete/professors/{id}")
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.DELETE,value = "/delete/professors/{id}")
	@ResponseBody
	public ResponseEntity deleteProfessor(@PathVariable Long id) {

		if (null == professorDAO.delete(id)) {
			return new ResponseEntity("No Professor found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(id, HttpStatus.OK);

	}

	//@PutMapping("/put/professors/{id}")
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.PUT,value = "/put/professors/{id}")
	@ResponseBody
	public ResponseEntity updateProfessor(@PathVariable Long id, @RequestBody Professor Professor) {

		Professor = professorDAO.update(id, Professor);

		if (null == Professor) {
			return new ResponseEntity("No Professor found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(Professor, HttpStatus.OK);
	}
	 */
	/**
	 * All the needed exception objects are got here
	 * 
	 */
	@Autowired
	AdminLoginFailException adminexcp1;
	
	@Autowired
	AdminAddProfessorFailException adminexcp2;
	
	@Autowired
	AdminDeleteProfessorFailException adminexcp3;
	
	@Autowired
	AdminAddCourseFailException adminexcp4;
	
	@Autowired
	AdminDeleteCourseFailException adminexcp5;
	
	@Autowired
	AdminPaymentStatusUpdationFailException adminexcp6;
	
	@Autowired
	AdminDeleteCourseFailException adminexcp7;
	
	@Autowired
	UserPasswordUpdationFailException adminexcp8;
	/**
	 * This method will check the URL and call the adminLogin() method
	 * @author G2
	 * @category GET  
	 * @param id is Admin ID
	 * @param pwd is Admin Pwd
	 * URL Pattern:/alogin/{id}/{pwd}
	 *
	 */
	
	
	
	@RequestMapping( method = RequestMethod.GET,value = "/alogin/{id}/{pwd}")
	@ResponseBody
	public ResponseEntity<String> getAdmin(@PathVariable("id") int id,@PathVariable("pwd") String pwd) {
		
		boolean admin = adminDAOImpl.adminLogin(id, pwd);
		if (admin == false) {
			return new ResponseEntity<String>(adminexcp1.getMessage(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>("Login Successful !", HttpStatus.OK);
	}
	
	/**
	 * This method will check the URL and call the adminLogin() method
	 * @author G2
	 * @category PUT  
	 * @param name is Professor name
	 * @param coursename is course name 
	 * @param cid is course id
	 * @param dept department
	 * URL Pattern:/addprofessor/{name}/{coursename}/{cid}/{dept}
	 *
	 */
	
	@RequestMapping( method = RequestMethod.PUT,value = "/addprofessor/{name}/{coursename}/{cid}/{dept}")
	@ResponseBody
	public ResponseEntity<String> addProfessor(@PathVariable("name") String name,@PathVariable("coursename") String cname,@PathVariable("cid") int cid,@PathVariable("dept") String dep) {

		boolean status = adminDAOImpl.addProfessor(name, cname, cid, dep);
		if (status == false) {
			return new ResponseEntity<String>(adminexcp2.getMessage(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>("Professor Added!", HttpStatus.OK);
	}
	
	
	/**
	 * This method will check the URL and call the deleteProfessor() method
	 * @author G2
	 * @category DELETE  
	 * @param pid professor id
	 * URL Pattern:/deleteprofessor/{pid}
	 *
	 */
	
	@RequestMapping( method = RequestMethod.DELETE,value = "/deleteprofessor/{pid}")
	@ResponseBody
	public ResponseEntity<String> deleteProfessor(@PathVariable("pid") int pid) {

		boolean status = adminDAOImpl.deleteProfessor(pid);
		if (status == false) {
			return new ResponseEntity<String>(adminexcp3.getMessage(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>("Professor Deleted!", HttpStatus.OK);
	}
	
	/**
	 * This method will check the URL and call the addCourse() method
	 * @author G2
	 * @category PUT  
	 * @param coursename is course name 
	 * @param fees is course fees
	 * URL Pattern:/addcourse/{coursename}/{fees}
	 *
	 */
	
	@RequestMapping( method = RequestMethod.PUT,value = "/addcourse")
	@ResponseBody
	public ResponseEntity<String> addCourse(@RequestParam("coursename") String coursename,@RequestParam("fees") int fees) {

		boolean status = adminDAOImpl.addCourse(coursename, fees);
		if (status == false) {
			return new ResponseEntity<String>(adminexcp4.getMessage(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>("Course Added!", HttpStatus.OK);
	}
	
	
	/**
	 * This method will check the URL and call the deleteCourse() method
	 * @author G2
	 * @category DELETE  
	 * @param cid course id
	 * URL Pattern:/deletecourse/{cid}
	 *
	 */
	
	@RequestMapping( method = RequestMethod.DELETE,value = "/deletecourse/{cid}")
	@ResponseBody
	public ResponseEntity<String> deleteCourse(@PathVariable("cid") int cid) {

		boolean status = adminDAOImpl.deleteCourse(cid);
		if (status == false) {
			return new ResponseEntity<String>(adminexcp5.getMessage(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>("Course Deleted!", HttpStatus.OK);
	}
	
	/**
	 * This method will check the URL and call the updatePaymentStatus() method
	 * @author G2
	 * @category PUT  
	 * @param sid is student id
	 * @param cid is course id
	 * URL Pattern:/updatePaymentStatus/{sid}/{cid}
	 *
	 */
	
	@RequestMapping( method = RequestMethod.PUT,value = "/updatePaymentStatus/{sid}/{cid}")
	@ResponseBody
	public ResponseEntity<String> updatePaymentStatus(@PathVariable("sid") int sid,@PathVariable("cid") int cid) {

		boolean status = adminDAOImpl.updatePaymentStatus(sid,cid);
		if (status == false) {
			return new ResponseEntity<String>(adminexcp6.getMessage(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>("payment status updated!", HttpStatus.OK);
	}
	
	/**
	 * This method will check the URL and call the approveStudent() method
	 * @author G2
	 * @category PUT  
	 * @param sid is student id
	 * URL Pattern:/approveStudent/{sid}
	 *
	 */
	
	@RequestMapping( method = RequestMethod.PUT,value = "/approveStudent/{sid}")
	@ResponseBody
	public ResponseEntity<String> approveStudent(@PathVariable("sid") int sid) {

		boolean status = adminDAOImpl.approveStudent(sid);
		if (status == false) {
			return new ResponseEntity<String>(adminexcp7.getMessage(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>("Student Approved!", HttpStatus.OK);
	}
	
	/**
	 * This method will check the URL and call the updatePassword() method
	 * @author G2
	 * @category PUT  
	 * @param id is user id
	 * @param oldpassword is student existing password
	 * @param newpassword is student new password
	 * URL Pattern:/approveStudent/{sid}
	 *
	 */
	
	@RequestMapping( method = RequestMethod.PUT,value = "/updatePassword")
	@ResponseBody
	public ResponseEntity<String> updatePassword(@RequestParam("newpwd") String newpwd,@RequestParam("id") int id,@RequestParam("oldpwd") String oldpwd) {

		boolean status = adminDAOImpl.updateUserPassword(newpwd,id,oldpwd);
		if (status == false) {
			return new ResponseEntity<String>(adminexcp8.getMessage(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>("Password Updated !!", HttpStatus.OK);
	}
}

