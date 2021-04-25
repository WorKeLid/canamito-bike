package core.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the c_province database table.
 * 
 */
@Entity
@Table(name="c_province")
@NamedQuery(name="CProvince.findAll", query="SELECT c FROM CProvince c")
public class CProvince implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="c_province_id", unique=true, nullable=false)
	private Integer cProvinceId;

	@Column(nullable=false, length=64)
	private String name;

	//bi-directional many-to-one association to CLocality
	@OneToMany(mappedBy="CProvince")
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

}