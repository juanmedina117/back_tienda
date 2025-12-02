package com.tienda.tiendita.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "proveedores")
public class ProveedoresModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Proveedor;

    @NotBlank(message = "El nombre del proveedor es obligatorio")
    @JsonAlias("nombre")
    @Column(name="nombre", nullable = false)
    private String nombre;

    @JsonAlias("telefono")
    @Column(nullable = true)
    private String telefono;


    @JsonAlias("direccion")
    @Column(name = "direccion", nullable = true)
    private String direccion;

    @JsonAlias("email")
    @Column(name = "email", nullable = true)
    private String email;

    @JsonAlias("comentarios")
    @Column(name = "comentarios",nullable = true)
    private Double comentarios;
}
