package co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities;

import java.util.List;

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
    private Long id;

    @Column(name = "general_objective", nullable = false)
    private String generalObjective;

    @Column(name = "title", nullable = false, length = 200)
    private String title;

    @Column(name = "specific_objective", nullable = false)
    private List<String> specificObjective;

    @ManyToOne(cascade = { CascadeType.PERSIST })
    @JoinColumn(name = "professorId", referencedColumnName = "id")
    private ProfessorEntity objProfessor;

    @OneToOne(mappedBy = "objAformat", cascade = { CascadeType.ALL})
    private StateEntity state;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "objAFormat", cascade = { CascadeType.REMOVE, CascadeType.PERSIST })
    private List<EvaluationEntity> evaluations;

}
