/**
 * 
 */
package com.lt.exceptions;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Deepikareddy , Bheem , Shiva Amancha, Shiva, Dinesh, Rajnish
 * @category ProfessorException
 */
@Component
public class ProfessorFetchStudentFailException extends Exception {
	/**
	 * @exception ProfessorFetchStudentFailException
	 */
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Dear Professor, fetching the information has failed. Please try again later.";
	}
}
