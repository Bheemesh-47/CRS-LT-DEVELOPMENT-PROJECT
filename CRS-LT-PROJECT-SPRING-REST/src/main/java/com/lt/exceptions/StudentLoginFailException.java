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
public class StudentLoginFailException extends Exception {
	/**
	 * @exception StudentLoginFailException
	 */
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Dear Student, your log in is failed. Please try again later.";
	}
}
