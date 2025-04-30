package co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.gateway;

import co.edu.unicauca.asae.app_formats_a.application.output.ManageHistoricalRecordGatewayIntPort;
import co.edu.unicauca.asae.app_formats_a.commons.enums.RoleEnum;
import co.edu.unicauca.asae.app_formats_a.domain.models.HistoricalRecord;
import co.edu.unicauca.asae.app_formats_a.domain.models.Professor;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.HistoricalRecordEntity;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.mappers.HistoricalRecordOutputMapper;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.mappers.ProfessorOutputMapper;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.repositories.HistoricalRecordRepositoryInt;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ManageHistoricalRecordGatewayIntPortImpl implements ManageHistoricalRecordGatewayIntPort {
    private final HistoricalRecordRepositoryInt historicalRecordRepository;
    private final HistoricalRecordOutputMapper historicalRecordOutputMapper;
    private final ProfessorOutputMapper professorOutputMapper;

    @Override
    public Optional<List<HistoricalRecord>> getCommiteeMembers() {

        Optional<List<HistoricalRecordEntity>> dbHistoricalRecords =
                historicalRecordRepository.findByObjRole_AssignedRole(RoleEnum.COMMITTEE_MEMBER);


        return dbHistoricalRecords.flatMap(entities -> Optional.of(historicalRecordOutputMapper.toDomainList(entities)));

    }
}
