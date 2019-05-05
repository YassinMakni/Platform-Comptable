package susitio.comptabilite.project.services;

import susitio.comptabilite.project.entities.Personne;
import susitio.comptabilite.project.exceptions.BusinessException;

public interface PersonneService {

    public Personne getPersonneById(int id);

	public Personne getPersonneByEmail(String email);
	
	public Personne getLoggedInUser() throws BusinessException;
}
