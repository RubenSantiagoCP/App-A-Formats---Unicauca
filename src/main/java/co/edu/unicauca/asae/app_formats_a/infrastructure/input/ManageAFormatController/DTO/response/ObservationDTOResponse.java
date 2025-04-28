package co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.DTO.response;

import java.time.LocalDate;
import java.util.List;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ObservationDTOResponse {
    private Long id;
    private String observation;
    private List<Long> professorsId;
    private Long formatId;
    private LocalDate observationRegisterDate;
}
