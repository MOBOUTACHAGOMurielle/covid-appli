package org.polytech.covid.publics.Repos;

import org.polytech.covid.publics.Entity.SuperAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ISuperAdmin extends JpaRepository<SuperAdmin, Integer> {
  SuperAdmin findByLogin(final String email);
  Boolean existsById(Long id);
  void deleteSuperAdminById(Long id);
}
