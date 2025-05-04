package co.edu.unicauca.asae.app_formats_a.domain.useCases;

import java.time.LocalDate;
import java.util.List;

import co.edu.unicauca.asae.app_formats_a.application.input.ManageObservationUCIntPort;
import co.edu.unicauca.asae.app_formats_a.application.output.ManageEvaluationGatewayIntPort;
import co.edu.unicauca.asae.app_formats_a.application.output.ManageAFormatGatewayIntPort;
import co.edu.unicauca.asae.app_formats_a.application.output.ManageObservationGatewayIntPort;
import co.edu.unicauca.asae.app_formats_a.application.output.ManageProfessorGatewayIntPort;
import co.edu.unicauca.asae.app_formats_a.commons.enums.ConceptEnum;
import co.edu.unicauca.asae.app_formats_a.domain.models.Evaluation;
import co.edu.unicauca.asae.app_formats_a.domain.models.Observation;
import co.edu.unicauca.asae.app_formats_a.domain.models.Professor;

public class ManageObservationUCAdapter implements ManageObservationUCIntPort {

    private final ManageObservationGatewayIntPort manageObservationGateway;
    private final ManageProfessorGatewayIntPort manageProfessorGateway;
    private final ManageEvaluationGatewayIntPort manageEvaluationGateway;
    private final ManageAFormatGatewayIntPort manageAFormatGateway;

    

    public ManageObservationUCAdapter(ManageObservationGatewayIntPort manageObservationGateway,
            ManageProfessorGatewayIntPort manageProfessorGateway, ManageEvaluationGatewayIntPort manageEvaluationGateway,
            ManageAFormatGatewayIntPort manageAFormatGateway) {
        this.manageObservationGateway = manageObservationGateway;
        this.manageProfessorGateway = manageProfessorGateway;
        this.manageEvaluationGateway = manageEvaluationGateway;
        this.manageAFormatGateway = manageAFormatGateway;
    }

    @Override
    public Observation save(Observation observation, Long formatId) {
        boolean existsFormat = manageAFormatGateway.existsById(formatId);
        if(!existsFormat){
            throw new IllegalArgumentException("El formato no existe");
        }

        for (Professor professor : observation.getProfessors()) {
            boolean professorById = manageProfessorGateway.existsById(professor.getId());
            if (!professorById) {
                throw new IllegalArgumentException("El profesor no existe");
            }
        }

        Evaluation evaluation = manageEvaluationGateway.getLastEvaluationByFormat(formatId);
        if(evaluation==null){
            evaluation = new Evaluation(null, ConceptEnum.UNESTABLISHED, LocalDate.now(), observation.getObservation(), null, null);
        }
        observation.setObservationDateRegister(LocalDate.now());
        observation.setObjEvaluation(evaluation);
        return manageObservationGateway.save(observation, formatId);

    }

    @Override
    public List<Observation> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

}
