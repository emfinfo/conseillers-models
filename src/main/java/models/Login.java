package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
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
@Table(name = "t_login")
@Data
@EqualsAndHashCode(of="pkLogin", callSuper=false)
@JsonPropertyOrder({ "id", "nom", "domaine", "profil", "email", "initiales", "langue"})
public class Login implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "pkLogin")
  @JsonProperty("id")
  private Integer pkLogin;

  @Basic(optional = false)
  @Column(name = "nom")
  private String nom;

  @Column(name = "motDePasse")
  @JsonProperty(access = Access.WRITE_ONLY) // nouveau JCS 13.6.2017 au lieu de JsonIgnore
  private String motDePasse;

  @Column(name = "domaine")
  private String domaine;

  @Column(name = "profil")
  private String profil;

  @Column(name = "email")
  private String email;

  @Column(name = "initiales")
  private String initiales;

  @Column(name = "langue")
  private String langue;

  @Override
  public String toString() {
    return nom + " (" + langue + ")";
  }

}
