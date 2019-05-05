package org.comptabilite.AMC.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.comptabilite.AMC.entities.Client;
import org.comptabilite.AMC.entities.DossierAnnuel;

public interface DossierAnnuelRepository extends JpaRepository<DossierAnnuel,Integer> {

    public List<DossierAnnuel> findByClient(Client client) ;
}
