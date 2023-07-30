package com.codingdojo.languages.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="languages")
public class Language {
	//ATRIBUTOS
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Size(min = 2, max = 20)
    private String name;
    @Size(min = 2, max = 20)
    private String creator;
    @Size(min = 1, max = 100)
    private String currentVersion;
    	//FECHAS
    @Column(updatable=false)
 	@DateTimeFormat(pattern="yyyy-MM-dd")
    	private Date createdAt;
   	@DateTimeFormat(pattern="yyyy-MM-dd")
    	private Date updatedAt;
    
    //CONSTRUCTORES
	public Language() {
	}

	public Language(Long id, @Size(min = 5, max = 100) String name, @Size(min = 2, max = 100) String creator,
			@Size(min = 3, max = 100) String currentVersion) {
		this.id = id;
		this.name = name;
		this.creator = creator;
		this.currentVersion = currentVersion;
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

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getCurrentVersion() {
		return currentVersion;
	}

	public void setCurrentVersion(String currentVersion) {
		this.currentVersion = currentVersion;
	}
	//FECHAS
	@PrePersist
	protected void onCreate(){
   		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate(){
    		this.updatedAt = new Date();
	 }
   
}
