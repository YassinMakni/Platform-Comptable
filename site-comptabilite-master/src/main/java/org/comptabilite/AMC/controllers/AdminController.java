package org.comptabilite.AMC.controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import org.comptabilite.AMC.dao.DocumentRepository;
import org.comptabilite.AMC.entities.*;
import org.comptabilite.AMC.enums.TypeFolder;
import org.comptabilite.AMC.enums.TypeNotification;
import org.comptabilite.AMC.services.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private ClientService clientService ;

    @Autowired
    private CollaborateurService collaborateurService ;

    @Autowired
    private AdminService adminService ;

    @Autowired
    private MessageService messageService ;

    @Autowired
    private NotificationService notificationService ;

    @Autowired
    private PersonneService personneService ;

    @Autowired
    private DocumentRepository documentRepository ;

    @Autowired
    private DocumentService documentService ;

    @Autowired
    DossierAnnuelService dossierAnnuelService ;



    /* ------------------------------------------------------------------------------------------------------------------


                                                 CRUD CLIENTS SECTION


    ------------------------------------------------------------------------------------------------------------- */

    @GetMapping({"/client/{id}"})
    public Client getPersonne(@PathVariable final int id){
        System.out.println(id);
        return clientService.getClientById(id) ;
    }

    @GetMapping({"/getAllClient"})
    public List<Client> getAllClient(){
        return clientService.getClients() ;
    }

    @GetMapping({"/client/validation/{valide}"})
    public List<Client> getClientByValidation(@PathVariable final Boolean valide){
        return clientService.getNonValidationClients(valide) ;
    }

    @GetMapping({"/client/view/{id}"})
    public Client getClientById(@PathVariable final int id){
        return clientService.getClientById(id) ;
    }

    @DeleteMapping({"/client/delete/{id}"})
    public void deleteClient(@PathVariable final int id){
        clientService.deleteClient(id);
    }

    @GetMapping({"/client/approuver/{id}"})
    public void approuveCleint(@PathVariable final int id){
        clientService.approuverClient(id);
    }

    @GetMapping({"/client/desapprouver/{id}"})
    public void desapprouveCleint(@PathVariable final int id){
        clientService.desapprouverClient(id);
    }

    /* ------------------------------------------------------------------------------------------------------------------


                                                    CRUD CONTRIBUTORS SECTION


       ------------------------------------------------------------------------------------------------------------- */

    @GetMapping({"/collaborateur/view/all"})
    public List<Collaborateur> getAllCollaborateur(){
        return collaborateurService.getCollaborateurs() ;
    }

    @GetMapping({"/collaborateur/view/{id}"})
    public Collaborateur getCollaborateurById(@PathVariable final int id){
        return collaborateurService.getCollaborateurById(id) ;
    }

    @DeleteMapping({"/collaborateur/delete/{id}"})
    public void deleteCollaborateur(@PathVariable final int id){
        collaborateurService.deleteCollaborateur(id);
    }

    @PostMapping({"/collaborateur/add"})
    public void createCollaborateur(@RequestBody Collaborateur collaborateur){
        collaborateurService.addCollaborateur(collaborateur);
    }

    @PutMapping({"/collaborateur/update"})
    public void updateCollaborateur(@RequestBody Collaborateur collaborateur){
        collaborateurService.addCollaborateur(collaborateur);
    }


    /* ------------------------------------------------------------------------------------------------------------------


                                                    CRUD DOCUMENTS SECTION


       ------------------------------------------------------------------------------------------------------------- */

        /*----------------------------------------------Partie administrative ------------------------------------- */
    @PostMapping("/upload")
    public void addDocument(@RequestParam("file") MultipartFile file,@RequestParam("type") TypeFolder type,@RequestParam("contenue") String contenue,@RequestParam("annee") String annee, @RequestParam("id") int id) {

        documentService.uploadDocuments(file, type, annee, contenue, personneService.getPersonneById(1), personneService.getPersonneById(1));
    }

    @GetMapping({"/document/delete/{id}"})
    public void deleteDocument(@PathVariable final int id){
        Document document = documentRepository.getOne(id) ;
        File file = new File("upload-dir\\" + document.getName());
        documentRepository.delete(document);
        if(file.delete()){
            System.out.println(file.getName() + " is deleted!");

        }else{
            System.out.println("Delete operation is failed.");
        }

    }





    @GetMapping("/document/dossierJuridique/{annee}/{id}")
    public List<Document> getDossierJuridique(@PathVariable final String annee, @PathVariable final  int id){

      //  List<String> files = documentService.createFilesList();
        Personne personne = personneService.getPersonneById(id) ;
        return documentService.getDossier(annee,personne,TypeFolder.dossierJuridique) ;

    }
/*    @GetMapping("/document/dossierJuridique/{annee}/{id}")
    public ResponseEntity<List<String>> getDossierJuridique(@PathVariable final String annee, @PathVariable final  int id){
        Personne personne = personneService.getPersonneById(id) ;
        List<String> files = documentService.createFilesList(documentService.getDossier(annee,personne,TypeFolder.dossierJuridique));
        List<String> fileNames = files
                .stream().map(fileName -> MvcUriComponentsBuilder
                        .fromMethodName(AdminController.class, "getFile", fileName).build().toString())
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(fileNames);

    } */

    @GetMapping("/document/bilanAnnuel/{annee}/{id}")
    public List<Document> getBilanAnnuel(@PathVariable final String annee, @PathVariable final  int id){
        Client client = null;

        return documentService.getDossier(annee,client,TypeFolder.dossierAnnuel) ;
    }
    @GetMapping("/document/bilanMensuel/{annee}/{mois}/{id}")
    public List<Document> getBilanMensuel(@PathVariable final String annee,@PathVariable final TypeFolder mois , @PathVariable final  int id){
        Client client = null;

        return documentService.getDossier(annee,client,mois) ;
    }

    @GetMapping("/document/annee/{id}")
    public List<DossierAnnuel> getAlLDossier(@PathVariable final int id){
        System.out.println(dossierAnnuelService.getDossierAnnuelByClient(clientService.getClientById(id)));
        return dossierAnnuelService.getDossierAnnuelByClient(clientService.getClientById(id)) ;
    }

    @GetMapping("/document/annee/cloturer/{id}")
    public void anneeCloturer(@PathVariable final int id){
        dossierAnnuelService.closeYear(id);
    }
    @GetMapping("/document/annee/activer/{id}")
    public void anneeActiver(@PathVariable final int id){
        dossierAnnuelService.openYear(id);
    }

    @GetMapping("/document/{id}")
    public Document getDocument(@PathVariable final int id){
        Document document = documentService.getDocumentById(id) ;
        Resource file = documentService.loadFile(document.getName());
        return document ;
    }

    /*------------------------------- Partie non administrative ( partie vitrine ) ------------------------------------- */


    @PostMapping("/upload/News")
    public void addDocumentNews(@RequestParam("type") TypeFolder type, @RequestParam("contenue") String contenue, @RequestParam("annee") String annee, @RequestParam("nomNews") String nomNews) {
        documentService.uploadDocumentsNews(type,annee,contenue,adminService.getAdminById(1),adminService.getAdminById(1),nomNews);
    }

    @PostMapping("/upload/news/file")
    public void addDocumentNewsFile(@RequestParam("file") MultipartFile file, @RequestParam("type") TypeFolder type, @RequestParam("contenue") String contenue, @RequestParam("nomNews") String nomNews) {
        documentService.uploadDocumentsNewsFile(file,type,contenue,adminService.getAdminById(1),adminService.getAdminById(1),nomNews);

    }
    @GetMapping("/document/news/{type}")
    public List<Document> getDocumentNews(@PathVariable final  TypeFolder type){
        return documentService.getDocumentNews(type) ;
    }




    /* ------------------------------------------------------------------------------------------------------------------


                                                 CRUD MESSAGES SECTION


    ------------------------------------------------------------------------------------------------------------- */


    @GetMapping({"/message/reception/view/all"})
    public List<Message> getAllMessagesReception(){
        return messageService.getMessagesRecepteur(personneService.getPersonneById(1));
    }

    @GetMapping({"/message/Emetteur/view/all"})
    public List<Message> getAllMessagesEnvoie(){
            return messageService.getMessagesEmmeteur(personneService.getPersonneById(1)) ;

    }

    @GetMapping({"message/view/{id}"})
    public Message getMessage(@PathVariable final int id){
        return messageService.getMessageById(id) ;
    }

    @PostMapping({"/message/create/{id}"})
    public void createMessage(@RequestBody Message message,@PathVariable final  int id){
        message.setPersonneEmetteur(personneService.getPersonneById(1));
        message.setPersonneRecepteur(personneService.getPersonneById(id));
        messageService.addMessage(message);
    }

    @DeleteMapping({"message/delete/{id}"})
    public void deleteMessage(@PathVariable final int id){
        messageService.deleteMessage(id);
    }

    @GetMapping({"/message/lu/{id}"})
    public void luMessage(@PathVariable final int id){
        messageService.luMessage(id);
    }
}
