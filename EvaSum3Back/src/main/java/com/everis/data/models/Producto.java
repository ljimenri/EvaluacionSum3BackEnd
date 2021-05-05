package com.everis.data.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "productos")
public class Producto {

	// ATRIBUTOS DE LA CLASE
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String precio;
	private String caracteristicas;

	public Producto() {

	}

	public Producto(Long id, String nombre, String precio, String caracteristicas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.caracteristicas = caracteristicas;
	}

	// RALCIÓN 1 A MUCHOS
	@OneToMany(mappedBy = "producto", fetch = FetchType.LAZY)
	private List<CarroCompra> carroCompra;

	// GETTERS AND SETTERS

	public Long getId() {
		return id;
	}

	public List<CarroCompra> getCarroCompra() {
		return carroCompra;
	}

	public void setCarroCompra(List<CarroCompra> carroCompra) {
		this.carroCompra = carroCompra;
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

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

}
