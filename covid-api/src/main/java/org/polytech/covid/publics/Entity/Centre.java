package org.polytech.covid.publics.Entity;

import javax.persistence.*;
import java.util.List;
import lombok.*;

import static javax.persistence.GenerationType.AUTO;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Centre {
@Id
@GeneratedValue(strategy= AUTO)
  private int id;
  private String ville;
  private String nom;
  private String adresse;
  private String codePostal;


  @OneToMany
  public List<Reservation> reservations;

  @OneToMany
  public List<Medecin> medecins;

  @OneToMany
  public List<Admin> admins;
/*
  public void setVille(String ville) {
      this.ville = ville;
  }

  public void setNom(String nom) {
      this.nom = nom;
  }

  public void setAdresse(String adresse) {
      this.adresse = adresse;
  }

  public String getVille() { return ville; }

  public String getAdresse() { return adresse; }

  public String getNom() { return nom; }

  public String getCodePostal() {
    return codePostal;
  }

  public void setCodePostal(String codePostal) {
    this.codePostal = codePostal;
  }*/
}
