package es.canamito.persistance.model;

import java.io.Serializable;
import java.util.ArrayList;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import es.canamito.app.model.CBAttribute;

/**
 * The persistent class for the c_user database table.
 * 
 * @author wkl
 * @version 1.210618 - Implementación y documentación de la interfaz
 *          CBWindowable
 */
@Entity
@Table(name = "c_user")
@NamedQuery(name = "CUser.findAll", query = "SELECT c FROM CUser c")
public class CUser implements Serializable, CBWindowable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "c_user_c_user_id_seq", sequenceName = "c_user_c_user_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "c_user_c_user_id_seq")
	@Column(name = "c_user_id", unique = true, nullable = false)
	private Integer cUserId;

	@Column(nullable = false, length = 128)
	private String email;

	@Column(name = "is_active", nullable = false)
	private Boolean isActive;

	@Column(name = "is_protected", nullable = false)
	private Boolean isProtected;

	@Column(nullable = false, length = 32)
	private String password;

	// bi-directional many-to-one association to CPerson
	@ManyToOne
	@JoinColumn(name = "fk_c_person_id")
	private CPerson CPerson;

	// bi-directional many-to-one association to CUserPreference
	@OneToMany(mappedBy = "CUser")
	private List<CUserPreference> CUserPreferences;

	// bi-directional many-to-one association to CUserRecovery
	@OneToMany(mappedBy = "CUser")
	private List<CUserRecovery> CUserRecoveries;

	// bi-directional many-to-one association to CUserRol
	@OneToMany(mappedBy = "CUser")
	private List<CUserRol> CUserRols;

	public CUser() {
		List<CUserRol> CUserRols = new ArrayList<CUserRol>();
		setCUserRols(CUserRols);
	}

	public Integer getCUserId() {
		return this.cUserId;
	}

	public void setCUserId(Integer cUserId) {
		this.cUserId = cUserId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsProtected() {
		return this.isProtected;
	}

	public void setIsProtected(Boolean isProtected) {
		this.isProtected = isProtected;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public CPerson getCPerson() {
		return this.CPerson;
	}

	public void setCPerson(CPerson CPerson) {
		this.CPerson = CPerson;
	}

	public List<CUserPreference> getCUserPreferences() {
		return this.CUserPreferences;
	}

	public void setCUserPreferences(List<CUserPreference> CUserPreferences) {
		this.CUserPreferences = CUserPreferences;
	}

	public CUserPreference addCUserPreference(CUserPreference CUserPreference) {
		getCUserPreferences().add(CUserPreference);
		CUserPreference.setCUser(this);

		return CUserPreference;
	}

	public CUserPreference removeCUserPreference(CUserPreference CUserPreference) {
		getCUserPreferences().remove(CUserPreference);
		CUserPreference.setCUser(null);

		return CUserPreference;
	}

	public List<CUserRecovery> getCUserRecoveries() {
		return this.CUserRecoveries;
	}

	public void setCUserRecoveries(List<CUserRecovery> CUserRecoveries) {
		this.CUserRecoveries = CUserRecoveries;
	}

	public CUserRecovery addCUserRecovery(CUserRecovery CUserRecovery) {
		getCUserRecoveries().add(CUserRecovery);
		CUserRecovery.setCUser(this);

		return CUserRecovery;
	}

	public CUserRecovery removeCUserRecovery(CUserRecovery CUserRecovery) {
		getCUserRecoveries().remove(CUserRecovery);
		CUserRecovery.setCUser(null);

		return CUserRecovery;
	}

	public List<CUserRol> getCUserRols() {
		return this.CUserRols;
	}

	public void setCUserRols(List<CUserRol> CUserRols) {
		this.CUserRols = CUserRols;
	}

	public CUserRol addCUserRol(CUserRol CUserRol) {
		getCUserRols().add(CUserRol);
		CUserRol.setCUser(this);

		return CUserRol;
	}

	public CUserRol removeCUserRol(CUserRol CUserRol) {
		getCUserRols().remove(CUserRol);
		CUserRol.setCUser(null);

		return CUserRol;
	}

	public CBAttribute getId() {
		return new CBAttribute("id", "cUserId", this.cUserId, this);
	}

	public CBAttribute getIdentifier() {
		return new CBAttribute("email", "email", this.email, this);
	}

	public List<CBAttribute> getAttributes() {
		List<CBAttribute> res = new ArrayList<CBAttribute>();

		CBAttribute email = new CBAttribute("email", "email", this.email, this);
		CBAttribute password = new CBAttribute("text", "password", this.password, this);
		CBAttribute isProtected = new CBAttribute("checkbox", "isProtected", this.isProtected, this);
		CBAttribute isActive = new CBAttribute("checkbox", "isActive", this.isActive, this);
		CBAttribute CPerson = new CBAttribute("selector", "CPerson", this.CPerson, this);

		res.add(email);
		res.add(password);
		res.add(isProtected);
		res.add(isActive);
		res.add(CPerson);

		return res;
	}

}