package com.example.E01PracticaGuiadaVicenteRufo.dto;

import com.example.E01PracticaGuiadaVicenteRufo.validacion.anotaciones.Ubicacion;
import lombok.*;

import javax.persistence.Lob;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Builder @Data
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor


public class CreateEstacionDTO {


    private Long id;
    @NotBlank(message = "{estaciondeservicio.nombre.blank}")
    private String nombre;

    @NotNull
    private String marca;

    @NotBlank(message = "{estaciondeservicio.ubicacion.blank}")
    @Ubicacion
    @Pattern(regexp ="^([-+]?\\d{1,2}[.]\\d+),\\s*([-+]?\\d{1,3}[.]\\d+)$",message = "Cambia al formato correcto")
    private String ubicacion;


    private boolean tieneAutolavado = false;

    @PositiveOrZero(message = "{estaciondeservicio.preciogasoilnormal.positiveorzero}")
    private float precioGasoilNormal;

    @PositiveOrZero(message = "{estaciondeservicio.preciogasolina95octanos.positiveorzero}")
    private float precioGasolina95Octanos;

    @PositiveOrZero(message = "{estaciondeservicio.preciogasoilespecial.positiveorzero}")
    private float precioGasoilEspecial;

    @PositiveOrZero(message = "{estaciondeservicio.preciogasolina98.positiveorzero}")
    private float precioGasolina98;

    @Lob
    private String servicios;

    @Past
    private LocalDateTime fechaApertura;

    private LocalDateTime fechaRegistro = LocalDateTime.now();

}
