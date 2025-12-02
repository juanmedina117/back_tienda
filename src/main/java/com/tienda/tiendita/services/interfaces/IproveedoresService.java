package com.tienda.tiendita.services.interfaces;

import com.tienda.tiendita.dto.RespuestaApi;
import com.tienda.tiendita.models.ProveedoresModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IproveedoresService {

    public List<ProveedoresModel> listaProveedores();

    public ProveedoresModel buscarProveedorePorId(Integer idProveedor);

    public ResponseEntity<RespuestaApi> guardarProveedor(ProveedoresModel proveedor);

    public ResponseEntity<RespuestaApi> eliminarProveedor(Integer id);

    public ResponseEntity<RespuestaApi> actualizarProducto(Integer id, ProveedoresModel proveedor);

}
