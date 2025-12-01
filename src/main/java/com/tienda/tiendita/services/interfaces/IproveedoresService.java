package com.tienda.tiendita.services.interfaces;

import com.tienda.tiendita.dto.RespuestaApi;
import com.tienda.tiendita.models.ProveedoresModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IproveedoresService {

    public List<ProveedoresModel> listaProveedores();

    public ProveedoresModel buscarProveedorePorId(Long idProveedor);

    public ResponseEntity<RespuestaApi> guardarProveedor(ProveedoresModel proveedor);

    public ResponseEntity<RespuestaApi> eliminarProveedor(Long id);

    public ResponseEntity<RespuestaApi> actualizarProducto(Long id, ProveedoresModel proveedor);

}
