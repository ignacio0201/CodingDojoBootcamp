package com.codingdojo.listaestudiantes2.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "students")
public class Student {

	// ATTRIBUTES
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min = 2, max = 70, message = "Debe contener entre 2 y 70 caracteres")
	private String firstName;
	@Size(min = 2, max = 70, message = "Debe contener entre 2 y 70 caracteres")
	private String lastName;
	@Size(min = 1, max = 4, message = "Debe contener entre 1 y 4 caracteres")
	private String age;

	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	@OneToOne(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference
	private ContactInfo contactInfo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="dormitory_id")
	@JsonBackReference
	
	private Dormitory dormitory;

	//CONSTRUCTORS
	public Student() {
	}
	public Student(Long id,
			@Size(min = 2, max = 70, message = "Debe contener entre 2 y 70 caracteres") String firstName,
			@Size(min = 2, max = 70, message = "Debe contener entre 2 y 70 caracteres") String lastName,
			@Size(min = 1, max = 4, message = "Debe contener entre 1 y 4 caracteres") String age, Date createdAt,
			Date updatedAt, ContactInfo contactInfo, Dormitory dormitory) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.contactInfo = contactInfo;
		this.dormitory = dormitory;
	}
	
	public Student(@Size(min = 2, max = 70, message = "Debe contener entre 2 y 70 caracteres") String firstName,
			@Size(min = 2, max = 70, message = "Debe contener entre 2 y 70 caracteres") String lastName,
			@Size(min = 1, max = 4, message = "Debe contener entre 1 y 4 caracteres") String age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	//GETTERS/SETTERS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
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
	public ContactInfo getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}
	public Dormitory getDormitory() {
		return dormitory;
	}
	public void setDormitory(Dormitory dormitory) {
		this.dormitory = dormitory;
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
