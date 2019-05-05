package susitio.comptabilite.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import susitio.comptabilite.project.entities.Payment;

public interface PayementRepository extends JpaRepository<Payment,Integer> {
}
