package entities;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import entities.Autor;

@RestController
@RequestMapping("/api/autor")
public class AutorController {
	
			
	@Autowired
	AuthorRepository autorRepository;
	
	@PostMapping
	public Autor salvarAutor(@RequestBody Autor autor) { //Salvar o autor
		return autorRepository.save(autor);
	}
	
	@GetMapping
	public List<Autor> mostrarAutores(){ //Listar os autores
		return autorRepository.findAll();
	}
	
	@DeleteMapping("/{Id}") //Vai ser deletado identificando o Id
	public void deletarAutor(@PathVariable long Id) { //Deletar um autor
		autorRepository.deleteById(Id);
	}
	
	@PutMapping
	public Autor atualizarAutor(@PathVariable long Id, @RequestBody Autor novoAutor) {
		Optional<Autor> optionalAutor = autorRepository.findById(Id);
		if(optionalAutor.isPresent()) { //Metodo para verficiar se existe
			Autor autor = optionalAutor.get(); //Pegando os dados
			autor.setNome(novoAutor.getNome());
			autor.setCPF(novoAutor.getCPF());
			autor.setEmail(novoAutor.getEmail());
			autor.setDataNascimento(novoAutor.getDataNascimento());
			autor.setEndereco(novoAutor.getEndereco());
			return autorRepository.save(autor);//Salvando este novo autor
		}
		return null;
	}
}
