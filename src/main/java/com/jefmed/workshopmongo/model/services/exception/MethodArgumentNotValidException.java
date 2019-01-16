package com.jefmed.workshopmongo.model.services.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class MethodArgumentNotValidException extends ValidationException{

	private String error;
	private List<FieldError> fieldErrorList;

	public MethodArgumentNotValidException(String error, List<FieldError> fieldErrorList) {
		this.error = error;
		this.fieldErrorList = fieldErrorList;
	}

	@Override
	public String getField() {
		return fieldErrorList.stream().map(FieldError::getField).collect(Collectors.joining(","));
	}

	@Override
	public String getFieldMessage() {
		return fieldErrorList.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(","));
	}

	@Override
	public String getMessage() {
		return error;
	}

	@Override
	public String getDetail() {
		return "testando getdetail METHOD ARG";
	}

	@Override
	public Integer getCode() {
		return 2345678;
	}

	@Override
	public Long getTimeStamp() {
		return new Date().getTime();
	}

	@Override
	public HttpStatus getHttpStatus() {
		return HttpStatus.BAD_REQUEST;
	}
}
