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
import com.entities.Author;
import com.repositories.AuthorRepository;

// Controlador REST responsável pelos endpoints relacionados a Author
@RestController
// Define o prefixo "/api/author" para todas as rotas deste controller
@RequestMapping("/api/author")
public class AuthorController {
	
    // Injeta automaticamente o repositório de Author
	@Autowired
	AuthorRepository authorRepository;
	
    // Endpoint POST para salvar um novo Author
	@PostMapping
	public Author saveAuthor(@RequestBody @NonNull Author author) {
		// Persiste o autor no banco e retorna o objeto salvo
        return authorRepository.save(author);
	}
	
    // Endpoint GET para listar todos os autores cadastrados
	@GetMapping
	public List<Author> showAuthors() {
		return authorRepository.findAll();
	}
	
    // Endpoint DELETE para remover um autor pelo ID
	@DeleteMapping("/{Id}")
	public void deleteAuthor(@PathVariable @NonNull Long Id) {
		authorRepository.deleteById(Id);
	}
	
    // Endpoint PUT para atualizar um autor existente
	@PutMapping("/{Id}")
	public Author atualizarAuthor(@PathVariable long Id, @RequestBody Author newAuthor) {

        // Busca o autor pelo ID
		Optional<Author> optionalAuthor = authorRepository.findById(Id);

        // Se encontrado, atualiza os dados e salva
		if (optionalAuthor.isPresent()) {
			Author author = optionalAuthor.get();
			author.setName(newAuthor.getName());
			author.setCPF(newAuthor.getCPF());
			author.setEmail(newAuthor.getEmail());
			author.setBirth(newAuthor.getBirth());
			author.setAddress(newAuthor.getAddress());
			return authorRepository.save(author);
		}

        // Caso o autor não exista, retorna null (poderia ser 404)
		return null;
	}
}
