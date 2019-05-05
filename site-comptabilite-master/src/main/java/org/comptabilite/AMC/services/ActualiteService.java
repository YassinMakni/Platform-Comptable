package org.comptabilite.AMC.services;

import org.comptabilite.AMC.entities.Actualites;

import java.util.List;

public interface ActualiteService {

    public List<Actualites> getAcualites() ;
    public Actualites getActualliteById(int id) ;
}
