package com.jefmed.workshopmongo.model.services.error;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ResourceNotFoundDetails extends ErrorDetails {

	@Builder(builderMethodName = "rnfBuilder")
	public ResourceNotFoundDetails(String title, Integer status, String detail, LocalDateTime timestamp, String developerMessage) {
		super(title, status, detail, timestamp, developerMessage);
	}
}
