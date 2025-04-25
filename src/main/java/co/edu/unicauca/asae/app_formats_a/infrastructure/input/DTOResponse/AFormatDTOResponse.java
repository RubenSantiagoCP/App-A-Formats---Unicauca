package co.edu.unicauca.asae.app_formats_a.infrastructure.input.DTOResponse;

import co.edu.unicauca.asae.app_formats_a.commons.enums.StateEnum;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.ProfessorEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AFormatDTOResponse {
    private Long formatAId;

    private String generalObjective;

    private String title;

    private List<String> specificObjective;

    private ProfessorEntity objProfessor;

    private StateEnum state;

    //private List<EvaluationEntity> evaluations;

}
