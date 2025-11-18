package com.entities;

import java.util.List;
import java.util.Set;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table( name = "Book" )
public class Book {

    @ManyToOne
    private Publisher publisher;
    @JoinColumn( name = "Publisher_id" )

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @NotBlank
    private String name;

    @Column( unique = true, name = "ISBN" )
    private String isbn;

    @Size( min = 4, max = 4 )
    private Long year;

    private String language;

    public String getName( ) {
        return name;
    }
    public void setName( String name ) {
        this.name = name;
    }


    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    public Long getYear() {
        return year;
    }
    public void setYear( Long year ) {
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
