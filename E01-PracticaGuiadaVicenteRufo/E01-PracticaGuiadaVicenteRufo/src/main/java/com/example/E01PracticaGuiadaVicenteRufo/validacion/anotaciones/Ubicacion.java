package com.example.E01PracticaGuiadaVicenteRufo.validacion.anotaciones;


import com.example.E01PracticaGuiadaVicenteRufo.validacion.validacion.UbicacionValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = UbicacionValidator.class)
@Target({ElementType.FIELD,ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Ubicacion {

    String message() default "Hay 2 ubicaciones iguales por los clavos de cristo";

    Class <?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};
}
