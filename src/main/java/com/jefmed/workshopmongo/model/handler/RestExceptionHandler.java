package com.jefmed.workshopmongo.model.handler;


import com.jefmed.workshopmongo.model.services.exception.ApiException;
import com.jefmed.workshopmongo.model.services.exception.ApiExceptionModel;
import com.jefmed.workshopmongo.model.services.exception.ObjectNotFoundDetails;
import com.jefmed.workshopmongo.model.services.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice // permite utilizar a classe atraves das camadas
public class RestExceptionHandler {
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<?> handlerObjectNotFoundException(ObjectNotFoundException onfException){
		ObjectNotFoundDetails onf =  ObjectNotFoundDetails.builder()
				.timestamp(new Date().getTime())
				.status(HttpStatus.NOT_FOUND.value())
				.title("Objeto nao encontrado")
				.detail(onfException.getMessage())
				.devmsg(onfException.getClass().getName())
				.build();
		return new ResponseEntity<>(onf, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ApiException.class)
	public ResponseEntity<ApiExceptionModel> handleApiException(ApiException apiException){
		return new ResponseEntity<>(
				ApiExceptionModel.builder()
						.message(apiException.getMessage())
						.detail(apiException.getDetail())
						.code(apiException.getCode())
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
