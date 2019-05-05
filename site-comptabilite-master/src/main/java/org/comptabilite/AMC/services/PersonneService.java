package org.comptabilite.AMC.services;

import org.comptabilite.AMC.entities.Personne;


public interface PersonneService {

    public Personne getPersonneById(int id);

	public Personne getPersonneByEmail(String email);

}
