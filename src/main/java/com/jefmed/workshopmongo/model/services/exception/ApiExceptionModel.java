package com.jefmed.workshopmongo.model.services.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiExceptionModel {

	private String message;
	private String detail;
	private Integer code;

}
