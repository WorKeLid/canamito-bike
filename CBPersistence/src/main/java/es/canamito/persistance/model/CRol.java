package es.canamito.persistance.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the c_rol database table.
 * 
 */
@Entity
@Table(name="c_rol")
@NamedQuery(name="CRol.findAll", query="SELECT c FROM CRol c")
public class CRol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="c_rol_id")
	private Integer cRolId;

	private String description;

	private String name;

	//bi-directional many-to-one association to CRolMenu
	@OneToMany(mappedBy="CRol")
	private List<CRolMenu> CRolMenus;

	//bi-directional many-to-one association to CUserRol
	@OneToMany(mappedBy="CRol")
	private List<CUserRol> CUserRols;

	public CRol() {
	}

	public Integer getCRolId() {
		return this.cRolId;
	}

	public void setCRolId(Integer cRolId) {
		this.cRolId = cRolId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CRolMenu> getCRolMenus() {
		return this.CRolMenus;
	}

	public void setCRolMenus(List<CRolMenu> CRolMenus) {
		this.CRolMenus = CRolMenus;
	}

	public CRolMenu addCRolMenus(CRolMenu CRolMenus) {
		getCRolMenus().add(CRolMenus);
		CRolMenus.setCRol(this);

		return CRolMenus;
	}

	public CRolMenu removeCRolMenus(CRolMenu CRolMenus) {
		getCRolMenus().remove(CRolMenus);
		CRolMenus.setCRol(null);

		return CRolMenus;
	}

	public List<CUserRol> getCUserRols() {
		return this.CUserRols;
	}

	public void setCUserRols(List<CUserRol> CUserRols) {
		this.CUserRols = CUserRols;
	}

	public CUserRol addCUserRol(CUserRol CUserRol) {
		getCUserRols().add(CUserRol);
		CUserRol.setCRol(this);

		return CUserRol;
	}

	public CUserRol removeCUserRol(CUserRol CUserRol) {
		getCUserRols().remove(CUserRol);
		CUserRol.setCRol(null);

		return CUserRol;
	}

}