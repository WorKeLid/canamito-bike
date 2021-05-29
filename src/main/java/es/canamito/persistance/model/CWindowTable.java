package es.canamito.persistance.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the c_window_table database table.
 * 
 */
@Entity
@Table(name="c_window_table")
@NamedQuery(name="CWindowTable.findAll", query="SELECT c FROM CWindowTable c")
public class CWindowTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="c_window_table_id", unique=true, nullable=false)
	private Integer cWindowTableId;

	@Column(nullable=false)
	private Integer level;

	@Column(nullable=false)
	private Integer secuence;

	//bi-directional many-to-one association to CTable
	@ManyToOne
	@JoinColumn(name="fk_c_table_id", nullable=false)
	private CTable CTable;

	//bi-directional many-to-one association to CWindow
	@ManyToOne
	@JoinColumn(name="fk_c_window_id", nullable=false)
	private CWindow CWindow;

	public CWindowTable() {
	}

	public Integer getCWindowTableId() {
		return this.cWindowTableId;
	}

	public void setCWindowTableId(Integer cWindowTableId) {
		this.cWindowTableId = cWindowTableId;
	}

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getSecuence() {
		return this.secuence;
	}

	public void setSecuence(Integer secuence) {
		this.secuence = secuence;
	}

	public CTable getCTable() {
		return this.CTable;
	}

	public void setCTable(CTable CTable) {
		this.CTable = CTable;
	}

	public CWindow getCWindow() {
		return this.CWindow;
	}

	public void setCWindow(CWindow CWindow) {
		this.CWindow = CWindow;
	}

}