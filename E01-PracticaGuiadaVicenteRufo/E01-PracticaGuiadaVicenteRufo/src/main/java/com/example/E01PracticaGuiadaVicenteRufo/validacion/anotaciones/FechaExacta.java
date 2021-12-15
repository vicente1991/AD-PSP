package com.example.E01PracticaGuiadaVicenteRufo.validacion.anotaciones;

import com.example.E01PracticaGuiadaVicenteRufo.validacion.validacion.FechaExactaValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = FechaExactaValidator.class)
@Target({ElementType.TYPE})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface FechaExacta {

    String message() default "La fecha de apertura debe ser anterior a la fecha de registro por tita concha";
    Class <?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};

    String fechaApertura();
    String fechaRegistro();
}
