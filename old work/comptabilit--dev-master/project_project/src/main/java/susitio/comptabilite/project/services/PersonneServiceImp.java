package susitio.comptabilite.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import susitio.comptabilite.project.dao.AdminRepository;
import susitio.comptabilite.project.dao.ClientRepository;
import susitio.comptabilite.project.dao.CollaborateurRepository;
import susitio.comptabilite.project.dao.PersonneRepository;
import susitio.comptabilite.project.entities.Personne;
import susitio.comptabilite.project.exceptions.BusinessErrorsEnum;
import susitio.comptabilite.project.exceptions.BusinessException;



@Service
public class PersonneServiceImp implements PersonneService, UserDetailsService  {
    @Autowired
    PersonneRepository personneRepository ;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    CollaborateurRepository collaborateurRepository;

    @Override
    public Personne getPersonneById(int id) {
        return personneRepository.findById(id).get() ;
    }
    
    @Override
    public Personne getPersonneByEmail(String email) {
        return personneRepository.findByEmail(email) ;
    }

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Personne user = null;
		user = personneRepository.findByEmail(email);
		if (user == null)
			throw new UsernameNotFoundException("Email not found");
		return user;
	}
	
	@Override
	public Personne getLoggedInUser() throws BusinessException {
		System.out.println("abc");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			return getPersonneByEmail(auth.getName());
		}
		throw new BusinessException(BusinessErrorsEnum.ERROR4);
	}
}
