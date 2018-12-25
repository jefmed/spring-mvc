package com.jefmed.workshopmongo.model.services;

import com.jefmed.workshopmongo.model.Usuario;
import com.jefmed.workshopmongo.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // indica que a classe represente um componente ligado a regra de negocio, permitindo sua injecao
public class UsuarioService {

    @Autowired // instancia automaticamente o objto (injecao de dependencia)
    private UsuarioRepository usuarioRepo;


    //metodo responsavel por retornar todos os usuarios do banco
    public List<Usuario> findAll(){
        return usuarioRepo.findAll();
    }
}
