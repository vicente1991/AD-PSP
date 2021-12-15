package com.example.E01PracticaGuiadaVicenteRufo.dto;

import com.example.E01PracticaGuiadaVicenteRufo.validacion.multiple.anotacion.FieldsValueMatch;
import lombok.*;

import javax.persistence.Lob;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Builder @Data
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldsValueMatch.List({
        @FieldsValueMatch(
                field = "location",
                fieldMatch = "verifyLocation",
                message = "Las ubicaciones coinciden y no puede ser por los clavos de cristo"
        )
})



public class CreateEstacionDTO {


    private Long id;
    @NotBlank(message = "{estaciondeservicio.nombre.blank}")
    private String nombre;

    @NotNull
    private String marca;

    @NotBlank(message = "{estaciondeservicio.ubicacion.blank}")
    private String ubicacion;

    private String verifyUbicacion;

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

    private LocalDateTime fechaRegistro;

}
