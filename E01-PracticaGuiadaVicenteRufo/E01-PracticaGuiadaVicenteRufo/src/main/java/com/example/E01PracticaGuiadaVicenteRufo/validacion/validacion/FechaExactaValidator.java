package com.example.E01PracticaGuiadaVicenteRufo.validacion.validacion;

import com.example.E01PracticaGuiadaVicenteRufo.validacion.anotaciones.FechaExacta;
import org.springframework.beans.PropertyAccessorFactory;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;

public class FechaExactaValidator implements ConstraintValidator<FechaExacta,Object> {

    private String fechaApertura;
    private String fechaRegistro;


    @Override
    public void initialize(FechaExacta constraintAnnotation) {
        fechaApertura= constraintAnnotation.fechaApertura();
        fechaRegistro= constraintAnnotation.fechaRegistro();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        LocalDateTime fechaAperturaValue = (LocalDateTime) PropertyAccessorFactory.forBeanPropertyAccess(o).getPropertyValue(String.valueOf(fechaApertura));
        LocalDateTime fechaRegistroValue = (LocalDateTime) PropertyAccessorFactory.forBeanPropertyAccess(o).getPropertyValue(String.valueOf(fechaRegistro));

        int fecha = fechaAperturaValue.compareTo(fechaRegistroValue);
        if (fecha >= 0){
            return false;
        }else{
            return true;
        }

    }
}
