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
    private UsuarioRepository usuarioRepo;


    //metodo responsavel por retornar todos os usuarios do banco
    public List<Usuario> findAll(){

    	return usuarioRepo.findAll();
    }

    //metodo responsavel por encontrar usuario por ID
    public Usuario findById(String id) {
        Optional<Usuario> obj = usuarioRepo.findById(id); //retorna o usuario por id
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado")); // ou retorna a excessao
    }

    //metodo responsavel por inserir novos usuarios
    public Usuario insert(Usuario obj){

    	return usuarioRepo.insert(obj);
    }

    //metodo responsavel por deletar usuarios
    public void delete(String id){

    	usuarioRepo.deleteById(id);
    }

	//metodo responsavel por fazer o update em usuario especifico
	public Usuario update(Usuario obj){
    	Usuario novoObj = findById(obj.getId());
    	updateData(novoObj, obj);
    	return usuarioRepo.save(novoObj);
	}

	//metodo responsavel por copiar os novos dados de obj para novoobj
	private void updateData(Usuario novoObj, Usuario obj) {
    	novoObj.setNome(obj.getNome());
    	novoObj.setEmail(obj.getEmail());
	}


	// metodo responsavel por retornar os dados d eum usuario
	public Usuario fromUser(Usuario obj) {
		return new Usuario(obj.getId(), obj.getNome(), obj.getEmail());
	}


}
