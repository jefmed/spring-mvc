package com.jefmed.workshopmongo.model.config;

import com.jefmed.workshopmongo.model.Usuario;
import com.jefmed.workshopmongo.model.repository.UsuarioRepository;
import lombok.SneakyThrows;
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
    @SneakyThrows
    public void run(String... args) {

        usuarioRepository.deleteAll(); //limpa a coleção no DB

        Usuario maria = new Usuario(null, "ana", "ana@gmail.com");
        Usuario alex = new Usuario(null, "jose", "jose@gmail.com");
        Usuario bob = new Usuario(null, "nhanha", "nhanha@gmail.com");

        usuarioRepository.saveAll(Arrays.asList(maria, alex, bob));
    }
}
