package susitio.comptabilite.project.services;

import org.springframework.stereotype.Repository;
import susitio.comptabilite.project.entities.Admin;

import java.util.List;

@Repository
public interface AdminService {

    public List<Admin> getAdmins();

    public Admin getAdminById(int id);

    public void  addAdmin(Admin admin);

    public void deleteAdmin(int id);
}
