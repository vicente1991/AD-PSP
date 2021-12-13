package com.example.E01PracticaGuiadaVicenteRufo.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateEstacionDTO {


    private String nombre;
    private String marca;
    private String ubicacion;
    private boolean tieneAutolavado;
    private float precioGasoilNormal;
    private float precioGasolina95Octanos;
    private float precioGasoilEspecial;
    private float precioGasolina98;
    private String descripcion;
    private LocalDateTime fechaApertura;

}
