package com.example.E01PracticaGuiadaVicenteRufo.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class GetEstacionDTO {


    @NotBlank(message = "La estacion debe tener un nombre")
    private String nombre;

    private String marca;

    @NotBlank(message = "Debes añadir una ubicacion en formato latitud/longitud")
    private String ubicacion;

    private boolean tieneAutolavado;

    @NotEmpty(message = "El precio debe ser positivo o cero")
    private float precioGasoilNormal;

    @NotEmpty(message = "El precio debe ser positivo o cero")
    private float precioGasolina95Octanos;

    @NotEmpty(message = "El precio debe ser positivo o cero")
    private float precioGasoilEspecial;

    @NotEmpty(message = "El precio debe ser positivo o cero")
    private float precioGasolina98;

    @Lob
    private String descripcion;

    @Past(message = "La fecha debe ser del pasado")
    private LocalDateTime fechaApertura;
}
