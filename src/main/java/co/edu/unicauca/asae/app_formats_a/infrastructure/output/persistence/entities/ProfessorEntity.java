package co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "proffesors")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "proffesor_name", length = 100, nullable = false)
    private String name;

    @Column(name = "proffesor_last_name", length = 100, nullable = false)
    private String lastName;

    @Column(name = "proffesor_grouo_name", length = 100, nullable = false)
    private String groupName;


    @Column(name = "proffesor_email", unique = true, length = 100, nullable = false)
    private String email;

    @OneToMany(mappedBy = "professor")
    private List<HistoricalRecordEntity> historicalRecord;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "objProfessor", cascade = {CascadeType.REMOVE})
    private List<AFormatEntity> aFormats;
}
