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
        Optional<Usuario> obj = usuarioRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    //metodo responsavel por inserir novos usuarios
    public Usuario insert(Usuario obj){
        return usuarioRepo.insert(obj);
    }

    //metodo responsavel por deletar usuarios
    public void delete(String id){
        usuarioRepo.deleteById(id);
    }




}
