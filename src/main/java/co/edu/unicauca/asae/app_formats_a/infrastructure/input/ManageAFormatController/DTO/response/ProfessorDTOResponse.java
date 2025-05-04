package co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.DTO.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfessorDTOResponse {
    private Long id;
    private String name;
    private String lastName;
    private String groupName;
    private String email;
    private List<HistoricalRecordDTOResponse> records;
}
