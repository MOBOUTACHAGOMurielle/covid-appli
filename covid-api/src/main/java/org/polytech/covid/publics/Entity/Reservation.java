package org.polytech.covid.publics.Entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Reservation {

    @Id
    private Long id;
    private Date creneau;
    private Boolean status;

    @ManyToOne
    private Centre centre;

    @ManyToOne
    private Utilisateur patient;
    



}
