package org.polytech.covid;

import org.polytech.covid.publics.Entity.Centre;
import org.polytech.covid.publics.Repos.ICentre;
import org.polytech.covid.publics.services.CentreService;
import org.polytech.covid.publics.services.UtilisateurService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class CovidApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CovidApiApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(CentreService centreService,
							 UtilisateurService utilisateurService

							 ){
		return args -> {

			centreService.addNewCentre("2 Rue Jean l'amour, 54000", "Polytech Nancy","Nancy", +3375509);
			centreService.addNewCentre("3 Rue Jean d'arc, 95300", "OuiLab","Paris", +337550559);
			centreService.addNewCentre("2 Rue Marthyr, 75000", "","Anger", +33755589);
			utilisateurService.createUserDefault();



		};
	}

}
