package models;

import ch.jcsinfo.system.InObject;
import ch.jcsinfo.util.ConvertLib;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Classe entité.
 *
 * @author jcstritt
 */
@Data
@EqualsAndHashCode(of = "pk", callSuper = false)
@JsonPropertyOrder({ "id", "abrev", "nom"})

@Entity
@Table(name = "t_groupe")
public class Groupe implements Serializable, Comparable<Groupe> {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "pkGroupe")
  @JsonProperty("id")
  private Integer pk;

  @Basic(optional = false)
  @Column(name = "abrev")
  private String abrev;

  @Basic(optional = false)
  @Column(name = "nom")
  private String nom;

  @OneToMany(mappedBy = "groupe", cascade = CascadeType.DETACH)
  @OrderBy("dateEntree ASC,conseiller.nom,conseiller.prenom")
  @JsonIgnore
  private List<Activite> activites;

  public Groupe() {
  }

  public Groupe(String abrev, String nom) {
    this.pk = -1;
    this.abrev = abrev;
    this.nom = nom;
    this.activites = null;
  }

  public String getAbrev(int len) {
    return ConvertLib.fillString(len, ' ', abrev);
  }

  @Override
  public String toString() {
    return abrev;
  }

  public String toString2() {
    return InObject.fieldsToString(this);
  }

  @Override
  public int compareTo(Groupe o) {
    return abrev.compareTo(o.getAbrev());
  }

}
