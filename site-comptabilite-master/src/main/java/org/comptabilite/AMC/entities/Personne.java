package org.comptabilite.AMC.entities;

import java.util.*;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Personne {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String telephone ;
	private String motDePasse;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles",
			joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private Set<Role> roles = new HashSet<>();

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@OneToMany(mappedBy = "personneEmetteur")
	@JsonIgnore
	private List<Message> messagesEmetteur ;
	
	@OneToMany(mappedBy = "personneRecepteur")
	@JsonIgnore
	private List<Message> messagesRecepteur ;
	
	@OneToMany(mappedBy = "personne")
	@JsonIgnore
	private List<Notification> notifications ;
	
	@OneToMany(mappedBy = "personneEmmeteurDocument")
	@JsonIgnore
	private List<Document> documentsEmmetteur ;
	@OneToMany(mappedBy = "personneRecepteurDocument")
	@JsonIgnore
	private List<Document> documentsRecepteur ;




	public Personne() {
		this.messagesEmetteur = new ArrayList<Message>();
		this.messagesRecepteur = new ArrayList<Message>();
		this.notifications = new ArrayList<Notification>();
	}


	public Personne(String nom, String prenom, String email, String telephone, String motDePasse) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.motDePasse = motDePasse;
		this.messagesEmetteur = new ArrayList<Message>();
		this.messagesRecepteur = new ArrayList<Message>();
		this.notifications = new ArrayList<Notification>();
	}

	public List<Document> getDocumentsEmmetteur() {
		return documentsEmmetteur;
	}

	public void setDocumentsEmmetteur(List<Document> documentsEmmetteur) {
		this.documentsEmmetteur = documentsEmmetteur;
	}

	public List<Document> getDocumentsRecepteur() {
		return documentsRecepteur;
	}

	public void setDocumentsRecepteur(List<Document> documentsRecepteur) {
		this.documentsRecepteur = documentsRecepteur;
	}

	@Override
	public String toString() {
		return "Personne{" +
				"id=" + id +
				", nom='" + nom + '\'' +
				", prenom='" + prenom + '\'' +
				", email='" + email + '\'' +
				", telephone='" + telephone + '\'' +
				", motDePasse='" + motDePasse + '\'' +
				", roles=" + roles +
				", messagesEmetteur=" + messagesEmetteur +
				", messagesRecepteur=" + messagesRecepteur +
				", notifications=" + notifications +
				", documentsEmmetteur=" + documentsEmmetteur +
				", documentsRecepteur=" + documentsRecepteur +
				'}';
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public List<Message> getMessagesEmetteur() {
		return messagesEmetteur;
	}

	public void setMessagesEmetteur(List<Message> messagesEmetteur) {
		this.messagesEmetteur = messagesEmetteur;
	}

	public List<Message> getMessagesRecepteur() {
		return messagesRecepteur;
	}

	public void setMessagesRecepteur(List<Message> messagesRecepteur) {
		this.messagesRecepteur = messagesRecepteur;
	}

	public List<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}
	


	

	


}
