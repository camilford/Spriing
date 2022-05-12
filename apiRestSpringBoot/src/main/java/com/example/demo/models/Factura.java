package com.example.demo.models;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@Entity
@Table(name = "facturas")

public class Factura {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String descripcion;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "factura_id")
	private ArrayList<ItemfacturaModel>  items;
	
	@JsonIgnoreProperties(value={"facturas", "hibernateLazyInitializer", "handler"}, allowSetters=true)
	@ManyToOne(fetch = FetchType.LAZY)
	private UsuarioModel usuario;
    
    public Factura() {
		items=new ArrayList<>();
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<ItemfacturaModel> getItems() {
		return items;
	}

	public void setItems(ArrayList<ItemfacturaModel> items) {
		this.items = items;
	}

    public Double getTotal() {
		Double total = 0.00;
		for (ItemfacturaModel item : items) {
			total += item.getImporte();
		}
		return total;
	}
  
}
