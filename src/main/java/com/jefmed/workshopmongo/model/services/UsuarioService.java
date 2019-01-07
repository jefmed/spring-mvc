package com.jefmed.workshopmongo.model.services;

import com.jefmed.workshopmongo.model.Usuario;
import com.jefmed.workshopmongo.model.repository.UsuarioRepository;
import com.jefmed.workshopmongo.model.services.exception.ObjectNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // indica que a classe represente um componente ligado a regra de negocio, permitindo sua injecao
@AllArgsConstructor
public class UsuarioService {

//    @Autowired // instancia automaticamente o objto (injecao de dependencia)
    private UsuarioRepository usuarioRepository;

    //metodo responsavel por retornar todos os usuarios do banco
    public List<Usuario> findAllUsers(){
    	return usuarioRepository.findAll();
    }

    //metodo responsavel por verificar/encontrar usuario pelo ID, caso nao exista lança uma excessao.
    public Usuario findUserById(String id) {
	    return usuarioRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("OBJETO COM ID: "+id+", NAO ENCONTRADO!"));
    }

    //metodo responsavel por inserir novos usuarios
    public Usuario insertNovoUsuario(Usuario objetoUsuario){
    	return usuarioRepository.insert(objetoUsuario);
    }

    //metodo responsavel por deletar usuarios
    public void deleteUsuario(String id){
    	findUserById(id);
    	usuarioRepository.deleteById(id);
    }

	//metodo responsavel por fazer o update em usuario especifico
	public Usuario update(Usuario objetoUsuario, String id){
    	Usuario novoObjetoUsuario = findUserById(id);
		novoObjetoUsuario.setNome(objetoUsuario.getNome());
    	novoObjetoUsuario.setEmail(objetoUsuario.getEmail());
	    return usuarioRepository.save(novoObjetoUsuario);
	}

}
