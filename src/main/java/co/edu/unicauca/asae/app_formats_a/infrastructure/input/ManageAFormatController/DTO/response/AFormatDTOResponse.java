package co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.DTO.response;

import co.edu.unicauca.asae.app_formats_a.domain.models.State;
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
    private Long id;

    private String generalObjective;

    private String title;

    private List<String> specificObjective;

    private ProfessorDTOResponse objProfessor;

    private State state;

    //private List<EvaluationEntity> evaluations;

}
