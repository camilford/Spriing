
package com.example.demo.services;


import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.ItemfacturaModel;
import com.example.demo.repositories.ItemfacturaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemfacturaService {
    @Autowired
    ItemfacturaRepository ItemfacturaRepository;
    
    public ArrayList<ItemfacturaModel> obtenerItemfactura(){
        return (ArrayList<ItemfacturaModel>) ItemfacturaRepository.findAll();
    }

    public ItemfacturaModel guardarItemfactura(ItemfacturaModel item){
        return ItemfacturaRepository.save(item);
    }

    public Optional<ItemfacturaModel> obtenerPorId(Long id){
        return ItemfacturaRepository.findById(id);
    }


   

    public boolean eliminarItemfactura(Long id) {
        try{
            ItemfacturaRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }  
}
