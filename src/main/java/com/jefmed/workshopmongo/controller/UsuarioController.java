package com.jefmed.workshopmongo.controller;

import com.jefmed.workshopmongo.model.Usuario;
import com.jefmed.workshopmongo.model.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // indica que a classe é responsavel por requisiçoes vindas do cliente e q eh um recurso Rest
@RequestMapping(value = "/usuarios") //indica o caminho do endpoint, e qual classe sera usada.
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioServ; //instancia automaticamente o objto (injecao de dependencia)

    @GetMapping
    //ResponseEntity auxilia no retorno de requisições HTTP e possiveis erros
    public ResponseEntity<List<Usuario>> findAll(){
        List<Usuario> list = usuarioServ.findAll(); // busca no BD e guarda na lista/var
        return ResponseEntity.ok() // metodo q instancia o RespInt ja com cod HTTP de sucesso(200)
                .body(list); // define o corpo da resposta
    }
}
