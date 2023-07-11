package com.codingdojo.proyectoclass;

public class ProyectoClass {
	//ATRIBUTOS ENCAPSULADOS
	private String nombre;
	private String descripcion;
	
	//METODOS
		//Constructor vacio
	public ProyectoClass() {
	}
		//Constructor (nombre)
	public ProyectoClass(String nombre) {
		this.nombre = nombre;
	}
		//Constructor (nombre y descripcion)
	public ProyectoClass(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
		//GETTERS Y SETTERS
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
		//ELEVATORPITCH
	public String elevatorPitch() {
		return this.nombre + ": " + this.descripcion;
	}
}
