package com.example.E01PracticaGuiadaVicenteRufo.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;


@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class GetEstacionDTO {

    private Long id;
    private String nombre;
    private String marca;
    private String ubicacion;
    private boolean tieneAutolavado;
    private float precioGasoilNormal;
    private float precioGasolina95Octanos;
    private float precioGasoilEspecial;
    private float precioGasolina98;
    private String servicios;
    private LocalDateTime fechaApertura;
}
