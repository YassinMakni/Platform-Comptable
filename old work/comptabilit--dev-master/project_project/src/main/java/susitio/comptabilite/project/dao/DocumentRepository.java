package susitio.comptabilite.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import susitio.comptabilite.project.entities.Document;
import susitio.comptabilite.project.entities.Personne;
import susitio.comptabilite.project.enums.TypeFolder;

public interface DocumentRepository extends JpaRepository<Document,Integer> {
    public List<Document> getDocumentByAnneeDeCreationAndPersonneEmmeteurDocumentAndTypeOrAnneeDeCreationAndPersonneRecepteurDocumentAndType(String annee, Personne personne, TypeFolder type , String annee1, Personne personne1, TypeFolder type1) ;
    public List<Document> getDocumentByType(TypeFolder type) ;
}
