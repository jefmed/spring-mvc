package com.jefmed.workshopmongo.model.request;

import lombok.*;
import org.springframework.hateoas.ResourceSupport;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UsuarioRequest extends ResourceSupport {


	@NotEmpty(message = "Campo ID nao pode ser cazio!")
	private String identity;

	@NotEmpty(message = "O campo nome nao pode ser vazio!")
	private String nome;

	@Email(message = "É necessário informar um e-mail válido!")
	@NotEmpty(message = "O campo e-mail nao pode ser vazio!")
//	@NotBlank(message = "O campo e-mail nao pode ser branco")
	private String email;

}
