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
 * The persistent class for the c_process_type database table.
 * 
 */
@Entity
@Table(name = "c_process_type")
@NamedQuery(name = "CProcessType.findAll", query = "SELECT c FROM CProcessType c")
public class CProcessType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "c_process_type_c_process_type_id_seq", sequenceName = "c_process_type_c_process_type_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "c_process_type_c_process_type_id_seq")
	@Column(name = "c_process_type_id", unique = true, nullable = false)
	private Integer cProcessTypeId;

	@Column(nullable = false, length = 64)
	private String type;

	// bi-directional many-to-one association to CProcess
	@OneToMany(mappedBy = "CProcessType")
	private List<CProcess> CProcesses;

	public CProcessType() {
	}

	public Integer getCProcessTypeId() {
		return this.cProcessTypeId;
	}

	public void setCProcessTypeId(Integer cProcessTypeId) {
		this.cProcessTypeId = cProcessTypeId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<CProcess> getCProcesses() {
		return this.CProcesses;
	}

	public void setCProcesses(List<CProcess> CProcesses) {
		this.CProcesses = CProcesses;
	}

	public CProcess addCProcess(CProcess CProcess) {
		getCProcesses().add(CProcess);
		CProcess.setCProcessType(this);

		return CProcess;
	}

	public CProcess removeCProcess(CProcess CProcess) {
		getCProcesses().remove(CProcess);
		CProcess.setCProcessType(null);

		return CProcess;
	}

}