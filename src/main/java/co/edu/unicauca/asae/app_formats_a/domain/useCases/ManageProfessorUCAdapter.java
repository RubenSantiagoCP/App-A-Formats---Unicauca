package co.edu.unicauca.asae.app_formats_a.domain.useCases;

import java.time.LocalDate;
import java.util.List;

import co.edu.unicauca.asae.app_formats_a.application.input.ManageProfessorUCIntPort;
import co.edu.unicauca.asae.app_formats_a.application.output.ManageHistoricalRecordGatewayIntPort;
import co.edu.unicauca.asae.app_formats_a.application.output.ManageProfessorGatewayIntPort;
import co.edu.unicauca.asae.app_formats_a.application.output.ResultsFormatterIntPort;
import co.edu.unicauca.asae.app_formats_a.domain.models.AFormat;
import co.edu.unicauca.asae.app_formats_a.domain.models.HistoricalRecord;
import co.edu.unicauca.asae.app_formats_a.domain.models.Professor;

public class ManageProfessorUCAdapter implements ManageProfessorUCIntPort {

    private final ManageProfessorGatewayIntPort manageProfessorGateway;
    private final ManageHistoricalRecordGatewayIntPort manageHistoricalRecordGateway;
    private final ResultsFormatterIntPort resultsFormatterIntPort;

    public ManageProfessorUCAdapter(ManageProfessorGatewayIntPort manageProfessorGateway, ManageHistoricalRecordGatewayIntPort manageHistoricalRecordGateway,
                                    ResultsFormatterIntPort resultsFormatterIntPort) {
        this.manageProfessorGateway = manageProfessorGateway;
        this. manageHistoricalRecordGateway = manageHistoricalRecordGateway;
        this.resultsFormatterIntPort = resultsFormatterIntPort;
    }

    @Override
    public List<Professor> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public List<AFormat> getAllAFormatsByProfessor(Long id) {

        boolean professorExists = this.manageProfessorGateway.existsById(id);
        if(!professorExists){
            resultsFormatterIntPort.returnResponseErrorEntityNotFound("Professor with ID "+id+" doesn't exist");
        }

        return this.manageProfessorGateway.getAllAFormatsById(id);
    }

    @Override
    public List<AFormat> getAllAFormatsByProfessorBetweenDates(Long id, LocalDate startDate, LocalDate endDate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllAFormatsByProfessorBetweenDates'");
    }

    @Override
    public List<Professor> getByGroupAndStartWithPattern(String groupName, String pattern) {
        return this.manageProfessorGateway.getByGroupAndStartWithPattern(groupName, pattern);
    }

    @Override
    public List<HistoricalRecord> getCommitteeMembers() {
        return manageHistoricalRecordGateway.getCommiteeMembers().orElseThrow();
    }

}
