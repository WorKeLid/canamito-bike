package es.canamito.persistance.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the c_theme_view database table.
 * 
 */
@Entity
@Table(name="c_theme_view")
@NamedQuery(name="CThemeView.findAll", query="SELECT c FROM CThemeView c")
public class CThemeView implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="c_theme_view_id")
	private Integer cThemeViewId;

	//bi-directional many-to-one association to CTheme
	@ManyToOne
	@JoinColumn(name="fk_c_theme_id")
	private CTheme CTheme;

	//bi-directional many-to-one association to CView
	@ManyToOne
	@JoinColumn(name="fk_c_view_id")
	private CView CView;

	public CThemeView() {
	}

	public Integer getCThemeViewId() {
		return this.cThemeViewId;
	}

	public void setCThemeViewId(Integer cThemeViewId) {
		this.cThemeViewId = cThemeViewId;
	}

	public CTheme getCTheme() {
		return this.CTheme;
	}

	public void setCTheme(CTheme CTheme) {
		this.CTheme = CTheme;
	}

	public CView getCView() {
		return this.CView;
	}

	public void setCView(CView CView) {
		this.CView = CView;
	}

}