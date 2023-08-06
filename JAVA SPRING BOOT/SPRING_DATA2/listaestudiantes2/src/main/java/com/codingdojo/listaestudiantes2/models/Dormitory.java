package com.codingdojo.listaestudiantes2.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "dormitories")
public class Dormitory {
	
	//ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min = 2, max = 70, message = "Debe contener entre 2 y 70 caracteres")
	private String name;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
	@OneToMany(mappedBy = "dormitory", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<Student> students;

	//FECHAS
	@PrePersist
	protected void onCreate(){
   		this.createdAt = new Date();
   		this.updatedAt = new Date();
	}
	@PreUpdate
	protected void onUpdate(){
    	this.updatedAt = new Date();
	 }
	
	
	//CONSTRUCTORES
	public Dormitory() {
	}
	public Dormitory(@Size(min = 2, max = 70, message = "Debe contener entre 2 y 70 caracteres") String name) {
		this.name = name;
	}
	public Dormitory(Long id, @Size(min = 2, max = 70, message = "Debe contener entre 2 y 70 caracteres") String name,
			Date createdAt, Date updatedAt, List<Student> students) {
		this.id = id;
		this.name = name;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.students = students;
	}
	
	
	//GETTERS/SETTERS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public List<Student> getStudent() {
		return students;
	}
	public void setStudent(List<Student> students) {
		this.students = students;
	}
	
}
