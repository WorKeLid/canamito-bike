package es.canamito.persistance.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the c_user_recovery database table.
 * 
 */
@Entity
@Table(name="c_user_recovery")
@NamedQuery(name="CUserRecovery.findAll", query="SELECT c FROM CUserRecovery c")
public class CUserRecovery implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="c_user_recovery_id")
	private Integer cUserRecoveryId;

	@Column(name="recovery_code")
	private Integer recoveryCode;

	@Column(name="tries_left")
	private Integer triesLeft;

	@Column(name="valid_until")
	private Timestamp validUntil;

	//bi-directional many-to-one association to CUser
	@ManyToOne
	@JoinColumn(name="fk_c_user_id")
	private CUser CUser;

	public CUserRecovery() {
	}

	public Integer getCUserRecoveryId() {
		return this.cUserRecoveryId;
	}

	public void setCUserRecoveryId(Integer cUserRecoveryId) {
		this.cUserRecoveryId = cUserRecoveryId;
	}

	public Integer getRecoveryCode() {
		return this.recoveryCode;
	}

	public void setRecoveryCode(Integer recoveryCode) {
		this.recoveryCode = recoveryCode;
	}

	public Integer getTriesLeft() {
		return this.triesLeft;
	}

	public void setTriesLeft(Integer triesLeft) {
		this.triesLeft = triesLeft;
	}

	public Timestamp getValidUntil() {
		return this.validUntil;
	}

	public void setValidUntil(Timestamp validUntil) {
		this.validUntil = validUntil;
	}

	public CUser getCUser() {
		return this.CUser;
	}

	public void setCUser(CUser CUser) {
		this.CUser = CUser;
	}

}