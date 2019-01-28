package com.jefmed.workshopmongo.model.request;

import lombok.*;
import org.springframework.hateoas.ResourceSupport;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true) // problemas com builder em classes extendidas, necessita essas anotações Callsuper
public class UsuarioRequest extends ResourceSupport {


	private String identity;

	@NotEmpty(message = "O campo nome nao pode ser vazio!")
//	@UsuarioUnico
	private String nome;

	@Email(regexp = "[A-Za-z0-9._-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}", message = "É necessário informar um e-mail válido!")
	@NotEmpty(message = "O campo e-mail nao pode ser vazio!")
	private String email;

}
