package com.jefmed.workshopmongo.model.handler;

import com.jefmed.workshopmongo.model.services.error.ErrorDetails;
import com.jefmed.workshopmongo.model.services.error.ResourceNotFoundDetails;
import com.jefmed.workshopmongo.model.services.error.ResourceNotFoundException;
import com.jefmed.workshopmongo.model.services.error.ValidationErrorDetails;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.lang.Nullable;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestErrorHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException rfnException){
		ResourceNotFoundDetails rfnDetails = ResourceNotFoundDetails.rnfBuilder()
				.timestamp(LocalDateTime.now())
				.status(HttpStatus.NOT_FOUND.value())
				.title("RESOURCE NOT FOUND")
				.detail(rfnException.getMessage()) // pega a mensagem informada no erro
				.developerMessage(rfnException.getClass().getName()) // pega o tipo de erro
				.build();
		return new ResponseEntity<>(rfnDetails, HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException manvException, HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<FieldError> fieldErrors = manvException.getBindingResult().getFieldErrors();
		String fields = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(" , "));
		String fieldMessage = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(" , "));
		ValidationErrorDetails manvDetails = ValidationErrorDetails.validationBuilder()
				.timestamp(LocalDateTime.now())
				.status(status.value())
				.title("FIELD VALIDATION ERROR")
				.detail("ERROR >>>>> FIELD VALIDATION ERROR")
				.developerMessage(manvException.getClass().getName()) // pega o tipo de erro
				.field(fields)
				.fieldMessage(fieldMessage)
				.build();
		return new ResponseEntity<>(manvDetails, status);
	}

/*	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorDetails errorDetails = ErrorDetails.builder()
				.timestamp(LocalDateTime.now())
				.status(status.value())
				.title("RESOURCE NOT FOUND")
				.detail(ex.getMessage()) // pega a mensagem informada no erro
				.developerMessage(ex.getClass().getName()) // pega o tipo de erro
				.build();
		return new ResponseEntity<>(errorDetails, headers, status);
	}*/

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(
			Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {

		ErrorDetails errorDetails = ErrorDetails.builder()
				.timestamp(LocalDateTime.now())
				.status(status.value())
				.title("INTERNAL EXCEPTION")
				.detail(ex.getMessage()) // pega a mensagem informada no erro
				.developerMessage(ex.getClass().getName()) // pega o tipo de erro
				.build();
		return new ResponseEntity<>(errorDetails, headers, status);
	}

}
