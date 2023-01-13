package org.polytech.covid.publics.Repos;

import org.polytech.covid.publics.Entity.Centre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface ICentre extends JpaRepository<Centre, Integer> {

    Centre findCentreByVille(String ville);
    Centre findCentreByNom(String name);
    Centre getById(int id);


    List<Centre> findCentresByVilleContaining(String name);
}
