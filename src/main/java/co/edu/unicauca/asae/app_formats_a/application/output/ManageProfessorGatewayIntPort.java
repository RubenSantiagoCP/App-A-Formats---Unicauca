package co.edu.unicauca.asae.app_formats_a.application.output;

import co.edu.unicauca.asae.app_formats_a.domain.models.Professor;

import java.util.Optional;

public interface ManageProfessorGatewayIntPort {

    public Optional<Professor> existsProfessorByEmail(String email);
}
