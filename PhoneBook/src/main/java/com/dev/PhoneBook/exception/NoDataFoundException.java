package com.dev.PhoneBook.exception;

public class NoDataFoundException  extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7244475311323738091L;

	public NoDataFoundException() {
		
	}
	
	public NoDataFoundException(String msg) {
		
		super(msg);
	}

}
