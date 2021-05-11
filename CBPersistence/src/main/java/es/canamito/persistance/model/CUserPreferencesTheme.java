package es.canamito.persistance.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the c_user_preferences_theme database table.
 * 
 */
@Entity
@Table(name="c_user_preferences_theme")
@NamedQuery(name="CUserPreferencesTheme.findAll", query="SELECT c FROM CUserPreferencesTheme c")
public class CUserPreferencesTheme implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="c_user_preferences_theme_id")
	private Integer cUserPreferencesThemeId;

	//bi-directional many-to-one association to CTheme
	@ManyToOne
	@JoinColumn(name="fk_c_theme_id")
	private CTheme CTheme;

	//bi-directional many-to-one association to CUserPreference
	@ManyToOne
	@JoinColumn(name="fk_c_user_preferences_id")
	private CUserPreference CUserPreference;

	public CUserPreferencesTheme() {
	}

	public Integer getCUserPreferencesThemeId() {
		return this.cUserPreferencesThemeId;
	}

	public void setCUserPreferencesThemeId(Integer cUserPreferencesThemeId) {
		this.cUserPreferencesThemeId = cUserPreferencesThemeId;
	}

	public CTheme getCTheme() {
		return this.CTheme;
	}

	public void setCTheme(CTheme CTheme) {
		this.CTheme = CTheme;
	}

	public CUserPreference getCUserPreference() {
		return this.CUserPreference;
	}

	public void setCUserPreference(CUserPreference CUserPreference) {
		this.CUserPreference = CUserPreference;
	}

}