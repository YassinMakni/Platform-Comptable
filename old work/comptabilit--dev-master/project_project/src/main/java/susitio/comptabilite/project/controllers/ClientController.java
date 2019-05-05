package susitio.comptabilite.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import susitio.comptabilite.project.entities.Client;
import susitio.comptabilite.project.entities.Document;
import susitio.comptabilite.project.entities.DossierAnnuel;
import susitio.comptabilite.project.entities.Message;
import susitio.comptabilite.project.entities.Notification;
import susitio.comptabilite.project.enums.TypeFolder;
import susitio.comptabilite.project.enums.TypeNotification;
import susitio.comptabilite.project.exceptions.BusinessException;
import susitio.comptabilite.project.services.ClientService;
import susitio.comptabilite.project.services.DocumentService;
import susitio.comptabilite.project.services.DossierAnnuelService;
import susitio.comptabilite.project.services.MessageService;
import susitio.comptabilite.project.services.NotificationService;
import susitio.comptabilite.project.services.PersonneService;

@CrossOrigin
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

	@GetMapping("/get")
	public UserDetails getloggedClient() throws BusinessException {
		System.out.println("abcd");
		return personneService.getLoggedInUser();
	}
	@PostMapping("/add")
	public Client addClient(@RequestBody Client client) {
		clientService.addClient(client);
		return client;
	}
	@PostMapping("/upload")
	public void addDocument(@RequestParam("file") MultipartFile file,@RequestParam("type") TypeFolder type,@RequestParam("contenue") String contenue,@RequestParam("annee") String annee) {
		try {
			documentService.uploadDocuments(file,type,annee,contenue,clientService.getLoggedInClient(),personneService.getPersonneById(1));
		} catch (BusinessException e) {
			e.printStackTrace();
		}

	}
	@GetMapping("/document/dossierJuridique/{annee}")
	public List<Document> getDossierJuridique(@PathVariable final String annee){
		Client client = null;
		try {
			client = clientService.getLoggedInClient();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return documentService.getDossier(annee,client,TypeFolder.dossierJuridique) ;
	}
	@GetMapping("/document/bilanAnnuel/{annee}")
	public List<Document> getBilanAnnuel(@PathVariable final String annee){
		Client client = null;
		try {
			client = clientService.getLoggedInClient();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return documentService.getDossier(annee,client,TypeFolder.dossierAnnuel) ;
	}
	@GetMapping("/document/bilanMensuel/{annee}/{mois}")
	public List<Document> getBilanMensuel(@PathVariable final String annee,@PathVariable final TypeFolder mois ){
		Client client = null;
		try {
			client = clientService.getLoggedInClient();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return documentService.getDossier(annee,client,mois) ;
	}
	@GetMapping("/document/{id}")
	public Document getDocument(@PathVariable final int id){
		return documentService.getDocumentById(id) ;
	}

	@GetMapping("/document/annee")
	public List<DossierAnnuel> getAlLDossier(){
		try {
			return dossierAnnuelService.getDossierAnnuelByClient(clientService.getLoggedInClient()) ;
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return null ;
	}

	@GetMapping({"/message/reception/view/all"})
	public List<Message> getAllMessagesReception(){
		try {
			return messageService.getMessagesRecepteur(clientService.getLoggedInClient());
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return null ;
	}

	@GetMapping({"/message/Emetteur/view/all"})
	public List<Message> getAllMessagesEnvoie(){
		try {
			return messageService.getMessagesEmmeteur(clientService.getLoggedInClient()) ;
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return null ;
	}

	@GetMapping({"message/view/{id}"})
	public Message getMessage(@PathVariable final int id){
		return messageService.getMessageById(id) ;
	}

	@PostMapping({"/message/create"})
	public void createMessage(@RequestBody Message message){
		try {
			message.setPersonneEmetteur(clientService.getLoggedInClient());
		} catch (BusinessException e) {
			e.printStackTrace();
		}
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

	@GetMapping({"/notification/{type}"})
	public List<Notification> getNotification(@PathVariable final TypeNotification type){
		try {
			return notificationService.getNotificationByPersinneAndType(clientService.getLoggedInClient(),type) ;
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return  null ;
	}
}

