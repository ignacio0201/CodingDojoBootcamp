package com.codingdojo.listaestudiantes2.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "contacts")
public class ContactInfo {

	// ATTRIBUTES
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min = 2, max = 80, message = "Debe contener entre 2 y 80 caracteres")
	private String address;
	
	@Size(min = 2, max = 80, message = "Debe contener entre 2 y 80 caracteres")
	private String city;
	
	@Size(min = 2, max = 6, message = "Debe contener entre 2 y 6 caracteres")
	private String state;

	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id")
	@JsonBackReference
	private Student student;
	
	//CONSTRUCTORS
	public ContactInfo() {
	}
	public ContactInfo(Long id,
			@Size(min = 2, max = 80, message = "Debe contener entre 2 y 80 caracteres") String address,
			@Size(min = 2, max = 80, message = "Debe contener entre 2 y 80 caracteres") String city,
			@Size(min = 2, max = 6, message = "Debe contener entre 2 y 6 caracteres") String state, Date createdAt,
			Date updatedAt, Student student) {
		this.id = id;
		this.address = address;
		this.city = city;
		this.state = state;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.student = student;
	}
	
	//GETTERS/SETTERS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
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
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	@PrePersist
	protected void onCreate(){
   		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate(){
    		this.updatedAt = new Date();
	 }
	
}
