package com.jefmed.workshopmongo.controller;

import com.jefmed.workshopmongo.model.Usuario;
import com.jefmed.workshopmongo.model.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // indica que a classe é responsavel por requisiçoes vindas do cliente e q eh um recurso Rest
@RequestMapping(value = "/usuarios") //indica o caminho do endpoint, e qual classe sera usada.
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService; //instancia automaticamente o objto (injecao de dependencia)

    @GetMapping
    //ResponseEntity auxilia no retorno de requisições HTTP e possiveis erros, contemplando: Status code; headers e body
    public ResponseEntity<List<Usuario>> findAllUsers(){
        List<Usuario> listaUsuarios = usuarioService.findAllUsers(); // busca no BD e guarda na lista/var
        return ResponseEntity.ok() // Cria uma Build com HttpStatus de sucess(200)
                .body(listaUsuarios); // define o corpo da resposta
    }

    @PostMapping
    public  ResponseEntity<Usuario> insert(@RequestBody Usuario objetoUsuario){
	   	Usuario user = usuarioService.insertNovoUsuario(objetoUsuario);
//    	return ResponseEntity.ok().body(usuarioService.insertNovoUsuario(objetoUsuario));
			   return user != null ? ResponseEntity.ok().body(user) : ResponseEntity.badRequest().body(user); // Cria novo usuario ou caso for nulo, envia badrequest
    }

    @DeleteMapping(value = "/usuarios/{idUsuario}")
    public ResponseEntity <Void> delete (@PathVariable String idUsuario){
        usuarioService.deleteUsuario(idUsuario);
        return ResponseEntity.noContent() //Cria uma Build com HttpStatus de nonContent (204)
                .build(); //define o corpo da resposta
    }

	@PutMapping(value = "/usuarios/{idUsuario}")
	public ResponseEntity<Void> update(@RequestBody Usuario objetoUsuario, @PathVariable String idUsuario){
    	Usuario novoObjetoUsuario = usuarioService.returnFromUser(objetoUsuario); //instancia o novoObjetoUsuario com os dados de objetoUsuario
    	novoObjetoUsuario.setId(idUsuario); //seta o idUsuario para ter ctza
    	novoObjetoUsuario = usuarioService.update(novoObjetoUsuario); // faz o update
    	return ResponseEntity.noContent() //Cria uma Build com HttpStatus de nonContent (204)
			    .build(); //define o corpo da resposta
	}


}
