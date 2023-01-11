package org.polytech.covid.publics.services;

import org.polytech.covid.publics.Entity.Centre;
import org.polytech.covid.publics.Repos.ICentre;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class CentreService {
  private final ICentre iCentre;

  public CentreService(ICentre iCentre) {
      this.iCentre = iCentre;
  }

  public List<Centre> getCentres () {return  iCentre.findAll();}

  public Centre addNewCentre (String address,String name, String ville,String codePostal) {

    Centre centre = new Centre();
    centre.setAdresse(address);
    centre.setNom(name);
    centre.setVille(ville.toLowerCase(Locale.ROOT));
    centre.setCodePostal(codePostal);

    this.iCentre.save(centre);
    return centre;
  }

  public Centre modifierCentre (Centre centre, int id) {
    Optional<Centre> center = iCentre.findById(id);
    center.get().setCodePostal(centre.getCodePostal());
    center.get().setAdresse(centre.getAdresse());
    center.get().setNom(centre.getNom());
    center.get().setVille(centre.getVille());
    this.iCentre.save(centre);
    return centre;
  }

  public Centre getCentrebyName(String name) {
        return iCentre.findCentreByNom(name);
    }

  public Centre getCentre (String ville) {
    Centre a = iCentre.findCentreByVille(ville);
        return a;
    }
}
