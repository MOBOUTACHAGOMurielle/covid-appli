package org.polytech.covid.publics.services;

import org.polytech.covid.publics.Entity.Centre;
import org.polytech.covid.publics.Entity.Medecin;
import org.polytech.covid.publics.Repos.ICentre;
import org.polytech.covid.publics.Repos.IMedecin;
import org.polytech.covid.publics.controllers.AddToCentreRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedecinService {

  private final IMedecin iMedecin;
  private final ICentre iCentre;

  public MedecinService(IMedecin medecin, ICentre iCentre) {
    this.iMedecin = medecin;
    this.iCentre = iCentre;
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

  public Medecin addnewMedecinwithCentre(int id, AddToCentreRequest medecin){
    Medecin newmedecin = new Medecin();
    newmedecin.setNom(medecin.getNom());
    newmedecin.setPrenom(medecin.getPrenom());
    newmedecin.setRole("MEDECIN");
    newmedecin.setMail(medecin.getEmail());
    newmedecin.setLogin(medecin.getEmail());
    newmedecin.setPassword(medecin.getPassword());
    newmedecin.setCentre(iCentre.getCentreById(id));
    return iMedecin.save(newmedecin);
  }

  public void deleteMedecin(Long id){

    boolean test = iMedecin.existsById(id);

    if(!test) {
      throw new IllegalStateException("User with id " + id +" doesn't exist");
    }
    else
      iMedecin.deleteMedecinById(id);

  }
}
