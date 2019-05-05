package susitio.comptabilite.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import susitio.comptabilite.project.entities.Client;
import susitio.comptabilite.project.entities.DossierAnnuel;

public interface DossierAnnuelRepository extends JpaRepository<DossierAnnuel,Integer> {

    public List<DossierAnnuel> findByClient(Client client) ;
}
