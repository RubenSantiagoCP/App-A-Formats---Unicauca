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


public class PPAFormatDTORequest extends AFormatDTORequest {
    
    private String assesorName;

    private String studedt1Name;

    private String acceptanceLetterRoute;
}
