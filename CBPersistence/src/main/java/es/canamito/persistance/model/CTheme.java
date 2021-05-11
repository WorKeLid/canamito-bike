package es.canamito.persistance.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the c_theme database table.
 * 
 */
@Entity
@Table(name="c_theme")
@NamedQuery(name="CTheme.findAll", query="SELECT c FROM CTheme c")
public class CTheme implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="c_theme_id")
	private Integer cThemeId;

	@Column(name="css_path")
	private String cssPath;

	private String description;

	private String name;

	//bi-directional many-to-one association to CThemeView
	@OneToMany(mappedBy="CTheme")
	private List<CThemeView> CThemeViews;

	//bi-directional many-to-one association to CUserPreferencesTheme
	@OneToMany(mappedBy="CTheme")
	private List<CUserPreferencesTheme> CUserPreferencesThemes;

	public CTheme() {
	}

	public Integer getCThemeId() {
		return this.cThemeId;
	}

	public void setCThemeId(Integer cThemeId) {
		this.cThemeId = cThemeId;
	}

	public String getCssPath() {
		return this.cssPath;
	}

	public void setCssPath(String cssPath) {
		this.cssPath = cssPath;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CThemeView> getCThemeViews() {
		return this.CThemeViews;
	}

	public void setCThemeViews(List<CThemeView> CThemeViews) {
		this.CThemeViews = CThemeViews;
	}

	public CThemeView addCThemeView(CThemeView CThemeView) {
		getCThemeViews().add(CThemeView);
		CThemeView.setCTheme(this);

		return CThemeView;
	}

	public CThemeView removeCThemeView(CThemeView CThemeView) {
		getCThemeViews().remove(CThemeView);
		CThemeView.setCTheme(null);

		return CThemeView;
	}

	public List<CUserPreferencesTheme> getCUserPreferencesThemes() {
		return this.CUserPreferencesThemes;
	}

	public void setCUserPreferencesThemes(List<CUserPreferencesTheme> CUserPreferencesThemes) {
		this.CUserPreferencesThemes = CUserPreferencesThemes;
	}

	public CUserPreferencesTheme addCUserPreferencesTheme(CUserPreferencesTheme CUserPreferencesTheme) {
		getCUserPreferencesThemes().add(CUserPreferencesTheme);
		CUserPreferencesTheme.setCTheme(this);

		return CUserPreferencesTheme;
	}

	public CUserPreferencesTheme removeCUserPreferencesTheme(CUserPreferencesTheme CUserPreferencesTheme) {
		getCUserPreferencesThemes().remove(CUserPreferencesTheme);
		CUserPreferencesTheme.setCTheme(null);

		return CUserPreferencesTheme;
	}

}