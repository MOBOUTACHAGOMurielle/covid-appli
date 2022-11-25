package org.polytech.covid;

import org.polytech.covid.publics.Entity.Centre;
import org.polytech.covid.publics.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class CovidApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CovidApiApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(CentreService centreService,
							 UtilisateurService utilisateurService,
               MedecinService medecinService,
               AdminService adminService,
               SuperAdminService superAdminService,
                           UserPatientService patientService,
                           ReservationService reservation
							 ){
		return args -> {

			centreService.addNewCentre("2 Rue Jean l'amour, 54000", "Polytech Nancy","Nancy", "54500");
			centreService.addNewCentre("3 Rue Jean d'arc, 95300", "OuiLab","Paris", "25480");
			centreService.addNewCentre("2 Rue Marthyr, 75000", "","Anger", "33400");

			medecinService.addNewMedecin("jean@durand.fr", "Durand", "jean", "Administrateur", centreService.getCentre("nancy"));
      medecinService.addNewMedecin("remi@Martin.fr", "Martin", "remi", "Administrateur", centreService.getCentre("paris"));
      medecinService.addNewMedecin("christine@Borne.fr", "Borne", "Christine", "Administrateur", centreService.getCentre("anger"));

      adminService.addNewAdmin("jean@durand.fr", "Durand", "jean", "Administrateur", centreService.getCentre("nancy"));
      adminService.addNewAdmin("remi@Martin.fr", "Martin", "remi", "Administrateur", centreService.getCentre("paris"));
      adminService.addNewAdmin("christine@Borne.fr", "Borne", "Christine", "Administrateur", centreService.getCentre("anger"));

      superAdminService.addNewSuperAdmin("jean@durand.fr", "Durand", "jean", "superAdministrateur");
      superAdminService.addNewSuperAdmin("remi@Martin.fr", "Martin", "remi", "superAdministrateur");
      superAdminService.addNewSuperAdmin("christine@Borne.fr", "Borne", "Christine", "superAdministrateur");

      patientService.addNewPatient("Blondeau", "Brice", "bb@gmail.com", medecinService.getMedecinByNom("Durand"));
      patientService.addNewPatient("Macron", "Remi", "macronremi@gmail.com", medecinService.getMedecinByNom("Martin"));
      patientService.addNewPatient("Mergez", "Berenice", "berenicemergez@gmail.com", medecinService.getMedecinByNom("Durand"));

      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
      reservation.addnewReservation(simpleDateFormat.parse("18/01/2022"), true, centreService.getCentre("nancy"), patientService.getPatientByName("Blondeau") );
      reservation.addnewReservation(simpleDateFormat.parse("20/12/2022"), false, centreService.getCentre("paris"), patientService.getPatientByName("Macron") );
      reservation.addnewReservation(simpleDateFormat.parse("25/12/2022"), true, centreService.getCentre("anger"), patientService.getPatientByName("Mergez") );
		};
	}

}
