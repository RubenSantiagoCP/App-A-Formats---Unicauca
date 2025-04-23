package co.edu.unicauca.asae.app_formats_a.infraestructura.output.persistencia.entidades;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "proffesors")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Professor {
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
    private List<HistoricalRecord> historicalRecord;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "objProfessor", cascade = {CascadeType.REMOVE})
    private List<AFormat> aFormats;

}
