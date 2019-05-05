package org.comptabilite.AMC.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.comptabilite.AMC.entities.Document;
import org.comptabilite.AMC.entities.Personne;
import org.comptabilite.AMC.enums.TypeFolder;

import java.util.List;

public interface DocumentRepository extends JpaRepository<Document,Integer> {
    public List<Document> getDocumentByAnneeDeCreationAndPersonneEmmeteurDocumentAndType(String annee, Personne personne, TypeFolder type) ;
    public List<Document> getDocumentByType(TypeFolder type) ;
}
