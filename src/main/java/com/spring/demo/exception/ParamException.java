package com.spring.demo.exception;

public class ParamException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3155242587563794522L;
	
	private ErrorCode code;
	
	public ParamException(ErrorCode paramerror,String message) {
        super(message);
    	this.code = paramerror;
    }

	public ErrorCode getCode() {
		return code;
	}

	public void setCode(ErrorCode code) {
		this.code = code;
	}
	
	
}
