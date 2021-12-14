package com.example.E01PracticaGuiadaVicenteRufo.dto;


import com.example.E01PracticaGuiadaVicenteRufo.modelo.Estacion;
import org.springframework.stereotype.Component;

@Component
public class EstacionDTOConverter {

    public Estacion createEstacionDtoToEstacion(CreateEstacionDTO dto){
        return Estacion.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .marca(dto.getMarca())
                .ubicacion(dto.getUbicacion())
                .tieneAutolavado(dto.isTieneAutolavado())
                .precioGasoilNormal(dto.getPrecioGasoilNormal())
                .precioGasoilEspecial(dto.getPrecioGasoilEspecial())
                .precioGasolina98(dto.getPrecioGasolina98())
                .precioGasolina95Octanos(dto.getPrecioGasolina95Octanos())
                .fechaApertura(dto.getFechaApertura())
                .descripcion(dto.getServicios())
                .build();
    }
    public GetEstacionDTO EstacionToGetEstacionDto(Estacion estacionDeServicio){
        return GetEstacionDTO.builder()
                .id(estacionDeServicio.getId())
                .nombre(estacionDeServicio.getNombre())
                .marca(estacionDeServicio.getMarca())
                .ubicacion(estacionDeServicio.getUbicacion())
                .tieneAutolavado(estacionDeServicio.isTieneAutolavado())
                .precioGasoilNormal(estacionDeServicio.getPrecioGasoilNormal())
                .precioGasoilEspecial(estacionDeServicio.getPrecioGasoilEspecial())
                .precioGasolina98(estacionDeServicio.getPrecioGasolina98())
                .precioGasolina95Octanos(estacionDeServicio.getPrecioGasolina95Octanos())
                .fechaApertura(estacionDeServicio.getFechaApertura())
                .servicios(estacionDeServicio.getDescripcion())
                .build();
    }

}
