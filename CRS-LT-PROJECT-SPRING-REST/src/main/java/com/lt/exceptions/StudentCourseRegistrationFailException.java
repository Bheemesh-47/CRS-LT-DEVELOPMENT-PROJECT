/**
 * 
 */
package com.lt.exceptions;

import org.springframework.stereotype.Component;
/**
 * @author Deepikareddy , Bheem , Shiva Amancha, Shiva, Dinesh, Rajnish
 * @category StudentException
 */
@Component
public class StudentCourseRegistrationFailException extends Exception {
	/**
	 * @exception StudentCourseRegistrationFailException
	 */
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Dear Student, your registration to the course could not be completed. Please try again later.";
	}
}
