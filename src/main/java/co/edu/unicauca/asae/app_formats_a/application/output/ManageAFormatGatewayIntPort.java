package co.edu.unicauca.asae.app_formats_a.application.output;

import co.edu.unicauca.asae.app_formats_a.domain.models.AFormat;

public interface ManageAFormatGatewayIntPort {
    
    public AFormat save(AFormat aFormat);

    public boolean existsAFormatByTitle(String title);
}


