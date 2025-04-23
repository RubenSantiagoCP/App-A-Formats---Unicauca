package co.edu.unicauca.asae.app_formats_a.infraestructura.output.persistencia.entidades;

import co.edu.unicauca.asae.app_formats_a.commons.enums.RoleEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "assigned_role", nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private RoleEnum assignedRole;

    @OneToMany(mappedBy = "objRole")
    private List<HistoricalRecord> historicalRecords;
}
