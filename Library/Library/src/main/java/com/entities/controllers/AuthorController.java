package com.entities.controllers;

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
@RequestMapping("/api/author")
public class AuthorController {
	
	@Autowired
	AuthorRepository authorRepository;
	
	@PostMapping
	public Author salvarAutor( @RequestBody Author author ) { //Salvar o autor
		return authorRepository.save(author);
	}
	
	@GetMapping
	public List<Author> mostrarAutores(){ //Listar os autores
		return authorRepository.findAll();
	}
	
	@DeleteMapping("/{Id}") //Vai ser deletado identificando o Id
	public void deletarAutor( @PathVariable Long Id ) { //Deletar um autor
		authorRepository.deleteById( Id );
	}
	
	@PutMapping
	public Author atualizarAutor( @PathVariable long Id, @RequestBody Author newAuthor ) {
		Optional<Author> optionalAuthor = authorRepository.findById(Id);
		if( optionalAuthor.isPresent( ) ) { //Metodo para verficiar se existe
			Author author = optionalAuthor.get( ); //Pegando os dados
			author.setName(newAuthor.getName( ) );
			author.setCPF( newAuthor.getCPF( ) );
			author.setEmail( newAuthor.getEmail( ) );
			author.setDataNascimento( newAuthor.getDataNascimento( ) );
			author.setEndereco( newAuthor.getEndereco( ) );
			return authorRepository.save( author );//Salvando este novo autor
		}
		return null;
	}
}
