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
import javax.persistence.Table;

/**
 * The persistent class for the c_table database table.
 * 
 */
@Entity
@Table(name = "c_table")
@NamedQuery(name = "CTable.findAll", query = "SELECT c FROM CTable c")
public class CTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "c_table_id", unique = true, nullable = false)
	private Integer cTableId;

	@Column(name = "db_name", nullable = false, length = 64)
	private String dbName;

	@Column(name = "class_name", nullable = false, length = 64)
	private String className;

	@Column(length = 256)
	private String description;

	@Column(nullable = false, length = 64)
	private String name;

	// bi-directional many-to-one association to CColumn
	@OneToMany(mappedBy = "CTable")
	private List<CColumn> CColumns;

	public CTable() {
	}

	public Integer getCTableId() {
		return this.cTableId;
	}

	public void setCTableId(Integer cTableId) {
		this.cTableId = cTableId;
	}

	public String getDbName() {
		return this.dbName;
	}

	public String getClassName() {
		return this.className;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public void setClassName(String className) {
		this.className = className;
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

	public List<CColumn> getCColumns() {
		return this.CColumns;
	}

	public void setCColumns(List<CColumn> CColumns) {
		this.CColumns = CColumns;
	}

	public CColumn addCColumn(CColumn CColumn) {
		getCColumns().add(CColumn);
		CColumn.setCTable(this);

		return CColumn;
	}

	public CColumn removeCColumn(CColumn CColumn) {
		getCColumns().remove(CColumn);
		CColumn.setCTable(null);

		return CColumn;
	}

}