package co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.DTO.response;

import java.util.List;

import co.edu.unicauca.asae.app_formats_a.commons.enums.ConceptEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class EvaluationDTOResponse {
    private Long id;
    private ConceptEnum concept;
    private String coordinatorName;
    private List<ObservationDTOWithoutRelations> observations;
}
