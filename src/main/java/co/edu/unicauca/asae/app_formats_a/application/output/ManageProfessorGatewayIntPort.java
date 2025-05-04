package co.edu.unicauca.asae.app_formats_a.application.output;

import co.edu.unicauca.asae.app_formats_a.domain.models.AFormat;
import co.edu.unicauca.asae.app_formats_a.domain.models.Professor;

import java.util.List;
import java.util.Optional;

public interface ManageProfessorGatewayIntPort {

    public boolean existsProfessorByEmail(String email);

    public Professor save(Professor professor);

    public List<Professor> getByGroupAndStartWithPattern(String groupName, String pattern);

    public Optional<Professor> findById(Long id);

    public List<Professor> getAllProfessorsById(List<Long> ids);

    public boolean existsById(Long id);

    Optional<List<Professor>> getCommiteeMembers();
    public List<AFormat> getAllAFormatsById(Long id);

}
