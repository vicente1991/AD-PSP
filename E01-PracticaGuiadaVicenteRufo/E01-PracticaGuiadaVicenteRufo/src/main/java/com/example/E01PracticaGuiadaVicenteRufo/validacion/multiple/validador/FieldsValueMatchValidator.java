package com.example.E01PracticaGuiadaVicenteRufo.validacion.multiple.validador;

import com.example.E01PracticaGuiadaVicenteRufo.validacion.multiple.anotacion.FieldsValueMatch;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FieldsValueMatchValidator implements ConstraintValidator<FieldsValueMatch,Object> {

    private String field;
    private String fieldMatch;



    @Override
    public void initialize(FieldsValueMatch constraintAnnotation) {

        this.field = constraintAnnotation.field();
        this.fieldMatch = constraintAnnotation.fieldMatch();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {

        return false;
    }
}
