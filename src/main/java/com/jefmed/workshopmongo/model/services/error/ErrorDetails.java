package com.jefmed.workshopmongo.model.services.error;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDetails {
	private String title;
	private Integer status;
	private String detail;
	private Long timestamp;
	private String developerMessage;
}
