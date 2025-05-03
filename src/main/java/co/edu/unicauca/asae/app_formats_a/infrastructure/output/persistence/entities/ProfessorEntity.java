package co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "professors")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "professor_name", length = 100, nullable = false)
    private String name;

    @Column(name = "professor_last_name", length = 100, nullable = false)
    private String lastName;

    @Column(name = "professor_group_name", length = 100, nullable = false)
    private String groupName;


    @Column(name = "professor_email", unique = true, length = 100, nullable = false)
    private String email;

    @OneToMany(mappedBy = "professor", fetch = FetchType.LAZY)
    private List<HistoricalRecordEntity> historicalRecord;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "objProfessor")
    private List<AFormatEntity> aFormats;
}
