package susitio.comptabilite.project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import susitio.comptabilite.project.enums.TypeFolder;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id ;
    private String object ;
    @Lob
    private String contenue ;
    private Boolean lu ;
    private String dateEnvoie ;
    @ManyToOne
    private Personne personneEmetteur ;
    @ManyToOne
    private Personne personneRecepteur ;

    public Message(String object, String contenue) {
        this.object = object;
        this.contenue = contenue;
        Date date = Calendar.getInstance().getTime();
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String today = formatter.format(date);
        this.lu = false ;
        this.dateEnvoie = today ;

    }

    public Message() {
        Date date = Calendar.getInstance().getTime();
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String today = formatter.format(date);
        this.lu = false ;
        this.dateEnvoie = today ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getContenue() {
        return contenue;
    }

    public void setContenue(String contenue) {
        this.contenue = contenue;
    }

    public Boolean getLu() {
        return lu;
    }

    public void setLu(Boolean lu) {
        this.lu = lu;
    }

    public String getDateEnvoie() {
        return dateEnvoie;
    }

    public void setDateEnvoie(String dateEnvoie) {
        this.dateEnvoie = dateEnvoie;
    }

    public Personne getPersonneEmetteur() {
        return personneEmetteur;
    }

    public void setPersonneEmetteur(Personne personneEmetteur) {
        this.personneEmetteur = personneEmetteur;
    }

    public Personne getPersonneRecepteur() {
        return personneRecepteur;
    }

    public void setPersonneRecepteur(Personne personneRecepteur) {
        this.personneRecepteur = personneRecepteur;
    }
}
