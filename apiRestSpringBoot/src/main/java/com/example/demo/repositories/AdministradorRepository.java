package com.example.demo.repositories;


import com.example.demo.models.AdministradorModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository

public interface AdministradorRepository  extends CrudRepository<AdministradorModel, Long> {
    
}
