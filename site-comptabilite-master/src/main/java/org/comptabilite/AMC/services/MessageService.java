package org.comptabilite.AMC.services;

import org.comptabilite.AMC.entities.Message;
import org.comptabilite.AMC.entities.Personne;

import java.util.ArrayList;
import java.util.List;

public interface MessageService {

    public List<Message> getMessagesEmmeteur(Personne personne) ;
    public List<Message> getMessagesRecepteur(Personne personne) ;
    public Message getMessageById(int id) ;
    public void addMessage(Message message) ;
    public void deleteMessage(int id) ;
    public void luMessage(int id) ;
}
