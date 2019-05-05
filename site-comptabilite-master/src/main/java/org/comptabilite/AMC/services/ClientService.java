package org.comptabilite.AMC.services;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.comptabilite.AMC.entities.Client;
import org.comptabilite.AMC.entities.Personne;


@Repository
public interface ClientService {

	public List<Client> getClients();
	
	public Client getClientById(int id);
	
	public void addClient(Client client);
	
	public void deleteClient(int id);

	public void approuverClient(int id);

	public void desapprouverClient(int id);


	public List<Client> getNonValidationClients(Boolean valide) ;
	
}
