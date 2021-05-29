package es.canamito.persistance.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the c_letter database table.
 * 
 */
@Entity
@Table(name="c_letter")
@NamedQuery(name="CLetter.findAll", query="SELECT c FROM CLetter c")
public class CLetter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="c_letter_id", unique=true, nullable=false)
	private Integer cLetterId;

	@Column(nullable=false, length=1)
	private String letter;

	//bi-directional many-to-one association to CGroup
	@OneToMany(mappedBy="CLetter")
	private List<CGroup> CGroups;

	public CLetter() {
	}

	public Integer getCLetterId() {
		return this.cLetterId;
	}

	public void setCLetterId(Integer cLetterId) {
		this.cLetterId = cLetterId;
	}

	public String getLetter() {
		return this.letter;
	}

	public void setLetter(String letter) {
		this.letter = letter;
	}

	public List<CGroup> getCGroups() {
		return this.CGroups;
	}

	public void setCGroups(List<CGroup> CGroups) {
		this.CGroups = CGroups;
	}

	public CGroup addCGroup(CGroup CGroup) {
		getCGroups().add(CGroup);
		CGroup.setCLetter(this);

		return CGroup;
	}

	public CGroup removeCGroup(CGroup CGroup) {
		getCGroups().remove(CGroup);
		CGroup.setCLetter(null);

		return CGroup;
	}

}