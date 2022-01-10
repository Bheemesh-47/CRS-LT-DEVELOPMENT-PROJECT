/**
 * 
 */
package com.lt.exceptions;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author Deepikareddy , Bheem , Shiva Amancha, Shiva, Dinesh, Rajnish
 * @category AdminException
 */

@Component
public class AdminLoginFailException extends Exception {
	/**
	 * @exception AdminLoginFailException
	 */
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "The Login is failed!! Please try with proper credentials";
	}
}
