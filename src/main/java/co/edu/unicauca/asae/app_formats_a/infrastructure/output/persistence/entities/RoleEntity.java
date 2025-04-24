package co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities;

import java.util.List;

import co.edu.unicauca.asae.app_formats_a.commons.enums.RoleEnum;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "assigned_role", nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private RoleEnum assignedRole;

    @OneToMany(mappedBy = "objRole")
    private List<HistoricalRecordEntity> historicalRecords;
}
