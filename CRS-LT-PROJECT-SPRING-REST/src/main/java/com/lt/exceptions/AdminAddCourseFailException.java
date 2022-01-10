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
public class AdminAddCourseFailException extends Exception {
	/**
	 * @exception AdminAddCourseFailException
	 */
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Dear Admin, registering new Course to CRS has Failed. Please try again later.";
	}
}
