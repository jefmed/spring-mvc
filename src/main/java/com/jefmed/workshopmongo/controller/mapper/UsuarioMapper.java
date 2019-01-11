package com.jefmed.workshopmongo.controller.mapper;

import com.jefmed.workshopmongo.model.request.UsuarioRequest;
import com.jefmed.workshopmongo.model.Usuario;

public class UsuarioMapper {

	public static Usuario mapToUser(UsuarioRequest usuarioRequest) {
		if(usuarioRequest == null) return null;
		return Usuario.builder()
				.id(usuarioRequest.getIdentity())
				.nome(usuarioRequest.getNome())
				.email(usuarioRequest.getEmail())
				.build();
	}
	public static UsuarioRequest userToMap(Usuario usuario) {
		if(usuario == null) return null;
		return UsuarioRequest.builder()
				.identity(usuario.getId())
				.nome(usuario.getNome())
				.email(usuario.getEmail())
				.build();
	}

}
