package co.edu.unicauca.asae.app_formats_a.infrastructure.configuration;

import co.edu.unicauca.asae.app_formats_a.application.output.ManageProfessorGatewayIntPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.asae.app_formats_a.application.output.ManageAFormatGatewayIntPort;
import co.edu.unicauca.asae.app_formats_a.application.output.ManageEvaluationGatewayIntPort;
import co.edu.unicauca.asae.app_formats_a.application.output.ManageObservationGatewayIntPort;
import co.edu.unicauca.asae.app_formats_a.domain.useCases.ManageAFormatUCAdapter;
import co.edu.unicauca.asae.app_formats_a.domain.useCases.ManageObservationUCAdapter;
import co.edu.unicauca.asae.app_formats_a.domain.useCases.ManageProfessorUCAdapter;

@Configuration
public class BeanConfigurations {

    @Bean
    public ManageAFormatUCAdapter createManageAFormatUCAdapter(ManageAFormatGatewayIntPort objAFormatGatewayIntPort,
            ManageProfessorGatewayIntPort objManageProfessorGatewayIntPort) {
        ManageAFormatUCAdapter objManageAFormatUCAdapter = new ManageAFormatUCAdapter(objAFormatGatewayIntPort,
                objManageProfessorGatewayIntPort);
        return objManageAFormatUCAdapter;
    }

    @Bean
    public ManageProfessorUCAdapter createManageProfessorUCAdapter(
            ManageProfessorGatewayIntPort objManageProfessorGatewayIntPort) {
        ManageProfessorUCAdapter objManageProfessorUCAdapter = new ManageProfessorUCAdapter(
                objManageProfessorGatewayIntPort);
        return objManageProfessorUCAdapter;
    }

    @Bean
    public ManageObservationUCAdapter createManageObservationUCAdapter(
            ManageObservationGatewayIntPort objManageObservationGatewayIntPort,
            ManageProfessorGatewayIntPort objManageProfessorGatewayIntPort,
            ManageEvaluationGatewayIntPort objEvaluationGatewayIntPort,
            ManageAFormatGatewayIntPort objManageAFormatGatewayIntPort) {
        ManageObservationUCAdapter objManageObservationUCAdapter = new ManageObservationUCAdapter(
                objManageObservationGatewayIntPort, objManageProfessorGatewayIntPort, objEvaluationGatewayIntPort,
                objManageAFormatGatewayIntPort);
        return objManageObservationUCAdapter;
    }

}