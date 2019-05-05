package susitio.comptabilite.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import susitio.comptabilite.project.entities.Message;
import susitio.comptabilite.project.entities.Personne;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message,Integer> {
    public List<Message> findByPersonneEmetteur(Personne personne) ;
    public List<Message> findByPersonneRecepteur(Personne personne) ;
    public List<Message> findByPersonneRecepteurOrderByIdDesc(Personne personne) ;
}
