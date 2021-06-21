package es.canamito.persistance.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the c_report database table.
 * 
 */
@Entity
@Table(name = "c_report")
@NamedQuery(name = "CReport.findAll", query = "SELECT c FROM CReport c")
public class CReport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "c_report_c_report_id_seq", sequenceName = "c_report_c_report_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "c_report_c_report_id_seq")
	@Column(name = "c_report_id", unique = true, nullable = false)
	private Integer cReportId;

	@Column(name = "report_path", nullable = false, length = 256)
	private String reportPath;

	// bi-directional one-to-one association to CProcess
	@OneToOne
	@JoinColumn(name = "c_report_id", nullable = false, insertable = false, updatable = false)
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