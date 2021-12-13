package com.example.E01PracticaGuiadaVicenteRufo.modelo;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
    private boolean tieneAutolavado;
    private float precioGasoilNormal;
    private float precioGasolina95Octanos;
    private float precioGasoilEspecial;
    private float precioGasolina98;
    private String descripcion;
    private LocalDateTime fechaApertura;

    public Estacion(String nombre, String marca, String ubicacion, boolean tieneAutolavado, float precioGasoilNormal, float precioGasolina95Octanos, float precioGasoilEspecial, float precioGasolina98, String descripcion, LocalDateTime fechaApertura) {
    }
}
