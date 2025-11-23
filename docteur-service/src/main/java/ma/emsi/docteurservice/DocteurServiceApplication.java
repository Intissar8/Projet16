package ma.emsi.docteurservice;

import ma.emsi.docteurservice.model.Docteur;
import ma.emsi.docteurservice.repositories.DocteurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DocteurServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocteurServiceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner run(DocteurRepository repository) {
		return args -> {
			repository.save(Docteur.builder()
					.nom("Ali")
					.prenom("Ken")
					.specialite("Cardiologie")
					.telephone("0612345678")
					.email("ali.saad@example.com")
					.build());

			repository.save(Docteur.builder()
					.nom("Sara")
					.prenom("Ben")
					.specialite("Dermatologie")
					.telephone("0611223344")
					.email("sara.ben@example.com")
					.build());

			repository.save(Docteur.builder()
					.nom("Khalid")
					.prenom("Amine")
					.specialite("Neurologie")
					.telephone("0622334455")
					.email("khalid.amine@example.com")
					.build());
		};
	}
}
