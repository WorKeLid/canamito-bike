package core.model;

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
	@Column(name="c_user_recovery_id", unique=true, nullable=false)
	private Integer cUserRecoveryId;

	@Column(name="recovery_code", nullable=false)
	private Integer recoveryCode;

	@Column(name="tries_left", nullable=false)
	private Integer triesLeft;

	@Column(name="valid_until", nullable=false)
	private Timestamp validUntil;

	//bi-directional many-to-one association to CUser
	@ManyToOne
	@JoinColumn(name="fk_c_user_id", nullable=false)
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