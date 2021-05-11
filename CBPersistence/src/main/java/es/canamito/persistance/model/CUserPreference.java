package es.canamito.persistance.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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
	@Column(name="c_user_preferences_id")
	private Integer cUserPreferencesId;

	//bi-directional many-to-one association to CUser
	@ManyToOne
	@JoinColumn(name="fk_c_user_id")
	private CUser CUser;

	//bi-directional many-to-one association to CUserPreferencesTheme
	@OneToMany(mappedBy="CUserPreference")
	private List<CUserPreferencesTheme> CUserPreferencesThemes;

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

	public List<CUserPreferencesTheme> getCUserPreferencesThemes() {
		return this.CUserPreferencesThemes;
	}

	public void setCUserPreferencesThemes(List<CUserPreferencesTheme> CUserPreferencesThemes) {
		this.CUserPreferencesThemes = CUserPreferencesThemes;
	}

	public CUserPreferencesTheme addCUserPreferencesTheme(CUserPreferencesTheme CUserPreferencesTheme) {
		getCUserPreferencesThemes().add(CUserPreferencesTheme);
		CUserPreferencesTheme.setCUserPreference(this);

		return CUserPreferencesTheme;
	}

	public CUserPreferencesTheme removeCUserPreferencesTheme(CUserPreferencesTheme CUserPreferencesTheme) {
		getCUserPreferencesThemes().remove(CUserPreferencesTheme);
		CUserPreferencesTheme.setCUserPreference(null);

		return CUserPreferencesTheme;
	}

}