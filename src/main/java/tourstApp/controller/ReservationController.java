package tourstApp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
import tourstApp.dto.ExcursionDTO;
import tourstApp.dto.ReservationDTO;
import tourstApp.model.Arrangement;
import tourstApp.model.Excursion;
import tourstApp.model.Reservation;
import tourstApp.service.ArrangementService;
import tourstApp.service.ReservationService;

@Tag(name = "Excursion controller", description = "Excursion API")
@RestController
@RequestMapping(value = "api/reservations")
public class ReservationController {
    
    @Autowired
    private ArrangementService arrangementService;

    @Autowired
    private ReservationService reservationService;


    @Operation(summary = "Create new reservation", description = "Creates new reservation", method = "POST")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Created",
					     content = { @Content(mediaType = "application/json", schema = @Schema(implementation =Reservation.class)) })
	})
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ReservationDTO> createReservation(@RequestBody ReservationDTO reservationDTO) {
        Reservation reservation = new Reservation();

        // Set the number of people and total price from the DTO
        reservation.setNumberOfPeople(reservationDTO.getNumberOfPeople());
        reservation.setTotalPrice(reservationDTO.getTotalPrice());

        Reservation savedReservation = reservationService.save(reservation);

        ReservationDTO savedReservationDTO = new ReservationDTO(savedReservation);
        return new ResponseEntity<>(savedReservationDTO, HttpStatus.CREATED);
    }
}