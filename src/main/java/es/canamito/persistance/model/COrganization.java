package es.canamito.persistance.model;

import java.io.Serializable;
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

/**
 * The persistent class for the c_organization database table.
 * 
 */
@Entity
@Table(name = "c_organization")
@NamedQuery(name = "COrganization.findAll", query = "SELECT c FROM COrganization c")
public class COrganization implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "c_organization_c_organization_id_seq", sequenceName = "c_organization_c_organization_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "c_organization_c_organization_id_seq")
	@Column(name = "c_organization_id", unique = true, nullable = false)
	private Integer cOrganizationId;

	@Column(nullable = false, length = 64)
	private String name;

	// bi-directional many-to-one association to CPersonOrganization
	@OneToMany(mappedBy = "COrganization")
	private List<CPersonOrganization> CPersonOrganizations;

	public COrganization() {
	}

	public Integer getCOrganizationId() {
		return this.cOrganizationId;
	}

	public void setCOrganizationId(Integer cOrganizationId) {
		this.cOrganizationId = cOrganizationId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CPersonOrganization> getCPersonOrganizations() {
		return this.CPersonOrganizations;
	}

	public void setCPersonOrganizations(List<CPersonOrganization> CPersonOrganizations) {
		this.CPersonOrganizations = CPersonOrganizations;
	}

	public CPersonOrganization addCPersonOrganization(CPersonOrganization CPersonOrganization) {
		getCPersonOrganizations().add(CPersonOrganization);
		CPersonOrganization.setCOrganization(this);

		return CPersonOrganization;
	}

	public CPersonOrganization removeCPersonOrganization(CPersonOrganization CPersonOrganization) {
		getCPersonOrganizations().remove(CPersonOrganization);
		CPersonOrganization.setCOrganization(null);

		return CPersonOrganization;
	}

}