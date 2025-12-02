package com.tienda.tiendita.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "proveedores")
public class ProveedoresModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id_Proveedor;

    @NotBlank(message = "El nombre del proveedor es obligatorio")
    @Column(name="nombre", nullable = false)
    private String nombre;

    @Column(name="telefono",nullable = true)
    private String telefono;


    @Column(name = "direccion", nullable = true)
    private String direccion;

    @Column(name = "email", nullable = true)
    private String email;

    @Column(name = "comentarios",nullable = true)
    private String comentarios;
}
