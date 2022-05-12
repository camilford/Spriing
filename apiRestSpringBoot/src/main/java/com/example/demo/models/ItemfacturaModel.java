package com.example.demo.models;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "itemfacturamodel")

public class ItemfacturaModel {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer cantidad;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "producto_id")
	private ProductoModel producto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
        
    public ProductoModel getProducto() {
		return producto;
	}

	public void setProducto(ProductoModel producto) {
		this.producto = producto;
	}

    public Double getImporte() {
		return cantidad.doubleValue() * producto.getPrecio();
	}
}
