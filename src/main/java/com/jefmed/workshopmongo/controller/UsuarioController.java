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
    private UsuarioService usuarioServ; //instancia automaticamente o objto (injecao de dependencia)

    @GetMapping
    //ResponseEntity auxilia no retorno de requisições HTTP e possiveis erros, contemplando: Status code; headers e body
    public ResponseEntity<List<Usuario>> findAll(){
        List<Usuario> list = usuarioServ.findAll(); // busca no BD e guarda na lista/var
        return ResponseEntity.ok() // Cria uma Build com HttpStatus de sucess(200)
                .body(list); // define o corpo da resposta
    }

    @PostMapping
    public  void insert(@RequestBody Usuario obj){

    	usuarioServ.insert(obj);
    }

    @DeleteMapping(value = "/usuarios/{id}")
    public ResponseEntity <Void> delete (@PathVariable String id){
        usuarioServ.delete(id);
        return ResponseEntity.noContent() //Cria uma Build com HttpStatus de nonContent (204)
                .build(); //define o corpo da resposta
    }

	@PutMapping(value = "/usuarios/{id}")
	public ResponseEntity<Void> update(@RequestBody Usuario obj, @PathVariable String id){
    	Usuario objUser = usuarioServ.fromUser(obj); //instancia o objUser com os dados de obj
    	objUser.setId(id); //seta o id para ter ctza
    	objUser = usuarioServ.update(objUser); // faz o update
    	return ResponseEntity.noContent() //Cria uma Build com HttpStatus de nonContent (204)
			    .build(); //define o corpo da resposta
	}


}
