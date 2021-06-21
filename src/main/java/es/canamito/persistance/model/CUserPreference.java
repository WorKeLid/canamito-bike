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
 * The persistent class for the c_user_preferences database table.
 * 
 */
@Entity
@Table(name = "c_user_preferences")
@NamedQuery(name = "CUserPreference.findAll", query = "SELECT c FROM CUserPreference c")
public class CUserPreference implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "c_user_preferences_c_user_preferences_id_seq", sequenceName = "c_user_preferences_c_user_preferences_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "c_user_preferences_c_user_preferences_id_seq")
	@Column(name = "c_user_preferences_id", unique = true, nullable = false)
	private Integer cUserPreferencesId;

	// bi-directional many-to-one association to CUser
	@ManyToOne
	@JoinColumn(name = "fk_c_user_id", nullable = false)
	private CUser CUser;

	public CUserPreference() {
	}

	public Integer getCUserPreferencesId() {
		return this.cUserPreferencesId;
	}

	public void setCUserPreferencesId(Integer cUserPreferencesId) {
		this.cUserPreferencesId = cUserPreferencesId;
	}

	public CUser getCUser() {
		return this.CUser;
	}

	public void setCUser(CUser CUser) {
		this.CUser = CUser;
	}

}