package co.edu.unicauca.asae.app_formats_a.domain.useCases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import co.edu.unicauca.asae.app_formats_a.application.input.ManageAFormatUCIntPort;
import co.edu.unicauca.asae.app_formats_a.application.output.ManageAFormatGatewayIntPort;
import co.edu.unicauca.asae.app_formats_a.application.output.ManageProfessorGatewayIntPort;
import co.edu.unicauca.asae.app_formats_a.application.output.ResultsFormatterIntPort;
import co.edu.unicauca.asae.app_formats_a.commons.enums.ConceptEnum;
import co.edu.unicauca.asae.app_formats_a.commons.enums.StateEnum;
import co.edu.unicauca.asae.app_formats_a.domain.models.AFormat;
import co.edu.unicauca.asae.app_formats_a.domain.models.Evaluation;
import co.edu.unicauca.asae.app_formats_a.domain.models.Professor;
import co.edu.unicauca.asae.app_formats_a.domain.models.State;

public class ManageAFormatUCAdapter implements ManageAFormatUCIntPort{

    private final ManageAFormatGatewayIntPort manageAFormatGateway;
    private final ManageProfessorGatewayIntPort manageProfessorGateway;
    private final ResultsFormatterIntPort resultsFormatter;

    public ManageAFormatUCAdapter(ManageAFormatGatewayIntPort manageAFormatGateway, ManageProfessorGatewayIntPort manageProfessorGateway,
                                  ResultsFormatterIntPort resultsFormatter) {
        this.manageAFormatGateway = manageAFormatGateway;
        this.manageProfessorGateway = manageProfessorGateway;
        this.resultsFormatter = resultsFormatter;
    }

    @Override
    public AFormat save(AFormat aFormat) {
        if (this.manageAFormatGateway.existsAFormatByTitle(aFormat.getTitle())) {
            resultsFormatter.returnResponseErrorBusinessRuleViolation("Format with title '" +aFormat.getTitle()+"' already exists");
        }
        validateProfessor(aFormat.getObjProfessor());
        aFormat.initialize();
        return this.manageAFormatGateway.save(aFormat);
    }

    @Override
    public AFormat getById(Long id) {
        boolean existsAFormat = this.manageAFormatGateway.existsById(id);
        if(!existsAFormat){
            resultsFormatter.returnResponseErrorBusinessRuleViolation("Format with ID "+id+" doesn't exist");
        }
        return this.manageAFormatGateway.findById(id);
    }

    @Override
    public List<AFormat> getAllByProffesorBetween(Long id,LocalDate startDate, LocalDate endDate) {

        if(this.manageProfessorGateway.existById(id)){
            Optional<List<AFormat>> formats = this.manageAFormatGateway.findAllByProffesorBetween( id,  startDate,  endDate);
            return formats.orElse(null);
        }
        resultsFormatter.returnResponseErrorBusinessRuleViolation("Professor with id "+id+" doesn't exist");
        return null;
    }

    private void validateProfessor(Professor professor) {
        if (professor == null) {
            resultsFormatter.returnResponseErrorBusinessRuleViolation("Professor can't be null");
        }

        boolean emailExists = this.manageProfessorGateway.existsProfessorByEmail(professor.getEmail());

        if (professor.getId() == null && emailExists) {
            resultsFormatter.returnResponseErrorBusinessRuleViolation("Email '" +professor.getEmail()+"' already registered");
        }

        if (professor.getId() != null) {
            boolean idExists = this.manageProfessorGateway.existsById(professor.getId());
            if (!idExists) {
                resultsFormatter.returnResponseErrorBusinessRuleViolation("Professor with ID "+professor.getId()+" doesn't exist");
            }
        }
    }
    
}
