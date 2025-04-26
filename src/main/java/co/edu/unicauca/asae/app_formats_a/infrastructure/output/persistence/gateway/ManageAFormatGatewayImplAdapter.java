package co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.gateway;

import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.app_formats_a.application.output.ManageAFormatGatewayIntPort;
import co.edu.unicauca.asae.app_formats_a.domain.models.AFormat;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.AFormatEntity;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.mappers.AFormatOutputMapper;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.repositories.AFormatRepositoryInt;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ManageAFormatGatewayImplAdapter implements ManageAFormatGatewayIntPort {

    private final AFormatRepositoryInt aFormatRepository;
    private final AFormatOutputMapper aFormatMapper;

    @Override
    @Transactional
    public AFormat save(AFormat aFormat) {
        AFormatEntity aFormatEntity = aFormatMapper.toEntity(aFormat);
        aFormatEntity = aFormatRepository.save(aFormatEntity);
        return aFormatMapper.toDomain(aFormatEntity);
    }

    @Override
    public boolean existsAFormatByTitle(String title) {
        return aFormatRepository.existsByTitle(title);
    }
    
}
