package com.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

// Indica que esta classe é uma entidade JPA representando a tabela "Book"
@Entity
@Table(name = "Book")
public class Book {

    // Relacionamento Many-to-One: vários livros podem ter o mesmo publisher
    @ManyToOne
    // Define a coluna de chave estrangeira que referencia Publisher
    @JoinColumn(name = "Publisher_id")
    private Publisher publisher;

    // Relacionamento Many-to-One: vários livros pertencem a um mesmo author
    @ManyToOne
    // Define a coluna de chave estrangeira que referencia Author
    @JoinColumn(name = "Author_id")
    private Author author;
    
    // Chave primária da entidade
    @Id
    // Define geração automática do ID pelo banco (auto-increment)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nome do livro — campo obrigatório
    @NotBlank
    private String name;

    // ISBN único e mapeado com nome customizado na tabela
    @Column(unique = true, name = "ISBN")
    private String isbn;

    // Ano de publicação do livro
    private Integer year;

    // Idioma do livro
    private String language;

    // Construtor utilizado para criação de novos livros com dados obrigatórios
    public Book(Publisher publisher, @NotBlank String name, String isbn, Integer year, String language) {
        this.publisher = publisher;
        this.name = name;
        this.isbn = isbn;
        this.year = year;
        this.language = language;
    }

    // Construtor padrão exigido pelo JPA
    public Book() {
    }

    // Métodos de acesso (getters e setters)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }

    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }

    public Publisher getPublisher() {
        return publisher;
    }
    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }
}
