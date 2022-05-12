package com.example.demo.repositories;



import com.example.demo.models.Factura;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository

public interface FacturaRepository   extends CrudRepository<Factura, Long> {
    
}
