package com.example.demo.services;


import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.ProductoModel;
import com.example.demo.repositories.ProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
    @Autowired
    ProductoRepository ProductoRepository;
    
    public ArrayList<ProductoModel> obtenerProducto(){
        return (ArrayList<ProductoModel>) ProductoRepository.findAll();
    }

    public ProductoModel guardarProducto(ProductoModel prod){
        return ProductoRepository.save(prod);
    }

    public Optional<ProductoModel> obtenerPorId(Long id){
        return ProductoRepository.findById(id);
    }


   

    public boolean eliminarProducto(Long id) {
        try{
            ProductoRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
