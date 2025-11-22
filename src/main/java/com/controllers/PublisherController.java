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
import com.entities.Publisher;
import com.repositories.PublisherRepository;

import jakarta.annotation.Nonnull;

// Controlador REST responsável pelos endpoints relacionados à entidade Publisher
@RestController
// Define o prefixo "/api/Library" para todas as rotas deste controller
@RequestMapping("/api/Library")
public class PublisherController {

    // Injeta automaticamente o repositório de Publisher
    @Autowired
    PublisherRepository publisherRepository;

    // Endpoint POST para cadastrar um novo Publisher
    @PostMapping
    public Publisher savPublisher(@RequestBody @NonNull Publisher publisher) {
        // Salva o publisher no banco e retorna o objeto persistido
        return publisherRepository.save(publisher);
    }

    // Endpoint GET que retorna a lista de todas as publishers cadastradas
    @GetMapping
    public List<Publisher> showPublishers() {
        return publisherRepository.findAll();
    }

    // Endpoint DELETE para remover uma publisher pelo ID
    @DeleteMapping("/{id}")
    public void deletePublisher(@PathVariable @Nonnull long id) {
        // Remove o registro correspondente ao ID informado
        publisherRepository.deleteById(id);
    }

    // Endpoint PUT para atualizar os dados de uma publisher existente
    @PutMapping("/{id}")
    public Publisher updatePublisher(@PathVariable @Nonnull long id, @RequestBody Publisher newPublisher) {

        // Busca o publisher pelo ID
        Optional<Publisher> optionalPublisher = publisherRepository.findById(id);

        // Se encontrado, copia os novos dados e salva
        if (optionalPublisher.isPresent()) {
            Publisher publisher = optionalPublisher.get();
            publisher.setName(newPublisher.getName());
            publisher.setAddress(newPublisher.getAddress());
            publisher.setCnpj(newPublisher.getCnpj());
            publisher.setPhone(newPublisher.getPhone());
            return publisherRepository.save(publisher);
        }

        // Caso o ID não exista, retorna null (ideal: retornar 404)
        return null;
    }
}
