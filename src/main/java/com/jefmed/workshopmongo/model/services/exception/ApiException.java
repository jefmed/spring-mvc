package com.jefmed.workshopmongo.model.services.exception;

import org.springframework.http.HttpStatus;

public abstract class ApiException extends RuntimeException {

	public abstract String getMessage();

	public abstract String getDetail();

	public abstract Integer getCode();

	public abstract HttpStatus getHttpStatus();

}
