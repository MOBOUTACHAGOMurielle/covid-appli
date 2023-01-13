package org.polytech.covid.publics.services;

import org.polytech.covid.publics.Entity.Admin;
import org.polytech.covid.publics.Entity.Centre;
import org.polytech.covid.publics.Entity.Medecin;
import org.polytech.covid.publics.Repos.ICentre;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Locale;

@Service
public class CentreService {
  private final ICentre iCentre;
  private final AdminService adminService;

  public CentreService(ICentre iCentre, AdminService adminservice) {
      this.iCentre = iCentre;
    this.adminService = adminservice;
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

  public Centre addNewMedecinToCentre (int id, Medecin medecin) {
    Centre center = iCentre.getById(id);
    if(center == null) {
      throw new EntityNotFoundException();
    }
    else {
      List<Medecin> list = center.getMedecins();
      list.add(medecin);
      center.setMedecins(list);
      return center;
    }
  }

  public Centre addNewAdminToCentre (int id, Admin admin) {
    Centre center = iCentre.getById(id);
    if(center == null) {
      throw new EntityNotFoundException();
    }
    else {
      Admin nadmin = adminService.addNewAdmin(admin.getMail(),admin.getNom(),admin.getPrenom(),admin.getRole(),null);
      List<Admin> list = center.getAdmins();
      list.add(nadmin);
      center.setAdmins(list);
      return center;
    }
  }


  /*public Centre removeAdminToCentre(int idCentre, int idAdmin){

  }*/
  public Centre modifierCentre (Centre centre, int id) {
    Centre center = iCentre.getById(id);
    if(center == null) {
      throw new EntityNotFoundException();
    }
    else {
      center.setCodePostal(centre.getCodePostal());
      center.setAdresse(centre.getAdresse());
      center.setNom(centre.getNom());
      center.setVille(centre.getVille());
      this.iCentre.save(centre);
      return center;
    }
  }

  public Centre getCentrebyName(String name) {
        return iCentre.findCentreByNom(name);
    }

  public Centre getCentre (String ville) {
    Centre a = iCentre.findCentreByVille(ville);
        return a;
    }

   public List<Medecin> getMedecins (int id) {
      Centre center = iCentre.getById(id);
      if(center == null) {
        throw new EntityNotFoundException();
      }
      else {
        return center.getMedecins();
      }
   }

  public List<Admin> getAdmins (int id) {
    Centre center = iCentre.getById(id);
    if(center == null) {
      throw new EntityNotFoundException();
    }
    else {
      return center.getAdmins();
    }
  }
}
