package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String nombre;
    private String telefono;
    private Integer prioridad;

    public void setPrioridad(Integer prioridad){
        this.prioridad = prioridad;
    }

    public Integer getPrioridad(){
        return prioridad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return telefono;
    }

    public void setEmail(String telefono) {
        this.telefono = telefono;
    }
    
}