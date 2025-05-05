package co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.controllers;


import co.edu.unicauca.asae.app_formats_a.application.input.ManageAFormatUCIntPort;
import co.edu.unicauca.asae.app_formats_a.commons.utils.PrintUtils;
import co.edu.unicauca.asae.app_formats_a.domain.models.AFormat;
import co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.DTO.request.AFormatDTORequest;
import co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.DTO.response.AFormatDTOResponse;
import co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.mappers.AFormatInputMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/aformat")
@RequiredArgsConstructor
@Validated
public class AFormatRestController {
    private final ManageAFormatUCIntPort objManageAFormatUCIntPort;
    private final AFormatInputMapper aFormatMapper;


    @PostMapping
    public ResponseEntity<AFormatDTOResponse> saveAFormat(@Valid @RequestBody AFormatDTORequest aFormat) {
        PrintUtils.writeHeader("Save A Format Method");
        AFormat formatToSave = aFormatMapper.toDomain(aFormat);
        AFormat savedAFormat = objManageAFormatUCIntPort.save(formatToSave);
        AFormatDTOResponse response = aFormatMapper.toResponse(savedAFormat);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AFormatDTOResponse> getAFormatById(@PathVariable Long id) {
        PrintUtils.writeHeader("Get A Format by Id Method");
        AFormat aFormat = objManageAFormatUCIntPort.getById(id);
        AFormatDTOResponse response = aFormatMapper.toResponse(aFormat);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }




    @GetMapping
    public ResponseEntity<List<AFormatDTOResponse>> getFormatsByProfessorAndDateRange(
            @RequestParam("professorId") Long professorId,
            @RequestParam("startDate") LocalDate startDate,
            @RequestParam("endDate") LocalDate endDate) {
        PrintUtils.writeHeader("get Formats By Professor And date Range Method");
        List<AFormat> formats = objManageAFormatUCIntPort.getAllByProffesorBetween(professorId, startDate, endDate);
        List<AFormatDTOResponse> response = formats.stream()
                .map(aFormatMapper::toResponse)
                .toList();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
