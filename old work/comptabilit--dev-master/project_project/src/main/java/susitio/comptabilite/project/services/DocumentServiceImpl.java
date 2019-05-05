package susitio.comptabilite.project.services;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import susitio.comptabilite.project.dao.DocumentRepository;
import susitio.comptabilite.project.entities.Document;
import susitio.comptabilite.project.entities.Notification;
import susitio.comptabilite.project.entities.Personne;
import susitio.comptabilite.project.enums.TypeFolder;
import susitio.comptabilite.project.enums.TypeNotification;

@Service
public class DocumentServiceImpl implements DocumentService{

    private final Path rootLocation = Paths.get("src\\main\\angular\\comptable\\src\\assets\\ProfilePictureStore");

    @Autowired
    DocumentRepository documentRepository;
    @Autowired
    NotificationService notificationService ;
    @Autowired
    PersonneService personneService ;

    @Override
    public List<Document> getDocuments() {
        return documentRepository.findAll();
    }

    @Override
    public List<Document> getDossier(String annee, Personne personne, TypeFolder type) {
        return documentRepository.getDocumentByAnneeDeCreationAndPersonneEmmeteurDocumentAndTypeOrAnneeDeCreationAndPersonneRecepteurDocumentAndType(annee, personne, type,annee, personne, type);
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
    @Override
	public void uploadDocumentsNews( TypeFolder type , String annee,String contenue,Personne personneEmmetteur, Personne personneRecepteur,String nomNews) {
        Document document = new Document("","",annee,contenue,type,personneEmmetteur,personneRecepteur,nomNews);
        documentRepository.save(document) ;
    }

    @Override
    public void uploadDocumentsNewsFile(MultipartFile file , TypeFolder type , String annee,String contenue,Personne personneEmmetteur, Personne personneRecepteur,String nomNews) {
        Document document = new Document(file.getOriginalFilename(),rootLocation.toUri().toString(),annee,contenue,type,personneEmmetteur,personneRecepteur,nomNews);
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
    @Override
	public List<Document> getDocumentNews(TypeFolder typeFolder){
        return documentRepository.getDocumentByType(typeFolder) ;
    }
}