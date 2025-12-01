package com.tienda.tiendita.services.interfaces;

import com.tienda.tiendita.dto.RespuestaApi;
import com.tienda.tiendita.models.ProductosModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IproductoService {

    public List<ProductosModel> listaProductos();

    public ProductosModel buscarProductosPorId(Long idProducto);

    public ResponseEntity<RespuestaApi> guardarProducto(ProductosModel producto);

    public ResponseEntity<RespuestaApi> eliminarProducto(Long id);

    public ResponseEntity<RespuestaApi> actualizarProducto(Long id, ProductosModel producto);


}
