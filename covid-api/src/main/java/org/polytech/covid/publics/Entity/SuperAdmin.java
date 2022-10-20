package org.polytech.covid.publics.Entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SuperAdmin extends Utilisateur {
  @OneToMany
  private List<Centre> centres;
}
