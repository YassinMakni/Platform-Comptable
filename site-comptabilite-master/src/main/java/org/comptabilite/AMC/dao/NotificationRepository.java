package org.comptabilite.AMC.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.comptabilite.AMC.entities.Notification;
import org.comptabilite.AMC.entities.Personne;
import org.comptabilite.AMC.enums.TypeNotification;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification,Integer> {
    public List<Notification> getNotificationByPersonneAndAndTypeNotification(Personne personne, TypeNotification typeNotification) ;
}
