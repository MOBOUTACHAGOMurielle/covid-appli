package org.polytech.covid.publics.controllers;

import org.polytech.covid.publics.Entity.Centre;
import org.polytech.covid.publics.Entity.Medecin;
import org.polytech.covid.publics.Entity.SuperAdmin;
import org.polytech.covid.publics.services.CentreService;
import org.polytech.covid.publics.services.SuperAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("superAdmin")
public class SuperAdminController {
  private final SuperAdminService superAdminService;

  @Autowired
  public SuperAdminController(SuperAdminService superAdminService) {
    this.superAdminService = superAdminService;
  }

  @GetMapping("list")
  public List<SuperAdmin> getSuperAdmins() {return superAdminService.getAdmins();}

  @GetMapping("list/{mail}")
  public SuperAdmin getSuperAdmin(@PathVariable("mail") String mail) {return superAdminService.getSuperAdminByMail(mail);}

  @PostMapping(path = "save")
  public ResponseEntity<SuperAdmin> addNewSuperAdmin(@RequestBody SuperAdmin superAdmin){
    SuperAdmin newSuperAdmin = superAdminService.addNewSuperAdmin(superAdmin.getMail(),superAdmin.getNom(),superAdmin.getPrenom(),superAdmin.getRole());
    return  new ResponseEntity<>(newSuperAdmin, OK);

  }

  @DeleteMapping("delete/{id}")
  public void deleteSuperAdminByid(@PathVariable("id") Long id) {
    superAdminService.deleteSuperAdmin(id);
  }
}
