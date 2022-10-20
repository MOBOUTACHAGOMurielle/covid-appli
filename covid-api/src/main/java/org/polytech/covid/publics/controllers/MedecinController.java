package org.polytech.covid.publics.controllers;

import org.polytech.covid.publics.Entity.Centre;
import org.polytech.covid.publics.Entity.Medecin;
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

  @PostMapping(path = "save")
  public ResponseEntity<Medecin> addNewMedecin(@RequestParam("email") String email,
                                               @RequestParam("name") String name,
                                               @RequestParam("firstname") String firstname,
                                               @RequestParam("role") String role,
                                               @RequestParam("center") Centre center){
    Medecin newMedecin = medecinService.addNewMedecin(email,name,firstname,role, center);
    return  new ResponseEntity<>(newMedecin, OK);
  }

}
