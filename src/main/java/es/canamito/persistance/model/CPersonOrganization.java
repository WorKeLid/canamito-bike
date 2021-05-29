package es.canamito.persistance.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the c_person_organization database table.
 * 
 */
@Entity
@Table(name="c_person_organization")
@NamedQuery(name="CPersonOrganization.findAll", query="SELECT c FROM CPersonOrganization c")
public class CPersonOrganization implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="c_person_organization_id", unique=true, nullable=false)
	private Integer cPersonOrganizationId;

	//bi-directional many-to-one association to COrganization
	@ManyToOne
	@JoinColumn(name="fk_c_organization_id", nullable=false)
	private COrganization COrganization;

	//bi-directional many-to-one association to CPerson
	@ManyToOne
	@JoinColumn(name="fk_c_person_id", nullable=false)
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