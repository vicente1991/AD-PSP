package com.example.E01PracticaGuiadaVicenteRufo.errores.excepciones;

public class ListEntityNotFoundException extends EntityFoundException{

    public ListEntityNotFoundException(Class clazz) {
        super(String.format("No se pueden encontrar elementos del tipo %s ", clazz.getName()));
    }
}
