package com.lt.crs.application.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lt.crs.application.dto.ProfessorDto;
import com.lt.crs.application.entity.Course;
import com.lt.crs.application.entity.Professor;
import com.lt.crs.application.entity.Student;
import com.lt.crs.application.entity.StudentGrade;
import com.lt.crs.application.service.AdminService;

/**
 * This is AdminController class where admin related end points are there
 * 
 * @author deepika, Shiva, Shiva Amancha, Dinesh, Rajneesh, Bheemesh
 *
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
	public static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Autowired
	AdminService adminService;

	/**
	 * save course restEndPoint is used by the admin to save the new course details into database
	 * @param course
	 * @return the course addition success or fail 
	 * url : "/course"
	 * description: This method adds the course to the respective DB Table
	 */
	//@PostMapping("/course")
	@RequestMapping( method = RequestMethod.POST,value = "/course")
	public ResponseEntity<String> saveCourse(@RequestBody Course course) {
		logger.info("In add course method Admin controller :" + course);
		course = adminService.saveCourse(course);
		logger.info("Course is saved with Id:" + course.getCourseId());
		return new ResponseEntity<String>("New Course added successfully With Id" + " " + course.getCourseId(),
				HttpStatus.OK);
	}

	/**
	 * Delete the course by course id by the admin
	 * 
	 * @param id
	 * url : "/course/{id}"
	 * description: This method deletes the course from the respective DB Table
	 */

	//@DeleteMapping("/course/{id}")
	@RequestMapping( method = RequestMethod.DELETE,value = "/course/{id}")
	public ResponseEntity<String> deleteCourseById(@PathVariable int id) {
		logger.info("In delete course method Admin controller :" + id);
		adminService.deleteCourseById(id);
		logger.info("Course is deleted Id:" + id);
		return new ResponseEntity<String>("course is deleted successfully With Id" + " " + id, HttpStatus.OK);
	}

	/**
	 * @param professorDto
	 * url : "/professor"
	 * description: This method adds the professor to the respective DB Table
	 */
	//@PostMapping("/professor")
	@RequestMapping( method = RequestMethod.POST,value = "/professor")
	public ResponseEntity<String> saveProfessor(@RequestBody ProfessorDto professorDto) {
		logger.info("In add Professor method Admin controller :" + professorDto);
		Professor professor = adminService.saveProfessor(professorDto);
		logger.info("Professor is saved with Id :" + professor.getProfessorId());
		return new ResponseEntity<String>(
				"professor is saved successfully with Id :" + " " + professor.getProfessorId(), HttpStatus.OK);
	}

	/**
	 * 
	 * @param professorId
	 * description : This method Deletes the professor from the respective DB Table
	 */

	//@DeleteMapping("/professor/{professorId}")
	@RequestMapping( method = RequestMethod.DELETE,value = "/professor/{professorId}")
	public ResponseEntity<String> deleteProfessorById(@PathVariable int professorId) {
		logger.info("In Remove professor method admin controller class");
		adminService.deleteProfessorById(professorId);
		logger.info("Professor is deleted with Id :" + professorId);
		return new ResponseEntity<String>("professor is deleted successfully with Id" + " " + professorId,
				HttpStatus.OK);
	}

	/**
	 * 
	 * @param studentId
	 * uel : "/approveStudent"
	 * description : In this method student is approved by the admin 
	 */

	//@GetMapping("/approveStudent")
	@RequestMapping( method = RequestMethod.GET,value = "/approveStudent")
	public ResponseEntity<String> approveStudent(@RequestParam int studentId) {
		logger.info("In approveStudent method admin controller class");
		Student student = adminService.approveStudent(studentId);
		logger.info("Approved student Id :"+studentId);
		return new ResponseEntity<String>("Student has been Approved with this Id:" + " " + student.getStudentID(),
				HttpStatus.OK);
	}

	/**
	 * 
	 * @param studentId
	 * url : "/rejectStudent"
	 * description : In this method student is rejected by the admin 
	 */

	//@DeleteMapping("/rejectStudent")
	@RequestMapping( method = RequestMethod.DELETE,value = "/rejectStudent")
	public ResponseEntity<String> rejectStudent(@RequestParam int studentId) {
		logger.info("In rejectStudent method admin controller class");
		Student student = adminService.rejectStudent(studentId);
		logger.info("Rejected student Id:"+studentId);
		return new ResponseEntity<String>("Student has been rejected with this Id:" + " " + student.getStudentID(),
				HttpStatus.OK);
	}

	/**
	 * 
	 * @return Report card
	 * url : "/generateReportCard"
	 * description : is used for genarating the report card for the students
	 */
	//@GetMapping("/generateReportCard")
	@RequestMapping( method = RequestMethod.GET,value = "/generateReportCard")
	public ResponseEntity<List<StudentGrade>> generateReportCard() {
		logger.info("In generateReportCard method admin controller class");
		List<StudentGrade> grades = adminService.generateReportCard();
		logger.info("Generating Report card"+grades);
		return new ResponseEntity<List<StudentGrade>>(grades, HttpStatus.OK);
	}

}
