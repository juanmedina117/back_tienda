package com.tienda.tiendita.services;

import com.tienda.tiendita.dto.RespuestaApi;
import com.tienda.tiendita.models.ProductosModel;
import com.tienda.tiendita.models.ProveedoresModel;
import com.tienda.tiendita.repository.ProductoRepository;
import com.tienda.tiendita.repository.ProveedoresRepository;
import com.tienda.tiendita.services.interfaces.IproveedoresService;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ProveedoresService implements IproveedoresService {
    private final ProveedoresRepository proveedoresRepository;

    public ProveedoresService(ProveedoresRepository proveedoresRepository) {
        this.proveedoresRepository = proveedoresRepository;
    }


    @Override
    public List<ProveedoresModel> listaProveedores() {
        List<ProveedoresModel> proveedores = this.proveedoresRepository.findAll();
        return proveedores;
    }

    @Override
    public ProveedoresModel buscarProveedorePorId(Long idProveedor) {
        ProveedoresModel producto = proveedoresRepository.findById(idProveedor).orElse(null);
        return producto;
    }

    @Override
    public ResponseEntity<RespuestaApi> guardarProveedor(ProveedoresModel proveedor) {
        return null;
    }

    @Override
    public ResponseEntity<RespuestaApi> eliminarProveedor(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<RespuestaApi> actualizarProducto(Long id, ProveedoresModel proveedor) {
        return null;
    }
}
