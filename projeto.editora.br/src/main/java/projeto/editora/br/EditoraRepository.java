package projeto.editora.br;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
	public interface EditoraRepository extends JpaRepository<Editora, Long>{
	boolean existsByCnpj(String cnpj);
}
