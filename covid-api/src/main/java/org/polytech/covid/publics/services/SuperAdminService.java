package org.polytech.covid.publics.services;

import org.polytech.covid.publics.Entity.Admin;
import org.polytech.covid.publics.Entity.Centre;
import org.polytech.covid.publics.Entity.Medecin;
import org.polytech.covid.publics.Entity.SuperAdmin;
import org.polytech.covid.publics.Repos.ISuperAdmin;
import org.springframework.stereotype.Service;

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

  public SuperAdmin modifierMedecin (SuperAdmin superAdmin,String email, String name, String firstname, String role, Centre centre) {
    superAdmin.setMail(email);
    superAdmin.setNom(name);
    superAdmin.setPrenom(firstname);
    superAdmin.setRole(role);

    this.iSuperAdmin.save(superAdmin);
    return superAdmin;
  }

  public SuperAdmin getSuperAdminByMail(final String mail) {
    return iSuperAdmin.findByLogin(mail);
  }
}
