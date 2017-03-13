package com.sportmgmt.utility.exception;

public class SportMgmtException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorCode;
	public SportMgmtException()
	{
		super();
	}

	public SportMgmtException(String message)
	{
		super(message);
	}
	public SportMgmtException(Exception ex)
	{
		super(ex);
	}
	public SportMgmtException(String errorCode,String message)
	{
		super(message);
		this.errorCode = errorCode;
	}
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	
}
