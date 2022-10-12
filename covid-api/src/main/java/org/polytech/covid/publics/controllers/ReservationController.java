package org.polytech.covid.publics.controllers;

import org.polytech.covid.publics.Entity.Centre;
import org.polytech.covid.publics.Entity.Reservation;
import org.polytech.covid.publics.Entity.Utilisateur;
import org.polytech.covid.publics.services.CentreService;
import org.polytech.covid.publics.services.ReservationService;
import org.polytech.covid.publics.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RestControllerAdvice
@RequestMapping("reservations")
public class ReservationController {

    public ReservationService reservationService;
    public CentreService centreService;
    public UtilisateurService utilisateurService;


@Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }


    @PostMapping(path = "save")
    public ResponseEntity<Reservation> addNewReservation(@RequestParam("creneau") String creneau,
                                               @RequestParam("centre") String centre,
                                               @RequestParam("patient") String _patient) {

    Centre center = centreService.getCentrebyName(centre);
    if(center == null){


    }
    Reservation newreservation = new Reservation();
    return ResponseEntity<>();

    }
}
