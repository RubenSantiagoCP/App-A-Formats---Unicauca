package co.edu.unicauca.asae.app_formats_a.infrastructure.configuration;

import co.edu.unicauca.asae.app_formats_a.application.output.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.asae.app_formats_a.domain.useCases.ManageAFormatUCAdapter;
import co.edu.unicauca.asae.app_formats_a.domain.useCases.ManageObservationUCAdapter;
import co.edu.unicauca.asae.app_formats_a.domain.useCases.ManageProfessorUCAdapter;

@Configuration
public class BeanConfigurations {

    @Bean
    public ManageAFormatUCAdapter createManageAFormatUCAdapter(ManageAFormatGatewayIntPort objAFormatGatewayIntPort,
            ManageProfessorGatewayIntPort objManageProfessorGatewayIntPort, ResultsFormatterIntPort resultsFormatterIntPort) {
        ManageAFormatUCAdapter objManageAFormatUCAdapter = new ManageAFormatUCAdapter(objAFormatGatewayIntPort,
                objManageProfessorGatewayIntPort, resultsFormatterIntPort);
        return objManageAFormatUCAdapter;
    }

    @Bean
    public ManageProfessorUCAdapter createManageProfessorUCAdapter(ManageProfessorGatewayIntPort objManageProfessorGatewayIntPort,
                                                                   ResultsFormatterIntPort resultsFormatterIntPort) {
        ManageProfessorUCAdapter objManageProfessorUCAdapter = new ManageProfessorUCAdapter(
                objManageProfessorGatewayIntPort, resultsFormatterIntPort);
        return objManageProfessorUCAdapter;
    }

    @Bean
    public ManageObservationUCAdapter createManageObservationUCAdapter(
            ManageObservationGatewayIntPort objManageObservationGatewayIntPort,
            ManageProfessorGatewayIntPort objManageProfessorGatewayIntPort,
            ManageEvaluationGatewayIntPort objEvaluationGatewayIntPort,
            ManageAFormatGatewayIntPort objManageAFormatGatewayIntPort,
            ResultsFormatterIntPort resultsFormatterIntPort) {
        ManageObservationUCAdapter objManageObservationUCAdapter = new ManageObservationUCAdapter(
                objManageObservationGatewayIntPort, objManageProfessorGatewayIntPort, objEvaluationGatewayIntPort,
                objManageAFormatGatewayIntPort, resultsFormatterIntPort);
        return objManageObservationUCAdapter;
    }

}