package es.canamito.persistance.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The persistent class for the c_process database table.
 * 
 */
@Entity
@Table(name = "c_process")
@NamedQuery(name = "CProcess.findAll", query = "SELECT c FROM CProcess c")
public class CProcess implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "c_process_id", unique = true, nullable = false)
	private Integer cProcessId;

	@Column(length = 256)
	private String description;

	@Column(name = "process_path", nullable = false, length = 256)
	private String processPath;

	// bi-directional many-to-one association to CMenu
	@OneToMany(mappedBy = "CProcess")
	private List<CMenu> CMenus;

	// bi-directional many-to-one association to CProcessType
	@ManyToOne
	@JoinColumn(name = "fk_c_process_type_id", nullable = false)
	private CProcessType CProcessType;

	// bi-directional many-to-one association to CProcessView
	@OneToMany(mappedBy = "CProcess")
	private List<CProcessView> CProcessViews;

	// bi-directional one-to-one association to CReport
	@OneToOne(mappedBy = "CProcess")
	private CReport CReport;

	// bi-directional one-to-one association to CWindow
	@OneToOne(mappedBy = "CProcess")
	private CWindow CWindow;

	public CProcess() {
	}

	public Integer getCProcessId() {
		return this.cProcessId;
	}

	public void setCProcessId(Integer cProcessId) {
		this.cProcessId = cProcessId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProcessPath() {
		return this.processPath;
	}

	public void setProcessPath(String processPath) {
		this.processPath = processPath;
	}

	public List<CMenu> getCMenus() {
		return this.CMenus;
	}

	public void setCMenus(List<CMenu> CMenus) {
		this.CMenus = CMenus;
	}

	public CMenu addCMenus(CMenu CMenus) {
		getCMenus().add(CMenus);
		CMenus.setCProcess(this);

		return CMenus;
	}

	public CMenu removeCMenus(CMenu CMenus) {
		getCMenus().remove(CMenus);
		CMenus.setCProcess(null);

		return CMenus;
	}

	public CProcessType getCProcessType() {
		return this.CProcessType;
	}

	public void setCProcessType(CProcessType CProcessType) {
		this.CProcessType = CProcessType;
	}

	public List<CProcessView> getCProcessViews() {
		return this.CProcessViews;
	}

	public void setCProcessViews(List<CProcessView> CProcessViews) {
		this.CProcessViews = CProcessViews;
	}

	public CProcessView addCProcessView(CProcessView CProcessView) {
		getCProcessViews().add(CProcessView);
		CProcessView.setCProcess(this);

		return CProcessView;
	}

	public CProcessView removeCProcessView(CProcessView CProcessView) {
		getCProcessViews().remove(CProcessView);
		CProcessView.setCProcess(null);

		return CProcessView;
	}

	public CReport getCReport() {
		return this.CReport;
	}

	public void setCReport(CReport CReport) {
		this.CReport = CReport;
	}

	public CWindow getCWindow() {
		return this.CWindow;
	}

	public void setCWindow(CWindow CWindow) {
		this.CWindow = CWindow;
	}

}