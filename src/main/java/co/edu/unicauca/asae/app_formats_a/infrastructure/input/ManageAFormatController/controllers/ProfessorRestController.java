package co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.controllers;

import co.edu.unicauca.asae.app_formats_a.commons.utils.PrintUtils;
import co.edu.unicauca.asae.app_formats_a.domain.models.AFormat;
import co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.DTO.response.AFormatDTOResponse;
import co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.mappers.AFormatInputMapper;
import co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.mappers.CycleAvoidingMappingContext;
import co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.mappers.HistoricalRecordInputMapper;
import jakarta.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;
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
@Validated
public class ProfessorRestController {
    
    private final ManageProfessorUCIntPort manageProfessorUCAdapter;
    private final ProfessorInputMapper professorInputMapper;
    private final HistoricalRecordInputMapper historicalRecordInputMapper;
    private final AFormatInputMapper aFormatInputMapper;


    @GetMapping
    public ResponseEntity<List<ProfessorDTOResponse>> getByGroupAndStartWithPattern(@RequestParam("groupName") String groupName, @RequestParam("pattern") String pattern) {
        PrintUtils.writeHeader("Get Professor by Group And Start With Pattern Method");
        List<Professor> professors = this.manageProfessorUCAdapter.getByGroupAndStartWithPattern(groupName, pattern);
        return ResponseEntity.ok(professorInputMapper.toResponseList(professors));
    }


    @GetMapping("/committee-members")
    public ResponseEntity<List<ProfessorDTOResponse>> getComiteeMembers(){
        PrintUtils.writeHeader("Get Committee Members Method");
        List<Professor> professors = this.manageProfessorUCAdapter.getCommitteeMembers();
        return ResponseEntity.ok(professorInputMapper.toResponseListWithHistoricalRecords(professors, new CycleAvoidingMappingContext()));
    }

    @GetMapping("/aformats/{id}")
    public ResponseEntity<List<AFormatDTOResponse>> getAFormatsByIdProfessor(@PathVariable @Min(value= 1, message = "{professor.getAFormats.IdValidation}") Long id){
        PrintUtils.writeHeader("get Formats By Professor Id Method");
        List<AFormat> aFormats = this.manageProfessorUCAdapter.getAllAFormatsByProfessor(id);
        return  ResponseEntity.ok(this.aFormatInputMapper.lstAFormatsToResponse(aFormats));
    }


}
