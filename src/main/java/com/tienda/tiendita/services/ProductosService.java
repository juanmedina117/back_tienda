package com.tienda.tiendita.services;

import com.tienda.tiendita.dto.RespuestaApi;
import com.tienda.tiendita.models.ProductosModel;
import com.tienda.tiendita.repository.ProductoRepository;
import com.tienda.tiendita.services.interfaces.IproductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;


@Service
public class ProductosService implements IproductoService {


    private final ProductoRepository productoRepository;

    public ProductosService(ProductoRepository productRepo) {
        this.productoRepository = productRepo;
    }


    @Override
    public List<ProductosModel> listaProductos() {
        List<ProductosModel> productos = productoRepository.findAll();
        return productos;
    }

    @Override
    public ProductosModel buscarProductosPorId(Long idProducto) {
        ProductosModel producto = productoRepository.findById(idProducto).orElse(null);
        return producto;
    }

    @Override
    public ResponseEntity<RespuestaApi> guardarProducto(ProductosModel producto) {

        ProductosModel productoNuevo = productoRepository.save(producto);

        RespuestaApi respuesta = new RespuestaApi(
                true,
                "Producto guardado correctamente",
                productoNuevo
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);

    }

    @Override
    public ResponseEntity<RespuestaApi> eliminarProducto(Long id) {


        if (!productoRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new RespuestaApi(false, "Producto no encontrado", null));
        }

        productoRepository.deleteById(id);

        RespuestaApi respuesta = new RespuestaApi(
                true,
                "Producto eliminado correctamente",
                null
        );

            return ResponseEntity.ok(respuesta);

    }

    @Override
    public ResponseEntity<RespuestaApi> actualizarProducto(Long id, ProductosModel producto) {

         // 1. Buscamos si el producto existe
        return productoRepository.findById(id)
                .map(productoExistente -> {
                    productoExistente.setNombre_producto(producto.getNombre_producto());
                    productoExistente.setMarca(producto.getMarca());
                    productoExistente.setCategoria(producto.getCategoria());
                    productoExistente.setUnidad_medida(producto.getUnidad_medida());
                    productoExistente.setPrecio_compra(producto.getPrecio_compra());
                    productoExistente.setPrecio_venta(producto.getPrecio_venta());
                    productoExistente.setStock(producto.getStock());
                    productoExistente.setId_proveedor(producto.getId_proveedor());

                    // 3. Guardamos (ahora SÍ hace UPDATE porque tiene ID)
                    ProductosModel guardado = productoRepository.save(productoExistente);

                    RespuestaApi respuesta = new RespuestaApi(
                            true,
                            "Producto actualizado correctamente",
                            guardado
                    );
                    return ResponseEntity.ok(respuesta);
                })
                .orElseGet(() -> {
                    // Si no existe el ID → devolvemos 404
                    RespuestaApi error = new RespuestaApi(false, "Producto no encontrado", null);
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
                });
    }
}
