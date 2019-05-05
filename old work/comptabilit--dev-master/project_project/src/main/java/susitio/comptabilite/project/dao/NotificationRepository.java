package susitio.comptabilite.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import susitio.comptabilite.project.entities.Notification;
import susitio.comptabilite.project.entities.Personne;
import susitio.comptabilite.project.enums.TypeNotification;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification,Integer> {
    public List<Notification> getNotificationByPersonneAndAndTypeNotification(Personne personne, TypeNotification typeNotification) ;
}
