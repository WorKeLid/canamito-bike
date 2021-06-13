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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The persistent class for the c_window database table.
 * 
 */
@Entity
@Table(name = "c_window")
@NamedQuery(name = "CWindow.findAll", query = "SELECT c FROM CWindow c")
public class CWindow implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "c_window_id", unique = true, nullable = false)
	private Integer cWindowId;

	@Column(nullable = false, length = 256)
	private String description;

	@Column(nullable = false, length = 64)
	private String name;

	// bi-directional one-to-one association to CProcess
	@OneToOne
	@JoinColumn(name = "c_window_id", nullable = false, insertable = false, updatable = false)
	private CProcess CProcess;

	// bi-directional many-to-one association to CTable
	@ManyToOne
	@JoinColumn(name = "fk_c_table_id", nullable = false)
	private CTable CTable;

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

	public CTable getCTable() {
		return this.CTable;
	}

	public void setCTable(CTable CTable) {
		this.CTable = CTable;
	}

}