package com.jefmed.workshopmongo.model.validators;

import com.jefmed.workshopmongo.model.services.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@AllArgsConstructor
@Component
public class UsuarioUnicoValidator implements ConstraintValidator<UsuarioUnico, String> {
    private UsuarioService usuarioService;

    @Override
    public void initialize(UsuarioUnico constraint){
    }

    @Override
    public boolean isValid(String nome, ConstraintValidatorContext context){
        return usuarioService.findByName(nome).isEmpty();
    }
}
