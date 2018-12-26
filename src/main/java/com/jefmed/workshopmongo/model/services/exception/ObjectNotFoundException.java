package com.jefmed.workshopmongo.model.services.exception;

import lombok.Data;

@Data
public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException(String msg){
        super(msg);
    }
}
