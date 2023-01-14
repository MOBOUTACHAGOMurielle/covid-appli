package org.polytech.covid.publics.services;

import org.polytech.covid.publics.Entity.*;
import org.polytech.covid.publics.Repos.IReservation;
import org.polytech.covid.publics.Repos.IUserPatient;
import org.polytech.covid.publics.controllers.ReservationForm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import org.polytech.covid.publics.Repos.ICentre;

@Service
public class ReservationService {

  private final IReservation ireservation;
  private final ICentre iCentre;
  private final IUserPatient iPatient;

  public ReservationService(IReservation reservation, ICentre iCentre, IUserPatient patient) {
    this.ireservation = reservation;
    this.iCentre = iCentre;
    this.iPatient = patient;
  }

  public List<Reservation> getReservations() { return ireservation.findAll();}

  public Reservation addnewReservation (ReservationForm rdv, int id) {
      Reservation reservation = new Reservation();
      reservation.setDate(rdv.getDate());
      reservation.setStatus(false);
      reservation.setCentre(iCentre.getCentreById(id));
      UserPatient patient = new UserPatient();
      patient.setNom(rdv.nom);
      patient.setPrenom(rdv.prenom);
      patient.setMail(rdv.email);
      reservation.setUtilisateur(patient);
      this.ireservation.save(reservation);
      return reservation;
  }

  public Reservation getReservationByCreneau(Date _creneau) {
    return ireservation.findReservationsByCreneau(_creneau);
  }








}
