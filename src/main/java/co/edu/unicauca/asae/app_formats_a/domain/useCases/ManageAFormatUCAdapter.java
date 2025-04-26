package co.edu.unicauca.asae.app_formats_a.domain.useCases;

import java.time.LocalDate;
import java.util.*;

import co.edu.unicauca.asae.app_formats_a.application.input.ManageAFormatUCIntPort;
import co.edu.unicauca.asae.app_formats_a.application.output.ManageAFormatGatewayIntPort;
import co.edu.unicauca.asae.app_formats_a.application.output.ManageProfessorGatewayIntPort;
import co.edu.unicauca.asae.app_formats_a.commons.enums.StateEnum;
import co.edu.unicauca.asae.app_formats_a.domain.models.AFormat;
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
        AFormat objCreatedAFormat = null;
        if(this.manageAFormatGateway.existsAFormatByTitle(aFormat.getTitle())){
            throw new IllegalArgumentException("El formato ya existe");
        }else{
            if(aFormat.getObjProfessor()==null){
                throw new IllegalArgumentException("El profesor no puede ser nulo");
            }

            String email = aFormat.getObjProfessor().getEmail();
            Optional<Professor> objProfessor = this.manageProfessorGateway.existsProfessorByEmail(email);

            if(objProfessor.isPresent()){
                aFormat.setObjProfessor(objProfessor.get());
            }else{
                aFormat.getObjProfessor().setAFormats(new ArrayList<>());
            }

            aFormat.getObjProfessor().addFormat(aFormat);
            State state = new State(StateEnum.FORMULATED, LocalDate.now());
            state.setObjAformat(aFormat);
            aFormat.setState(state);
            objCreatedAFormat = this.manageAFormatGateway.save(aFormat);
        }
        return objCreatedAFormat;
    }
    
}
