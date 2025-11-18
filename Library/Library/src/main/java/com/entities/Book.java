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

@Entity
@Table( name = "Book" )
public class Book {

    @ManyToOne
    @JoinColumn( name = "Publisher_id" )
    private Publisher publisher;
    

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @NotBlank
    private String name;

    @Column( unique = true, name = "ISBN" )
    private String isbn;

    private Integer year;

    private String language;

    public Book(Publisher publisher, @NotBlank String name, String isbn, Integer year, String language) {
        this.publisher = publisher;
        this.name = name;
        this.isbn = isbn;
        this.year = year;
        this.language = language;
    }

    public Book( ){

    }

    public String getName( ) {
        return name;
    }
    public void setName( String name ) {
        this.name = name;
    }


    public String getIsbn( ) {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    public Integer getYear( ) {
        return year;
    }
    public void setYear( Integer year ) {
        this.year = year;
    }


    public String getLanguage(  ) {
        return language;
    }
    public void setLanguage( String language ) {
        this.language = language;
    }


    public Publisher getPublisher( ) {
        return publisher;
    }
    public void setPublisher( Publisher publisher ) {
        this.publisher = publisher;
    }

    

}
