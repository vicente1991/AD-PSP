package com.example.E01PracticaGuiadaVicenteRufo.errores.excepciones;

public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException(String message) {
        super(message);
    }

}
