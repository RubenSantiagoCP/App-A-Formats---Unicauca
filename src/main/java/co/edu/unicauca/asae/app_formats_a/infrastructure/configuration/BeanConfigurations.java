package co.edu.unicauca.asae.app_formats_a.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.asae.app_formats_a.application.output.ManageAFormatGatewayIntPort;
import co.edu.unicauca.asae.app_formats_a.domain.useCases.ManageAFormatUCAdapter;

@Configuration
public class BeanConfigurations {

    @Bean
    public ManageAFormatUCAdapter createManageAFormatUCAdapter(ManageAFormatGatewayIntPort objAFormatGatewayIntPort) {
        ManageAFormatUCAdapter objManageAFormatUCAdapter = new ManageAFormatUCAdapter(objAFormatGatewayIntPort);
        return objManageAFormatUCAdapter;
    }

}