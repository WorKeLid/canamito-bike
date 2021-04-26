package org.canamito.core.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the c_report database table.
 * 
 */
@Entity
@Table(name="c_report")
@NamedQuery(name="CReport.findAll", query="SELECT c FROM CReport c")
public class CReport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="c_report_id", unique=true, nullable=false)
	private Integer cReportId;

	@Column(name="report_path", nullable=false, length=256)
	private String reportPath;

	//bi-directional one-to-one association to CProcess
	@OneToOne
	@JoinColumn(name="c_report_id", nullable=false, insertable=false, updatable=false)
	private CProcess CProcess;

	public CReport() {
	}

	public Integer getCReportId() {
		return this.cReportId;
	}

	public void setCReportId(Integer cReportId) {
		this.cReportId = cReportId;
	}

	public String getReportPath() {
		return this.reportPath;
	}

	public void setReportPath(String reportPath) {
		this.reportPath = reportPath;
	}

	public CProcess getCProcess() {
		return this.CProcess;
	}

	public void setCProcess(CProcess CProcess) {
		this.CProcess = CProcess;
	}

}