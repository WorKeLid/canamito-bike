package es.canamito.persistance.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import es.canamito.app.model.CBAttribute;

/**
 * The persistent class for the c_person database table.
 * 
 * @author wkl
 * @version 1.210618 - Implementación y documentación de la interfaz
 *          CBWindowable
 */
@Entity
@Table(name = "c_person")
@NamedQuery(name = "CPerson.findAll", query = "SELECT c FROM CPerson c")
public class CPerson implements Serializable, CBWindowable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "c_person_c_person_id_seq", sequenceName = "c_person_c_person_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "c_person_c_person_id_seq")
	@Column(name = "c_person_id", unique = true, nullable = false)
	private Integer cPersonId;

	@Column(nullable = false, length = 128)
	private String address;

	@Temporal(TemporalType.DATE)
	@Column(name = "born_date", nullable = false)
	private Date bornDate;

	@Column(nullable = false, length = 9)
	private String dni;

	@Column(name = "is_active", nullable = false)
	private Boolean isActive;

	@Column(name = "is_verified", nullable = false)
	private Boolean isVerified;

	@Column(nullable = false, length = 128)
	private String name;

	@Column(name = "phone_number", nullable = false, length = 9)
	private String phoneNumber;

	@Column(nullable = false, length = 128)
	private String surname;

	// bi-directional many-to-one association to CGroupPerson
	@OneToMany(mappedBy = "CPerson")
	private List<CGroupPerson> CGroupPersons;

	// bi-directional many-to-one association to CLocality
	@ManyToOne
	@JoinColumn(name = "fk_c_locality_id", nullable = false)
	private CLocality CLocality;

	// bi-directional many-to-one association to CPerson
	@ManyToOne
	@JoinColumn(name = "fk_authorizer_id")
	private CPerson CPerson;

	// bi-directional many-to-one association to CPerson
	@OneToMany(mappedBy = "CPerson")
	private List<CPerson> CPersons;

	// bi-directional many-to-one association to CPersonAuthorization
	@OneToMany(mappedBy = "CPerson")
	private List<CPersonAuthorization> CPersonAuthorizations;

	// bi-directional many-to-one association to CPersonOrganization
	@OneToMany(mappedBy = "CPerson")
	private List<CPersonOrganization> CPersonOrganizations;

	// bi-directional many-to-one association to CUser
	@OneToMany(mappedBy = "CPerson")
	private List<CUser> CUsers;

	public CPerson() {
	}

	public Integer getCPersonId() {
		return this.cPersonId;
	}

	public void setCPersonId(Integer cPersonId) {
		this.cPersonId = cPersonId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBornDate() {
		return this.bornDate;
	}

	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsVerified() {
		return this.isVerified;
	}

	public void setIsVerified(Boolean isVerified) {
		this.isVerified = isVerified;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<CGroupPerson> getCGroupPersons() {
		return this.CGroupPersons;
	}

	public void setCGroupPersons(List<CGroupPerson> CGroupPersons) {
		this.CGroupPersons = CGroupPersons;
	}

	public CGroupPerson addCGroupPerson(CGroupPerson CGroupPerson) {
		getCGroupPersons().add(CGroupPerson);
		CGroupPerson.setCPerson(this);

		return CGroupPerson;
	}

	public CGroupPerson removeCGroupPerson(CGroupPerson CGroupPerson) {
		getCGroupPersons().remove(CGroupPerson);
		CGroupPerson.setCPerson(null);

		return CGroupPerson;
	}

	public CLocality getCLocality() {
		return this.CLocality;
	}

	public void setCLocality(CLocality CLocality) {
		this.CLocality = CLocality;
	}

	public CPerson getCPerson() {
		return this.CPerson;
	}

	public void setCPerson(CPerson CPerson) {
		this.CPerson = CPerson;
	}

	public List<CPerson> getCPersons() {
		return this.CPersons;
	}

	public void setCPersons(List<CPerson> CPersons) {
		this.CPersons = CPersons;
	}

	public CPerson addCPerson(CPerson CPerson) {
		getCPersons().add(CPerson);
		CPerson.setCPerson(this);

		return CPerson;
	}

	public CPerson removeCPerson(CPerson CPerson) {
		getCPersons().remove(CPerson);
		CPerson.setCPerson(null);

		return CPerson;
	}

	public List<CPersonAuthorization> getCPersonAuthorizations() {
		return this.CPersonAuthorizations;
	}

	public void setCPersonAuthorizations(List<CPersonAuthorization> CPersonAuthorizations) {
		this.CPersonAuthorizations = CPersonAuthorizations;
	}

	public CPersonAuthorization addCPersonAuthorization(CPersonAuthorization CPersonAuthorization) {
		getCPersonAuthorizations().add(CPersonAuthorization);
		CPersonAuthorization.setCPerson(this);

		return CPersonAuthorization;
	}

	public CPersonAuthorization removeCPersonAuthorization(CPersonAuthorization CPersonAuthorization) {
		getCPersonAuthorizations().remove(CPersonAuthorization);
		CPersonAuthorization.setCPerson(null);

		return CPersonAuthorization;
	}

	public List<CPersonOrganization> getCPersonOrganizations() {
		return this.CPersonOrganizations;
	}

	public void setCPersonOrganizations(List<CPersonOrganization> CPersonOrganizations) {
		this.CPersonOrganizations = CPersonOrganizations;
	}

	public CPersonOrganization addCPersonOrganization(CPersonOrganization CPersonOrganization) {
		getCPersonOrganizations().add(CPersonOrganization);
		CPersonOrganization.setCPerson(this);

		return CPersonOrganization;
	}

	public CPersonOrganization removeCPersonOrganization(CPersonOrganization CPersonOrganization) {
		getCPersonOrganizations().remove(CPersonOrganization);
		CPersonOrganization.setCPerson(null);

		return CPersonOrganization;
	}

	public List<CUser> getCUsers() {
		return this.CUsers;
	}

	public void setCUsers(List<CUser> CUsers) {
		this.CUsers = CUsers;
	}

	public CUser addCUser(CUser CUser) {
		getCUsers().add(CUser);
		CUser.setCPerson(this);

		return CUser;
	}

	public CUser removeCUser(CUser CUser) {
		getCUsers().remove(CUser);
		CUser.setCPerson(null);

		return CUser;
	}

	public CBAttribute getId() {
		return new CBAttribute("id", "cPersonId", this.cPersonId, this);
	}

	public CBAttribute getIdentifier() {
		String identifier = this.surname + ", " + this.name;
		return new CBAttribute("text", "cPerson", identifier, this);
	}

	public List<CBAttribute> getAttributes() {
		List<CBAttribute> res = new ArrayList<CBAttribute>();

		CBAttribute dni = new CBAttribute("text", "dni", this.dni, this);
		CBAttribute name = new CBAttribute("text", "name", this.name, this);
		CBAttribute surname = new CBAttribute("text", "surname", this.surname, this);
		CBAttribute bornDate = new CBAttribute("date", "bornDate", this.bornDate, this);
		CBAttribute address = new CBAttribute("text", "address", this.address, this);
		CBAttribute phoneNumber = new CBAttribute("text", "phoneNumber", this.phoneNumber, this);
		CBAttribute isVerified = new CBAttribute("text", "isVerfied", this.isVerified, this);
		CBAttribute isActive = new CBAttribute("text", "isActive", this.isActive, this);
		CBAttribute CAuthorizer = new CBAttribute("selector", "CPerson", this.CPerson, this);
		CBAttribute CLocality = new CBAttribute("selector", "CLocality", this.CLocality, this);

		res.add(dni);
		res.add(name);
		res.add(surname);
		res.add(bornDate);
		res.add(address);
		res.add(phoneNumber);
		res.add(isVerified);
		res.add(isActive);
		res.add(CAuthorizer);
		res.add(CLocality);

		return res;
	}
}