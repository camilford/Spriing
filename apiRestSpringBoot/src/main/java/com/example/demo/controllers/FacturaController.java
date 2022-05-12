package com.example.demo.controllers;





import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.example.demo.models.Factura;
import com.example.demo.services.FacturaService;

@RestController
@RequestMapping("/Factura")
// probar servicios en postman 
public class FacturaController {
    @Autowired
    FacturaService FacturaService;
    

    @GetMapping()
    public ArrayList<Factura> obtenerFactura(){
        return FacturaService.obtenerFactura();
    }

    @PostMapping()
    public Factura guardaItemFactura(@RequestBody Factura fac){
        return this.FacturaService.guardarFactura(fac);
    }

    @PostMapping()
    public Factura guardarFactura(@RequestBody Factura item){
        return this.FacturaService.guardarFactura(item);
    }

    @GetMapping( path = "/{id}")
    public Optional<Factura> obtenerFacturaPorId(@PathVariable("id") Long id) {
        return this.FacturaService.obtenerPorId(id);
    }



    @DeleteMapping( path = "/{id}")
    public String eliminarPorIdFactura(@PathVariable("id") Long id){
        boolean ok = this.FacturaService.eliminarFactura(id);
        if (ok){
            return "Se eliminó la factura con id " + id;
        }else{
            return "No se pudo eliminar la factura con id" + id;
        }
    }
    

}
