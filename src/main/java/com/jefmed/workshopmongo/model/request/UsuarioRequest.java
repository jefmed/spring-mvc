package com.jefmed.workshopmongo.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequest {

	@NotEmpty(message = "O campo nome nao pode ser vazio!")
	private String nome;
	@Email(message = "É necessário informail um e-mail válido!")
	@NotEmpty(message = "O campo e-mail nao pode ser vazio!")
	private String email;

}
