package org.comptabilite.AMC.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.comptabilite.AMC.dao.PayementRepository;
import org.comptabilite.AMC.entities.Notification;
import org.comptabilite.AMC.entities.Payment;
import org.comptabilite.AMC.enums.TypeNotification;

import java.util.List;

@Service
public class PayementServiceImpl implements PayementService {

    @Autowired
    PayementRepository payementRepository ;

    @Autowired
    NotificationService notificationService ;


    @Override
    public List<Payment> getPayments() {
        return payementRepository.findAll();
    }

    @Override
    public Payment getPaymentById(int id) {
        return payementRepository.findById(id).get();
    }

    @Override
    public void addPayement(Payment payment) {
      /*  String contenue = "Facture crée le : " ;
        Notification notification = new Notification(TypeNotification.payement,contenue,payment.getId()) ;
        notificationService.addNotification(notification);*/
        payementRepository.save(payment) ;
    }

    @Override
    public void deletePayment(int id) {
        payementRepository.deleteById(id);
    }
}
