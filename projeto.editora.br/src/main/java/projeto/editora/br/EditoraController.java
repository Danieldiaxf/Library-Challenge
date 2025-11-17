package projeto.editora.br;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/biblioteca")
public class EditoraController {
    @Autowired
    private EditoraRepository repository;

    // POST 
    @PostMapping
    public Editora salvarEditora(@RequestBody Editora editora) {
        return repository.save(editora);
    }

    // GET 
    @GetMapping
    public List<Editora> mostrarEditoras() {
        return repository.findAll();
    }

    // GET
    @GetMapping("/{id}")
    public Editora buscarEditora(@PathVariable Long id) {
        return repository.findById(id)
                .orElse(null);  
    }

    // PUT 
    @PutMapping
    public Editora atualizarEditora(@PathVariable Long id, @RequestBody Editora nova) {
        return repository.findById(id).map(editora -> {
            editora.setNome(nova.getNome());
            editora.setCnpj(nova.getCnpj());
            editora.setEndereco(nova.getEndereco());
            editora.setTelefone(nova.getTelefone());
            return repository.save(editora);
        }).orElse(null);
    }

    // DELETE
    @DeleteMapping
    public void deletarEditora(@PathVariable Long id) {
        repository.deleteById(id);
    }
}