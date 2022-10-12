package org.polytech.covid.publics.controllers;


import org.polytech.covid.publics.Entity.Centre;
import org.polytech.covid.publics.services.CentreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("centre")
public class CentreController {
    private final CentreService centreService;

@Autowired
    public CentreController(CentreService centreService) {
        this.centreService = centreService;
    }
@GetMapping("list")
    public List<Centre> getCentres() {return centreService.getCentres();}

@GetMapping("list/{ville}")
    public Centre getCentre(@PathVariable("ville") String ville) {return centreService.getCentre(ville);}

   @PostMapping(path = "save")
    public ResponseEntity<Centre> addNewCentre(@RequestParam("address") String address,
                                               @RequestParam("name") String name,
                                               @RequestParam("ville") String ville,
                                               @RequestParam("tel") Integer tel){
    Centre newCentre = centreService.addNewCentre(address,name,ville,tel);
    return  new ResponseEntity<>(newCentre, OK);

    }
}
