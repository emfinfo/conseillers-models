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
@Entity
@Table(name = "t_conseil")
@Data
@EqualsAndHashCode(of="pkConseil", callSuper=false)
@JsonPropertyOrder({ "id", "abrev", "nom"})
public class Conseil implements Serializable, Comparable<Conseil> {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "pkConseil")
  @JsonProperty("id")
  private Integer pkConseil;

  @Basic(optional = false)
  @Column(name = "abrev")
  private String abrev;

  @Basic(optional = false)
  @Column(name = "nom")
  private String nom;

  @OneToMany(mappedBy = "conseil", cascade = CascadeType.DETACH)
  @OrderBy("dateEntree ASC")
  @JsonIgnore
  private List<Activite> activites;

  public Conseil() {
  }

  public Conseil(String abrev, String nom) {
    this.pkConseil = -1;
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
  public int compareTo(Conseil o) {
    return abrev.compareTo(o.getAbrev());
  }

}
