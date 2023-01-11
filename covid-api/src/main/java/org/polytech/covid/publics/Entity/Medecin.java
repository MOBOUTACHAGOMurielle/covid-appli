package org.polytech.covid.publics.Entity;

import lombok.*;
import org.hibernate.annotations.Table;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Medecin extends Utilisateur{
  @ManyToOne
  private Centre centre;

  @OneToMany
  private List<UserPatient> patient;

  public Centre getCentre() {
    return centre;
  }

  public void setCentre(Centre centre) {
    this.centre = centre;
  }

  public Medecin(String message) {
    this.status = message;
  }
}
