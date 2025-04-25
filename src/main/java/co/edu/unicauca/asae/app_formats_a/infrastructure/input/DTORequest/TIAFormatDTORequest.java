package co.edu.unicauca.asae.app_formats_a.infrastructure.input.DTORequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


public class TIAFormatDTORequest extends AFormatDTORequest {
    private String student1Name;

    private String student2Name;
}
