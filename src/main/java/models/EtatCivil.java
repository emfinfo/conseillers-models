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
@Table(name = "t_etat_civil")
public class EtatCivil implements Serializable, Comparable<EtatCivil> {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "pkEtatCivil")
  @JsonProperty("id")
  private Integer pk;

  @Basic(optional = false)
  @Column(name = "abrev")
  private String abrev;

  @Basic(optional = false)
  @Column(name = "nom")
  private String nom;

  @OneToMany(mappedBy = "etatCivil", cascade = CascadeType.DETACH)
  @OrderBy("canton.abrev,nom,prenom")
  @JsonIgnore
  private List<Conseiller> conseillers;

  public EtatCivil() {
  }

  public EtatCivil(String abrev, String nom) {
    this.pk = -1;
    this.abrev = abrev;
    this.nom = nom;
    this.conseillers = null;
  }

  public String getAbrev(int len) {
    return ConvertLib.fillString(len, ' ', abrev);
  }

  @Override
  public String toString() {
    return nom;
  }

  public String toString2() {
    return InObject.fieldsToString(this);
  }

  @Override
  public int compareTo(EtatCivil o) {
    return abrev.compareTo(o.getAbrev());
  }

}
