package com.salesianostriana.dam.validacion.simple.validadores;


import com.salesianostriana.dam.validacion.simple.anotaciones.StrongPassword;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StrongPasswordValidate implements ConstraintValidator<StrongPassword,String> {

private int min;
private int max;
private boolean hasUpper;
private boolean hasNumber;
private boolean hasLower;
private boolean hasAlpha;
private boolean hasOthers;


    @Override
    public void initialize(StrongPassword constraintAnnotation) {
        min = constraintAnnotation.min();
        max = constraintAnnotation.max();
        hasUpper = constraintAnnotation.hasUpper();
        hasLower = constraintAnnotation.hasLower();
        hasNumber = constraintAnnotation.hasNumber();
        hasAlpha = constraintAnnotation.hasAlpha();
        hasOthers = constraintAnnotation.hasOthers();
    }

    @Override
    public boolean isValid(String clave, ConstraintValidatorContext constraintValidatorContext) {
        if(clave.length()>max|| clave.length()<min) {
            return false;
        }
        if(hasUpper){
            if(clave.equals(clave.toLowerCase())){
                return false;
            };
        }
        if(hasLower){
            if(clave.equals(clave.toUpperCase())){
                return false;
            }
        }
        if(hasNumber){
            if(!clave.matches(".*\\d.*"))
                return false;
        }
        if(hasAlpha){
            if(!clave.matches(".*[a-z].*")){
                return false;
            }
        }
        if(hasOthers){
            if(!(clave.contains(".") || clave.contains(",") || clave.contains("$")
                    || clave.contains("-") || clave.contains("_"))){
                return false;
            }
        }
        return true;
    }
}

