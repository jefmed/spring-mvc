package com.jefmed.workshopmongo.model.services.exception;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class ServerErrorException extends ApiException {

	private String error;

	public ServerErrorException(String error) {
		this.error = error;
	}

	@Override
	public String getMessage() {
		return error;
	}

	@Override
	public String getDetail() {
		return "asdad";
	}

	@Override
	public Integer getCode() {
		return 10;
	}

	@Override
	public Long getTimeStamp() {
		return new Date().getTime();
	}

	@Override
	public HttpStatus getHttpStatus() {
		return HttpStatus.INTERNAL_SERVER_ERROR;
	}
}
