package co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities;

import java.time.LocalDate;

import co.edu.unicauca.asae.app_formats_a.commons.enums.StateEnum;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "states")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StateEntity {
    @Id
    private Long id;

    @Column(name = "actual_state", nullable = false)
    @Enumerated(EnumType.STRING)
    private StateEnum actualState;

    @Column(name = "register_state_date", nullable = false)
    private LocalDate registerStateDate;

    @OneToOne(cascade = CascadeType.MERGE)
    @MapsId
    @JoinColumn(name = "formatAId", unique = true)
    private AFormatEntity objAformat;
}
