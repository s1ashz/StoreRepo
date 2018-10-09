package com.polo.rest.polo.responses;

public class ResponseJson {

	private String action;
	private boolean success;
	
	public ResponseJson(String action, boolean success ) {
		this.action = action;
		this.success = success;
	}
	
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	@Override
	public String toString() {
		return "ResponseJson [action=" + action + ", success=" + success + "]";
	}
	
}
