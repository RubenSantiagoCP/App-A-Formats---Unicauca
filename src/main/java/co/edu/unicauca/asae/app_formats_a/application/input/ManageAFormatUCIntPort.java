package co.edu.unicauca.asae.app_formats_a.application.input;

//import java.util.List;

import co.edu.unicauca.asae.app_formats_a.domain.models.AFormat;

public interface ManageAFormatUCIntPort {
    public AFormat save(AFormat aFormat);
    
    public AFormat getById(Long id);
}

