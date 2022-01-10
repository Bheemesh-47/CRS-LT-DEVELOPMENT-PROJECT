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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lt.DAO.CourseDAOImpl;
import com.lt.bean.Course;
import com.lt.bean.Professor;

/**
 * @author Deepikareddy , Bheem , Shiva Amancha, Shiva, Dinesh, Rajnish
 * @category CourseRestController
 */
@RestController
@CrossOrigin
public class CourseRestController {


	@Autowired
	private CourseDAOImpl couDAO;

	/**
	 * This method will check the URL and calls the listCourses() method 
	 * @author Deepikareddy , Bheem , Shiva Amancha, Shiva, Dinesh, Rajnish
	 * @return It returns List of courses
	 * @category PUT  
	 * URL Pattern:/listcourses
	 *
	 */
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET,value = "/listcourses")
	@ResponseBody
	public List<Course> getCoursesD() {	
		return couDAO.listCourses();
	}

}
