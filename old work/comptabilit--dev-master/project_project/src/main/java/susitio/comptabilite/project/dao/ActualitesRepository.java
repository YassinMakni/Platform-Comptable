package susitio.comptabilite.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import susitio.comptabilite.project.entities.Actualites;

public interface ActualitesRepository extends JpaRepository<Actualites,Integer> {
}
