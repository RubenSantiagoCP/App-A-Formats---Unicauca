package co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.DTO.response;

import java.time.LocalDate;
import java.util.List;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ObservationDTOCreateResponse {
    private Long id;
    private String observation;
    private List<ProfessorDTOResponse> professors;
    private LocalDate observationDateRegister;
    private EvaluationWithoutRelationsDTOResponse objEvaluation;
}
