package susitio.comptabilite.project.services;

import java.util.List;

import org.springframework.stereotype.Repository;
import susitio.comptabilite.project.entities.Client;
import susitio.comptabilite.project.entities.Personne;
import susitio.comptabilite.project.exceptions.BusinessException;

@Repository
public interface ClientService {

	public List<Client> getClients();
	
	public Client getClientById(int id);
	
	public void addClient(Client client);
	
	public void deleteClient(int id);

	public void approuverClient(int id);

	public void desapprouverClient(int id);

	public Client getLoggedInClient() throws BusinessException;

	public List<Client> getNonValidationClients(Boolean valide) ;
	
}
