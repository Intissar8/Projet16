package ma.emsi.docteurservice.repositories;

import ma.emsi.docteurservice.model.Docteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "docteurs") //exposes the REST API automatically
public interface DocteurRepository extends JpaRepository<Docteur, Long> {
}
