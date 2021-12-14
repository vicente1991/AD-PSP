package com.example.E01PracticaGuiadaVicenteRufo.modelo;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.Past;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class Estacion {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private String marca;
    private String ubicacion;
    private boolean tieneAutolavado=false;
    private float precioGasoilNormal;
    private float precioGasolina95Octanos;
    private float precioGasoilEspecial;
    private float precioGasolina98;

    @Lob
    private String descripcion;

    @Past
    private LocalDateTime fechaApertura;


}
