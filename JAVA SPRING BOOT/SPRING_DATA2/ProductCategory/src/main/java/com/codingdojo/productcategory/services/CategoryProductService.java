package com.codingdojo.productcategory.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.productcategory.models.CategoryProduct;
import com.codingdojo.productcategory.repositories.CategoryProductRepository;

@Service
public class CategoryProductService {
	
	@Autowired private CategoryProductRepository categoryProductRepository;
	
	//--------------------------------------------------------------------------------------//
	
	// AGREGAR CATEGORIA A UN PRODUCTO
	public CategoryProduct agregarCategoriaProducto(CategoryProduct categoryProduct) {
		return categoryProductRepository.save(categoryProduct);
	}
	
	// AGREGAR PRODUCTO A UNA CATEGORIA
	public CategoryProduct agregarProductoCategoria(CategoryProduct categoryProduct) {
		return categoryProductRepository.save(categoryProduct);
	}
	
}
