package org.polytech.covid.publics.services;

import org.polytech.covid.publics.Entity.Admin;
import org.polytech.covid.publics.Entity.Centre;
import org.polytech.covid.publics.Entity.Medecin;
import org.polytech.covid.publics.Entity.SuperAdmin;
import org.polytech.covid.publics.Repos.ISuperAdmin;
import org.polytech.covid.publics.controllers.UserForm;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class SuperAdminService {

  public final ISuperAdmin iSuperAdmin;

  public SuperAdminService(ISuperAdmin superAdmin) {
    this.iSuperAdmin = superAdmin;
  }

  public List<SuperAdmin> getAdmins() { return iSuperAdmin.findAll();}

  public SuperAdmin addNewSuperAdmin (String email, String name, String firstname, String role) {

    SuperAdmin superAdmin = new SuperAdmin();
    superAdmin.setMail(email);
    superAdmin.setNom(name);
    superAdmin.setPrenom(firstname);
    superAdmin.setRole(role);

    this.iSuperAdmin.save(superAdmin);
    return superAdmin;
  }

  public void reMoveSuperAdmin (SuperAdmin superAdmin) {
    this.iSuperAdmin.delete(superAdmin);
  }

  public SuperAdmin modifierSuperAdmin (UserForm form, Long id) {
    SuperAdmin superAdmin = iSuperAdmin.getMedecinById(id);
    if(superAdmin == null) {
      throw new EntityNotFoundException();
    }
    else {
      superAdmin.setNom(form.getNom());
      superAdmin.setPrenom(form.getPrenom());
      superAdmin.setMail(form.getEmail());
      superAdmin.setRole("SUPERADMIN");
      superAdmin.setLogin(form.getEmail());
      superAdmin.setPassword(form.getPassword());
      return iSuperAdmin.save(superAdmin);
    }
  }

  public void deleteSuperAdmin(Long id ){
    boolean test = iSuperAdmin.existsById(id);

    if(!test) {
      throw new IllegalStateException("User with id " + id +" doesn't exist");
    }
    else
      iSuperAdmin.deleteSuperAdminById(id);

  }
  public SuperAdmin getSuperAdminByMail(final String mail) {
    return iSuperAdmin.findByLogin(mail);
  }
}
