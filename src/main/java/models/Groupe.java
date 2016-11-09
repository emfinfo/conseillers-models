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
@Table(name = "t_groupe")
@Data
@EqualsAndHashCode(of = "pkGroupe", callSuper = false)
public class Groupe implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "pkGroupe")
  private Integer pkGroupe;

  @Basic(optional = false)
  @Column(name = "nomGroupe")
  private String nomGroupe;

//  @OneToMany(mappedBy = "groupe")
//  @OrderBy("dateEntree ASC")  
//  private List<Activite> activites;

  @Override
  public String toString() {
    return nomGroupe;
  }
  
}
