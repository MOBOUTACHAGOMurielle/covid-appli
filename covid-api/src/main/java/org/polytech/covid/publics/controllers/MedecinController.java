package org.polytech.covid.publics.controllers;

import org.polytech.covid.publics.Entity.Centre;
import org.polytech.covid.publics.Entity.Medecin;
import org.polytech.covid.publics.Entity.Utilisateur;
import org.polytech.covid.publics.services.MedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("medecin")
public class MedecinController {
  private final MedecinService medecinService;

@Autowired
  public MedecinController(MedecinService medecin) { this.medecinService = medecin;}

@GetMapping("list")
 public List<Medecin> getMedecins() {return medecinService.getMedecins();}

  @GetMapping("list/{centre}")
  public List<Medecin> getMedecinsByCentre(@PathVariable("centre") Centre center) {
  return medecinService.getMedecinByCentre(center);
}

  @GetMapping("login")
  @RequestMapping("/validateLogin")
  public Medecin validateLogin(){
    return new Medecin("user successfully authenticated");
  }

  @PostMapping(path = "save")
  public ResponseEntity<Medecin> addNewMedecin(@RequestBody Medecin medecin){
    Medecin newMedecin = medecinService.addNewMedecin(medecin.getMail(),medecin.getNom(),medecin.getPrenom(),medecin.getRole(), medecin.getCentre());
    return  new ResponseEntity<>(newMedecin, OK);
  }

}
