package com.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

// Indica que esta classe representa uma entidade JPA mapeada para uma tabela no banco
@Entity
public class Author {

    // Define um relacionamento One-to-Many entre Author e Book
    @OneToMany
    // Especifica a coluna que fará o vínculo na tabela Book (chave estrangeira)
    @JoinColumn( name = "Publisher_id" )
    private List<Book> books;
    
    // Identifica o campo como chave primária
    @Id
    // Define que o ID será gerado automaticamente pelo banco (auto-increment)
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    // Campo obrigatório (not null) do nome do autor
    @Column( nullable = false )
    private String name;

    // Campo obrigatório, único e renomeado como "CPF" no banco
    @Column( nullable = false, unique = true, name = "CPF" )
    @NotBlank // Validação: não pode ser vazio nem apenas espaços
    private String CPF;

    // Armazena o email do autor (campo opcional)
    private String email;

    // Armazena a data de nascimento (campo opcional — seria ideal usar LocalDate)
    private String birth;

    // Armazena o endereço do autor
    private String address;

    // Getters e setters para acesso e modificação dos atributos
    public Long getId( ) {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getName( ) {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getCPF( ) {
        return CPF;
    }

    public void setCPF( String CPF ) {
        this.CPF = CPF;
    }

    public String getEmail( ) {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getBirth( ) {
        return birth;
    }

    public void setBirth( String birth ) {
        this.birth = birth;
    }

    public String getAddress( ) {
        return address;
    }

    public void setAddress( String address ) {
        this.address = address;
    }

    public List<Book> getBooks( ) {
        return books;
    }

    public void setBooks( List<Book> books ) {
        this.books = books;
    }
}
