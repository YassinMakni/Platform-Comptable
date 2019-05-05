package org.comptabilite.AMC.services;

import org.springframework.stereotype.Repository;
import org.comptabilite.AMC.entities.Notification;
import org.comptabilite.AMC.entities.Personne;
import org.comptabilite.AMC.enums.TypeNotification;

import java.util.List;

@Repository
public interface NotificationService {
    public void addNotification(Notification notification) ;
    public List<Notification> getNotificationByPersinneAndType(Personne personne, TypeNotification typeNotification) ;
    public void luNotification(int id);
    public void deleteNotification(int id) ;
}
