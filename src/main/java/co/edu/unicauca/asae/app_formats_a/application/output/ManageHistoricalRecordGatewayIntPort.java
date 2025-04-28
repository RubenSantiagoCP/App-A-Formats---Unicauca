package co.edu.unicauca.asae.app_formats_a.application.output;

import co.edu.unicauca.asae.app_formats_a.domain.models.HistoricalRecord;
import co.edu.unicauca.asae.app_formats_a.domain.models.Professor;

import java.util.List;
import java.util.Optional;

public interface ManageHistoricalRecordGatewayIntPort {
    public Optional<List<HistoricalRecord>> getCommiteeMembers();
}
