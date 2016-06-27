package com.wsq.jhone.base.exception;

public abstract class WSQBaseRuntimeException extends RuntimeException{ 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public abstract String getJsonMessage();

}
