package com.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table( name = "Book" )
public class Book {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )

    private Long id;
    private String name;
    private String isbn;
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

    

}
