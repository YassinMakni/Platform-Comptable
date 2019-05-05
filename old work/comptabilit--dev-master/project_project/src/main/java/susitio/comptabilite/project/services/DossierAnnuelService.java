package susitio.comptabilite.project.services;

import java.util.List;

import org.springframework.stereotype.Repository;

import susitio.comptabilite.project.entities.Client;
import susitio.comptabilite.project.entities.DossierAnnuel;

@Repository
public interface DossierAnnuelService {

    public List<DossierAnnuel> getDossierAnnuelByClient(Client client) ;
    public DossierAnnuel getDossierAnnuelById(int id) ;
    public void addDossierAnnuel(DossierAnnuel dossierAnnuel) ;
    public void deleteDossierAnnuel(int id) ;
    public void closeYear(int id) ;
    public void openYear(int id) ;
}
