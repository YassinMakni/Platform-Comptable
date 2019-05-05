package org.comptabilite.AMC.services;

import org.springframework.stereotype.Repository;
import org.comptabilite.AMC.entities.Client;
import org.comptabilite.AMC.entities.Collaborateur;

import java.util.List;

@Repository
public interface CollaborateurService {

    public List<Collaborateur> getCollaborateurs() ;
    public Collaborateur getCollaborateurById(int id ) ;
    public void addCollaborateur(Collaborateur collaborateur);
    public void deleteCollaborateur(int id) ;
}
