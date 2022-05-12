package com.example.demo.repositories;


import com.example.demo.models.ItemfacturaModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository

public interface ItemfacturaRepository  extends CrudRepository<ItemfacturaModel, Long>{
    
}
