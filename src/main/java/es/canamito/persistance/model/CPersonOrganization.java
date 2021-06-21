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
 * The persistent class for the c_person_organization database table.
 * 
 */
@Entity
@Table(name = "c_person_organization")
@NamedQuery(name = "CPersonOrganization.findAll", query = "SELECT c FROM CPersonOrganization c")
public class CPersonOrganization implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "c_person_organization_c_person_organization_id_seq", sequenceName = "c_person_organization_c_person_organization_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "c_person_organization_c_person_organization_id_seq")
	@Column(name = "c_person_organization_id", unique = true, nullable = false)
	private Integer cPersonOrganizationId;

	// bi-directional many-to-one association to COrganization
	@ManyToOne
	@JoinColumn(name = "fk_c_organization_id", nullable = false)
	private COrganization COrganization;

	// bi-directional many-to-one association to CPerson
	@ManyToOne
	@JoinColumn(name = "fk_c_person_id", nullable = false)
	private CPerson CPerson;

	public CPersonOrganization() {
	}

	public Integer getCPersonOrganizationId() {
		return this.cPersonOrganizationId;
	}

	public void setCPersonOrganizationId(Integer cPersonOrganizationId) {
		this.cPersonOrganizationId = cPersonOrganizationId;
	}

	public COrganization getCOrganization() {
		return this.COrganization;
	}

	public void setCOrganization(COrganization COrganization) {
		this.COrganization = COrganization;
	}

	public CPerson getCPerson() {
		return this.CPerson;
	}

	public void setCPerson(CPerson CPerson) {
		this.CPerson = CPerson;
	}

}