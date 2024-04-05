package tourstApp.controller;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import tourstApp.dto.ArrangementDTO;
import tourstApp.dto.ExcursionDTO;
import tourstApp.dto.RatingDTO;
import tourstApp.model.Arrangement;
import tourstApp.model.Excursion;
import tourstApp.model.Rating;
import tourstApp.service.ArrangementService;
import tourstApp.service.ExcursionService;

@Tag(name = "Excursion controller", description = "Excursion API")
@RestController
@RequestMapping(value = "api/excursions")
public class ExcursionController {


    @Autowired
    private ExcursionService excursionService;

    @Operation(summary = "Get all excursions", description = "Gets all excursions.", method = "GET")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "All excursions fetched successfully.",
                     content = @Content(mediaType = "application/json",
                     array = @ArraySchema(schema = @Schema(implementation = Excursion.class))))
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ExcursionDTO>> getAll() {
        List<Excursion> excursions = excursionService.findAll();

        List<ExcursionDTO> excursionDTOs = new ArrayList<>();

        for(Excursion e : excursions){
            excursionDTOs.add(new ExcursionDTO(e));
        }

        return new ResponseEntity<>(excursionDTOs, HttpStatus.OK);
    }


    @Operation(summary = "Get excursion by id", description = "Gets excursion by id", method = "GET")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Excursion fetched successfully.",
        content = @Content(mediaType = "application/json",
        schema = @Schema(implementation = Excursion.class))),
        @ApiResponse(responseCode = "404", description = "Excursion not found.", content = @Content)
    })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ExcursionDTO> getExcursionById(@PathVariable Integer id) {
        Excursion excursion = excursionService.findById(id);
                 
        if (excursion == null) {
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<>(new ExcursionDTO(excursion), HttpStatus.FOUND);
    }

    @Operation(summary = "Create new excursion", description = "Creates new excursion", method = "POST")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Created",
					     content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Arrangement.class)) })
	})
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ExcursionDTO> saveExcursion(@RequestBody ExcursionDTO excursionDTO) {

        Excursion excursion = new Excursion();

        excursion.setName(excursionDTO.getName());
        excursion.setPrice(excursionDTO.getPrice());
        excursion.setNumberOfPeopleRegistered(excursionDTO.getNumberOfPeopleRegistered());
        excursion.setType(excursionDTO.getType());
        excursion.setTotalPrice(excursionDTO.getTotalPrice());
        
        excursion = excursionService.save(excursion);


        return new ResponseEntity<>(new ExcursionDTO(excursion), HttpStatus.FOUND);
    }


    @Operation(summary = "Update excursion info", description = "Update excursion info", method = "PUT")
	@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK",
                     content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Arrangement.class)) }),
        @ApiResponse(responseCode = "404", description = "Excursion not found.", content = @Content)
	})
	@PutMapping(value = "update/{id}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ExcursionDTO> updateExcursionInfo(@PathVariable Integer id, @RequestBody ExcursionDTO excursionDTO) {
        
        Excursion excursion = excursionService.findById(id);


        if (excursion == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


        excursion.setName(excursionDTO.getName());
        excursion.setPrice(excursionDTO.getPrice());
        excursion.setNumberOfPeopleRegistered(excursionDTO.getNumberOfPeopleRegistered());
        excursion.setType(excursionDTO.getType());
        excursion.setTotalPrice(excursionDTO.getTotalPrice());
        
        excursion = excursionService.save(excursion);

        return new ResponseEntity<>(new ExcursionDTO(excursion), HttpStatus.OK);
    }


}
