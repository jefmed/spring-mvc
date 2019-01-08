package com.jefmed.workshopmongo.controller.mapper;

import com.jefmed.workshopmongo.model.request.UsuarioRequest;
import com.jefmed.workshopmongo.model.Usuario;

public class UsuarioMapper {

	public static Usuario mapToUser(UsuarioRequest usuarioRequest) {
		if(usuarioRequest == null) return null;
		return Usuario.builder()
				.nome(usuarioRequest.getNome())
				.email(usuarioRequest.getEmail())
				.build();
	}

}
