package com.example.demo.services;


import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.Factura;
import com.example.demo.repositories.FacturaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaService {
    @Autowired
    FacturaRepository FacturaRepository;
    
    public ArrayList<Factura> obtenerFactura(){
        return (ArrayList<Factura>) FacturaRepository.findAll();
    }

    public Factura guardarFactura(Factura fac){
        return FacturaRepository.save(fac);
    }

    public Optional<Factura> obtenerPorId(Long id){
        return FacturaRepository.findById(id);
    }


   

    public boolean eliminarFactura(Long id) {
        try{
            FacturaRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }  
}
