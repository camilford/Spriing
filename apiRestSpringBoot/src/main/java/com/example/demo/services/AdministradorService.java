package com.example.demo.services;


import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.AdministradorModel;
import com.example.demo.repositories.AdministradorRepository;

import com.example.demo.models.ProductoModel;
import com.example.demo.repositories.ProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministradorService {
    @Autowired
    AdministradorRepository AdministradorRepository;
    ProductoRepository productoRepository;
    
    public ArrayList<AdministradorModel> obtenerAdmin(){
        return (ArrayList<AdministradorModel>) AdministradorRepository.findAll();
    }

    public AdministradorModel guardarAdmin(AdministradorModel admi){
        return AdministradorRepository.save(admi);
    }

    public Optional<AdministradorModel> obtenerPorId(Long id){
        return AdministradorRepository.findById(id);
    }


   

    public boolean eliminarAdmin(Long id) {
        try{
            AdministradorRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }



    public boolean eliminarProducto(Long id) {
        try{
            productoRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

    public ProductoModel guardarPro(ProductoModel prod){
        return productoRepository.save(prod);
    }

}
