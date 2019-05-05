package susitio.comptabilite.project.services;

import org.springframework.stereotype.Repository;
import susitio.comptabilite.project.entities.Notification;
import susitio.comptabilite.project.entities.Personne;
import susitio.comptabilite.project.enums.TypeNotification;

import java.util.List;

@Repository
public interface NotificationService {
    public void addNotification(Notification notification) ;
    public List<Notification> getNotificationByPersinneAndType(Personne personne, TypeNotification typeNotification) ;
    public void luNotification(int id);
    public void deleteNotification(int id) ;
}
