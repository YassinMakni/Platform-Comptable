package susitio.comptabilite.project.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import susitio.comptabilite.project.entities.Document;
import susitio.comptabilite.project.entities.Personne;
import susitio.comptabilite.project.enums.TypeFolder;

public interface DocumentService {
    public List<Document> getDocuments() ;
    public List<Document> getDossier(String annee, Personne personne, TypeFolder type) ;
    public List<Document> getDocumentNews(TypeFolder typeFolder) ;
    public Document getDocumentById(int Id) ;
    public void deleteDocument(int id) ;
	public void uploadDocuments(MultipartFile file, TypeFolder type, String annee,String contenue,Personne personneEmmetteur, Personne personneRecepteur);
    public void uploadDocumentsNews(TypeFolder type, String annee,String contenue,Personne personneEmmetteur, Personne personneRecepteur,String nomNews);
    public void uploadDocumentsNewsFile(MultipartFile file, TypeFolder type, String annee,String contenue,Personne personneEmmetteur, Personne personneRecepteur,String nomNews);

}
