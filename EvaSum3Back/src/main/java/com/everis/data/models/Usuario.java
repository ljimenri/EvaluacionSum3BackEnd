package com.everis.data.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// ATRIBUTOS
	private Long id;
	private String nombreCompleto;
	private String correo;
	private String clave;

	// CONSTRUCTOR VACIO Y NO VACIO
	public Usuario() {
	}

	public Usuario(Long id, String nombreCompleto, String correo, String clave) {
		super();
		this.id = id;
		this.nombreCompleto = nombreCompleto;
		this.correo = correo;
		this.clave = clave;
	}

	/*
	@ManyToMany(fetch = FetchType.LAZY)
	
	@JoinTable(name = "usuarios_roles", // plural
			joinColumns = @JoinColumn(name = "usuario_id"), // singular
			inverseJoinColumns = @JoinColumn(name = "rol_id")// singular
	)
	
	private List<Rol> roles;

	// GETTERS AND SETTERS

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}
*/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

}
