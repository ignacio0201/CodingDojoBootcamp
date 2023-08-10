package com.codingdojo.productcategory.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name="categories_products")
public class CategoryProduct {
	
	//ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_id")
    private Product product;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id")
    private Category category;
    
    //----------------------------------------------------------------------------------------------------//
    
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
  	
    //----------------------------------------------------------------------------------------------------//
  	
  	//CONSTRUCTORES
    public CategoryProduct() {
    }
    public CategoryProduct(Long id, Date createdAt, Date updatedAt, Product product, Category category) {
		this.id = id;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.product = product;
		this.category = category;
	}
    
    //----------------------------------------------------------------------------------------------------//
    
	//GETTERS/SETTERS
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
}