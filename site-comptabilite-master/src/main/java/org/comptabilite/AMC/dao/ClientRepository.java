package org.comptabilite.AMC.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.comptabilite.AMC.entities.Client;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client,Integer> {

    public List<Client> findClientByValidation(Boolean valide) ;

    public  Client getClientByEmail(String email) ;

}
