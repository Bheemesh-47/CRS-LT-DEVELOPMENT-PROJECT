/**
 * 
 */
package com.lt.exceptions;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Deepikareddy , Bheem , Shiva Amancha, Shiva, Dinesh, Rajnish
 * @category ProfessorException
 */
@Component
public class ProfessorAddingGradesFailException extends Exception {
	/**
	 * @exception ProfessorAddingGradesFailException
	 */
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Dear Professor, adding grades to students in CRS application has failed. Please try again later.";
	}
}
