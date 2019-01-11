package com.jefmed.workshopmongo.model.services.error;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResourceNotFoundDetails extends ErrorDetails {

	@Builder(builderMethodName = "rnfBuilder")
	public ResourceNotFoundDetails(String title, Integer status, String detail, Long timestamp, String developerMessage) {
		super(title, status, detail, timestamp, developerMessage);
	}
}
