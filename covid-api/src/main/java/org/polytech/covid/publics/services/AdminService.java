package org.polytech.covid.publics.services;

import org.polytech.covid.publics.Entity.Admin;
import org.polytech.covid.publics.Entity.Centre;
import org.polytech.covid.publics.Repos.IAdmin;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

  public final IAdmin iAdmin;

  public AdminService(IAdmin iAdmin) {
    this.iAdmin = iAdmin;
  }

  public List<Admin> getAdmins() { return iAdmin.findAll();}

  public Centre getCentre(int id) {return  iAdmin.getAdminById(id).getCentre();}

  public Admin addNewAdmin (String email, String name, String firstname, String role, Centre centre) {

    Admin admin = new Admin();
    admin.setMail(email);
    admin.setNom(name);
    admin.setPrenom(firstname);
    admin.setRole(role);
    admin.setCentre(centre);

    this.iAdmin.save(admin);
    return admin;
  }

  public Admin modifierAdmin (Admin admin,String email, String name, String firstname, String role, Centre centre) {
    admin.setMail(email);
    admin.setNom(name);
    admin.setPrenom(firstname);
    admin.setRole(role);
    admin.setCentre(centre);

    this.iAdmin.save(admin);
    return admin;
  }

  public void reMoveAdmin ( Admin admin) {
    this.iAdmin.delete(admin);
  }

  public List<Admin> getAdminByCentre (Centre centre) {
    return iAdmin.findAdminByCentre(centre);
  }

}
