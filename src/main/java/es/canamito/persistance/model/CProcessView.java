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
 * The persistent class for the c_process_view database table.
 * 
 */
@Entity
@Table(name = "c_process_view")
@NamedQuery(name = "CProcessView.findAll", query = "SELECT c FROM CProcessView c")
public class CProcessView implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "c_process_view_c_process_view_id_seq", sequenceName = "c_process_view_c_process_view_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "c_process_view_c_process_view_id_seq")
	@Column(name = "c_process_view_id", unique = true, nullable = false)
	private Integer cProcessViewId;

	@Column(name = "is_default", nullable = false)
	private Boolean isDefault;

	// bi-directional many-to-one association to CProcess
	@ManyToOne
	@JoinColumn(name = "fk_c_process_id", nullable = false)
	private CProcess CProcess;

	// bi-directional many-to-one association to CView
	@ManyToOne
	@JoinColumn(name = "fk_c_view_id", nullable = false)
	private CView CView;

	public CProcessView() {
	}

	public Integer getCProcessViewId() {
		return this.cProcessViewId;
	}

	public void setCProcessViewId(Integer cProcessViewId) {
		this.cProcessViewId = cProcessViewId;
	}

	public Boolean getIsDefault() {
		return this.isDefault;
	}

	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}

	public CProcess getCProcess() {
		return this.CProcess;
	}

	public void setCProcess(CProcess CProcess) {
		this.CProcess = CProcess;
	}

	public CView getCView() {
		return this.CView;
	}

	public void setCView(CView CView) {
		this.CView = CView;
	}

}