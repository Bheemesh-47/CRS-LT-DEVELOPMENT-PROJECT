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
public class StudentCoursePayementFailException extends Exception {
	/**
	 * @exception StudentCoursePayementFailException
	 */
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Dear Student, The payement to your course could not be completed. Please try again later.";
	}
}
