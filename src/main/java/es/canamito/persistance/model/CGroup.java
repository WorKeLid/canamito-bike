package es.canamito.persistance.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the c_group database table.
 * 
 */
@Entity
@Table(name = "c_group")
@NamedQuery(name = "CGroup.findAll", query = "SELECT c FROM CGroup c")
public class CGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "c_group_c_group_id_seq", sequenceName = "c_group_c_group_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "c_group_c_group_id_seq")
	@Column(name = "c_group_id", unique = true, nullable = false)
	private Integer cGroupId;

	// bi-directional many-to-one association to CGrade
	@ManyToOne
	@JoinColumn(name = "fk_c_grade_id", nullable = false)
	private CGrade CGrade;

	// bi-directional many-to-one association to CLetter
	@ManyToOne
	@JoinColumn(name = "fk_c_letter_id", nullable = false)
	private CLetter CLetter;

	// bi-directional many-to-one association to CGroupPerson
	@OneToMany(mappedBy = "CGroup")
	private List<CGroupPerson> CGroupPersons;

	public CGroup() {
	}

	public Integer getCGroupId() {
		return this.cGroupId;
	}

	public void setCGroupId(Integer cGroupId) {
		this.cGroupId = cGroupId;
	}

	public CGrade getCGrade() {
		return this.CGrade;
	}

	public void setCGrade(CGrade CGrade) {
		this.CGrade = CGrade;
	}

	public CLetter getCLetter() {
		return this.CLetter;
	}

	public void setCLetter(CLetter CLetter) {
		this.CLetter = CLetter;
	}

	public List<CGroupPerson> getCGroupPersons() {
		return this.CGroupPersons;
	}

	public void setCGroupPersons(List<CGroupPerson> CGroupPersons) {
		this.CGroupPersons = CGroupPersons;
	}

	public CGroupPerson addCGroupPerson(CGroupPerson CGroupPerson) {
		getCGroupPersons().add(CGroupPerson);
		CGroupPerson.setCGroup(this);

		return CGroupPerson;
	}

	public CGroupPerson removeCGroupPerson(CGroupPerson CGroupPerson) {
		getCGroupPersons().remove(CGroupPerson);
		CGroupPerson.setCGroup(null);

		return CGroupPerson;
	}

}