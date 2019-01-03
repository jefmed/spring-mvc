package com.jefmed.workshopmongo.model.services.exception;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ObjectNotFoundDetails {
	private String title;
	private Integer status;
	private String detail;
	private Long timestamp;
	private String devmsg;


}
