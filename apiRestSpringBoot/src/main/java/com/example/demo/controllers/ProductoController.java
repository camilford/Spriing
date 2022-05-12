package com.example.demo.controllers;


import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.example.demo.models.ProductoModel;
import com.example.demo.services.ProductoService;

@RestController
@RequestMapping("/administrador")
// probar servicios en postman 
public class ProductoController {
    @Autowired
    ProductoService ProductoService;

    @GetMapping()
    public ArrayList<ProductoModel> obtenerProducto(){
        return ProductoService.obtenerProducto();
    }

    @PostMapping()
    public ProductoModel guardarProducto(@RequestBody ProductoModel admi){
        return this.ProductoService.guardarProducto(admi);
    }

    @GetMapping( path = "/{id}")
    public Optional<ProductoModel> obtenerProductoPorId(@PathVariable("id") Long id) {
        return this.ProductoService.obtenerPorId(id);
    }



    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.ProductoService.eliminarProducto(id);
        if (ok){
            return "Se eliminó el producto con id " + id;
        }else{
            return "No pudo eliminar el producto con id" + id;
        }
    }
}
