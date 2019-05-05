package susitio.comptabilite.project.entities;

import javax.persistence.*;

import susitio.comptabilite.project.enums.TypeNotification;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id  ;
	@Enumerated(EnumType.STRING)
    private TypeNotification typeNotification;
    private String contenue ;
    private Integer idobject ;
    private Boolean vu ;
    private String dateCreation ;
    @ManyToOne
    private Personne personne;

    public Notification() {
		Date date = Calendar.getInstance().getTime();
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		String today = formatter.format(date);
    	this.vu = false ;
    	this.dateCreation = today ;
    }

	public Notification(TypeNotification typeNotification, String contenue, Integer idobject,Personne personne) {
		super();
		Date date = Calendar.getInstance().getTime();
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		String today = formatter.format(date);
		this.dateCreation = today ;
		this.typeNotification = typeNotification;
		this.contenue = contenue;
		this.idobject = idobject;
		this.vu = false;
		this.personne = personne ;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TypeNotification getTypeNotification() {
		return typeNotification;
	}

	public void setTypeNotification(TypeNotification typeNotification) {
		this.typeNotification = typeNotification;
	}

	public String getContenue() {
		return contenue;
	}

	public void setContenue(String contenue) {
		this.contenue = contenue;
	}

	public Integer getIdobject() {
		return idobject;
	}

	public void setIdobject(Integer idobject) {
		this.idobject = idobject;
	}

	public Boolean getVu() {
		return vu;
	}

	public void setVu(Boolean vu) {
		this.vu = vu;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}
}
