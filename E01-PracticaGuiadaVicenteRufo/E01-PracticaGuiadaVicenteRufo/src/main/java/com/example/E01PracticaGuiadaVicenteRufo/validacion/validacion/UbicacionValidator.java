package com.example.E01PracticaGuiadaVicenteRufo.validacion.validacion;

import com.example.E01PracticaGuiadaVicenteRufo.repository.EstacionRepository;
import com.example.E01PracticaGuiadaVicenteRufo.validacion.anotaciones.Ubicacion;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class UbicacionValidator implements ConstraintValidator<Ubicacion,String> {

    private final EstacionRepository estacionRepository;


    @Override
    public void initialize(Ubicacion constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.hasText(s) && !estacionRepository.existsByUbicacion(s);
    }
}
