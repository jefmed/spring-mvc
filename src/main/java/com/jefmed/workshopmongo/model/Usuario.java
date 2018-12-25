package com.jefmed.workshopmongo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements Serializable {
//    Para q objts sejam convertidos em bytes para trafegar em redes ou gravados em arquivos
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private String nome;
    private String email;

}
