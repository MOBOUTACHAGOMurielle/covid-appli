package org.polytech.covid.publics.Repos;

import org.polytech.covid.publics.Entity.SuperAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISuperAdmin extends JpaRepository<SuperAdmin, Integer> {
  SuperAdmin findByLogin(final String email);
}
