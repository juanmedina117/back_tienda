package com.tienda.tiendita.services;

import com.tienda.tiendita.dto.RespuestaApi;
import com.tienda.tiendita.models.ProductosModel;
import com.tienda.tiendita.models.ProveedoresModel;
import com.tienda.tiendita.repository.ProductoRepository;
import com.tienda.tiendita.repository.ProveedoresRepository;
import com.tienda.tiendita.services.interfaces.IproveedoresService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedoresService implements IproveedoresService {
    private  ProveedoresRepository proveedoresRepository;

    public ProveedoresService(ProveedoresRepository proveedoresRepository) {
        this.proveedoresRepository = proveedoresRepository;
    }

    @Override
    public List<ProveedoresModel> listaProveedores() {
        List<ProveedoresModel> proveedores = this.proveedoresRepository.findAll();
        return proveedores;
    }

    @Override
    public ProveedoresModel buscarProveedorePorId(Integer idProveedor) {
        ProveedoresModel proveedor = proveedoresRepository.findById(idProveedor).orElse(null);
        return proveedor;
    }

    @Override
    public ResponseEntity<RespuestaApi> guardarProveedor(ProveedoresModel proveedor) {
        ProveedoresModel nuevoProveedor = proveedoresRepository.save(proveedor);

        RespuestaApi respuesta = new RespuestaApi(
                true,
                "Producto guardado correctamente",
                nuevoProveedor
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
    }

    @Override
    public ResponseEntity<RespuestaApi> eliminarProveedor(Integer id) {
        if (!proveedoresRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new RespuestaApi(false, "Proovedor no encontrado", null));
        }

        proveedoresRepository.deleteById(id);

        RespuestaApi respuesta = new RespuestaApi(
                true,
                "Producto eliminado correctamente",
                null
        );

        return ResponseEntity.ok(respuesta);
    }

    @Override
    public ResponseEntity<RespuestaApi> actualizarProducto(Integer id, ProveedoresModel proveedor) {

        // 1. Buscamos si el producto existe
        return proveedoresRepository.findById(id)
                .map(productoExistente -> {
                    productoExistente.setNombre(proveedor.getNombre());
                    productoExistente.setTelefono(proveedor.getTelefono());
                    productoExistente.setDireccion(proveedor.getDireccion());
                    productoExistente.setEmail(proveedor.getEmail());
                    productoExistente.setComentarios(proveedor.getComentarios());

                    // 3. Guardamos (ahora SÍ hace UPDATE porque tiene ID)
                    ProveedoresModel guardado = proveedoresRepository.save(productoExistente);

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
