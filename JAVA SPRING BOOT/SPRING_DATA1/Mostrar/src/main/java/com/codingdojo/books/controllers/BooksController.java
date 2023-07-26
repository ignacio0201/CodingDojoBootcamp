package com.codingdojo.books.controllers;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.books.models.Book;
import com.codingdojo.books.services.BookService;

import jakarta.validation.Valid;

@Controller
public class BooksController {
	private final BookService bookService;

	public BooksController(BookService bookService) {
		this.bookService = bookService;
	}
	
	//Muestra la view con todos los libros
	@GetMapping("/books")
	public String index(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "/books/index.jsp";
	}
	
	//Muestra la view para crear un libro
	@GetMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book) {
		return "/books/new.jsp";
	}
	
	//Crear libro
	@PostMapping("/books")
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if (result.hasErrors()) {
			return "/books/new.jsp";
		} else {
			bookService.createBook(book);
			return "redirect:/books";
		}
	}
	
	//Obtener libro por id
	@GetMapping("/books/{id}")
	public String findBookById(@PathVariable("id") Long id, Model model) {
		Book book = bookService.findBook(id);
		if(book == null) {
			return "No se encontro el libro";
		}else {
			model.addAttribute("book", book);
			return "/books/show.jsp";
		}
	}

}
