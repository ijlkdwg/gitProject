package com.wsq.jhone.base.exception;

import org.apache.shiro.authc.AuthenticationException;

public class ValidCodeException extends AuthenticationException {
	 /**
	 * 
	 */
	private static final long serialVersionUID = -2905407402189475160L;

	public ValidCodeException(String msg){  
	        super(msg);  
	    }  
}
