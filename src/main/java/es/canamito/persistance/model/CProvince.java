package es.canamito.persistance.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import es.canamito.app.model.CBAttribute;

/**
 * The persistent class for the c_province database table. TODO: Documentacion
 */
@Entity
@Table(name = "c_province")
@NamedQuery(name = "CProvince.findAll", query = "SELECT c FROM CProvince c")
public class CProvince implements Serializable, CBModel {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "c_province_id", unique = true, nullable = false)
	private Integer cProvinceId;

	@Column(nullable = false, length = 64)
	private String name;

	// bi-directional many-to-one association to CLocality
	@OneToMany(mappedBy = "CProvince")
	private List<CLocality> CLocalities;

	public CProvince() {
	}

	public Integer getCProvinceId() {
		return this.cProvinceId;
	}

	public void setCProvinceId(Integer cProvinceId) {
		this.cProvinceId = cProvinceId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CLocality> getCLocalities() {
		return this.CLocalities;
	}

	public void setCLocalities(List<CLocality> CLocalities) {
		this.CLocalities = CLocalities;
	}

	public CLocality addCLocality(CLocality CLocality) {
		getCLocalities().add(CLocality);
		CLocality.setCProvince(this);

		return CLocality;
	}

	public CLocality removeCLocality(CLocality CLocality) {
		getCLocalities().remove(CLocality);
		CLocality.setCProvince(null);

		return CLocality;
	}

	/**
	 * TODO: Documentacion
	 */
	public List<CBAttribute> getAttributes() {
		List<CBAttribute> res = new ArrayList<CBAttribute>();

		CBAttribute id = new CBAttribute("id", this.cProvinceId.getClass(), this.cProvinceId);
		CBAttribute name = new CBAttribute("text", this.name.getClass(), this.name);

		res.add(id);
		res.add(name);

		return res;
	}

}