package es.canamito.persistance.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the c_user_rol database table.
 * 
 */
@Entity
@Table(name = "c_user_rol")
@NamedQuery(name = "CUserRol.findAll", query = "SELECT c FROM CUserRol c")
public class CUserRol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "c_user_rol_c_user_rol_id_seq", sequenceName = "c_user_rol_c_user_rol_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "c_user_rol_c_user_rol_id_seq")
	@Column(name = "c_user_rol_id", unique = true, nullable = false)
	private Integer cUserRolId;

	// bi-directional many-to-one association to CRol
	@ManyToOne
	@JoinColumn(name = "fk_c_rol_id", nullable = false)
	private CRol CRol;

	// bi-directional many-to-one association to CUser
	@ManyToOne
	@JoinColumn(name = "fk_c_user_id", nullable = false)
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