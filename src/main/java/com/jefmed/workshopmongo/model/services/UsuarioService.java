package com.jefmed.workshopmongo.model.services;

import com.jefmed.workshopmongo.model.Usuario;
import com.jefmed.workshopmongo.model.repository.UsuarioRepository;
import com.jefmed.workshopmongo.model.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // indica que a classe represente um componente ligado a regra de negocio, permitindo sua injecao
public class UsuarioService {

    @Autowired // instancia automaticamente o objto (injecao de dependencia)
    private UsuarioRepository usuarioRepository;


    //metodo responsavel por retornar todos os usuarios do banco
    public List<Usuario> findAllUsers(){

    	return usuarioRepository.findAll();
    }

    //metodo responsavel por encontrar usuario por ID
    public Usuario findUserById(String id) {
        Optional<Usuario> objetoUsuarioOptional = usuarioRepository.findById(id); //retorna o usuario por id
        return objetoUsuarioOptional.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado")); // ou retorna a excessao

    }

    //metodo responsavel por inserir novos usuarios
    public Usuario insertNovoUsuario(Usuario objetoUsuario){

    	return usuarioRepository.insert(objetoUsuario);
    }

    //metodo responsavel por deletar usuarios
    public void deleteUsuario(String idUsuario){

    	usuarioRepository.deleteById(idUsuario);
    }

	//metodo responsavel por fazer o update em usuario especifico
	public Usuario update(Usuario objetoUsuario){
    	Usuario novoObjetoUsuario = findUserById(objetoUsuario.getId());
    	updateData(novoObjetoUsuario, objetoUsuario);
    	return usuarioRepository.save(novoObjetoUsuario);
	}

	//metodo responsavel por copiar os novos dados de obj para novoobj
	private void updateData(Usuario novoObjetoUsuario, Usuario objetoUsuario) {
    	novoObjetoUsuario.setNome(objetoUsuario.getNome());
    	novoObjetoUsuario.setEmail(objetoUsuario.getEmail());
	}


	// metodo responsavel por retornar os dados d eum usuario
	public Usuario returnFromUser(Usuario objetoUsuario) {
		return new Usuario(objetoUsuario.getId(), objetoUsuario.getNome(), objetoUsuario.getEmail());
	}


}
