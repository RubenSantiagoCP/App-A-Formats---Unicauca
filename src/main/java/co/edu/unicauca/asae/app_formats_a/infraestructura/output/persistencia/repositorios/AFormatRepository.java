package co.edu.unicauca.asae.app_formats_a.infraestructura.output.persistencia.repositorios;

import co.edu.unicauca.asae.app_formats_a.infraestructura.output.persistencia.entidades.AFormat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AFormatRepository extends JpaRepository<AFormat, Long> {
    List<AFormat> findAllByObjProfessor_Id(Long id);
}
