package com.example.E01PracticaGuiadaVicenteRufo.services;

import com.example.E01PracticaGuiadaVicenteRufo.errores.excepciones.EntityNotFoundException;
import com.example.E01PracticaGuiadaVicenteRufo.errores.excepciones.ListEntityNotFoundException;
import com.example.E01PracticaGuiadaVicenteRufo.modelo.Estacion;
import com.example.E01PracticaGuiadaVicenteRufo.repository.EstacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EstacionService {

    private final EstacionRepository estacionRepository;

    public List<Estacion> findAll(){
        if(estacionRepository.findAll().isEmpty()){
            throw new ListEntityNotFoundException(EstacionService.class);
        }else{
            return this.estacionRepository.findAll();
        }
    }

    public Optional<Estacion> findById(Long id){
        if(estacionRepository.findById(id).isEmpty()){
            throw new EntityNotFoundException(id);
        }else{
            return this.estacionRepository.findById(id);
        }
    }

    public Estacion save(Estacion estacion) {
        return estacionRepository.save(estacion);
    }


    public void deleteById(Long id) {
        if (estacionRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException(id);
        } else {
            estacionRepository.deleteById(id);
        }
    }


    public Estacion edit(Estacion estacion){ return estacionRepository.save(estacion);}
}
