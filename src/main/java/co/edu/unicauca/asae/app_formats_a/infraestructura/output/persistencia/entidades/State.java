package co.edu.unicauca.asae.app_formats_a.infraestructura.output.persistencia.entidades;

import co.edu.unicauca.asae.app_formats_a.commons.enums.StateEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "states")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stateId;

    @Column(name = "actual_state", nullable = false)
    @Enumerated(EnumType.STRING)
    private StateEnum actualState;

    @Column(name = "register_state_date", nullable = false)
    private LocalDate registerStateDate;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "formatAId", unique = true)
    private AFormat objAformat;
}
