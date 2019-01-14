package com.jefmed.workshopmongo.model.services.error;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
public class ValidationErrorDetails extends ErrorDetails {
	private String field;
	private String fieldMessage;

	@Builder(builderMethodName = "validationBuilder")
	public ValidationErrorDetails(String title, Integer status, String detail, LocalDateTime timestamp, String developerMessage, String field, String fieldMessage) {
		super(title, status, detail, timestamp, developerMessage);
		this.field = field;
		this.fieldMessage = fieldMessage;
	}
}
