package com.example.E01PracticaGuiadaVicenteRufo.errores.excepciones;

import javax.persistence.EntityNotFoundException;

public class ListEntityNotFoundException extends EntityNotFoundException {

    public ListEntityNotFoundException(Class clas) {
        super(String.format("No se pueden encontrar elementos del tipo %s ", clas.getName()));
    }
}
