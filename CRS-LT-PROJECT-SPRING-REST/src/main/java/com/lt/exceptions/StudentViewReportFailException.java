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
public class StudentViewReportFailException extends Exception {
	/**
	 * @exception StudentViewReportFailException
	 */
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Dear Student, your report card cannot be fetched. Please try again later.";
	}
}
