package com.jefmed.workshopmongo.controller;

import com.jefmed.workshopmongo.model.Usuario;
import com.jefmed.workshopmongo.model.services.UsuarioService;
import com.jefmed.workshopmongo.model.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // indica que a classe é responsavel por requisiçoes vindas do cliente e q eh um recurso Rest
@RequestMapping(value = "/usuarios") //indica o caminho do endpoint, e qual classe sera usada.
public class  UsuarioController {

    @Autowired
    private UsuarioService usuarioService; //instancia automaticamente o objto (injecao de dependencia)

    @GetMapping
    //ResponseEntity auxilia no retorno de requisições HTTP e possiveis erros, contemplando: Status code; headers e body
    public ResponseEntity<List<Usuario>> findAllUsers(){
        List<Usuario> listaUsuarios = usuarioService.findAllUsers(); // busca no BD e guarda na lista
        return listaUsuarios != null ? ResponseEntity.ok(listaUsuarios) : ResponseEntity.notFound().build();
    }

	@GetMapping(value = "/{idUsuario}")
	public ResponseEntity<Usuario> findUsuarioById(@PathVariable String idUsuario){
    	Usuario user = usuarioService.findUserById(idUsuario);
    	return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
	}

    @PostMapping
    public  ResponseEntity<Usuario> insert(@RequestBody Usuario objetoUsuario){
	    return ResponseEntity.ok(usuarioService.insertNovoUsuario(objetoUsuario));
    }

    @DeleteMapping(value = "/{idUsuario}")
    public ResponseEntity <Void> delete (@PathVariable String idUsuario){
        usuarioService.deleteUsuario(idUsuario);
        return ResponseEntity.noContent() //Cria uma Build com HttpStatus de nonContent (204)
                .build(); // constroi uma resposta sem corpo e retorna o tipo declarado
    }

	@PutMapping(value = "/{idUsuario}")
	public ResponseEntity<Usuario> update(@RequestBody Usuario objetoUsuario, @PathVariable String idUsuario){
    	usuarioService.update(objetoUsuario, idUsuario);
		return ResponseEntity.noContent().build();
	}


}
