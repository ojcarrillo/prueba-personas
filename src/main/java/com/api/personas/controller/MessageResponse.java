package com.api.personas.controller;

public class MessageResponse {

	private String msg;
	
	private String statusText;

	public MessageResponse(String errormsg, String statusText) {
		super();
		this.msg = errormsg;
		this.statusText = statusText;
	}

	public String getErrormsg() {
		return msg;
	}

	public void setErrormsg(String errormsg) {
		this.msg = errormsg;
	}

	public String getStatusText() {
		return statusText;
	}

	public void setStatusText(String statusText) {
		this.statusText = statusText;
	}

	
}