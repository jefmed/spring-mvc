package com.jefmed.workshopmongo.model.repository;

import com.jefmed.workshopmongo.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository //indica q a classe é responsavel pelo acesso a dados e torna elegivel p ser injetada
public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    //extender a interface MongoRep permite o acesso a varias ops basicas como CRUD
}
