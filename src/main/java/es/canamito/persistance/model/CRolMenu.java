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
 * The persistent class for the c_rol_menu database table.
 * 
 */
@Entity
@Table(name = "c_rol_menu")
@NamedQuery(name = "CRolMenu.findAll", query = "SELECT c FROM CRolMenu c")
public class CRolMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "c_rol_menu_c_rol_menu_id_seq", sequenceName = "c_rol_menu_c_rol_menu_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "c_rol_menu_c_rol_menu_id_seq")
	@Column(name = "c_rol_menu_id", unique = true, nullable = false)
	private Integer cRolMenuId;

	// bi-directional many-to-one association to CMenu
	@ManyToOne
	@JoinColumn(name = "fk_c_menu_id", nullable = false)
	private CMenu CMenu;

	// bi-directional many-to-one association to CRol
	@ManyToOne
	@JoinColumn(name = "fk_c_rol_id", nullable = false)
	private CRol CRol;

	public CRolMenu() {
	}

	public Integer getCRolMenuId() {
		return this.cRolMenuId;
	}

	public void setCRolMenuId(Integer cRolMenuId) {
		this.cRolMenuId = cRolMenuId;
	}

	public CMenu getCMenu() {
		return this.CMenu;
	}

	public void setCMenu(CMenu CMenu) {
		this.CMenu = CMenu;
	}

	public CRol getCRol() {
		return this.CRol;
	}

	public void setCRol(CRol CRol) {
		this.CRol = CRol;
	}

}