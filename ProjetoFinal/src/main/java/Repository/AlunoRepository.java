package Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    Aluno findByMatricula(String matricula);
}
