package susitio.comptabilite.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import susitio.comptabilite.project.dao.NotificationRepository;
import susitio.comptabilite.project.entities.Notification;
import susitio.comptabilite.project.entities.Personne;
import susitio.comptabilite.project.enums.TypeNotification;

import java.util.List;


@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    private NotificationRepository notificationRepository ;

    @Override
    public void addNotification(Notification notification) {
        notificationRepository.save(notification) ;
    }

    @Override
    public List<Notification> getNotificationByPersinneAndType(Personne personne, TypeNotification typeNotification) {
        return notificationRepository.getNotificationByPersonneAndAndTypeNotification(personne,typeNotification) ;
    }

    @Override
    public void luNotification(int id) {
        Notification notification = notificationRepository.findById(id).get() ;
        notification.setVu(true);
        notificationRepository.save(notification);
    }

    @Override
    public void deleteNotification(int id) {
        notificationRepository.deleteById(id);
    }

}
