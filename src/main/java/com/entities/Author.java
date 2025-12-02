package com.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Author {

    @OneToMany
    @JoinColumn( name = "Publisher_id" )
    private List<Book> books;
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column( nullable = false )
    private String name;

    @Column( nullable = false, unique = true, name = "CPF" )
    private String CPF;

    private String email;

    private String birth;

    private String address;

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
