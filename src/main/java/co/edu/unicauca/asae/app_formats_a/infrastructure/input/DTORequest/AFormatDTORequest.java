package co.edu.unicauca.asae.app_formats_a.infrastructure.input.DTORequest;

import co.edu.unicauca.asae.app_formats_a.commons.enums.StateEnum;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.EvaluationEntity;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.ProfessorEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

public class AFormatDTORequest {
    private Long formatAId;

    private String generalObjective;

    private String title;

    private List<String> specificObjective;

    private ProfessorEntity objProfessor;

    private StateEnum state;

    //private List<EvaluationEntity> evaluations;

}
