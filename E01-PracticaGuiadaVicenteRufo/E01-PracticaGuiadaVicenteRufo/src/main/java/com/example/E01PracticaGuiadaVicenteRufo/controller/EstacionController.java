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
import java.util.Optional;

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

    @PutMapping("/{id}")
    public ResponseEntity<Optional<GetEstacionDTO>> edit(@PathVariable Long id, @Valid @RequestBody CreateEstacionDTO estacionDeServicio) {
        return ResponseEntity.ok().body(estacionService.findById(id).map(e ->
        {e.setId(id);
            e.setMarca(estacionDeServicio.getMarca());
            e.setNombre(estacionDeServicio.getNombre());
            e.setUbicacion(estacionDeServicio.getUbicacion());
            e.setTieneAutolavado(estacionDeServicio.isTieneAutolavado());
            e.setPrecioGasoilNormal(estacionDeServicio.getPrecioGasoilNormal());
            e.setPrecioGasoilEspecial(estacionDeServicio.getPrecioGasoilEspecial());
            e.setPrecioGasolina98(estacionDeServicio.getPrecioGasolina98());
            e.setPrecioGasolina95Octanos(estacionDeServicio.getPrecioGasolina95Octanos());
            e.setDescripcion(estacionDeServicio.getServicios());
            e.setFechaApertura(estacionDeServicio.getFechaApertura());
            estacionService.save(e);
            GetEstacionDTO g = estacionDTOConverter.EstacionToGetEstacionDto(e);
            return g;
        }));
    }
}
