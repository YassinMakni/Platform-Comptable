package org.comptabilite.AMC.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.comptabilite.AMC.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin,Integer> {

}
