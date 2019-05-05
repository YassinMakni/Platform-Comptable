package susitio.comptabilite.project.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
@Entity
@PrimaryKeyJoinColumn(name="ID")
public class Collaborateur extends Personne{

}
