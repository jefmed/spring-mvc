package com.jefmed.workshopmongo.controller.mapper;

import com.jefmed.workshopmongo.controller.model.request.UsuarioRequest;
import com.jefmed.workshopmongo.model.Usuario;

public class UsuarioMapper {

	public static Usuario mapToImpl(UsuarioRequest usuarioRequest) {
		if(usuarioRequest == null) return null;
		return Usuario.builder()
				.nome(usuarioRequest.getNome())
				.email(usuarioRequest.getEmail())
				.build();
	}

}
