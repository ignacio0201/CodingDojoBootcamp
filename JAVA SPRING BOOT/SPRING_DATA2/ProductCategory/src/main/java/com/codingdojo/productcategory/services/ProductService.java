package com.codingdojo.productcategory.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.productcategory.models.Category;
import com.codingdojo.productcategory.models.Product;
import com.codingdojo.productcategory.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired private ProductRepository productRepository;
	
	//-------------------------------------------------------------------------//
	
	//REGISTRAR UN PRODUCTO
	public Product registrarProducto(Product product) {
		return productRepository.save(product);
	}
	
	//BUSCAR PRODUCTO POR ID
	public Product buscarProductoById(Long id) {
		return productRepository.findProductById(id);
	}
	
	//BUSCAR LAS CATEGORIAS NO ASIGNADAS AL PRODUCTO
	public List<Product> buscarProductosSinAsignar(Category category) {
		return productRepository.findByCategoriesNotContains(category);
	}
	
}
