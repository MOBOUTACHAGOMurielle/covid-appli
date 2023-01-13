package org.polytech.covid.publics.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Admin extends Utilisateur {
  @ManyToOne
  @JoinColumn(name = "centre_id")
  @JsonBackReference(value = "admintocours")
  private Centre centre;

  @OneToMany
  private List<Medecin> medecins;

  public Centre getCentre() {
    return centre;
  }

  public void setCentre(Centre centre) {
    this.centre = centre;
  }
}
