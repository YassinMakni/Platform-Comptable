package susitio.comptabilite.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import susitio.comptabilite.project.entities.Collaborateur;
import susitio.comptabilite.project.services.CollaborateurService;

@RestController
@RequestMapping("/api/collaborateur")
public class CollaborateurController {

    @Autowired
    CollaborateurService collaborateurService ;

    @PostMapping("/add")
    public void addCollaborateur(@RequestBody Collaborateur collaborateur){
        collaborateurService.addCollaborateur(collaborateur);
    }
    @GetMapping("getAll")
    public List<Collaborateur> getAllCollaborateurs(){
        return collaborateurService.getCollaborateurs() ;
    }
    @DeleteMapping("/delete/{id}")
    public void deleteCollaborateur(@PathVariable final int id){
        collaborateurService.deleteCollaborateur(id);
    }
}
