package susitio.comptabilite.project.services;

import susitio.comptabilite.project.entities.Actualites;

import java.util.List;

public interface ActualiteService {

    public List<Actualites> getAcualites() ;
    public Actualites getActualliteById(int id) ;
}
