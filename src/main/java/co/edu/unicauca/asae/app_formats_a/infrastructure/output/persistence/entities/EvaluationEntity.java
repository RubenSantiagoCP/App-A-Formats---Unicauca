package co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities;

import co.edu.unicauca.asae.app_formats_a.commons.enums.ConceptEnum;

import co.edu.unicauca.asae.app_formats_a.domain.models.AFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "evaluations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EvaluationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long evaluationId;

    @Column(name = "concept", nullable = false)
    @Enumerated(EnumType.STRING)
    private ConceptEnum concept;

    @Column(name = "date_register_concept", nullable = false)
    private LocalDate dateRegisterConcept;

    @Column(name = "coordinator_name", length = 100, nullable = false)
    private String coordinatorName;

    @ManyToOne
    @JoinColumn(name = "formatAId", nullable = false)
    private AFormat objAFormat;

    @OneToMany(mappedBy = "objEvaluation")
    private List<ObservationEntity> observations;

}
