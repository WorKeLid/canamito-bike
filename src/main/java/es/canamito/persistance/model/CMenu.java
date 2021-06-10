package es.canamito.persistance.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the c_menu database table.
 * 
 * @version 1.210607 - Implementado compareTo para ordenar los enlaces de la
 *          cabecera
 */
@Entity
@Table(name = "c_menu")
@NamedQuery(name = "CMenu.findAll", query = "SELECT c FROM CMenu c")
public class CMenu implements Serializable, Comparable<CMenu> {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "c_menu_id", unique = true, nullable = false)
	private Integer cMenuId;

	@Column(length = 64)
	private String description;

	@Column(length = 64)
	private String name;

	@Column(length = 64)
	private String path;

	// bi-directional many-to-one association to CMenu
	@ManyToOne
	@JoinColumn(name = "fk_c_menu_group_id")
	private CMenu CMenu;

	// bi-directional many-to-one association to CMenu
	@OneToMany(mappedBy = "CMenu")
	private List<CMenu> CMenus;

	// bi-directional many-to-one association to CProcess
	@ManyToOne
	@JoinColumn(name = "fk_c_process_id")
	private CProcess CProcess;

	// bi-directional many-to-one association to CRolMenu
	@OneToMany(mappedBy = "CMenu")
	private List<CRolMenu> CRolMenus;

	public CMenu() {
	}

	public Integer getCMenuId() {
		return this.cMenuId;
	}

	public void setCMenuId(Integer cMenuId) {
		this.cMenuId = cMenuId;
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

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public CMenu getCMenu() {
		return this.CMenu;
	}

	public void setCMenu(CMenu CMenu) {
		this.CMenu = CMenu;
	}

	public List<CMenu> getCMenus() {
		return this.CMenus;
	}

	public void setCMenus(List<CMenu> CMenus) {
		this.CMenus = CMenus;
	}

	public CMenu addCMenus(CMenu CMenus) {
		getCMenus().add(CMenus);
		CMenus.setCMenu(this);

		return CMenus;
	}

	public CMenu removeCMenus(CMenu CMenus) {
		getCMenus().remove(CMenus);
		CMenus.setCMenu(null);

		return CMenus;
	}

	public CProcess getCProcess() {
		return this.CProcess;
	}

	public void setCProcess(CProcess CProcess) {
		this.CProcess = CProcess;
	}

	public List<CRolMenu> getCRolMenus() {
		return this.CRolMenus;
	}

	public void setCRolMenus(List<CRolMenu> CRolMenus) {
		this.CRolMenus = CRolMenus;
	}

	public CRolMenu addCRolMenus(CRolMenu CRolMenus) {
		getCRolMenus().add(CRolMenus);
		CRolMenus.setCMenu(this);

		return CRolMenus;
	}

	public CRolMenu removeCRolMenus(CRolMenu CRolMenus) {
		getCRolMenus().remove(CRolMenus);
		CRolMenus.setCMenu(null);

		return CRolMenus;
	}

	/**
	 * Los menús se ordenan por orden alfabético
	 */
	@Override
	public int compareTo(CMenu menu) {
		return this.getName().compareTo(menu.getName());
	}
}