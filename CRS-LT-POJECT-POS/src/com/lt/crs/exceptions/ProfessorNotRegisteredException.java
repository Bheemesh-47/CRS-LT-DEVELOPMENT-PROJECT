
package com.lt.crs.exceptions;

/**
 * @author deepikareddy
 * @exception ProfessorNotRegisteredException
 *
 */
public class ProfessorNotRegisteredException extends Exception{
	public String getMessage() {
		return "Professor Registration has been Rejected (OR) Pending for Admin Approval";
	}
}
