package com.employee_dept_manager.payloadDTO;

import org.springframework.http.HttpStatus;

public class ResponseWrapperDTO {

	private HttpStatus status;
	private String message;
	private String error;
	private Object data;

	public ResponseWrapperDTO(HttpStatus status, String message, String error, Object data) {
		this.status = status;
		this.message = message;
		this.error = error;
		this.data = data;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
