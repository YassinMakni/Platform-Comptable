package org.comptabilite.AMC.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import org.comptabilite.AMC.dao.DocumentRepository;
import org.comptabilite.AMC.dao.NotificationRepository;
import org.comptabilite.AMC.entities.Document;
import org.comptabilite.AMC.entities.Notification;
import org.comptabilite.AMC.entities.Personne;
import org.comptabilite.AMC.enums.TypeFolder;
import org.comptabilite.AMC.enums.TypeNotification;
import java.util.Iterator;

@Service
public class DocumentServiceImpl implements DocumentService{

    private final Path rootLocation = Paths.get("upload-dir");

    @Autowired
    DocumentRepository documentRepository;
    @Autowired
    NotificationService notificationService ;
    @Autowired
    PersonneService personneService ;



    @Override
    public List<Document> getDossier(String annee, Personne personne, TypeFolder type) {
        return documentRepository.getDocumentByAnneeDeCreationAndPersonneEmmeteurDocumentAndType(annee, personne, type);
    }

    @Override
    public Document getDocumentById(int id) {
        return documentRepository.findById(id).get();
    }

    @Override
    public void deleteDocument(int id) {
        documentRepository.deleteById(id);
    }



    @Override
    public void uploadDocuments(MultipartFile file , TypeFolder type , String annee,String contenue,Personne personneEmmetteur, Personne personneRecepteur) {
        Document document = new Document(file.getOriginalFilename(),rootLocation.toUri().toString(),annee,contenue,type,personneEmmetteur,personneRecepteur,"");
        String contenueNotification =  type.toString() ;
        Notification notification = new Notification(TypeNotification.document,contenueNotification,documentRepository.saveAndFlush(document).getId(),personneRecepteur) ;
        notificationService.addNotification(notification);
        String message = "";
        try {

            try {

                Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
            } catch (Exception e) {
                throw new RuntimeException("FAIL!");
            }

            message = "You successfully uploaded " + file.getOriginalFilename() + "!";

        } catch (Exception e) {
            message = "Fail to upload Profile Picture" + file.getOriginalFilename() + "!";
        }

    }
    public void uploadDocumentsNews( TypeFolder type , String annee,String contenue,Personne personneEmmetteur, Personne personneRecepteur,String nomNews) {
        Document document = new Document("","",annee,contenue,type,personneEmmetteur,personneRecepteur,nomNews);
        documentRepository.save(document) ;
    }

    @Override
    public void uploadDocumentsNewsFile(MultipartFile file , TypeFolder type ,String contenue,Personne personneEmmetteur, Personne personneRecepteur,String nomNews) {
        Document document = new Document(file.getOriginalFilename(),rootLocation.toUri().toString(),contenue,type,personneEmmetteur,personneRecepteur,nomNews);
        documentRepository.save(document) ;
        String message = "";
        try {

            try {
                System.out.println(file.getOriginalFilename());
                System.out.println(rootLocation.toUri());
                Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
            } catch (Exception e) {
                throw new RuntimeException("FAIL!");
            }

            message = "You successfully uploaded " + file.getOriginalFilename() + "!";

        } catch (Exception e) {
            message = "Fail to upload Profile Picture" + file.getOriginalFilename() + "!";
        }

    }
    public List<Document> getDocumentNews(TypeFolder typeFolder){
        return documentRepository.getDocumentByType(typeFolder) ;
    }
    public Resource loadFile(String filename) {
        try {
            Path file = rootLocation.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("FAIL!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("FAIL!");
        }
    }

}