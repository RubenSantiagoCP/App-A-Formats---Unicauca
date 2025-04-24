package co.edu.unicauca.asae.app_formats_a.domain.useCases;

import java.time.LocalDate;

import co.edu.unicauca.asae.app_formats_a.application.input.ManageAFormatUCIntPort;
import co.edu.unicauca.asae.app_formats_a.application.output.ManageAFormatGatewayIntPort;
import co.edu.unicauca.asae.app_formats_a.commons.enums.StateEnum;
import co.edu.unicauca.asae.app_formats_a.domain.models.AFormat;
import co.edu.unicauca.asae.app_formats_a.domain.models.State;

public class ManageAFormatUCAdapter implements ManageAFormatUCIntPort{

    private final ManageAFormatGatewayIntPort manageAFormatGateway;

    public ManageAFormatUCAdapter(ManageAFormatGatewayIntPort manageAFormatGateway) {
        this.manageAFormatGateway = manageAFormatGateway;
    }

    @Override
    public AFormat save(AFormat aFormat) {
        AFormat objCreatedAFormat = null;
        if(this.manageAFormatGateway.existsAFormatByTitle(aFormat.getTitle())){
            throw new IllegalArgumentException("El formato ya existe");
        }else{
            State state = new State(StateEnum.FORMULATED, LocalDate.now());
            aFormat.setState(state);
            objCreatedAFormat = this.manageAFormatGateway.save(aFormat);
        }
        return objCreatedAFormat;
    }
    
}
