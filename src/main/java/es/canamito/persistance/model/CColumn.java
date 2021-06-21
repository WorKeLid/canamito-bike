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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the c_column database table.
 * 
 */
@Entity
@Table(name = "c_column")
@NamedQuery(name = "CColumn.findAll", query = "SELECT c FROM CColumn c")
public class CColumn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "c_column_c_column_id_seq", sequenceName = "c_column_c_column_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "c_column_c_column_id_seq")
	@Column(name = "c_column_id", unique = true, nullable = false)
	private Integer cColumnId;

	@Column(name = "db_name", nullable = false, length = 64)
	private String dbName;

	@Column(name = "attribute_name", nullable = false, length = 64)
	private String attributeName;

	@Column(length = 256)
	private String description;

	@Column(nullable = false, length = 64)
	private String name;

	@Column(length = 64)
	private String inputType;

	// bi-directional many-to-one association to CTable
	@ManyToOne
	@JoinColumn(name = "fk_c_table_id", nullable = false)
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

	public String getAttributeName() {
		return this.attributeName;
	}

	public String getInputType() {
		return this.inputType;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setInputType(String inputType) {
		this.inputType = inputType;
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