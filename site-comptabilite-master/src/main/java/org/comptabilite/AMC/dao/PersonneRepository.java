package org.comptabilite.AMC.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.comptabilite.AMC.entities.Personne;

import java.util.Optional;

public interface PersonneRepository extends JpaRepository<Personne,Integer> {

	Optional<Personne> findByEmail(String email);
	Personne findByNom(String username);
	Boolean existsByEmail(String email) ;
}
