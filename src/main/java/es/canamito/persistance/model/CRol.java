package es.canamito.persistance.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import es.canamito.app.model.CBAttribute;

/**
 * The persistent class for the c_rol database table.
 * 
 * @author wkl
 * @version 1.210618 - Implementación y documentación de la interfaz
 *          CBWindowable
 */
@Entity
@Table(name = "c_rol")
@NamedQuery(name = "CRol.findAll", query = "SELECT c FROM CRol c")
public class CRol implements Serializable, CBWindowable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "c_rol_c_rol_id_seq", sequenceName = "c_rol_c_rol_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "c_rol_c_rol_id_seq")
	@Column(name = "c_rol_id", unique = true, nullable = false)
	private Integer cRolId;

	@Column(length = 255)
	private String description;

	@Column(nullable = false, length = 64)
	private String name;

	// bi-directional many-to-one association to CRolMenu
	@OneToMany(mappedBy = "CRol")
	private List<CRolMenu> CRolMenus;

	// bi-directional many-to-one association to CUserRol
	@OneToMany(mappedBy = "CRol")
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

	public CBAttribute getId() {
		return new CBAttribute("id", "cRolId", this.cRolId, this);
	}

	public CBAttribute getIdentifier() {
		return new CBAttribute("text", "name", this.name, this);
	}

	public List<CBAttribute> getAttributes() {
		List<CBAttribute> res = new ArrayList<CBAttribute>();

		CBAttribute name = new CBAttribute("text", "name", this.name, this);
		CBAttribute description = new CBAttribute("text", "description", this.description, this);

		res.add(name);
		res.add(description);

		return res;
	}

}