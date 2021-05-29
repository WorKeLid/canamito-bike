package es.canamito.persistance.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the c_group_person database table.
 * 
 */
@Entity
@Table(name="c_group_person")
@NamedQuery(name="CGroupPerson.findAll", query="SELECT c FROM CGroupPerson c")
public class CGroupPerson implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="c_group_person_id", unique=true, nullable=false)
	private Integer cGroupPersonId;

	//bi-directional many-to-one association to CGroup
	@ManyToOne
	@JoinColumn(name="fk_c_group_id", nullable=false)
	private CGroup CGroup;

	//bi-directional many-to-one association to CPerson
	@ManyToOne
	@JoinColumn(name="fk_c_person_id", nullable=false)
	private CPerson CPerson;

	public CGroupPerson() {
	}

	public Integer getCGroupPersonId() {
		return this.cGroupPersonId;
	}

	public void setCGroupPersonId(Integer cGroupPersonId) {
		this.cGroupPersonId = cGroupPersonId;
	}

	public CGroup getCGroup() {
		return this.CGroup;
	}

	public void setCGroup(CGroup CGroup) {
		this.CGroup = CGroup;
	}

	public CPerson getCPerson() {
		return this.CPerson;
	}

	public void setCPerson(CPerson CPerson) {
		this.CPerson = CPerson;
	}

}