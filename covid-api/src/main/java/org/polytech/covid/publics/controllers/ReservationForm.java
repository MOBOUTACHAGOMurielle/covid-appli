package org.polytech.covid.publics.controllers;

import lombok.Getter;

import java.util.Date;

@Getter
public class ReservationForm {

    public String nom;
    public String prenom;
    public String email;
    public Date date;
}
