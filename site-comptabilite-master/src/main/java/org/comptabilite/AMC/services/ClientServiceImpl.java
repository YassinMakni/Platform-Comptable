package org.comptabilite.AMC.services;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.comptabilite.AMC.dao.ClientRepository;
import org.comptabilite.AMC.entities.Client;
import org.comptabilite.AMC.entities.DossierAnnuel;


@Service
public class ClientServiceImpl implements ClientService {

	
	@Autowired
	ClientRepository clientRepository;


	@Autowired
	DossierAnnuelService dossierAnnuelService ;

	@Autowired
	PersonneService personneService;


	@Override
	public List<Client> getClients() {
		return clientRepository.findAll();
	}

	@Override
	public Client getClientById(int id) {
		return clientRepository.findById(id).get();
	}

	@Override
	public void addClient(Client client) {

	}


	@Override
	public void deleteClient(int id) {
		
		clientRepository.deleteById(id);
	}

	@Override
	public void approuverClient(int id) {
		Client client = clientRepository.findById(id).get();
		client.setValidation(true);
		clientRepository.save(client);
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		DossierAnnuel dossierAnnuel = new DossierAnnuel(true,year,client) ;
		dossierAnnuelService.addDossierAnnuel(dossierAnnuel);

	}

	@Override
	public void desapprouverClient(int id) {
		Client client = clientRepository.findById(id).get();
		client.setValidation(false);
		clientRepository.save(client);
	}

	@Override
	public List<Client> getNonValidationClients(Boolean valide) {
		return  clientRepository.findClientByValidation(valide) ;
	}


}
