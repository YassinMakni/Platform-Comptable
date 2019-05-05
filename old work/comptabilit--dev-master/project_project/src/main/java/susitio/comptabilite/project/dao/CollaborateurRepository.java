package susitio.comptabilite.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import susitio.comptabilite.project.entities.Collaborateur;

public interface CollaborateurRepository extends JpaRepository<Collaborateur,Integer> {
}
