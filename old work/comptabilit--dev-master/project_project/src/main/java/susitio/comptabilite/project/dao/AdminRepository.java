package susitio.comptabilite.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import susitio.comptabilite.project.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin,Integer> {

}
