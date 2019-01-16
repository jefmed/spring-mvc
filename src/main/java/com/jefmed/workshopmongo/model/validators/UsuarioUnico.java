package com.jefmed.workshopmongo.model.validators;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UsuarioUnicoValidator.class)
public @interface UsuarioUnico {
    String message() default "Este usuario ja esta cadastrado";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
