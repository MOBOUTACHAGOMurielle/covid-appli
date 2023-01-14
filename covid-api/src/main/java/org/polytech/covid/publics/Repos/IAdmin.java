package org.polytech.covid.publics.Repos;

import org.polytech.covid.publics.Entity.Admin;
import org.polytech.covid.publics.Entity.Centre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IAdmin extends JpaRepository<Admin, Integer> {
  List<Admin> findMedecinByCentreContaining(Centre center);
  List<Admin> findAdminByCentre(Centre center);
  Admin findAdminById(Long id);

  Boolean existsByMail(String mail);


  Admin getAdminById (Long id);
  Boolean existsById(Long id);
  void deleteAdminById(Long id);
}
