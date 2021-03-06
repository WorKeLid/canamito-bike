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
 * The persistent class for the c_grade database table.
 * 
 */
@Entity
@Table(name = "c_grade")
@NamedQuery(name = "CGrade.findAll", query = "SELECT c FROM CGrade c")
public class CGrade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "c_grade_c_grade_id_seq", sequenceName = "c_grade_c_grade_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "c_grade_c_grade_id_seq")
	@Column(name = "c_grade_id", unique = true, nullable = false)
	private Integer cGradeId;

	@Column(nullable = false)
	private Integer grade;

	// bi-directional many-to-one association to CGroup
	@OneToMany(mappedBy = "CGrade")
	private List<CGroup> CGroups;

	public CGrade() {
	}

	public Integer getCGradeId() {
		return this.cGradeId;
	}

	public void setCGradeId(Integer cGradeId) {
		this.cGradeId = cGradeId;
	}

	public Integer getGrade() {
		return this.grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public List<CGroup> getCGroups() {
		return this.CGroups;
	}

	public void setCGroups(List<CGroup> CGroups) {
		this.CGroups = CGroups;
	}

	public CGroup addCGroup(CGroup CGroup) {
		getCGroups().add(CGroup);
		CGroup.setCGrade(this);

		return CGroup;
	}

	public CGroup removeCGroup(CGroup CGroup) {
		getCGroups().remove(CGroup);
		CGroup.setCGrade(null);

		return CGroup;
	}

}