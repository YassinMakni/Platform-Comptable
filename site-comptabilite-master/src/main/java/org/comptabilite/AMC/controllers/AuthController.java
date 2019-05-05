package org.comptabilite.AMC.controllers;

import org.comptabilite.AMC.dao.AdminRepository;
import org.comptabilite.AMC.dao.ClientRepository;
import org.comptabilite.AMC.dao.PersonneRepository;
import org.comptabilite.AMC.dao.RoleRepository;
import org.comptabilite.AMC.entities.Admin;
import org.comptabilite.AMC.entities.Client;
import org.comptabilite.AMC.entities.Personne;
import org.comptabilite.AMC.entities.Role;
import org.comptabilite.AMC.enums.RoleName;
import org.comptabilite.AMC.exchangeForm.Requests.LoginForm;
import org.comptabilite.AMC.exchangeForm.Requests.Responses.JwtResponse;
import org.comptabilite.AMC.exchangeForm.Requests.Responses.ResponseMessage;
import org.comptabilite.AMC.exchangeForm.Requests.SignUpForm;
import org.comptabilite.AMC.exchangeForm.Requests.SignUpFormAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;
import org.comptabilite.AMC.security.jwt.JwtProvider  ;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    PersonneRepository personneRepository  ;

    @Autowired
    ClientRepository clientRepository ;

    @Autowired
    AdminRepository adminRepository ;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getMotDePasse()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
        if ( personneRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        Client client = new Client(signUpRequest.getNom(),signUpRequest.getPrenom(),signUpRequest.getEmail(),signUpRequest.getTelephone(),encoder.encode(signUpRequest.getMotDePasse()) , signUpRequest.getNomSociete(), signUpRequest.getMatricule(), signUpRequest.getTelSociete(), signUpRequest.getNumRegistreCommerce(), signUpRequest.getSecteurActivite(), signUpRequest.getAdresseSociete(), signUpRequest.getEmailSociete()) ;

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        strRoles.forEach(role -> {
            switch (role) {
                case "admin":
                    Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                    roles.add(adminRole);

                    break;
                case "collaborateur":
                    Role pmRole = roleRepository.findByName(RoleName.ROLE_COLLABORATER)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                    roles.add(pmRole);

                    break;
                default:
                    Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                    roles.add(userRole);
            }
        });


        client.setRoles(roles);
        clientRepository.save(client) ;

        return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);
    }

    @PostMapping("/signup/admin")
    public ResponseEntity<?> registerAdmin(@Valid @RequestBody SignUpFormAdmin signUpRequest) {
        if ( personneRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        // Creating admin's account

        Admin admin = new Admin(signUpRequest.getNom(),signUpRequest.getPrenom(),signUpRequest.getEmail(),signUpRequest.getTelephone(),encoder.encode(signUpRequest.getMotDePasse()) );
        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        strRoles.forEach(role -> {
            switch (role) {
                case "admin":
                    Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                    roles.add(adminRole);

                    break;
                case "collaborateur":
                    Role pmRole = roleRepository.findByName(RoleName.ROLE_COLLABORATER)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                    roles.add(pmRole);

                    break;
                default:
                    Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                    roles.add(userRole);
            }
        });


        admin.setRoles(roles);
        adminRepository.save(admin) ;

        return new ResponseEntity<>(new ResponseMessage("Admin registered successfully!"), HttpStatus.OK);
    }
}
