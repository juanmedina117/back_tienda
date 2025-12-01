package com.tienda.tiendita.repository;

import com.tienda.tiendita.models.ProductosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<ProductosModel, Long> {



}
