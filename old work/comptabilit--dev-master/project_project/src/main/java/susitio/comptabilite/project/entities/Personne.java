package susitio.comptabilite.project.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Personne implements UserDetails{
	
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
	
	@ManyToOne(cascade={CascadeType.REFRESH,CascadeType.MERGE,CascadeType.PERSIST})
	private Role role;



	public Personne() {
		this.messagesEmetteur = new ArrayList<Message>();
		this.messagesRecepteur = new ArrayList<Message>();
		this.notifications = new ArrayList<Notification>();
	}

	public Personne(String nom, String prenom, String email, String telephone,
			String motDePasse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.motDePasse = motDePasse;
		this.messagesEmetteur = new ArrayList<Message>();
		this.messagesRecepteur = new ArrayList<Message>();
		this.notifications = new ArrayList<Notification>();

	}

	public Personne(String nom, String prenom, String email, String telephone,
			String motDePasse, Role role) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.motDePasse = motDePasse;
		this.messagesEmetteur = new ArrayList<Message>();
		this.messagesRecepteur = new ArrayList<Message>();
		this.notifications = new ArrayList<Notification>();
		this.role=role;

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
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	@JsonIgnore
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		Role role = this.getRole();
		authorities.add(new SimpleGrantedAuthority(role.getName()));
		return authorities;
	}
	@JsonIgnore
	@Override
	public String getPassword() {
		return this.getMotDePasse();
	}
	@JsonIgnore
	@Override
	public String getUsername() {
		return this.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	
	

	


}
