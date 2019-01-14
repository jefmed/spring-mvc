package com.jefmed.workshopmongo.model.request;

import lombok.*;
import org.springframework.hateoas.ResourceSupport;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true) // problemas com builder em classes extendidas, necessita essas anotações Callsuper
public class UsuarioRequest extends ResourceSupport {


	private String identity;

	@NotEmpty(message = "O campo nome nao pode ser vazio!")
	private String nome;

	@Email(regexp = "[A-Za-z0-9._-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}", message = "É necessário informar um e-mail válido!")
//	@Email(regexp = "\\w+@\\w+\\.\\w", message = "É necessário informar um e-mail válido!")
//	@Pattern(regexp = ".+@.+\\.[a-z]+", message = "Digite um e-mail válido!")
	@NotEmpty(message = "O campo e-mail nao pode ser vazio!")
//	@NotBlank(message = "O campo e-mail nao pode ser branco")
	private String email;

}
