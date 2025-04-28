package co.edu.unicauca.asae.app_formats_a.application.input;

import java.time.LocalDate;
import java.util.List;

import co.edu.unicauca.asae.app_formats_a.domain.models.AFormat;
import co.edu.unicauca.asae.app_formats_a.domain.models.Professor;

public interface ManageProfessorUCIntPort {
    
    public List<Professor> getAll();

    public List<AFormat> getAllAFormatsByProfessor(Long id);

    public List<AFormat> getAllAFormatsByProfessorBetweenDates(Long id, LocalDate startDate, LocalDate endDate);

    public List<Professor> getByGroupAndStartWithPattern(String groupName, String pattern);
}
