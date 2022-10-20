package org.polytech.covid.publics.Repos;

import org.polytech.covid.publics.Entity.Centre;
import org.polytech.covid.publics.Entity.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMedecin extends JpaRepository<Medecin, Integer> {
  List<Medecin> findMedecinByCentreContaining(Centre center);
  Medecin findMedecinByCentre(Centre center);
  Medecin findMedcinByNom(String name);
}
