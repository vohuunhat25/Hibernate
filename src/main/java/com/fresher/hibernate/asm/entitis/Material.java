package com.fresher.hibernate.asm.entitis;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fresher.hibernate.asm.DTO.MaterialDTO;

@Entity
@Table(name = "material_table")
public class Material {

	@Id
	@Column(name = "material_id")
	private Long materialId;

	@Column(name = "material_name")
	private String materialName;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "material")
	private Set<Product> product;

	public Material() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Material(Long materialId, String materialName) {
		super();
		this.materialId = materialId;
		this.materialName = materialName;
	}

	public Material(MaterialDTO materialDto) {
		super();
		this.materialId = materialDto.getMaterialId();
		this.materialName = materialDto.getMaterialName();
	}

	public Long getMaterialId() {
		return materialId;
	}

	public void setMaterialId(Long materialId) {
		this.materialId = materialId;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	@Override
	public String toString() {
		return "Material [materialId=" + materialId + ", materialName=" + materialName + "]";
	}

}
