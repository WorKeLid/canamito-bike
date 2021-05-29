package es.canamito.persistance.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the c_locality database table.
 * 
 */
@Entity
@Table(name="c_locality")
@NamedQuery(name="CLocality.findAll", query="SELECT c FROM CLocality c")
public class CLocality implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="c_locality_id", unique=true, nullable=false)
	private Integer cLocalityId;

	@Column(nullable=false, length=128)
	private String name;

	@Column(name="postal_code", nullable=false, length=5)
	private String postalCode;

	//bi-directional many-to-one association to CProvince
	@ManyToOne
	@JoinColumn(name="fk_c_province_id", nullable=false)
	private CProvince CProvince;

	//bi-directional many-to-one association to CPerson
	@OneToMany(mappedBy="CLocality")
	private List<CPerson> CPersons;

	public CLocality() {
	}

	public Integer getCLocalityId() {
		return this.cLocalityId;
	}

	public void setCLocalityId(Integer cLocalityId) {
		this.cLocalityId = cLocalityId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public CProvince getCProvince() {
		return this.CProvince;
	}

	public void setCProvince(CProvince CProvince) {
		this.CProvince = CProvince;
	}

	public List<CPerson> getCPersons() {
		return this.CPersons;
	}

	public void setCPersons(List<CPerson> CPersons) {
		this.CPersons = CPersons;
	}

	public CPerson addCPerson(CPerson CPerson) {
		getCPersons().add(CPerson);
		CPerson.setCLocality(this);

		return CPerson;
	}

	public CPerson removeCPerson(CPerson CPerson) {
		getCPersons().remove(CPerson);
		CPerson.setCLocality(null);

		return CPerson;
	}

}