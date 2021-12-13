package com.example.E01PracticaGuiadaVicenteRufo.dto;


import com.example.E01PracticaGuiadaVicenteRufo.modelo.Estacion;
import org.springframework.stereotype.Component;

@Component
public class EstacionDTOConverter {

    public GetEstacionDTO estacionToEstacionDTO(Estacion e){
        return GetEstacionDTO.builder()
                .nombre(e.getNombre())
                .marca(e.getMarca())
                .ubicacion(e.getUbicacion())
                .tieneAutolavado(e.isTieneAutolavado())
                .precioGasoilNormal(e.getPrecioGasoilNormal())
                .precioGasolina95Octanos(e.getPrecioGasolina95Octanos())
                .precioGasoilEspecial(e.getPrecioGasoilEspecial())
                .precioGasolina98(e.getPrecioGasolina98())
                .descripcion(e.getDescripcion())
                .fechaApertura(e.getFechaApertura())
                .build();
    }

    public Estacion estacionDTOToEstacion(CreateEstacionDTO c){
        return new Estacion(
                c.getNombre(),
                c.getMarca(),
                c.getUbicacion(),
                c.isTieneAutolavado(),
                c.getPrecioGasoilNormal(),
                c.getPrecioGasolina95Octanos(),
                c.getPrecioGasoilEspecial(),
                c.getPrecioGasolina98(),
                c.getDescripcion(),
                c.getFechaApertura()
        );

    }

}
