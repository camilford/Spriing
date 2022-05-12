package com.example.demo.repositories;

import com.example.demo.models.ProductoModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository

public interface ProductoRepository extends CrudRepository<ProductoModel, Long> {
    
}
