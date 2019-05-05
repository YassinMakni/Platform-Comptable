package org.comptabilite.AMC.security.services;


import org.comptabilite.AMC.dao.PersonneRepository;
import org.comptabilite.AMC.entities.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {



	@Autowired
	PersonneRepository personneRepository ;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		Personne user = personneRepository.findByEmail(email).orElseThrow(
				() -> new UsernameNotFoundException("User Not Found with -> username or email : " + email));
		return UserPrinciple.build(user);
	}
}