package com.example.E01PracticaGuiadaVicenteRufo.controller;


import com.example.E01PracticaGuiadaVicenteRufo.dto.CreateEstacionDTO;
import com.example.E01PracticaGuiadaVicenteRufo.dto.EstacionDTOConverter;
import com.example.E01PracticaGuiadaVicenteRufo.dto.GetEstacionDTO;
import com.example.E01PracticaGuiadaVicenteRufo.modelo.Estacion;
import com.example.E01PracticaGuiadaVicenteRufo.services.EstacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/estacion")
public class EstacionController {

    private final EstacionService estacionService;
    private final EstacionDTOConverter estacionDTOConverter;

    @GetMapping("/")
    public ResponseEntity<List<Estacion>> findAll(){
        return ResponseEntity.ok().body(estacionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetEstacionDTO> findOne(@PathVariable Long id){
        return ResponseEntity.ok().body(estacionDTOConverter.EstacionToGetEstacionDto(estacionService.findById(id).get()));
    }

    @PostMapping("/")
    public ResponseEntity<GetEstacionDTO> save(@Valid @RequestBody CreateEstacionDTO c){
        Estacion estacion = estacionDTOConverter.createEstacionDtoToEstacion(c);
        estacionService.save(estacion);
        GetEstacionDTO estacionDto = estacionDTOConverter.EstacionToGetEstacionDto(estacion);
        return ResponseEntity.status(HttpStatus.CREATED).body(estacionDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        estacionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
