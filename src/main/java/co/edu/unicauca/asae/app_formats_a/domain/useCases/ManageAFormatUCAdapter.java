package co.edu.unicauca.asae.app_formats_a.domain.useCases;

import java.time.LocalDate;


import co.edu.unicauca.asae.app_formats_a.application.input.ManageAFormatUCIntPort;
import co.edu.unicauca.asae.app_formats_a.application.output.ManageAFormatGatewayIntPort;
import co.edu.unicauca.asae.app_formats_a.application.output.ManageProfessorGatewayIntPort;
import co.edu.unicauca.asae.app_formats_a.commons.enums.StateEnum;
import co.edu.unicauca.asae.app_formats_a.domain.models.AFormat;
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
    
        if (aFormat.getObjProfessor() == null) {
            throw new IllegalArgumentException("El profesor no puede ser nulo");
        }

        boolean existingProfessor = this.manageProfessorGateway.existsById(aFormat.getObjProfessor().getId());

        if(!existingProfessor){
            boolean exists = this.manageProfessorGateway.existsProfessorByEmail(aFormat.getObjProfessor().getEmail());
            if (exists) {
                throw new IllegalArgumentException("El email ya se encuentra registrado");
            }
        }
    
        State state = new State(null, StateEnum.FORMULATED, LocalDate.now(), aFormat);
        aFormat.setState(state);
    
        AFormat savedFormat = this.manageAFormatGateway.save(aFormat);
    
        return savedFormat;
    }
    
}
