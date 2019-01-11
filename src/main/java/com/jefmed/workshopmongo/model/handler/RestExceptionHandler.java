package com.jefmed.workshopmongo.model.handler;


import com.jefmed.workshopmongo.model.services.exception.ApiException;
import com.jefmed.workshopmongo.model.services.exception.ApiExceptionModel;
import com.jefmed.workshopmongo.model.services.exception.ValidationException;
import com.jefmed.workshopmongo.model.services.exception.ValidationExceptionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*
@ControllerAdvice // permite utilizar a classe atraves das camadas
public class RestExceptionHandler{

	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<ValidationExceptionModel> handleValidationException(ValidationException validationException){
		return new ResponseEntity<>(
				ValidationExceptionModel.validationBuilder()
						.message(validationException.getMessage())
						.detail(validationException.getDetail())
						.code(validationException.getCode())
						.timestamp(validationException.getTimeStamp())
						.field(validationException.getField())
						.fieldMessage(validationException.getFieldMessage())
						.build(),
				validationException.getHttpStatus());
	}

	@ExceptionHandler(ApiException.class)
	public ResponseEntity<ApiExceptionModel> handleApiException(ApiException apiException){
		return new ResponseEntity<>(
				ApiExceptionModel.builder()
						.message(apiException.getMessage())
						.detail(apiException.getDetail())
						.code(apiException.getCode())
						.timestamp(apiException.getTimeStamp())
						.build(),
				apiException.getHttpStatus());
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiExceptionModel> handleApiException(Exception exception){
		exception.printStackTrace();
		return new ResponseEntity<>(
				ApiExceptionModel.builder()
						.message("Entre em contato com o suporte")
						.build(),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
*/
