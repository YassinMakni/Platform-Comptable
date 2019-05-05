package org.comptabilite.AMC.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.comptabilite.AMC.dao.CollaborateurRepository;
import org.comptabilite.AMC.entities.Collaborateur;

import java.util.List;

@Service
public class CollaborateurServiceImp implements CollaborateurService {

    @Autowired
    CollaborateurRepository collaborateurRepository ;

    @Override
    public List<Collaborateur> getCollaborateurs() {
        return collaborateurRepository.findAll();
    }

    @Override
    public Collaborateur getCollaborateurById(int id) {

        return collaborateurRepository.findById(id).get();
    }

    @Override
    public void addCollaborateur(Collaborateur collaborateur) {
        collaborateurRepository.save(collaborateur) ;
    }

    @Override
    public void deleteCollaborateur(int id) {
        collaborateurRepository.deleteById(id);
    }
}
