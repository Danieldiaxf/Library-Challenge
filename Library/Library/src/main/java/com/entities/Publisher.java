package com.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity
@Table( name = "Publisher" )
public class Publisher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	@Size( max = 120 )
	private String name;
	
	@Column( name = "cnpj", unique = true )
	@NotBlank
	@Size( max = 20 )
	private String cnpj;
	
	@Size( max = 200 )
	private String address;
	
	@Size( max = 30 )
	private String phone;
		
	  public Publisher( String name, String cnpj, String address, String phone ) {
	  this.name = name;
	  this.cnpj = cnpj;
	  this.address = address;
	  this.phone = phone;
	
	}

	  public long getId( ) {
		  return id;
	  }

	  public void setId( long id ) {
		  this.id = id;
	  }

	  public String getName( ) {
		  return name;
	  }

	  public void setName( String name ) {
		  this.name = name;
	  }

	  public String getCnpj( ) {
		  return cnpj;
	  }

	  public void setCnpj( String cnpj ) {
		  this.cnpj = cnpj;
	  }

	  public String getAddress( ) {
		  return address;
	  }

	  public void setAddress( String address ) {
		  this.address = address;
	  }

	  public String getPhone( ) {
		  return phone;
	  }

	  public void setPhone( String phone ) {
		  this.phone = phone;
	  }

    }

