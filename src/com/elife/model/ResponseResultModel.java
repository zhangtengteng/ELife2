package com.elife.model;

public class ResponseResultModel {
	private boolean success;
	private int result;
	private String message;
	private String datacity;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getDatacity() {
		return datacity;
	}
	public void setDatacity(String datacity) {
		this.datacity = datacity;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
