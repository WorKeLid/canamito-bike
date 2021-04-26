package org.canamito.core.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the c_rol_menu database table.
 * 
 */
@Entity
@Table(name="c_rol_menu")
@NamedQuery(name="CRolMenu.findAll", query="SELECT c FROM CRolMenu c")
public class CRolMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="c_rol_menu_id", unique=true, nullable=false)
	private Integer cRolMenuId;

	//bi-directional many-to-one association to CMenu
	@ManyToOne
	@JoinColumn(name="fk_c_menu_id", nullable=false)
	private CMenu CMenu;

	//bi-directional many-to-one association to CRol
	@ManyToOne
	@JoinColumn(name="fk_c_rol_id", nullable=false)
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