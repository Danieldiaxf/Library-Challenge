package projeto.editora.br;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "editora")
public class Editora {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	@Size(max = 120)
	private String nome;
	
	@Column(name = "cnpj", unique = true)
	@NotBlank
	@Size(max = 20)
	private String cnpj;
	
	@Size(max = 200)
	private String endereco;
	
	@Size(max = 30)
	private String telefone;

	public Editora () {}
		
	  public Editora(String nome, String cnpj, String endereco, String telefone) {
	  this.nome = nome;
	  this.cnpj = cnpj;
	  this.endereco = endereco;
	  this.telefone = telefone;
	
	}

	  public long getId() {
		  return id;
	  }

	  public void setId(long id) {
		  this.id = id;
	  }

	  public String getNome() {
		  return nome;
	  }

	  public void setNome(String nome) {
		  this.nome = nome;
	  }

	  public String getCnpj() {
		  return cnpj;
	  }

	  public void setCnpj(String cnpj) {
		  this.cnpj = cnpj;
	  }

	  public String getEndereco() {
		  return endereco;
	  }

	  public void setEndereco(String endereco) {
		  this.endereco = endereco;
	  }

	  public String getTelefone() {
		  return telefone;
	  }

	  public void setTelefone(String telefone) {
		  this.telefone = telefone;
	  }
	  
}
