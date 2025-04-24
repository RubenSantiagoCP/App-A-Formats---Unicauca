package co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities;

import java.util.List;

import co.edu.unicauca.asae.app_formats_a.commons.enums.StateEnum;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "a_formats")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString(exclude = { "generalObjective", "specificObjective", "objProfessor", "state", "evaluations" })
public class AFormatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long formatAId;

    @Column(name = "general_objective", nullable = false)
    private String generalObjective;

    @Column(name = "title", nullable = false, unique = true, length = 200)
    private String title;

    @Column(name = "specific_objective", nullable = false)
    private List<String> specificObjective;

    @ManyToOne(cascade = { CascadeType.PERSIST })
    @JoinColumn(name = "professorId", nullable = false)
    private ProfessorEntity objProfessor;

    @OneToOne(mappedBy = "objAformat", cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
    private StateEnum state;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "objAFormat", cascade = { CascadeType.REMOVE, CascadeType.PERSIST })
    private List<EvaluationEntity> evaluations;

}
