package com.jefmed.workshopmongo.controller;

import com.jefmed.workshopmongo.controller.mapper.UsuarioMapper;
import com.jefmed.workshopmongo.model.Usuario;
import com.jefmed.workshopmongo.model.request.UsuarioRequest;
import com.jefmed.workshopmongo.model.services.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@Api(value = "API de Cadastro de usuarios")
@RestController // indica que a classe é responsavel por requisiçoes vindas do cliente e q eh um recurso Rest
@RequestMapping("/usuarios") //indica o caminho do endpoint, e qual classe sera usada.
@AllArgsConstructor
public class  UsuarioController {

//    @Autowired
    private UsuarioService usuarioService; //instancia automaticamente o objto (injecao de dependencia)

	@ApiOperation(value = "Retorna uma lista de todos os usuarios cadastrados")
    @GetMapping
    //ResponseEntity auxilia no retorno de requisições HTTP e possiveis erros, contemplando: Status code; headers e body
    public ResponseEntity<List<UsuarioRequest>> findAllUsers(){
		List<UsuarioRequest> usuarioRequests = new ArrayList<>();
		List<Usuario> listaUsuarios = usuarioService.findAllUsers(); // busca no BD e guarda na Var.listaUsuarios
		listaUsuarios.forEach(usuario ->{
			UsuarioRequest usuarioRequest = UsuarioMapper.mapToUsuarioRequest(usuario);
			usuarioRequest.add(linkTo(methodOn(UsuarioController.class).getUserById(usuario.getId())).withSelfRel());
			usuarioRequests.add(usuarioRequest);
		});
        return ResponseEntity.ok(usuarioRequests);
    }

	@ApiOperation(value = "Retorna um usuario especifico")
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioRequest> getUserById(@PathVariable String id){
		Usuario usuario = usuarioService.findUserById(id);
		UsuarioRequest usuarioRequest = UsuarioMapper.mapToUsuarioRequest(usuario);
		usuarioRequest.add(linkTo(methodOn(UsuarioController.class).findAllUsers()).withRel("Lista de Usuarios"));
    	return ResponseEntity.ok(usuarioRequest);
	}

	@ApiOperation(value = "Inserir um novo usuario")
    @PostMapping
	public  ResponseEntity<UsuarioRequest> insert(@Valid @RequestBody UsuarioRequest objetoUsuario) throws URISyntaxException {
		Usuario usuario = usuarioService.insertNovoUsuario((UsuarioMapper.mapToUsuario(objetoUsuario)));
		return ResponseEntity.created(new URI(usuario.getId())).build();
	}
    /*public  ResponseEntity<UsuarioRequest> insert(@Valid @RequestBody UsuarioRequest objetoUsuario){
		Usuario usuario = usuarioService.insertNovoUsuario(UsuarioMapper.mapToUsuario(objetoUsuario));
		UsuarioRequest usuarioRequest = UsuarioMapper.mapToUsuarioRequest(usuario);
		usuarioRequest.add(linkTo(methodOn(UsuarioController.class).getUserById(usuario.getId())).withSelfRel());
		return ResponseEntity.ok(usuarioRequest);
    }*/

	@ApiOperation(value = "Deleta um usuario")
    @DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id){
		usuarioService.deleteUsuario(id);
		return ResponseEntity.noContent().build();
	}
    /*public ResponseEntity <?> delete (@PathVariable String id){
		Usuario usuariocp = usuarioService.findUserById(id);
        usuarioService.deleteUsuario(id);
        UsuarioRequest usuarioRequestcp = UsuarioMapper.mapToUsuarioRequest(usuariocp);
        usuarioRequestcp.add(linkTo(methodOn(UsuarioController.class).findAllUsers()).withRel("Lista de usuarios"));
        return ResponseEntity.ok(usuarioRequestcp);
    }*/

	@ApiOperation(value = "Altera um usuario ja existente")
	@PutMapping("/{id}")
	public ResponseEntity<UsuarioRequest> update(@RequestBody UsuarioRequest objetoUsuario, @PathVariable String id){
		usuarioService.update(UsuarioMapper.mapToUsuario(objetoUsuario), id);
		return ResponseEntity.noContent().build();
	}
	/*public ResponseEntity<UsuarioRequest> update(@RequestBody UsuarioRequest objetoUsuario, @PathVariable String id){
    	Usuario usuario = usuarioService.update(UsuarioMapper.mapToUsuario(objetoUsuario), id);
    	UsuarioRequest usuarioRequest = UsuarioMapper.mapToUsuarioRequest(usuario);
    	usuarioRequest.add(linkTo(methodOn(UsuarioController.class).getUserById(usuario.getId())).withSelfRel());
		return ResponseEntity.ok(usuarioRequest);
	}*/


}
