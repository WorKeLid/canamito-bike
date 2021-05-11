package es.canamito.persistance.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the c_authorization database table.
 * 
 */
@Entity
@Table(name="c_authorization")
@NamedQuery(name="CAuthorization.findAll", query="SELECT c FROM CAuthorization c")
public class CAuthorization implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="c_authorization_id")
	private Integer cAuthorizationId;

	private String name;

	@Column(name="terms_description")
	private String termsDescription;

	//bi-directional many-to-one association to CPersonAuthorization
	@OneToMany(mappedBy="CAuthorization")
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