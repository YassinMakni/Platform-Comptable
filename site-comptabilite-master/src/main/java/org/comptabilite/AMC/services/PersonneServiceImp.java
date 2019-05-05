package org.comptabilite.AMC.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.comptabilite.AMC.dao.AdminRepository;
import org.comptabilite.AMC.dao.ClientRepository;
import org.comptabilite.AMC.dao.CollaborateurRepository;
import org.comptabilite.AMC.dao.PersonneRepository;
import org.comptabilite.AMC.entities.Personne;




@Service
public class PersonneServiceImp implements PersonneService  {
    @Autowired
    PersonneRepository personneRepository ;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    CollaborateurRepository collaborateurRepository;

    @Override
    public Personne getPersonneById(int id) {
        return personneRepository.findById(id).get() ;
    }
    
    @Override
    public Personne getPersonneByEmail(String email) {
        return personneRepository.findByEmail(email).get() ;
    }


}
