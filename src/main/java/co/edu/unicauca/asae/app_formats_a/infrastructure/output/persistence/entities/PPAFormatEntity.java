package co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "ppa_formats")
@PrimaryKeyJoinColumn(name = "idPPAFormat")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class PPAFormatEntity extends AFormatEntity {
    
    @Column(name = "assesor_name", nullable = false)
    private String assesorName;

    @Column(name="acceptance_letter_route", nullable = false)
    private String acceptanceLetterRoute;
}
