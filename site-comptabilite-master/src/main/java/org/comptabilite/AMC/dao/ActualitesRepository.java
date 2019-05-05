package org.comptabilite.AMC.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.comptabilite.AMC.entities.Actualites;

public interface ActualitesRepository extends JpaRepository<Actualites,Integer> {
}
