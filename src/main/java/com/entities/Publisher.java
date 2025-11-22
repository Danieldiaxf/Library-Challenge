package com.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


// Indica que esta classe é uma entidade JPA mapeada para a tabela "Publisher"
@Entity
@Table(name = "Publisher")
public class Publisher {

    // Relacionamento One-to-Many: um publisher pode possuir vários livros
    // "mappedBy" indica que o lado responsável pelo relacionamento é a entidade Book
    @OneToMany(mappedBy = "publisher")
    private List<Book> books;

    // Chave primária da entidade
    @Id
    // ID gerado automaticamente pelo banco (auto-increment)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    // Nome da editora — obrigatório e limitado a 120 caracteres
    @NotBlank
    @Size(max = 120)
    private String name;
    
    // CNPJ único, obrigatório e limitado a 20 caracteres
    @Column(name = "cnpj", unique = true)
    @NotBlank
    @Size(max = 20)
    private String cnpj;
    
    // Endereço da editora — campo opcional com limite de tamanho
    @Size(max = 200)
    private String address;
    
    // Telefone da editora — opcional, até 30 caracteres
    @Size(max = 30)
    private String phone;
        
    // Construtor padrão exigido pelo JPA
    public Publisher() {
    }

    // Construtor utilizado na criação de novos Publishers
    public Publisher(String name, @NotBlank String cnpj, String address, String phone) {
        this.name = name;
        this.cnpj = cnpj;
        this.address = address;
        this.phone = phone;
    }

    // Getters e setters para acesso aos atributos
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
