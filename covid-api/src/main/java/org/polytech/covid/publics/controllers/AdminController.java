package org.polytech.covid.publics.controllers;

import org.polytech.covid.publics.Entity.Admin;
import org.polytech.covid.publics.Entity.Centre;
import org.polytech.covid.publics.Entity.Medecin;
import org.polytech.covid.publics.services.AdminService;
import org.polytech.covid.publics.services.CentreService;
import org.polytech.covid.publics.services.MedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("admin")
public class AdminController {
  private final AdminService adminService;
  private CentreController center;

  @Autowired
  public AdminController(AdminService adminService) {
    this.adminService = adminService; }

  @GetMapping("list")
  public List<Admin> getAdmins() {return adminService.getAdmins();}

  @GetMapping("list/{centre}")
  public List<Admin> getAdmin(@PathVariable("centre") Centre centre) {return adminService.getAdminByCentre(centre);}

  @PostMapping(path = "save")
  public ResponseEntity<Admin> addNewAdmin(@RequestBody Admin admin){
    Admin newAdmin = adminService.addNewAdmin(admin.getMail(),admin.getNom(),admin.getPrenom(),admin.getRole(),admin.getCentre());
    return  new ResponseEntity<>(newAdmin, OK);
  }
}
