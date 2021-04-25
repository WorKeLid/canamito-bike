package core.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the c_window database table.
 * 
 */
@Entity
@Table(name="c_window")
@NamedQuery(name="CWindow.findAll", query="SELECT c FROM CWindow c")
public class CWindow implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="c_window_id", unique=true, nullable=false)
	private Integer cWindowId;

	@Column(nullable=false, length=256)
	private String description;

	@Column(nullable=false, length=64)
	private String name;

	//bi-directional one-to-one association to CProcess
	@OneToOne
	@JoinColumn(name="c_window_id", nullable=false, insertable=false, updatable=false)
	private CProcess CProcess;

	//bi-directional many-to-one association to CWindowTable
	@OneToMany(mappedBy="CWindow")
	private List<CWindowTable> CWindowTables;

	public CWindow() {
	}

	public Integer getCWindowId() {
		return this.cWindowId;
	}

	public void setCWindowId(Integer cWindowId) {
		this.cWindowId = cWindowId;
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

	public CProcess getCProcess() {
		return this.CProcess;
	}

	public void setCProcess(CProcess CProcess) {
		this.CProcess = CProcess;
	}

	public List<CWindowTable> getCWindowTables() {
		return this.CWindowTables;
	}

	public void setCWindowTables(List<CWindowTable> CWindowTables) {
		this.CWindowTables = CWindowTables;
	}

	public CWindowTable addCWindowTable(CWindowTable CWindowTable) {
		getCWindowTables().add(CWindowTable);
		CWindowTable.setCWindow(this);

		return CWindowTable;
	}

	public CWindowTable removeCWindowTable(CWindowTable CWindowTable) {
		getCWindowTables().remove(CWindowTable);
		CWindowTable.setCWindow(null);

		return CWindowTable;
	}

}