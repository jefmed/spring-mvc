package com.jefmed.workshopmongo.model.services.exception;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ValidationExceptionModel extends ApiExceptionModel {
	private String field;
	private String fieldMessage;

	@Builder(builderMethodName = "validationBuilder")
	public ValidationExceptionModel(String message, String detail, Integer code, Long timestamp, String field, String fieldMessage) {
		super(message, detail, code, timestamp);
		this.field = field;
		this.fieldMessage = fieldMessage;
	}
}
