package models;

import ch.jcsinfo.system.InObject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Classe entité.
 *
 * @author jcstritt
 */
@Data
@EqualsAndHashCode(of="pk", callSuper=false)
@JsonPropertyOrder({ "id", "nom", "domaine", "profil", "email", "initiales", "langue"})

@Entity
@Table(name = "t_login")
public class Login implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "pkLogin")
  @JsonProperty("id")
  private Integer pk;

  @Basic(optional = false)
  @Column(name = "nom")
  private String nom;

  @Basic(optional = false)
  @Column(name = "domaine")
  private String domaine;

  @Basic(optional = false)
  @Column(name = "motDePasse")
  @JsonProperty(access = Access.WRITE_ONLY) // nouveau JCS 13.6.2017 au lieu de JsonIgnore
  private String motDePasse;

  @Column(name = "profil")
  private String profil;

  @Column(name = "email")
  private String email;

  @Column(name = "initiales")
  private String initiales;

  @Column(name = "langue")
  private String langue;

  @Column(name = "timestamp")
  @Temporal(TemporalType.TIMESTAMP)
  @JsonIgnore
  private Date timestamp;

  @Column(name = "version")
  @Version
  @JsonIgnore
  private long version;

  public Login(String nom, String domaine, String motDePasse, String profil, String email, String initiales, String lang) {
    this.pk = 0;
    this.nom = nom;
    this.domaine = domaine;
    this.motDePasse = motDePasse;
    this.profil = profil;
    this.email = email;
    this.initiales = initiales;
    this.langue = lang;
  }

  public Login() {
    this("", "", null, null, null, null, null);
  }

  @PrePersist
  public void prePersist() {
    version = 1;
    timestamp = new Date();
  }

  @PreUpdate
  public void preUpdate() {
    timestamp = new Date();
  }


  @Override
  public String toString() {
    return nom + " (" + langue + ")";
  }

  public String toString2() {
    return InObject.fieldsToString(this);
  }

}
