package com.codingdojo.productcategory.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.productcategory.models.Category;
import com.codingdojo.productcategory.models.CategoryProduct;
import com.codingdojo.productcategory.models.Product;
import com.codingdojo.productcategory.services.CategoryProductService;
import com.codingdojo.productcategory.services.CategoryService;
import com.codingdojo.productcategory.services.ProductService;

import jakarta.validation.Valid;

@Controller
public class HomeController {
	
	@Autowired private ProductService productService;
	@Autowired private CategoryService categoryService;
	@Autowired private CategoryProductService categoryProductService;
	
	//-------------------------------------------------------------------------------------------------------------------------------------------//
	
	//VISTA REGISTRAR UN PRODUCTO
	@GetMapping("/products/new")
	public String viewRegistrarProducto(@ModelAttribute("nuevoProducto") Product nuevoProducto) {
		return "/views/newProduct.jsp";
	}
	//REGISTRAR PRODUCTO
	@PostMapping("/products/new")
	public String registrarProducto(@Valid @ModelAttribute("nuevoProducto") Product nuevoProducto, BindingResult result) {
		if (result.hasErrors()) {
			return "/views/newProduct.jsp";
		} else {
			productService.registrarProducto(nuevoProducto);
			return "/views/newProduct.jsp";
		}
	}
	
	//VISTA REGISTRAR UNA CATEGORIA
	@GetMapping("/categories/new")
	public String viewRegistrarCategoria(@ModelAttribute("nuevaCategoria") Category nuevaCategoria) {
		return "/views/newCategory.jsp";
	}
	//REGISTRAR UNA CATEGORIA
	@PostMapping("/categories/new")
	public String registrarCategoria(@Valid @ModelAttribute("nuevaCategoria") Category nuevaCategoria,
			BindingResult result) {
		if (result.hasErrors()) {
			return "/views/newCategory.jsp";
		} else {
			categoryService.registrarCategoria(nuevaCategoria);
			return "/views/newCategory.jsp";
		}
	}
	
	//VISTA MOSTRAR PRODUCTO POR ID
	@GetMapping("/products/{idProducto}")
	public String viewProductoById(
			@PathVariable("idProducto") Long idProducto, 
			Model model, 
			@ModelAttribute("category_product") CategoryProduct categoryProduct) {	
		
		Product product = productService.buscarProductoById(idProducto);
		java.util.List<Category> listaCategorias = categoryService.buscarCategoriasSinAsignar(product);
		model.addAttribute("product", product);
		model.addAttribute("listaCategorias", listaCategorias);
		return "/views/products.jsp";
	}
	//AGREGAR CATEGORIA A UN PRODUCTO
	@PostMapping("/products/{idProducto}")
	public String addCategoryProduct(
			@PathVariable("idProducto") Long idProducto,
			@Valid @ModelAttribute("category_product") CategoryProduct categoryProduct,
			BindingResult result) {
		if(result.hasErrors()) {
			return "/views/products.jsp";
		}else {
			Product product = new Product();		
			categoryProduct.setProduct(product);
			categoryProduct.getProduct().setId(idProducto);
			categoryProductService.agregarCategoriaProducto(categoryProduct);
			return "redirect:/products/{idProducto}";	
		}
	}
	
	//VISTA MOSTRAR CATEGORIA POR ID
	@GetMapping("/categories/{idCategoria}")
	public String viewCategoryById(
			@PathVariable("idCategoria") Long idCategoria,
			Model model,
			@ModelAttribute("category_product") CategoryProduct categoryProduct) {
		
		Category category = categoryService.buscarCategoriaById(idCategoria);
		java.util.List<Product> listaProductos = productService.buscarProductosSinAsignar(category);
		model.addAttribute("category", category);
		model.addAttribute("listaProductos", listaProductos);
		return "/views/categories.jsp";
	}
	//AGREGAR PRODUCTO A UNA CATEGORIA
	@PostMapping("/categories/{idCategoria}")
	public String addProductCategory(
			@PathVariable("idCategoria") Long idCategoria,
			@Valid @ModelAttribute("category_product") CategoryProduct categoryProduct,
			BindingResult result) {
		if(result.hasErrors()) {
			return "/views/categories.jsp";
		}else {
			Category category = new Category();		
			categoryProduct.setCategory(category);
			categoryProduct.getCategory().setId(idCategoria);
			categoryProductService.agregarProductoCategoria(categoryProduct);
			return "redirect:/categories/{idCategoria}";	
		}
	}
	
	
}
