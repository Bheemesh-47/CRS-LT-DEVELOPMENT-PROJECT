package com.lt.crs.exception;

/**
 * @author deepika, Shiva, Shiva Amancha, Dinesh, Rajneesh, Bheemesh
 */
public class InsufficientCardDetailsException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InsufficientCardDetailsException(String msg){
		super(msg);
	}
}
