
package com.lt.restcontroller;
/**
 * @author Deepikareddy , Bheem , Shiva Amancha, Shiva, Dinesh, Rajnish
 * @category ProfessorRestController
 */

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

import com.lt.DAO.*;
import com.lt.bean.Professor;
import com.lt.exceptions.AdminDeleteProfessorFailException;
import com.lt.exceptions.ProfessorAddingGradesFailException;
import com.lt.exceptions.ProfessorFetchStudentFailException;
import com.lt.exceptions.ProfessorLoginFailException;


@RestController
@CrossOrigin
public class ProfessorRestController {


	@Autowired
	private ProfessorDAOImpl professorDAO;

	
	/**
	 * All exception objects are created here
	 */
	
	@Autowired
	ProfessorLoginFailException profexcp1;
	
	@Autowired
	ProfessorFetchStudentFailException profexcp2;
	
	@Autowired
	ProfessorAddingGradesFailException profexcp3;
	
	/**
	 * This method will perform Professor login
	 * @author Deepikareddy , Bheem , Shiva Amancha, Shiva, Dinesh, Rajnish
	 * @category GET  
	 * @param id is Professor ID
	 * @param pwd is Professor Password
	 * URL Pattern:/plogin
	 *
	 */
	@RequestMapping(method = RequestMethod.GET,value = "/plogin")
	@ResponseBody
	public ResponseEntity getProfessors(@RequestParam("id") int id,@RequestParam("pwd") String pwd) {

		boolean Professor = professorDAO.professorLogin(id, pwd);
		if (Professor == false) {
			return new ResponseEntity(profexcp1.getMessage(), HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity("Login Successful!", HttpStatus.OK);

	}

	/**
	 * This method will call viewEnrolledStudents() method 
	 * @author Deepikareddy , Bheem , Shiva Amancha, Shiva, Dinesh, Rajnish
	 * @category GET  
	 * @param cid is Course ID
	 * URL Pattern:/viewenrolledstudents/{cid}
	 *
	 */
	@RequestMapping( method = RequestMethod.GET,value = "/viewenrolledstudents/{cid}")
	@ResponseBody
	public ResponseEntity getEnrolledStudents(@PathVariable("cid") int cid) {

		List list = professorDAO.viewEnrolledStudents(cid);
		if (list == null) {
			return new ResponseEntity(profexcp2.getMessage(), HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(list, HttpStatus.OK);

	}



	/**
	 * This method will call addGrades() method 
	 * @author Deepikareddy , Bheem , Shiva Amancha, Shiva, Dinesh, Rajnish
	 * @category PUT  
	 * @param sid is Student ID
	 * @param cid is Course ID
	 * @param grade is Student Grade
	 * URL Pattern:/addgrade/{sid}/{cid}/{grade}
	 *
	 */
	@RequestMapping(method = RequestMethod.PUT,value = "/addgrade/{sid}/{cid}/{grade}")
	@ResponseBody
	public ResponseEntity<String> getStudents(@PathVariable("sid") int sid,@PathVariable("cid") int cid,@PathVariable("grade") String grade) {

		boolean student = professorDAO.addGrades(sid, cid,grade);
		if (student == false) {
			return new ResponseEntity<String>(profexcp3.getMessage(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>("Grade added successfully to the student with ID : " + sid +" for the given Course ID: "+ cid, HttpStatus.OK);
	}   


}
