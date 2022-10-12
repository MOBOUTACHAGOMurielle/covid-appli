package org.polytech.covid.publics.services;

import org.polytech.covid.publics.Entity.Centre;
import org.polytech.covid.publics.Entity.Reservation;
import org.polytech.covid.publics.Entity.Utilisateur;
import org.polytech.covid.publics.Repos.IReservation;
import org.springframework.stereotype.Service;

import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.List;

@Service
public class ReservationService {

    private final IReservation ireservation;

    public ReservationService(IReservation reservation) {
        this.ireservation = reservation;
    }

    public Reservation addnewReservation (Date _creneau , Boolean _status, Centre _centre, Utilisateur _patient ) {
        Reservation reservation = new Reservation();
        reservation.setCreneau(_creneau);
        reservation.setStatus(_status);
        reservation.setPatient(_patient);
        reservation.setCentre(_centre);

        this.ireservation.save(reservation);
        return reservation;
    }

    public List<Reservation> getReservationByCreneau(Date _creneau) {
        return ireservation.findReservationsByCreneau(_creneau);
    }








}
