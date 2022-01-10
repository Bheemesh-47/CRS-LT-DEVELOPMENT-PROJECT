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
public class ProfessorLoginFailException extends Exception {
	/**
	 * @exception ProfessorLoginFailException
	 */
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Dear Professor, Logging to CRS Application has failed. Please try again later.";
	}
}
