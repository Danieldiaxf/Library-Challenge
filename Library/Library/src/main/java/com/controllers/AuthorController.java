package com.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.entities.Author;
import com.repositories.AuthorRepository;

@RestController
@RequestMapping( "/api/author" )
public class AuthorController {
	
	@Autowired
	AuthorRepository authorRepository;
	
	@PostMapping
	public Author saveAuthor( @RequestBody Author author ) {
		return authorRepository.save( author );
	}
	
	@GetMapping
	public List<Author> showAuthors(  ){
		return authorRepository.findAll(  );
	}
	
	@DeleteMapping("/{Id}")
	public void deleteAuthor( @PathVariable Long Id ) {
		authorRepository.deleteById( Id );
	}
	
	@PutMapping
	public Author atualizarAuthor( @PathVariable long Id, @RequestBody Author newAuthor ) {
	Optional<Author> optionalAuthor = authorRepository.findById(Id);
	if( optionalAuthor.isPresent( ) ) {
		Author author = optionalAuthor.get( );
		author.setName(newAuthor.getName( ) );
		author.setCPF( newAuthor.getCPF( ) );
		author.setEmail( newAuthor.getEmail( ) );
		author.setBirth( newAuthor.getBirth( ) );
		author.setAddress( newAuthor.getAddress( ) );
		return authorRepository.save( author );
		}return null;
	}
}
