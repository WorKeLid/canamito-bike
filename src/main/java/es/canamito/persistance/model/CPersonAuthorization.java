package es.canamito.persistance.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the c_person_authorization database table.
 * 
 */
@Entity
@Table(name="c_person_authorization")
@NamedQuery(name="CPersonAuthorization.findAll", query="SELECT c FROM CPersonAuthorization c")
public class CPersonAuthorization implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="c_person_authorization_id", unique=true, nullable=false)
	private Integer cPersonAuthorizationId;

	@Temporal(TemporalType.DATE)
	@Column(name="authorization_date", nullable=false)
	private Date authorizationDate;

	@Column(name="is_accepted", nullable=false)
	private Boolean isAccepted;

	//bi-directional many-to-one association to CAuthorization
	@ManyToOne
	@JoinColumn(name="fk_c_authorization_id", nullable=false)
	private CAuthorization CAuthorization;

	//bi-directional many-to-one association to CPerson
	@ManyToOne
	@JoinColumn(name="fk_c_person_id", nullable=false)
	private CPerson CPerson;

	public CPersonAuthorization() {
	}

	public Integer getCPersonAuthorizationId() {
		return this.cPersonAuthorizationId;
	}

	public void setCPersonAuthorizationId(Integer cPersonAuthorizationId) {
		this.cPersonAuthorizationId = cPersonAuthorizationId;
	}

	public Date getAuthorizationDate() {
		return this.authorizationDate;
	}

	public void setAuthorizationDate(Date authorizationDate) {
		this.authorizationDate = authorizationDate;
	}

	public Boolean getIsAccepted() {
		return this.isAccepted;
	}

	public void setIsAccepted(Boolean isAccepted) {
		this.isAccepted = isAccepted;
	}

	public CAuthorization getCAuthorization() {
		return this.CAuthorization;
	}

	public void setCAuthorization(CAuthorization CAuthorization) {
		this.CAuthorization = CAuthorization;
	}

	public CPerson getCPerson() {
		return this.CPerson;
	}

	public void setCPerson(CPerson CPerson) {
		this.CPerson = CPerson;
	}

}