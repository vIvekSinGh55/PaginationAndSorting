package com.vivek.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.vivek.model.Book;
import com.vivek.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepo;
	
	
	public Book saveBook(Book book) {
	
		return bookRepo.save(book);
	}

	
	public List<Book> allBook()
	{
		return bookRepo.findAll();
	}
	
	public Page<Book> fetchBook(int page, int size)
	{
		Pageable pageable = PageRequest.of(page, size);
		
		return bookRepo.findAll(pageable);
	}
	
	public Page<Book> getBooksPaginatedSorted(int page, int size, String sortBy)
	{
		Pageable pagebale = PageRequest.of(page, size, Sort.by(sortBy).ascending());
		
		return bookRepo.findAll(pagebale);
	}
	

}
