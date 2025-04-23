package co.edu.unicauca.asae.app_formats_a.infraestructura.output.persistencia.repositorios;

import co.edu.unicauca.asae.app_formats_a.infraestructura.output.persistencia.entidades.HistoricalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricalRecordRepository extends JpaRepository<HistoricalRecord, Long> {
    
}
