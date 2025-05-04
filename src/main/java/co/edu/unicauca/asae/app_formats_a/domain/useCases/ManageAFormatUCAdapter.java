package co.edu.unicauca.asae.app_formats_a.domain.useCases;

import java.time.LocalDate;
import java.util.ArrayList;

import co.edu.unicauca.asae.app_formats_a.application.input.ManageAFormatUCIntPort;
import co.edu.unicauca.asae.app_formats_a.application.output.ManageAFormatGatewayIntPort;
import co.edu.unicauca.asae.app_formats_a.application.output.ManageProfessorGatewayIntPort;
import co.edu.unicauca.asae.app_formats_a.commons.enums.ConceptEnum;
import co.edu.unicauca.asae.app_formats_a.commons.enums.StateEnum;
import co.edu.unicauca.asae.app_formats_a.domain.models.AFormat;
import co.edu.unicauca.asae.app_formats_a.domain.models.Evaluation;
import co.edu.unicauca.asae.app_formats_a.domain.models.Professor;
import co.edu.unicauca.asae.app_formats_a.domain.models.State;

public class ManageAFormatUCAdapter implements ManageAFormatUCIntPort{

    private final ManageAFormatGatewayIntPort manageAFormatGateway;
    private final ManageProfessorGatewayIntPort manageProfessorGateway;

    public ManageAFormatUCAdapter(ManageAFormatGatewayIntPort manageAFormatGateway, ManageProfessorGatewayIntPort manageProfessorGateway) {
        this.manageAFormatGateway = manageAFormatGateway;
        this.manageProfessorGateway = manageProfessorGateway;
    }

    @Override
    public AFormat save(AFormat aFormat) {
        if (this.manageAFormatGateway.existsAFormatByTitle(aFormat.getTitle())) {
            throw new IllegalArgumentException("El formato ya existe");
        }
        validateProfessor(aFormat.getObjProfessor());
        aFormat.initialize();
        return this.manageAFormatGateway.save(aFormat);
    }

    @Override
    public AFormat getById(Long id) {
        AFormat aFormat = this.manageAFormatGateway.findById(id);
        return aFormat;
    }

    private void validateProfessor(Professor professor) {
        if (professor == null) {
            throw new IllegalArgumentException("El profesor no puede ser nulo");
        }

        boolean emailExists = this.manageProfessorGateway.existsProfessorByEmail(professor.getEmail());

        if (professor.getId() == null && emailExists) {
            throw new IllegalArgumentException("El email ya se encuentra registrado");
        }

        if (professor.getId() != null) {
            boolean idExists = this.manageProfessorGateway.existsById(professor.getId());
            if (!idExists) {
                throw new IllegalArgumentException("Id de profesor no existe");
            }
        }
    }
    
}
