package susitio.comptabilite.project.services;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import susitio.comptabilite.project.entities.Payment;

import java.util.List;

@Repository
public interface PayementService {
    public List<Payment> getPayments() ;
    public Payment getPaymentById(int id) ;
    public void addPayement(Payment payment) ;
    public void deletePayment(int id) ;
}
