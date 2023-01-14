package org.polytech.covid.publics.services;

import org.polytech.covid.publics.Entity.Admin;
import org.polytech.covid.publics.Entity.Centre;
import org.polytech.covid.publics.Repos.IAdmin;
import org.polytech.covid.publics.Repos.ICentre;
import org.polytech.covid.publics.controllers.UserForm;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class AdminService {

  private final IAdmin iAdmin;
  private final ICentre iCentre;

  public AdminService(IAdmin iAdmin, ICentre iCentre) {
    this.iAdmin = iAdmin;
    this.iCentre = iCentre;
  }

  public List<Admin> getAdmins() { return iAdmin.findAll();}

  public Centre getCentre(Long id) {
    return  iCentre.getCentreByAdminsContaining(iAdmin.getAdminById(id));
  }

  public Admin addNewAdmin (String email, String name, String firstname, String role, Centre centre) {

    Admin admin = new Admin();
    admin.setMail(email);
    admin.setNom(name);
    admin.setRole("ADMINISTRATEUR");
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

  public Admin getAdmin (Long id) {
    return iAdmin.findAdminById(id);
  }

  public Admin addnewAdminwithCentre(int id, UserForm admin){
    Admin newadmin = new Admin();
    newadmin.setNom(admin.getNom());
    newadmin.setPrenom(admin.getPrenom());
    newadmin.setMail(admin.getEmail());
    newadmin.setRole("ADMINISTRATEUR");
    newadmin.setLogin(admin.getEmail());
    newadmin.setPassword(admin.getPassword());
    newadmin.setCentre(iCentre.getCentreById(id));
    return iAdmin.save(newadmin);
  }

  public void deleteAdmin(Long id){
    boolean test = iAdmin.existsById(id);

    if(!test) {
      throw new IllegalStateException("User with id " + id +" doesn't exist");
    }
    else
      iAdmin.deleteAdminById(id);

  }


  public Boolean isAdmin (String mail) {
    return iAdmin.existsByMail(mail);
  }


  public Admin modifierAdmin (UserForm form, Long id) {
    Admin admin = iAdmin.getAdminById(id);
    if(admin == null) {
      throw new EntityNotFoundException();
    }
    else {
      admin.setNom(form.getNom());
      admin.setPrenom(form.getPrenom());
      admin.setMail(form.getEmail());
      admin.setRole("ADMINISTRATEUR");
      admin.setLogin(form.getEmail());
      admin.setPassword(form.getPassword());
      return iAdmin.save(admin);
    }
  }

}
