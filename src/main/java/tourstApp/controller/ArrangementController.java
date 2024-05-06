package tourstApp.controller;

import java.util.ArrayList;
import java.util.List;

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
import tourstApp.service.ArrangementAuthService;
import tourstApp.service.ArrangementService;
import tourstApp.service.RatingService;

@Tag(name = "Arrangement controller", description = "Arrangement API")
@RestController
@RequestMapping(value = "api/arrangements")
public class ArrangementController {
    
    @Autowired
    private ArrangementService arrangementService;

    @Autowired
    private ArrangementAuthService arrangementAuthService;

    @Autowired
    private RatingService ratingService;

    @Operation(summary = "Get all arrangements", description = "Gets all arrangements.", method = "GET")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "All arrangements fetched successfully.",
                     content = @Content(mediaType = "application/json",
                     array = @ArraySchema(schema = @Schema(implementation = Arrangement.class))))
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ArrangementDTO>> getAll() {
        List<Arrangement> arrangements = arrangementService.findAll();


        List<ArrangementDTO> arrangementDTOs = new ArrayList<>();
        for(Arrangement a : arrangements){
            a.setExcursions(arrangementService.getExcursionsByArrangementId(a.getId()));
            a.setRatings(arrangementService.getRatingsByArrangementId(a.getId()));
            arrangementDTOs.add(new ArrangementDTO(a));
        }

        return new ResponseEntity<>(arrangementDTOs, HttpStatus.OK);
    }


    @Operation(summary = "Get arrangement by id", description = "Gets arrangement by id", method = "GET")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Arrangement fetched successfully.",
        content = @Content(mediaType = "application/json",
        schema = @Schema(implementation = Arrangement.class))),
        @ApiResponse(responseCode = "404", description = "Arrangement not found.", content = @Content)
    })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrangementDTO> getArrangementById(@PathVariable Integer id) {
        Arrangement arrangement = arrangementService.findById(id);
                 
        if (arrangement == null) {
            return null;
        }

        List<Excursion> excursions = arrangementService.getExcursionsByArrangementId(arrangement.getId());
        List<Rating> ratings = arrangementService.getRatingsByArrangementId(arrangement.getId());


        arrangement.setExcursions(excursions);
        arrangement.setRatings(ratings);


        return new ResponseEntity<>(new ArrangementDTO(arrangement), HttpStatus.OK);
    }

    @Operation(summary = "Create new arrangement", description = "Creates new arrangement", method = "POST")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Created",
					     content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Arrangement.class)) })
	})
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrangementDTO> saveArrangement(@RequestBody ArrangementDTO arrangementDTO) {
        Arrangement arrangement = new Arrangement();


        arrangement.setName(arrangementDTO.getName());
        arrangement.setType(arrangementDTO.getType());
        arrangement.setPrice(arrangementDTO.getPrice());
        arrangement.setAverageRating(arrangementDTO.getAverageRating());
        arrangement.setDate(arrangementDTO.getDate());

        List<ExcursionDTO> excursionDTOs = arrangementDTO.getExcursions();
        List<RatingDTO > ratingDTOs = arrangementDTO.getRatings();


        if(excursionDTOs != null){
            List<Excursion> excursions = new ArrayList<>();

            for(ExcursionDTO excursionDTO : excursionDTOs){
                Excursion excursion = new Excursion();

                excursion.setName(excursionDTO.getName());
                excursion.setPrice(excursionDTO.getPrice());
                excursion.setType(excursionDTO.getType());

                excursion.setArrangement(arrangement);
                
                excursions.add(excursion);
            }
            arrangement.setExcursions(excursions);
        }


        if(ratingDTOs != null){
            List<Rating> ratings = new ArrayList<>();

            for(RatingDTO ratingDTO : ratingDTOs){
                Rating rating = new Rating();

                rating.setRatingValue(ratingDTO.getRatingValue());
                rating.setArrangement(arrangement);

                ratings.add(rating);
            }
            arrangement.setRatings(ratings);
        }

        arrangement = arrangementService.save(arrangement);


        return new ResponseEntity<>(new ArrangementDTO(arrangement), HttpStatus.CREATED);
    }


    @Operation(summary = "Update arrangement info", description = "Update arrangement info", method = "PUT")
	@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK",
                     content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Arrangement.class)) }),
        @ApiResponse(responseCode = "404", description = "Company not found.", content = @Content)
	})
	@PutMapping(value = "update/{id}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrangementDTO> updateArrangementInfo(@PathVariable Integer id, @RequestBody ArrangementDTO arrangementDTO) {
        Arrangement arrangement = arrangementService.findById(id);

        if (arrangement == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        arrangement.setName(arrangementDTO.getName());
        arrangement.setType(arrangementDTO.getType());
        arrangement.setPrice(arrangementDTO.getPrice());
        arrangement.setAverageRating(arrangementDTO.getAverageRating());
        arrangement.setDate(arrangementDTO.getDate());
        

        arrangement = arrangementService.save(arrangement);

        return new ResponseEntity<>(new ArrangementDTO(arrangement), HttpStatus.OK);
    }



    @Operation(summary = "Update arrangement ratings", description = "Update arrangement ratings", method = "PUT")
	@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK",
                     content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Arrangement.class)) }),
        @ApiResponse(responseCode = "404", description = "Company not found.", content = @Content)
	})
	@PutMapping(value = "ratings/{id}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrangementDTO> updateArrangementRatings(@PathVariable Integer id, @RequestBody ArrangementDTO arrangementDTO) {
        Arrangement arrangement = arrangementService.findByIdWithRatings(id);

        if (arrangement == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        arrangement.setName(arrangementDTO.getName());
        arrangement.setType(arrangementDTO.getType());
        arrangement.setPrice(arrangementDTO.getPrice());
        arrangement.setAverageRating(arrangementDTO.getAverageRating());
        arrangement.setDate(arrangementDTO.getDate());
        
        List<RatingDTO> ratingDTOs = arrangementDTO.getRatings();
        arrangement.getRatings().clear();
        for(RatingDTO ratingDTO : ratingDTOs){
            Rating rating = new Rating();
            rating.setRatingValue(ratingDTO.getRatingValue());
            rating.setArrangement(arrangement);
            ratingService.save(rating);
            arrangement.getRatings().add(rating);
        }

        arrangement = arrangementService.save(arrangement);

        return new ResponseEntity<>(new ArrangementDTO(arrangement), HttpStatus.OK);
    }
}
