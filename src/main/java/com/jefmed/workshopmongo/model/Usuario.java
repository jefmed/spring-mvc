package com.jefmed.workshopmongo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "user") // indica que a classe corresponde a uma colecao no mongodb, caso nao indique o nome da colecao ele ira mapear por um nome igual ao da classe
public class Usuario implements Serializable {
//    Para q objts sejam convertidos em bytes para trafegar em redes ou gravados em arquivos
    private static final long serialVersionUID = 1L;

    @Id // indica qual atributo sera a PK
    private String id;

    private String nome;
    private String email;

}
