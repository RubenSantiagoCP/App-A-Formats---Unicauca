package co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.DTO.response;

import co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.DTO.request.PPAFormatDTORequest;
import co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.DTO.request.TIAFormatDTORequest;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)

@JsonSubTypes({
        @JsonSubTypes.Type(value = PPAFormatDTORequest.class, name = "PPA"),
        @JsonSubTypes.Type(value = TIAFormatDTORequest.class, name = "TIA"),
})

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

    private StateDTOResponse state;

    private List<EvaluationDTOResponse> evaluations;

    private String student1Name;

    private String student1code;
}
