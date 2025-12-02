package com.tienda.tiendita.controller;

import com.tienda.tiendita.dto.RespuestaApi;
import com.tienda.tiendita.models.ProductosModel;
import com.tienda.tiendita.models.ProveedoresModel;
import com.tienda.tiendita.services.ProductosService;
import com.tienda.tiendita.services.ProveedoresService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ProveedoresController {


    ProveedoresService proveedoresService;

    public ProveedoresController(ProveedoresService proveedoresService) {
        this.proveedoresService = proveedoresService;
    }

    @GetMapping("/proveedores")
    public List<ProveedoresModel> obtenerProveedor() {

        return proveedoresService.listaProveedores();

    }

    @GetMapping("/proveedor/{id}")
    public ProductosModel verProveedor(@PathVariable Long id) {

        return null;

    }


    @PostMapping("/crearProveedor")
    public ResponseEntity<RespuestaApi> crearProveedor(@Valid @RequestBody ProveedoresModel proveedor) {


        return null;

    }
    @DeleteMapping("/eliminarProveedor/{id}")
    public ResponseEntity<RespuestaApi> eliminarProveedor(@PathVariable Long id) {

        return null;

    }

    @PutMapping("/actualizarProvedor/{id}")
    public ResponseEntity<RespuestaApi> actualizarProveedor(@PathVariable Long id, @RequestBody ProveedoresModel proveedor){
        return null;
    }

}
