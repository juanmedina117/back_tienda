package com.tienda.tiendita.repository;

import com.tienda.tiendita.models.ProductosModel;
import com.tienda.tiendita.models.ProveedoresModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProveedoresRepository extends JpaRepository<ProveedoresModel, Integer> {
}
