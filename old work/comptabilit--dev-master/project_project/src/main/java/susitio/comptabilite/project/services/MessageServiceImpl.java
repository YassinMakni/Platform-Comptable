package susitio.comptabilite.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import susitio.comptabilite.project.dao.MessageRepository;
import susitio.comptabilite.project.entities.Client;
import susitio.comptabilite.project.entities.Message;
import susitio.comptabilite.project.entities.Notification;
import susitio.comptabilite.project.entities.Personne;
import susitio.comptabilite.project.enums.TypeNotification;

import java.util.ArrayList;
import java.util.List;



@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageRepository messageRepository ;

    @Autowired
    NotificationService notificationService ;

    @Autowired
    ClientService clientService ;

    @Autowired
    PersonneService personneService ;

    @Override
    public List<Message> getMessagesEmmeteur(Personne personne) {

        return messageRepository.findByPersonneEmetteur(personne);
    }

    @Override
    public List<Message> getMessagesRecepteur(Personne personne) {
        return messageRepository.findByPersonneRecepteurOrderByIdDesc(personne);
    }

    @Override
    public Message getMessageById(int id) {
        return messageRepository.findById(id).get();
    }

    @Override
    public void addMessage(Message message) {
        Client client = clientService.getClientById(message.getPersonneEmetteur().getId()) ;
        String contenueNotification = message.getObject() ;
        Notification notification = new Notification(TypeNotification.message,contenueNotification,messageRepository.saveAndFlush(message).getId(),personneService.getPersonneById(1)) ;
        notificationService.addNotification(notification);


    }

    @Override
    public void deleteMessage(int id) {
        messageRepository.deleteById(id);
    }

    @Override
    public void luMessage(int id) {
        Message message = messageRepository.findById(id).get() ;
        message.setLu(true);
        messageRepository.save(message) ;
    }

}
