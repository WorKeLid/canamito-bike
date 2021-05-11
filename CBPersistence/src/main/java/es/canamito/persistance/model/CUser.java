package es.canamito.persistance.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the c_user database table.
 * 
 */
@Entity
@Table(name="c_user")
@NamedQuery(name="CUser.findAll", query="SELECT c FROM CUser c")
public class CUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="c_user_id")
	private Integer cUserId;

	private String email;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_protected")
	private Boolean isProtected;

	private String password;

	//bi-directional many-to-one association to CPerson
	@ManyToOne
	@JoinColumn(name="fk_c_person_id")
	private CPerson CPerson;

	//bi-directional many-to-one association to CUserPreference
	@OneToMany(mappedBy="CUser")
	private List<CUserPreference> CUserPreferences;

	//bi-directional many-to-one association to CUserRecovery
	@OneToMany(mappedBy="CUser")
	private List<CUserRecovery> CUserRecoveries;

	//bi-directional many-to-one association to CUserRol
	@OneToMany(mappedBy="CUser")
	private List<CUserRol> CUserRols;

	public CUser() {
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

}