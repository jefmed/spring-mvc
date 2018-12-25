package com.jefmed.workshopmongo.model.config;

import com.jefmed.workshopmongo.model.Usuario;
import com.jefmed.workshopmongo.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
@Configuration // indica que a classe é uma configuracao
//classe que popula/instancia o bd
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public void run(String... args) throws Exception {

        usuarioRepository.deleteAll(); //limpa a coleção no DB

        Usuario maria = new Usuario(null, "Maria", "maria@gmail.com");
        Usuario alex = new Usuario(null, "Alex", "alex@gmail.com");
        Usuario bob = new Usuario(null, "Bob", "bob@gmail.com");

        usuarioRepository.saveAll(Arrays.asList(maria, alex, bob));
    }
}
