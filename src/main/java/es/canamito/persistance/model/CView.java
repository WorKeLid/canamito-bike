package es.canamito.persistance.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the c_view database table.
 * 
 */
@Entity
@Table(name = "c_view")
@NamedQuery(name = "CView.findAll", query = "SELECT c FROM CView c")
public class CView implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "c_view_c_view_id_seq", sequenceName = "c_view_c_view_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "c_view_c_view_id_seq")
	@Column(name = "c_view_id", unique = true, nullable = false)
	private Integer cViewId;

	@Column(name = "jsp_path", nullable = false, length = 256)
	private String jspPath;

	@Column(nullable = false, length = 64)
	private String name;

	// bi-directional many-to-one association to CProcessView
	@OneToMany(mappedBy = "CView")
	private List<CProcessView> CProcessViews;

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

}