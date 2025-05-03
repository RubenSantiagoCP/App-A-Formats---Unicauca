package co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.DTO.response;

import co.edu.unicauca.asae.app_formats_a.commons.enums.ConceptEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EvaluationWithoutRelationsDTOResponse {
    private Long id;
    private ConceptEnum concept;
    private String coordinatorName;
}
