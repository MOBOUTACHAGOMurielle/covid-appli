package org.polytech.covid.publics.Entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@AllArgsConstructor
@Getter
@Setter
public class Reservation {

  @Id
  @GeneratedValue(strategy= AUTO)
  private Long id;
  private Date creneau;
  private Boolean status;

  @ManyToOne
  private Centre centre;

  @ManyToOne
  private UserPatient patient;

  public Reservation() {
  }

  public Reservation(Date creneau, Boolean status, Centre centre, UserPatient patient) {
  }

  public void setDate(Date date) {
    this.creneau = date;
  }

  public void setStatus(Boolean _status) {
    this.status = _status;
  }

  public void setCentre(Centre center) {
    this.centre = center;
  }

  public void setUtilisateur(UserPatient user) { this.patient = user; }

  public Date getCreneau() {
      return creneau;
    }

    public Boolean getStatus() {
      return status;
    }

    public Centre getCentre() {
      return centre;
    }

    public UserPatient getPatient() {
      return patient;
    }
}
