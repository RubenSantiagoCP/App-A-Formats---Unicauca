package co.edu.unicauca.asae.app_formats_a.application.input;

//import java.util.List;

import co.edu.unicauca.asae.app_formats_a.domain.models.AFormat;

import java.time.LocalDate;
import java.util.List;

public interface ManageAFormatUCIntPort {
    public AFormat save(AFormat aFormat);
    
    public AFormat getById(Long id);

    public List<AFormat> getAllByProffesorBetween(Long id, LocalDate startDate, LocalDate endDate);
}

