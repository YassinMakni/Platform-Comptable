package susitio.comptabilite.project.services;

import org.springframework.stereotype.Repository;
import susitio.comptabilite.project.entities.Client;
import susitio.comptabilite.project.entities.Collaborateur;

import java.util.List;

@Repository
public interface CollaborateurService {

    public List<Collaborateur> getCollaborateurs() ;
    public Collaborateur getCollaborateurById(int id ) ;
    public void addCollaborateur(Collaborateur collaborateur);
    public void deleteCollaborateur(int id) ;
}
