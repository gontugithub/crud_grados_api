package com.example.grado.model;

import jakarta.persistence.*;

@Entity
public class Grado {
	
	// ASIGNA EL VALOR DE PRIMARY KEY
	@Id 
	// SE APLICA JUNTO A LA ANOTACION @Id, ES AUTO INCREMENTADO
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String type;
	private Long studentLimit;
	private String name;
	
	// NECESITAMOS 2 CONSTRUCTORES (JPA: VACIO) (NORMAL: SIN ID, QUE ES AUTOINCREMENTADO)
	
	public Grado() {
	
		
	}

	public Grado(String type, Long studentLimit, String name) {
		this.type = type;
		this.studentLimit = studentLimit;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getStudentLimit() {
		return studentLimit;
	}

	public void setStudentLimit(Long studentLimit) {
		this.studentLimit = studentLimit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
