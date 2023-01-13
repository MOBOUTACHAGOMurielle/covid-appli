package org.polytech.covid.publics.services;

import org.polytech.covid.publics.Entity.Centre;
import org.polytech.covid.publics.Entity.Medecin;
import org.polytech.covid.publics.Repos.IMedecin;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedecinService {

  private final IMedecin iMedecin;

  public MedecinService(IMedecin medecin) {
    this.iMedecin = medecin;
  }

  public List<Medecin> getMedecins() { return iMedecin.findAll();}

  public Medecin addNewMedecin (String email, String name, String firstname, String role, Centre centre ) {

    Medecin medecin = new Medecin();
    medecin.setMail(email);
    medecin.setNom(name);
    medecin.setPrenom(firstname);
    medecin.setRole(role);
    medecin.setCentre(centre);

    this.iMedecin.save(medecin);
    return medecin;
  }

  public void reMoveMedecin ( Medecin medecin) {
    this.iMedecin.delete(medecin);
  }

  public Medecin modifierMedecin (Medecin medecin,String email, String name, String firstname, String role, Centre centre) {
    medecin.setMail(email);
    medecin.setNom(name);
    medecin.setPrenom(firstname);
    medecin.setRole(role);
    medecin.setCentre(centre);

    this.iMedecin.save(medecin);
    return medecin;
  }

  public List<Medecin> getMedecinByCentre (Centre centre) {
    return iMedecin.findMedecinByCentre(centre);
  }

  public Medecin getMedecinByNom(String nom) { return iMedecin.findMedcinByNom(nom);}
}
