package com.example.E01PracticaGuiadaVicenteRufo.validacion.simple.validador;

import com.example.E01PracticaGuiadaVicenteRufo.validacion.simple.anotaciones.LocationMatch;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LocationMatchValidator implements ConstraintValidator<LocationMatch,Object> {

    private String locationField;
    private String verifyLocationField;

    @Override
    public void initialize(LocationMatch constraintAnnotation) {
        locationField= constraintAnnotation.locationField();
        verifyLocationField= constraintAnnotation.verifyLocationField();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        String  location = (String) PropertyAccessorFactory.forBeanPropertyAccess(o).getPropertyValue(locationField);
        String verifyLocation = (String) PropertyAccessorFactory.forBeanPropertyAccess(o).getPropertyValue(verifyLocationField);

        return StringUtils.hasText(location) && !location.contentEquals(verifyLocation);
    }
}
