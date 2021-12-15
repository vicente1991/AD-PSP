package com.example.E01PracticaGuiadaVicenteRufo.validacion.simple.anotaciones;


import com.example.E01PracticaGuiadaVicenteRufo.validacion.simple.validador.LocationMatchValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = LocationMatchValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface LocationMatch {

    String message() default "La localizaciones introdicidas deben coincidir entre si";
    Class <?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};

    String locationField();
    String verifyLocationField();

}
