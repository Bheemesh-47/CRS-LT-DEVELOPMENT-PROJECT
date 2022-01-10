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
public class UserPasswordUpdationFailException extends Exception {
	/**
	 * @exception UserPasswordUpdationFailException
	 */
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Dear user, your password could not be updated. Please try again later.";
	}
}
