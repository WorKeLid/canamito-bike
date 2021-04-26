package org.canamito.core.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the c_process_view database table.
 * 
 */
@Entity
@Table(name="c_process_view")
@NamedQuery(name="CProcessView.findAll", query="SELECT c FROM CProcessView c")
public class CProcessView implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="c_process_view_id", unique=true, nullable=false)
	private Integer cProcessViewId;

	@Column(name="is_default", nullable=false)
	private Boolean isDefault;

	//bi-directional many-to-one association to CProcess
	@ManyToOne
	@JoinColumn(name="fk_c_process_id", nullable=false)
	private CProcess CProcess;

	//bi-directional many-to-one association to CView
	@ManyToOne
	@JoinColumn(name="fk_c_view_id", nullable=false)
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