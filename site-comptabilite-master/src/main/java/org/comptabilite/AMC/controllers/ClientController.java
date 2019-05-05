package org.comptabilite.AMC.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.comptabilite.AMC.entities.*;
import org.comptabilite.AMC.enums.TypeFolder;
import org.comptabilite.AMC.enums.TypeNotification;
import org.comptabilite.AMC.services.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/client")
public class ClientController {

	private static String UPLOAD_FOLDER = "C://test//";

	@Autowired
	ClientService clientService;
	@Autowired
	DocumentService documentService;
	@Autowired
	PersonneService personneService;
	@Autowired
	DossierAnnuelService dossierAnnuelService ;
	@Autowired
	private MessageService messageService ;
	@Autowired
	private NotificationService notificationService ;


	@PostMapping("/add")
	public Client addClient(@RequestBody Client client) {
		clientService.addClient(client);
		return client;
	}
/*	@PostMapping("/upload")
	public void addDocument(@RequestParam("file") MultipartFile file,@RequestParam("type") TypeFolder type,@RequestParam("contenue") String contenue,@RequestParam("annee") String annee) {
		try {
			documentService.uploadDocuments(file,type,annee,contenue,clientService.getLoggedInClient(),clientService.getClientById(1));
		} catch (BusinessException e) {
			e.printStackTrace();
		}

	}*/
	@GetMapping("/document/dossierJuridique/{annee}")
	public List<Document> getDossierJuridique(@PathVariable final String annee){
		Client client = null;

		return documentService.getDossier(annee,client,TypeFolder.dossierJuridique) ;
	}
	@GetMapping("/document/bilanAnnuel/{annee}")
	public List<Document> getBilanAnnuel(@PathVariable final String annee){
		Client client = null;

		return documentService.getDossier(annee,client,TypeFolder.dossierAnnuel) ;
	}
	@GetMapping("/document/bilanMensuel/{annee}/{mois}")
	public List<Document> getBilanMensuel(@PathVariable final String annee,@PathVariable final TypeFolder mois ){
		Client client = null;

		return documentService.getDossier(annee,client,mois) ;
	}


	@GetMapping("/document/annee")
	public List<DossierAnnuel> getAlLDossier(){

		return null ;
	}

	@GetMapping({"/message/reception/view/all"})
	public List<Message> getAllMessagesReception(){

		return null ;
	}

	@GetMapping({"/message/Emetteur/view/all"})
	public List<Message> getAllMessagesEnvoie(){

		return null ;
	}

	@GetMapping({"message/view/{id}"})
	public Message getMessage(@PathVariable final int id){
		return messageService.getMessageById(id) ;
	}

	@PostMapping({"/message/create"})
	public void createMessage(@RequestBody Message message){

		message.setPersonneRecepteur(personneService.getPersonneById(1));
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

	@GetMapping({"/notification/vu/{id}"})
	public void vuNotification(@PathVariable final int id){
		notificationService.luNotification(id);
	}

	@GetMapping({"/notification/delete/{id}"})
	public void deleteNotification(@PathVariable final int id){
		notificationService.deleteNotification(id);
	}

/*	@GetMapping({"/notification/{type}"})
	public List<Notification> getNotification(@PathVariable final TypeNotification type){
		try {
			return notificationService.getNotificationByPersinneAndType(clientService.getLoggedInClient(),type) ;
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return  null ;
	}*/
}

