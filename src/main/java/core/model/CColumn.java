package core.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the c_column database table.
 * 
 */
@Entity
@Table(name="c_column")
@NamedQuery(name="CColumn.findAll", query="SELECT c FROM CColumn c")
public class CColumn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="c_column_id", unique=true, nullable=false)
	private Integer cColumnId;

	@Column(name="db_name", nullable=false, length=64)
	private String dbName;

	@Column(length=256)
	private String description;

	@Column(nullable=false, length=64)
	private String name;

	//bi-directional many-to-one association to CTable
	@ManyToOne
	@JoinColumn(name="fk_c_table_id", nullable=false)
	private CTable CTable;

	public CColumn() {
	}

	public Integer getCColumnId() {
		return this.cColumnId;
	}

	public void setCColumnId(Integer cColumnId) {
		this.cColumnId = cColumnId;
	}

	public String getDbName() {
		return this.dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
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

	public CTable getCTable() {
		return this.CTable;
	}

	public void setCTable(CTable CTable) {
		this.CTable = CTable;
	}

}