package susitio.comptabilite.project.entities;

import javax.persistence.*;

import susitio.comptabilite.project.enums.TypeFolder;


@Entity
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private String name;
    private String nomNews  ;
    private String path ;
    private String anneeDeCreation  ;
	@Lob
	private String contenue ;
	@Enumerated(EnumType.STRING)
    private TypeFolder type ;
    @ManyToOne
    private Personne personneEmmeteurDocument ;
	@ManyToOne
	private Personne personneRecepteurDocument ;

	public String getAnneeDeCreation() {
		return anneeDeCreation;
	}

	public void setAnneeDeCreation(String anneeDeCreation) {
		this.anneeDeCreation = anneeDeCreation;
	}

	public Personne getPersonneEmmeteurDocument() {
		return personneEmmeteurDocument;
	}

	public void setPersonneEmmeteurDocument(Personne personneEmmeteurDocument) {
		this.personneEmmeteurDocument = personneEmmeteurDocument;
	}

	public Personne getPersonneRecepteurDocument() {
		return personneRecepteurDocument;
	}

	public void setPersonneRecepteurDocument(Personne personneRecepteurDocument) {
		this.personneRecepteurDocument = personneRecepteurDocument;
	}

	public Document(String name, String path, String anneeDeCreation,String contenue, TypeFolder type,Personne personneEmmetteur, Personne personneRecepteur,String nomNews) {
		super();
		this.name = name;
		this.path = path;
		this.anneeDeCreation = anneeDeCreation;
		this.type = type;
		this.personneEmmeteurDocument = personneEmmetteur ;
		this.personneRecepteurDocument = personneRecepteur ;
		this.contenue = contenue ;
		this.nomNews = nomNews ;
	}

	public Document() {
    }
	public String getContenue() {
		return contenue;
	}

	public void setContenue(String contenue) {
		this.contenue = contenue;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public TypeFolder getType() {
		return type;
	}

	public void setType(TypeFolder type) {
		this.type = type;
	}

	public String getNomNews() {
		return nomNews;
	}

	public void setNomNews(String nomNews) {
		this.nomNews = nomNews;
	}

	@Override
	public String toString() {
		return "Document [id=" + id + ", name=" + name + ", path=" + path + ", dateCreation=" + anneeDeCreation + ", type="
				+ type + "]";
	}
    
    
}
