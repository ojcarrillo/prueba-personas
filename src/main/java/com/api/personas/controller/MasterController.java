package com.api.personas.controller;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class MasterController {

	public ResponseEntity error(String msg) {
		MessageResponse error = new MessageResponse(msg, HttpStatus.BAD_REQUEST.toString());
		return ResponseEntity.badRequest().body(error);
	}
	
	public ResponseEntity info(String msg) {
		MessageResponse ok = new MessageResponse(msg, HttpStatus.OK.toString());
		return ResponseEntity.ok().body(ok);
	}
	
	public String getRawError(Exception e) {
		return ExceptionUtils.getRootCause(e).getMessage();
	}
}
