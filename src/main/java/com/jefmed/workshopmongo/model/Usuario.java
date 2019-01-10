package com.jefmed.workshopmongo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users") // indica que a classe corresponde a uma colecao no mongodb, caso nao indique o nome da colecao ele ira mapear por um nome igual ao da classe
public class Usuario {

    @Id // indica qual atributo sera a PK
    private String id;

    private String nome;
    private String email;

}
