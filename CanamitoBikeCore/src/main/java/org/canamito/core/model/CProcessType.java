package org.canamito.core.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the c_process_type database table.
 * 
 */
@Entity
@Table(name="c_process_type")
@NamedQuery(name="CProcessType.findAll", query="SELECT c FROM CProcessType c")
public class CProcessType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="c_process_type_id", unique=true, nullable=false)
	private Integer cProcessTypeId;

	@Column(nullable=false, length=64)
	private String type;

	//bi-directional many-to-one association to CProcess
	@OneToMany(mappedBy="CProcessType")
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