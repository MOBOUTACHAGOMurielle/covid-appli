package org.polytech.covid.publics.Entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Personne {
    @Id
    private int id;
    private String nom;
    private String prenom;
    private String mail;
    private String telephone;
    private Date date;
}
