package com.salesianostriana.dam.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@ToString
@Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Cliente {

    @Id
    @GeneratedValue
    private Long id;

    private String dni;
    private String nombre;
    private String email;

    public Cliente(String s, String pedro) {
    }
}
