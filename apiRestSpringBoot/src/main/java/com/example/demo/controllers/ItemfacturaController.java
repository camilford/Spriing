package com.example.demo.controllers;



import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.example.demo.models.ItemfacturaModel;
import com.example.demo.services.ItemfacturaService;

@RestController
@RequestMapping("/Itemfactura")
// probar servicios en postman 
public class ItemfacturaController {
    @Autowired
    ItemfacturaService ItemService;
    

    @GetMapping()
    public ArrayList<ItemfacturaModel> obtenerItemfactura(){
        return ItemService.obtenerItemfactura();
    }

    @PostMapping()
    public ItemfacturaModel guardaItemfactura(@RequestBody ItemfacturaModel item){
        return this.ItemService.guardarItemfactura(item);
    }

    @PostMapping()
    public ItemfacturaModel guardarProducto(@RequestBody ItemfacturaModel item){
        return this.ItemService.guardarItemfactura(item);
    }

    @GetMapping( path = "/{id}")
    public Optional<ItemfacturaModel> obtenerAdminPorId(@PathVariable("id") Long id) {
        return this.ItemService.obtenerPorId(id);
    }



    @DeleteMapping( path = "/{id}")
    public String eliminarPorIdItem(@PathVariable("id") Long id){
        boolean ok = this.ItemService.eliminarItemfactura(id);
        if (ok){
            return "Se eliminó el Item de factura con id " + id;
        }else{
            return "No pudo eliminar el Item de factura con id" + id;
        }
    }
    
}
