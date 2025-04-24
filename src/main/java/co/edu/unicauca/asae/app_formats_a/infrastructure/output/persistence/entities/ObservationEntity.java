package co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="observations")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"objEvaluation", "proffesors"})

public class ObservationEntity {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long observationId;

    @Column(name = "observation", nullable = false)
    private String observation;

    @Column(name = "observation_date_register", nullable = false)
    private LocalDate observationDateRegister;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "proffesor_observation",
            joinColumns = @JoinColumn(name = "observation_id"),
            inverseJoinColumns = @JoinColumn(name = "proffesor_id"))
    private List<ProfessorEntity> proffesors;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "evaluationId",nullable = false)
    private EvaluationEntity objEvaluation;
}
