package com.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.entities.Book;
import com.repositories.BookRepository;
import jakarta.annotation.Nonnull;

@RestController
@RequestMapping( "/api/library" )

public class BookController {
    
	@Autowired
	BookRepository bookRepository;

	@PostMapping
	public Book saveBook( @RequestBody @NonNull Book book ) {
		return bookRepository.save( book );
	}

	@GetMapping
	public List<Book> showBooks( ) {
		return bookRepository.findAll();
	}

	@DeleteMapping("/{id}")
	public void deleteBook( @PathVariable @Nonnull long id ) {
		bookRepository.deleteById( id );
	}

	@PutMapping( "/{id}" )
	public Book updateBook( @PathVariable @Nonnull long id, @RequestBody Book newBook ) {
		Optional<Book> optionalBook = bookRepository.findById( id );
		if (optionalBook.isPresent()) {
			Book book = optionalBook.get();
			book.setName( newBook.getName( ) );
			book.setIsbn( newBook.getIsbn( ) );
			book.setYear( newBook.getYear( ) );
			return bookRepository.save( book );
		}
		return null;
	}

}

