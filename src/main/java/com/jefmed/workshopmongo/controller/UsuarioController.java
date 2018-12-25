package com.jefmed.workshopmongo.controller;

import com.jefmed.workshopmongo.model.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController // indica que a classe é responsavel por requisiçoes vindas do cliente e q eh um recurso Rest
@RequestMapping(value = "/usuarios") //indica o caminho do endpoint, e qual classe sera usada.
public class UsuarioController {

    @GetMapping
    //ResponseEntity auxilia no retorno de requisições HTTP e possiveis erros
    public ResponseEntity<List<Usuario>> findAll(){
        Usuario maria = new Usuario("1", "maria", "maria@gmail.com");
        Usuario alex = new Usuario("2", "alex", "alex@gmail.com");
        List<Usuario> list = new ArrayList<>();
        list.addAll(Arrays.asList(maria, alex));
        return ResponseEntity.ok() // metodo q instancia o RespInt ja com cod HTTP de sucesso(200)
                .body(list); // define o corpo da resposta
    }
}
