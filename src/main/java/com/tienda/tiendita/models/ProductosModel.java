package com.tienda.tiendita.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="productos")
public class ProductosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_producto;

    @NotBlank(message = "El nombre del producto es obligatorio")
    @JsonAlias("nombre_producto")
    @Column(name="nombre_producto",nullable = false)
    private String nombre_producto;

    @NotBlank(message = "La marca es obligatoria")
    @JsonAlias("marca")
    @Column(nullable = false)
    private String marca;

    @NotBlank(message = "La categoría es obligatoria")
    @NotBlank(message = "La categoría es obligatoria")
    @JsonAlias("categoria")
    @Column(name = "categoria", nullable = false)
    private String categoria;

    @NotBlank(message = "La unidade de medida es obligatoria")
    @JsonAlias("unidad_medida")
    @Column(name = "unidad_medida", nullable = false)
    private String unidad_medida;

    @JsonAlias("precio_compra")
    @Column(name = "precio_compra",nullable = false)
    private Double precio_compra;

    @JsonAlias("precio_venta")
    @Column(name = "precio_venta", nullable = false)
    private Double precio_venta;

    @JsonAlias("stock")
    @Column(nullable = false)
    private Integer  stock;

    @JsonAlias("id_proveedor")
    @Column(name = "id_proveedor", nullable = true)
    private Integer id_proveedor;



}
