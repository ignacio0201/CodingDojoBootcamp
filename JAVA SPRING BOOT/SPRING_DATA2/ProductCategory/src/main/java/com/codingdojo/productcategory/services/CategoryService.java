package com.codingdojo.productcategory.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.productcategory.models.Category;
import com.codingdojo.productcategory.models.Product;
import com.codingdojo.productcategory.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired private CategoryRepository categoryRepository;
	
	//-------------------------------------------------------------------------//
	
	//REGISTRAR UNA CATEGORIA
	public Category registrarCategoria(Category category) {
		return categoryRepository.save(category);
	}
	
	//BUSCAR LAS CATEGORIAS NO ASIGNADAS AL PRODUCTO
	public List<Category> buscarCategoriasSinAsignar(Product product){
		return categoryRepository.findByProductsNotContains(product);
	}
	
	//BUSCAR CATEGORIA POR ID
	public Category buscarCategoriaById(Long id) {
		return categoryRepository.findCategoryById(id);
	}
	
}
