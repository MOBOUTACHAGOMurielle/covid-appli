package org.polytech.covid.publics.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    public int id;
    public String ville;
//    public List<Personne> medecins;
    public String nom;
    public String adresse;
    public Integer telephone;

    @OneToMany
    public List<Reservation> reservations;




    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }
}
