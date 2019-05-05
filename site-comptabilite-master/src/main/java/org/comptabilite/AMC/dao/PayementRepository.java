package org.comptabilite.AMC.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.comptabilite.AMC.entities.Payment;

public interface PayementRepository extends JpaRepository<Payment,Integer> {
}
