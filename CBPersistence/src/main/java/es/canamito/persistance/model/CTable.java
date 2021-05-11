package es.canamito.persistance.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the c_table database table.
 * 
 */
@Entity
@Table(name="c_table")
@NamedQuery(name="CTable.findAll", query="SELECT c FROM CTable c")
public class CTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="c_table_id")
	private Integer cTableId;

	@Column(name="db_name")
	private String dbName;

	private String description;

	private String name;

	//bi-directional many-to-one association to CColumn
	@OneToMany(mappedBy="CTable")
	private List<CColumn> CColumns;

	//bi-directional many-to-one association to CWindowTable
	@OneToMany(mappedBy="CTable")
	private List<CWindowTable> CWindowTables;

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

	public List<CWindowTable> getCWindowTables() {
		return this.CWindowTables;
	}

	public void setCWindowTables(List<CWindowTable> CWindowTables) {
		this.CWindowTables = CWindowTables;
	}

	public CWindowTable addCWindowTable(CWindowTable CWindowTable) {
		getCWindowTables().add(CWindowTable);
		CWindowTable.setCTable(this);

		return CWindowTable;
	}

	public CWindowTable removeCWindowTable(CWindowTable CWindowTable) {
		getCWindowTables().remove(CWindowTable);
		CWindowTable.setCTable(null);

		return CWindowTable;
	}

}