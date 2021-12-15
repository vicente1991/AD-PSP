package com.example.E01PracticaGuiadaVicenteRufo.errores.modelo;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class ValidatorError extends ApiSubError {

    private String objeto, mensaje;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String campo;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object ValorOff;
}
