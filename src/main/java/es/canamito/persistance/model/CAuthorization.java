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
 * The persistent class for the c_authorization database table.
 * 
 */
@Entity
@Table(name = "c_authorization")
@NamedQuery(name = "CAuthorization.findAll", query = "SELECT c FROM CAuthorization c")
public class CAuthorization implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "c_authorization_c_authorization_id_seq", sequenceName = "c_authorization_c_authorization_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "c_authorization_c_authorization_id_seq")
	@Column(name = "c_authorization_id", unique = true, nullable = false)
	private Integer cAuthorizationId;

	@Column(nullable = false, length = 64)
	private String name;

	@Column(name = "terms_description", nullable = false, length = 1024)
	private String termsDescription;

	// bi-directional many-to-one association to CPersonAuthorization
	@OneToMany(mappedBy = "CAuthorization")
	private List<CPersonAuthorization> CPersonAuthorizations;

	public CAuthorization() {
	}

	public Integer getCAuthorizationId() {
		return this.cAuthorizationId;
	}

	public void setCAuthorizationId(Integer cAuthorizationId) {
		this.cAuthorizationId = cAuthorizationId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTermsDescription() {
		return this.termsDescription;
	}

	public void setTermsDescription(String termsDescription) {
		this.termsDescription = termsDescription;
	}

	public List<CPersonAuthorization> getCPersonAuthorizations() {
		return this.CPersonAuthorizations;
	}

	public void setCPersonAuthorizations(List<CPersonAuthorization> CPersonAuthorizations) {
		this.CPersonAuthorizations = CPersonAuthorizations;
	}

	public CPersonAuthorization addCPersonAuthorization(CPersonAuthorization CPersonAuthorization) {
		getCPersonAuthorizations().add(CPersonAuthorization);
		CPersonAuthorization.setCAuthorization(this);

		return CPersonAuthorization;
	}

	public CPersonAuthorization removeCPersonAuthorization(CPersonAuthorization CPersonAuthorization) {
		getCPersonAuthorizations().remove(CPersonAuthorization);
		CPersonAuthorization.setCAuthorization(null);

		return CPersonAuthorization;
	}

}