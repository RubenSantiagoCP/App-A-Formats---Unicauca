package co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.app_formats_a.domain.models.Professor;
import co.edu.unicauca.asae.app_formats_a.domain.useCases.ManageProfessorUCAdapter;
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
    
    private final ManageProfessorUCAdapter manageProfessorUCAdapter;
    private final ProfessorInputMapper professorInputMapper;

    @GetMapping("/get")
    public ResponseEntity<List<ProfessorDTOResponse>> getByGroupAndStartWithPattern(@RequestParam("groupName") String groupName, @RequestParam("pattern") String pattern) {
        List<Professor> professors = this.manageProfessorUCAdapter.getByGroupAndStartWithPattern(groupName, pattern);
        return ResponseEntity.ok(professorInputMapper.toResponseList(professors));
    }

    
}
