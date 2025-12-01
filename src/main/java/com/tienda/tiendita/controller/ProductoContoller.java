package com.tienda.tiendita.controller;


import com.tienda.tiendita.dto.RespuestaApi;
import com.tienda.tiendita.models.ProductosModel;
import com.tienda.tiendita.services.ProductosService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ProductoContoller {

    ProductosService productosService;

    public ProductoContoller(ProductosService productosService) {
        this.productosService = productosService;
    }


    @GetMapping("/")
    public String pruebaServicioe() {
        return "Saludos";

    }

    @GetMapping("/productos")
    public List<ProductosModel> obtenerProductos() {

        return productosService.listaProductos();

    }

    @GetMapping("/producto/{id}")
    public ProductosModel verProducto(@PathVariable Long id) {

        return productosService.buscarProductosPorId(id);

    }


    @PostMapping("/crearProducto")
    public ResponseEntity<RespuestaApi> crearProducto(@Valid @RequestBody ProductosModel producto) {


        return productosService.guardarProducto(producto);

    }
    @DeleteMapping("/eliminarProducto/{id}")
    public ResponseEntity<RespuestaApi> eliminarProducto(@PathVariable Long id) {

          return productosService.eliminarProducto(id);

    }

    @PutMapping("/actualizarProducto/{id}")
    public ResponseEntity<RespuestaApi> actualizarProducto(@PathVariable Long id, @RequestBody ProductosModel producto){
        return productosService.actualizarProducto(id, producto);
    }



}
