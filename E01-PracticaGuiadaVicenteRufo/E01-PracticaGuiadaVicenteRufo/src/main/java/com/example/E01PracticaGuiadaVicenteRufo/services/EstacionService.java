package com.example.E01PracticaGuiadaVicenteRufo.services;

import com.example.E01PracticaGuiadaVicenteRufo.modelo.Estacion;
import com.example.E01PracticaGuiadaVicenteRufo.repository.EstacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstacionService {

    private final EstacionRepository estacionRepository;

    public List<Estacion> findAll(){
        List<Estacion> todas= estacionRepository.findAll();

        if (todas.isEmpty()){
            throw new EntityNotFoundException(Estacion.class);
        }else{
            return todas;
        }
    }
}
