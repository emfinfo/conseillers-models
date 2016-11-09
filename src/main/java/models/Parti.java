package models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author jcstritt
 */
@Entity
@Table(name = "t_parti")
@Data
@EqualsAndHashCode(of="pkParti", callSuper=false)
public class Parti implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "pkParti")
  private Integer pkParti;

  @Basic(optional = false)
  @Column(name = "nomParti")
  private String nomParti;

//  @OneToMany(cascade = CascadeType.ALL, mappedBy = "parti")
//  @OrderBy("canton.abrev asc, nom ASC, prenom ASC")
//  private List<Conseiller> conseillers;

  @Override
  public String toString() {
    return nomParti;
  }
  
}
