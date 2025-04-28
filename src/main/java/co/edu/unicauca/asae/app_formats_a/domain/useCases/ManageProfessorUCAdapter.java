package co.edu.unicauca.asae.app_formats_a.domain.useCases;

import java.time.LocalDate;
import java.util.List;

import co.edu.unicauca.asae.app_formats_a.application.input.ManageProfessorUCIntPort;
import co.edu.unicauca.asae.app_formats_a.application.output.ManageProfessorGatewayIntPort;
import co.edu.unicauca.asae.app_formats_a.domain.models.AFormat;
import co.edu.unicauca.asae.app_formats_a.domain.models.Professor;

public class ManageProfessorUCAdapter implements ManageProfessorUCIntPort {

    private final ManageProfessorGatewayIntPort manageProfessorGateway;

    public ManageProfessorUCAdapter(ManageProfessorGatewayIntPort manageProfessorGateway) {
        this.manageProfessorGateway = manageProfessorGateway;
    }

    @Override
    public List<Professor> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public List<AFormat> getAllAFormatsByProfessor(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllAFormatsByProfessor'");
    }

    @Override
    public List<AFormat> getAllAFormatsByProfessorBetweenDates(Long id, LocalDate startDate, LocalDate endDate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllAFormatsByProfessorBetweenDates'");
    }

    @Override
    public List<Professor> getByGroupAndStartWithPattern(String groupName, String pattern) {
        return this.manageProfessorGateway.getByGroupAndStartWithPattern(groupName, pattern);
    }

}
