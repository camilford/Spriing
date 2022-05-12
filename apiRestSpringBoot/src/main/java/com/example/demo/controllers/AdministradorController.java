package com.example.demo.controllers;


import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.AdministradorModel;
import com.example.demo.models.ProductoModel;
import com.example.demo.services.AdministradorService;
import com.example.demo.services.ProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/administrador")
// probar servicios en postman 
public class AdministradorController {
    @Autowired
    AdministradorService admiService;
    ProductoService productService;

    @GetMapping()
    public ArrayList<AdministradorModel> obtenerAdministrador(){
        return admiService.obtenerAdmin();
    }

    @PostMapping()
    public AdministradorModel guardarAdmin(@RequestBody AdministradorModel admi){
        return this.admiService.guardarAdmin(admi);
    }

    @PostMapping()
    public ProductoModel guardarProducto(@RequestBody ProductoModel prod){
        return this.productService.guardarProducto(prod);
    }

    @GetMapping( path = "/{id}")
    public Optional<AdministradorModel> obtenerAdminPorId(@PathVariable("id") Long id) {
        return this.admiService.obtenerPorId(id);
    }



    @DeleteMapping( path = "/{id}")
    public String eliminarPorIdAdmin(@PathVariable("id") Long id){
        boolean ok = this.admiService.eliminarAdmin(id);
        if (ok){
            return "Se eliminó el administrador con id " + id;
        }else{
            return "No pudo eliminar el administrador con id" + id;
        }
    }
}
