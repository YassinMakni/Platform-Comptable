package org.comptabilite.AMC.services;

import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import org.comptabilite.AMC.entities.Document;
import org.comptabilite.AMC.entities.Personne;
import org.comptabilite.AMC.enums.TypeFolder;

public interface DocumentService {

    public List<Document> getDossier(String annee, Personne personne, TypeFolder type) ;
    public List<Document> getDocumentNews(TypeFolder typeFolder) ;
    public Document getDocumentById(int Id) ;
    public Resource loadFile(String filename) ;
    public void deleteDocument(int id) ;
	public void uploadDocuments(MultipartFile file, TypeFolder type, String annee,String contenue,Personne personneEmmetteur, Personne personneRecepteur);
    public void uploadDocumentsNews(TypeFolder type, String annee,String contenue,Personne personneEmmetteur, Personne personneRecepteur,String nomNews);
    public void uploadDocumentsNewsFile(MultipartFile file, TypeFolder type,String contenue,Personne personneEmmetteur, Personne personneRecepteur,String nomNews);

}
