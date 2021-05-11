package es.canamito.persistance.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the c_user_rol database table.
 * 
 */
@Entity
@Table(name="c_user_rol")
@NamedQuery(name="CUserRol.findAll", query="SELECT c FROM CUserRol c")
public class CUserRol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="c_user_rol_id")
	private Integer cUserRolId;

	//bi-directional many-to-one association to CRol
	@ManyToOne
	@JoinColumn(name="fk_c_rol_id")
	private CRol CRol;

	//bi-directional many-to-one association to CUser
	@ManyToOne
	@JoinColumn(name="fk_c_user_id")
	private CUser CUser;

	public CUserRol() {
	}

	public Integer getCUserRolId() {
		return this.cUserRolId;
	}

	public void setCUserRolId(Integer cUserRolId) {
		this.cUserRolId = cUserRolId;
	}

	public CRol getCRol() {
		return this.CRol;
	}

	public void setCRol(CRol CRol) {
		this.CRol = CRol;
	}

	public CUser getCUser() {
		return this.CUser;
	}

	public void setCUser(CUser CUser) {
		this.CUser = CUser;
	}

}