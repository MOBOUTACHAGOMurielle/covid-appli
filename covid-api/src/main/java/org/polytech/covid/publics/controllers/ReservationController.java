package org.polytech.covid.publics.controllers;

import org.polytech.covid.publics.Entity.*;
import org.polytech.covid.publics.services.CentreService;
import org.polytech.covid.publics.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RestControllerAdvice
@RequestMapping("reservations")
public class ReservationController {

    public ReservationService reservationService;
    public CentreService centreService;


    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("list")
    public List<Reservation> getReservations() {return reservationService.getReservations();}

    @GetMapping("list/{creneau}")
    public Reservation getResevation(@PathVariable("creneau") Date creneau){ return reservationService.getReservationByCreneau(creneau);}

    @PostMapping(path = "save")
    public ResponseEntity<Reservation> addNewReservation(@RequestParam("creneau") Date creneau,
                                               @RequestParam("status") Boolean status,
                                               @RequestParam("centre") Centre centre,
                                               @RequestParam("patient") UserPatient _patient) throws Exception {

    if (centre == null) {
        throw new Exception("The center doesn't exist");
    } else {
        Reservation newReservation = reservationService.addnewReservation(creneau, status, centre,_patient);
        return new ResponseEntity<>(newReservation, OK);
      }

    }
}
