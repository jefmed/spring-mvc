package com.jefmed.workshopmongo.controller;

import com.jefmed.workshopmongo.controller.mapper.UsuarioMapper;
import com.jefmed.workshopmongo.controller.model.request.UsuarioRequest;
import com.jefmed.workshopmongo.model.Usuario;
import com.jefmed.workshopmongo.model.services.UsuarioService;
import com.jefmed.workshopmongo.model.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // indica que a classe é responsavel por requisiçoes vindas do cliente e q eh um recurso Rest
@RequestMapping("/usuarios") //indica o caminho do endpoint, e qual classe sera usada.
public class  UsuarioController {

    @Autowired
    private UsuarioService usuarioService; //instancia automaticamente o objto (injecao de dependencia)

    @GetMapping
    //ResponseEntity auxilia no retorno de requisições HTTP e possiveis erros, contemplando: Status code; headers e body
    public ResponseEntity<List<Usuario>> findAllUsers(){
        List<Usuario> listaUsuarios = usuarioService.findAllUsers(); // busca no BD e guarda na Var.listaUsuarios
        return listaUsuarios != null ? ResponseEntity.ok(listaUsuarios) : ResponseEntity.notFound().build();
    }

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getUserById(@PathVariable String id){
    	return ResponseEntity.ok(usuarioService.findUserById(id));
	}

    @PostMapping
    public  ResponseEntity<Usuario> insert(@RequestBody UsuarioRequest objetoUsuario){
	    return ResponseEntity.ok(usuarioService.insertNovoUsuario(UsuarioMapper.mapToImpl(objetoUsuario)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> delete (@PathVariable String id){
        usuarioService.deleteUsuario(id);
        return ResponseEntity.noContent() //Cria uma Response com HttpStatus de nonContent (204)
                .build(); // constroi uma resposta sem corpo e retorna o tipo declarado
    }

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody Usuario objetoUsuario, @PathVariable String id){
    	usuarioService.update(objetoUsuario, id);
		return ResponseEntity.noContent().build();
	}


}
