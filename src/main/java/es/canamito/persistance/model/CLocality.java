package es.canamito.persistance.model;

import java.io.Serializable;
import java.util.ArrayList;
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

import es.canamito.app.model.CBAttribute;

/**
 * The persistent class for the c_locality database table.
 * 
 * @author wkl
 * @version 1.210618 - Implementación y documentación de la interfaz
 *          CBWindowable
 */
@Entity
@Table(name = "c_locality")
@NamedQuery(name = "CLocality.findAll", query = "SELECT c FROM CLocality c")
public class CLocality implements Serializable, CBWindowable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "c_locality_c_locality_id_seq", sequenceName = "c_locality_c_locality_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "c_locality_c_locality_id_seq")
	@Column(name = "c_locality_id", unique = true, nullable = false)
	private Integer cLocalityId;

	@Column(nullable = false, length = 128)
	private String name;

	@Column(name = "postal_code", nullable = false, length = 5)
	private String postalCode;

	// bi-directional many-to-one association to CProvince
	@ManyToOne
	@JoinColumn(name = "fk_c_province_id", nullable = false)
	private CProvince CProvince;

	// bi-directional many-to-one association to CPerson
	@OneToMany(mappedBy = "CLocality")
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

	public CBAttribute getId() {
		return new CBAttribute("id", "cLocalityId", this.cLocalityId, this);
	}

	public CBAttribute getIdentifier() {
		return new CBAttribute("text", "name", this.name, this);
	}

	public List<CBAttribute> getAttributes() {
		List<CBAttribute> res = new ArrayList<CBAttribute>();

		CBAttribute name = new CBAttribute("text", "name", this.name, this);
		CBAttribute postalCode = new CBAttribute("text", "postalCode", this.postalCode, this);
		CBAttribute CProvince = new CBAttribute("selector", "CProvince", this.CProvince, this);

		res.add(name);
		res.add(postalCode);
		res.add(CProvince);

		return res;
	}

}