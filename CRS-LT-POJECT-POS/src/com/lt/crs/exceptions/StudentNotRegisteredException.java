
package com.lt.crs.exceptions;

/**
 * @author deepikareddy
 * @exception StudentNotRegisteredException
 * 
 */
public class StudentNotRegisteredException extends Exception {
	public String getMessage() {		
		return "Student Registration has been Rejected (OR) Pending for Admin Approval";
	}
}
