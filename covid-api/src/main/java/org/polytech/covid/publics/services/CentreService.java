package org.polytech.covid.publics.services;

import org.polytech.covid.publics.Entity.Centre;
import org.polytech.covid.publics.Repos.ICentre;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class CentreService {
    private final ICentre iCentre;

    public CentreService(ICentre iCentre) {
        this.iCentre = iCentre;
    }

    public List<Centre> getCentres () {return  iCentre.findAll();}

    public Centre addNewCentre (String address,String name, String ville,Integer tel ) {

        Centre centre = new Centre();
        centre.setAdresse(address);
        centre.setNom(name);
        centre.setVille(ville.toLowerCase(Locale.ROOT));
        centre.setTelephone(tel);


        this.iCentre.save(centre);
        return centre;
    }

    public Centre getCentrebyName(String name) {
        return iCentre.findCentreByNom(name);
    }

    public Centre getCentre (String ville) {
        return iCentre.findCentreByVille(ville);
    }
}
