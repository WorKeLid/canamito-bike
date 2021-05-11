package es.canamito.persistance.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the c_view database table.
 * 
 */
@Entity
@Table(name="c_view")
@NamedQuery(name="CView.findAll", query="SELECT c FROM CView c")
public class CView implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="c_view_id")
	private Integer cViewId;

	@Column(name="jsp_path")
	private String jspPath;

	private String name;

	//bi-directional many-to-one association to CProcessView
	@OneToMany(mappedBy="CView")
	private List<CProcessView> CProcessViews;

	//bi-directional many-to-one association to CThemeView
	@OneToMany(mappedBy="CView")
	private List<CThemeView> CThemeViews;

	public CView() {
	}

	public Integer getCViewId() {
		return this.cViewId;
	}

	public void setCViewId(Integer cViewId) {
		this.cViewId = cViewId;
	}

	public String getJspPath() {
		return this.jspPath;
	}

	public void setJspPath(String jspPath) {
		this.jspPath = jspPath;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CProcessView> getCProcessViews() {
		return this.CProcessViews;
	}

	public void setCProcessViews(List<CProcessView> CProcessViews) {
		this.CProcessViews = CProcessViews;
	}

	public CProcessView addCProcessView(CProcessView CProcessView) {
		getCProcessViews().add(CProcessView);
		CProcessView.setCView(this);

		return CProcessView;
	}

	public CProcessView removeCProcessView(CProcessView CProcessView) {
		getCProcessViews().remove(CProcessView);
		CProcessView.setCView(null);

		return CProcessView;
	}

	public List<CThemeView> getCThemeViews() {
		return this.CThemeViews;
	}

	public void setCThemeViews(List<CThemeView> CThemeViews) {
		this.CThemeViews = CThemeViews;
	}

	public CThemeView addCThemeView(CThemeView CThemeView) {
		getCThemeViews().add(CThemeView);
		CThemeView.setCView(this);

		return CThemeView;
	}

	public CThemeView removeCThemeView(CThemeView CThemeView) {
		getCThemeViews().remove(CThemeView);
		CThemeView.setCView(null);

		return CThemeView;
	}

}