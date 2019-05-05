package org.comptabilite.AMC.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.comptabilite.AMC.entities.Collaborateur;

public interface CollaborateurRepository extends JpaRepository<Collaborateur,Integer> {
}
