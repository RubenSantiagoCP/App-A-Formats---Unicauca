package co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.app_formats_a.application.input.ManageObservationUCIntPort;
import co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.DTO.request.ObservationDTORequest;
import co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.DTO.response.ObservationDTOCreateResponse;
import co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.mappers.ObservationInputMapper;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/observation")
@RequiredArgsConstructor
@Validated
public class ObservationRestController {
    
    private final ManageObservationUCIntPort manageObservationUCIntPort;
    private final ObservationInputMapper observationInputMapper;

    @PostMapping
    public ResponseEntity<ObservationDTOCreateResponse> save(@Valid  @RequestBody ObservationDTORequest observationDTORequest, @RequestParam("formatId") Long formatId) {
        ObservationDTOCreateResponse observationDTOCreateResponse = observationInputMapper.toResponse(this.manageObservationUCIntPort.save(observationInputMapper.toDomain(observationDTORequest), formatId));
        return new ResponseEntity<>(observationDTOCreateResponse, HttpStatus.CREATED);
    }
}
