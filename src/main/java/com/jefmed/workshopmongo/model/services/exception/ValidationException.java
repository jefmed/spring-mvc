package com.jefmed.workshopmongo.model.services.exception;

public abstract class ValidationException extends ApiException{

	public abstract String getField();

	public abstract String getFieldMessage();
}
