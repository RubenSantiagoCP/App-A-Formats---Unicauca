package co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ObservationDTOWithoutRelations {
    private Long id;
    private String observation;
    private LocalDate observationDateRegister;
}
