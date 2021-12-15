package com.example.E01PracticaGuiadaVicenteRufo.errores.excepciones;

public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException(Long id) {
        super("No se encontro la estacion con la siguiente id: " + id);
    }

}
