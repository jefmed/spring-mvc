package com.jefmed.workshopmongo.model.services.exception;

import org.springframework.http.HttpStatus;
import java.util.Date;

//@ResponseStatus(HttpStatus.NOT_FOUND) // ao inves de passar o 500 (internal server error) ele classifica como 404 (not_found)
public class ObjectNotFoundException extends ApiException {

    private String error;

    public ObjectNotFoundException(String error) {
        this.error = error;
    }

    @Override
    public String getMessage() {
        return error;
    }

    @Override
    public String getDetail() {
        return "Objecto Not Found exception teste 12";
    }

    @Override
    public Integer getCode() {
        return 1111111;
    }

    @Override
    public Long getTimeStamp() {
        return new Date().getTime();
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }

//    public ObjectNotFoundException(String msg){
//        super(msg);
//    }
}
