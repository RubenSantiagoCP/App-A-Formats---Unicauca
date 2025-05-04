package co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.controllers;

import co.edu.unicauca.asae.app_formats_a.domain.models.HistoricalRecord;
import co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.DTO.response.HistoricalRecordDTOResponse;
import co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.mappers.HistoricalRecordInputMapper;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import co.edu.unicauca.asae.app_formats_a.application.input.ManageProfessorUCIntPort;
import co.edu.unicauca.asae.app_formats_a.domain.models.Professor;
import co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.DTO.response.ProfessorDTOResponse;
import co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.mappers.ProfessorInputMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/professor")
@RequiredArgsConstructor
public class ProfessorRestController {
    
    private final ManageProfessorUCIntPort manageProfessorUCAdapter;
    private final ProfessorInputMapper professorInputMapper;
    private final HistoricalRecordInputMapper historicalRecordInputMapper;
    private final AFormatInputMapper aFormatInputMapper;


    @GetMapping("/get")
    public ResponseEntity<List<ProfessorDTOResponse>> getByGroupAndStartWithPattern(@RequestParam("groupName") String groupName, @RequestParam("pattern") String pattern) {
        List<Professor> professors = this.manageProfessorUCAdapter.getByGroupAndStartWithPattern(groupName, pattern);
        return ResponseEntity.ok(professorInputMapper.toResponseList(professors));
    }


    @GetMapping("/committee-members")
    public ResponseEntity<List<ProfessorDTOResponse>> getComiteeMembers(){
        List<Professor> professors = this.manageProfessorUCAdapter.getCommitteeMembers();
        return ResponseEntity.ok(professorInputMapper.toResponseListWithHistoricalRecords(professors));
    }

    @GetMapping("/aformats/{id}")
    public ResponseEntity<List<AFormatDTOResponse>> getAFormatsByIdProfessor(@PathVariable Long id){
        List<AFormat> aFormats = this.manageProfessorUCAdapter.getAllAFormatsByProfessor(id);
        return  ResponseEntity.ok(this.aFormatInputMapper.lstAFormatsToResponse(aFormats));
    }


}
