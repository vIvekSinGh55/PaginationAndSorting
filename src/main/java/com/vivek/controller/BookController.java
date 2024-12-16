package com.vivek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vivek.model.Book;
import com.vivek.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	
	@PostMapping("/add")
	public ResponseEntity<Book> saveBook(@RequestBody Book book) {
		Book newBook = bookService.saveBook(book);
		return ResponseEntity.status(HttpStatus.CREATED).body(newBook);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Book>> getAllBook()
	{
		
		return ResponseEntity.status(HttpStatus.OK).body(bookService.allBook());
	}
	
	@GetMapping("/allPage")
	public ResponseEntity<Page<Book>> getAllBookSt(@RequestParam(value="page", defaultValue = "0")int page, 
			@RequestParam(value="size", defaultValue = "2")int size)
	{
		
		return ResponseEntity.status(HttpStatus.OK).body(bookService.fetchBook(page, size));
	}
	
	@GetMapping("/allPageSort")
	public ResponseEntity<Page<Book>> getAllBookSorted(@RequestParam(value="page", defaultValue = "0")int page, 
			@RequestParam(value="size", defaultValue = "2")int size, @RequestParam(value="sortBy", defaultValue = "title") String sortBy )
	{
		
		return ResponseEntity.status(HttpStatus.OK).body(bookService.getBooksPaginatedSorted(page, size, sortBy));
	}

}
