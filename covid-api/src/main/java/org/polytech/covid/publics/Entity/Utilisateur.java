package org.polytech.covid.publics.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "UTILISATEUR")
public class Utilisateur {
  @Id
  @GeneratedValue
  private Long id;

  private String login;

  private String password;

  private String role;

  private String nom;

  private String prenom;

  private String mail;

//  @OneToMany
//  public List<Reservation> reservations;

  public Long getId() {
      return id;
  }

  public void setId(final Long id) {
      this.id = id;
  }

  public String getLogin() {
      return login;
  }

  public void setLogin(final String email) {
      this.login = email;
  }

  public String getPassword() {
      return password;
  }

  public void setPassword(final String password) {
      this.password = password;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }
}
