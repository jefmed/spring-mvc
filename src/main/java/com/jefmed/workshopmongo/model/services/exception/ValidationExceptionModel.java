package com.jefmed.workshopmongo.model.services.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationErrorModel extends ApiExceptionModel {
	private String field;
	private String fieldMessage;

}
