package co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.repositories;

import co.edu.unicauca.asae.app_formats_a.commons.enums.RoleEnum;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.HistoricalRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HistoricalRecordRepositoryInt extends JpaRepository<HistoricalRecordEntity, Long> {
    Optional<List<HistoricalRecordEntity>> findByObjRole_AssignedRole(RoleEnum objRoleAssignedRole);
}
