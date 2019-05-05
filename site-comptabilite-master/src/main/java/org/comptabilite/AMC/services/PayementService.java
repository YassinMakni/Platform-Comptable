package org.comptabilite.AMC.services;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.comptabilite.AMC.entities.Payment;

import java.util.List;

@Repository
public interface PayementService {
    public List<Payment> getPayments() ;
    public Payment getPaymentById(int id) ;
    public void addPayement(Payment payment) ;
    public void deletePayment(int id) ;
}
