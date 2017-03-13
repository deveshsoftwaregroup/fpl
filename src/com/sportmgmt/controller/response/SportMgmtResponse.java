package com.sportmgmt.controller.response;

import java.util.List;

import com.sportmgmt.utility.exception.SportMgmtException;

public class SportMgmtResponse<T> {
	
	private boolean isSuccess;
	private String message;
	private List<String> logList;
	private T result;
	
	public T getResult() {
		return result;
	}
	public void setResult(T result) {
		this.result = result;
	}
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<String> getLogList() {
		return logList;
	}
	public void setLogList(List<String> logList) {
		this.logList = logList;
	}
	
	public String toString()
	{
		return "isSuccess = "+isSuccess+" , result = "+result;
	}
}
