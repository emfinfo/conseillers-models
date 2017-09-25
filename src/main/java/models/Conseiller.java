package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import helpers.CustomDateSerializer;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Classe entité.
 *
 * @author jcstritt
 */
@Entity
@Table(name = "t_conseiller")

// pour appels getList avec du SQL natif
//@SqlResultSetMapping(name = "ConseillerResult",
//  classes = {
//    @ConstructorResult(
//      targetClass = Conseiller.class,
//      columns = {
//        @ColumnResult(name = "pkConseiller"),
//        @ColumnResult(name = "nom"),
//        @ColumnResult(name = "prenom"),
//        @ColumnResult(name = "sexe"),
//        @ColumnResult(name = "origine", type = String.class),
//        @ColumnResult(name = "dateNaissance", type = Date.class),
//        @ColumnResult(name = "dateDeces", type = Date.class),
//        @ColumnResult(name = "actif", type = Boolean.class),
//        @ColumnResult(name = "fkParti"),
//        @ColumnResult(name = "fkCanton"),}
//    )
//  }
//)

@Data
@EqualsAndHashCode(of = "pkConseiller", callSuper = false)
public class Conseiller implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "pkConseiller")
  @JsonProperty("id")
  private Integer pkConseiller;

  @Basic(optional = false)
  @Column(name = "actif")
  private boolean actif;

  @Column(name = "dateNaissance")
  @Temporal(TemporalType.DATE)
  @JsonSerialize(using = CustomDateSerializer.class)
  private Date dateNaissance;

  @Column(name = "dateDeces")
  @Temporal(TemporalType.DATE)
  @JsonSerialize(using = CustomDateSerializer.class)
  private Date dateDeces;

  @Basic(optional = false)
  @Column(name = "nom")
  private String nom;

  @Basic(optional = false)
  @Column(name = "prenom")
  private String prenom;

  @Basic(optional = false)
  @Column(name = "sexe")
  private String sexe;

  @Column(name = "citoyennete")
  private String citoyennete;

  @Column(name = "lieuNaissance")
  private String lieuNaissance;

  @Column(name = "cantonNaissance")
  private String cantonNaissance;

  @Lob
  @Column(name = "mandats")
  private String mandats;

  @JoinColumn(name = "fkEtatCivil", referencedColumnName = "pkEtatCivil")
  @ManyToOne(optional = false)
  private EtatCivil etatCivil;

  @JoinColumn(name = "fkCanton", referencedColumnName = "pkCanton")
  @ManyToOne(optional = false)
  private Canton canton;

  @JoinColumn(name = "fkParti", referencedColumnName = "pkParti")
  @ManyToOne(optional = false)
  private Parti parti;

  @OneToMany(mappedBy = "conseiller", orphanRemoval=true, cascade = {CascadeType.DETACH})
  @OrderBy("dateEntree ASC")
  private List<Activite> activites;

  @Override
  public String toString() {
    return nom + " " + prenom;
//      + " ("
//      + ((dateNaissance != null) ? DateTimeLib.dateToString(dateNaissance) : "?")
//      + ((dateDeces != null) ? " - " + DateTimeLib.dateToString(dateDeces) : "") + ")"
//      + ", actif=" + ((actif)?"OUI":"NON");
  }


}
