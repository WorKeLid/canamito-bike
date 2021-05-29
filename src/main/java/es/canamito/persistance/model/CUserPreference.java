package es.canamito.persistance.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the c_user_preferences database table.
 * 
 */
@Entity
@Table(name="c_user_preferences")
@NamedQuery(name="CUserPreference.findAll", query="SELECT c FROM CUserPreference c")
public class CUserPreference implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="c_user_preferences_id", unique=true, nullable=false)
	private Integer cUserPreferencesId;

	//bi-directional many-to-one association to CUser
	@ManyToOne
	@JoinColumn(name="fk_c_user_id", nullable=false)
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