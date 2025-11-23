package ma.emsi.rdvservice.repositories;

import ma.emsi.rdvservice.model.Rdv;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RdvRepository extends JpaRepository<Rdv, Long> {
}
