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
@Table(name = "tia_formats")
@PrimaryKeyJoinColumn(name = "idTIAFormat")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class TIAFormatEntity extends AFormatEntity {
    @Column(name = "student2_name")
    private String student2Name;

    @Column(name = "student2_code")
    private String student2code;
}
