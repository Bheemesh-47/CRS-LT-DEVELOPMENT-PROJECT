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
public class StudentDropCourseFailException extends Exception {
	/**
	 * @exception StudentDropCourseFailException
	 */
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Dear Student, the course could not be dropped. Please try again later.";
	}
}
