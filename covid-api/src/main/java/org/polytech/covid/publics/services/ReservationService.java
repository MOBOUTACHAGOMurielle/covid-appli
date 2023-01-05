package org.polytech.covid.publics.services;

import org.polytech.covid.publics.Entity.*;
import org.polytech.covid.publics.Repos.IReservation;
import org.springframework.hateoas.Link;
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

  public List<Reservation> getReservations() { return ireservation.findAll();}

  public Reservation addnewReservation (Date _creneau , Boolean _status, Centre _centre, UserPatient _patient ) {
      Reservation reservation = new Reservation();
      reservation.setDate(_creneau);
      reservation.setStatus(_status);
      reservation.setCentre(_centre);
      reservation.setUtilisateur(_patient);
      this.ireservation.save(reservation);
      return reservation;
  }

  public Reservation getReservationByCreneau(Date _creneau) {
    return ireservation.findReservationsByCreneau(_creneau);
  }








}
