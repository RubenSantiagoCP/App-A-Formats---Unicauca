package co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.DTO.request;

import co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.validations.ObjectiveStartsWithInfinitiveInt;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;

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
@NoArgsConstructor
@AllArgsConstructor
public abstract class AFormatDTORequest {

    @Size(min = 3, max = 100, message = "{format.generalObjective.size}")
    @NotBlank(message = "{format.generalObjective.required}")
    @ObjectiveStartsWithInfinitiveInt(message = "{objective.startsWith.infinitive}")
    private String generalObjective;

    @Size(min = 3, max = 100, message = "{format.title.size}")
    @NotBlank(message = "{format.title.required}")
    private String title;

    @NotEmpty(message = "{format.specificObjective.required}")
    @Size(min = 3, max=6, message = "{format.specificObjective.sizeElements}")
    private List<
                @Size(min = 3, max = 100, message = "{format.specificObjective.size}")
                @NotBlank(message = "{format.specificObjective.required}")
                @ObjectiveStartsWithInfinitiveInt(message = "{objective.startsWith.infinitive}") String> specificObjective;

    @NotNull(message = "{format.objProfessor.required}")
    @Valid
    private ProfessorDTORequest objProfessor;

    @Size(min = 3, max = 100, message = "{AFormat.studentName.size}")
    @NotBlank(message = "{AFormat.studentName.required}")
    private String student1Name;

    @NotEmpty(message = "{AFormat.studentCode.required}")
    @Pattern(regexp = "^1046\\d*$", message = "{AFormat.studentCode.mustStartWith1046}")
    private String student1code;
}
