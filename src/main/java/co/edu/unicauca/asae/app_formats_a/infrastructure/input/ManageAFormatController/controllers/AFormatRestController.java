package co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.controllers;


import co.edu.unicauca.asae.app_formats_a.application.input.ManageAFormatUCIntPort;
import co.edu.unicauca.asae.app_formats_a.domain.models.AFormat;
import co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.DTO.request.AFormatDTORequest;
import co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.DTO.response.AFormatDTOResponse;
import co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.mappers.AFormatInputMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/aformat")
@RequiredArgsConstructor
public class AFormatRestController {
    private final ManageAFormatUCIntPort objManageAFormatUCIntPort;
    private final AFormatInputMapper aFormatMapper;


    @PostMapping
    public ResponseEntity<AFormatDTOResponse> saveAFormat(@RequestBody AFormatDTORequest aFormat) {
        AFormat formatToSave = aFormatMapper.toDomain(aFormat);
        AFormat savedAFormat = objManageAFormatUCIntPort.save(formatToSave);
        AFormatDTOResponse response = aFormatMapper.toResponse(savedAFormat);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AFormatDTOResponse> getAFormatById(@PathVariable Long id) {
        AFormat aFormat = objManageAFormatUCIntPort.getById(id);
        AFormatDTOResponse response = aFormatMapper.toResponse(aFormat);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
