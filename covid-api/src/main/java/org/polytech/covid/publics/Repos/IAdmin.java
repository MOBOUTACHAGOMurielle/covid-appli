package org.polytech.covid.publics.Repos;

import org.polytech.covid.publics.Entity.Admin;
import org.polytech.covid.publics.Entity.Centre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAdmin extends JpaRepository<Admin, Integer> {
  List<Admin> findMedecinByCentreContaining(Centre center);
  List<Admin> findAdminByCentre(Centre center);
  Admin getAdminById (int id);
}
