package co.edu.unicauca.asae.app_formats_a.application.output;

import co.edu.unicauca.asae.app_formats_a.domain.models.Professor;

import java.util.List;
import java.util.Optional;

public interface ManageProfessorGatewayIntPort {

    public Optional<Professor> existsProfessorByEmail(String email);

    public Professor save(Professor professor);

    public List<Professor> getByGroupAndStartWithPattern(String groupName, String pattern);
}
