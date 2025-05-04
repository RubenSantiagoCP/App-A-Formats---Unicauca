package co.edu.unicauca.asae.app_formats_a.application.output;

import co.edu.unicauca.asae.app_formats_a.domain.models.AFormat;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ManageAFormatGatewayIntPort {
    
    public AFormat save(AFormat aFormat);

    public boolean existsAFormatByTitle(String title);

    public AFormat findById(Long id);

    boolean existsById(Long id);

    Optional<List<AFormat>> findAllByProffesorBetween(Long id, LocalDate startDate, LocalDate endDate);
}


