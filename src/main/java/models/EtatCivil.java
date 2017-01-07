/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import ch.jcsinfo.system.InObject;
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
 *
 * @author jcstritt
 */
@Entity
@Table(name = "t_etat_civil")
@Data
@EqualsAndHashCode(of = "pkEtatCivil", callSuper = false)
@JsonPropertyOrder({ "id", "abrev", "nom"})
public class EtatCivil implements Serializable, Comparable<EtatCivil> {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "pkEtatCivil")
  @JsonProperty("id")
  private Integer pkEtatCivil;

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
