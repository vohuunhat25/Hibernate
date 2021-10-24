package com.fresher.hibernate.asm.DTO;

import com.fresher.hibernate.asm.entitis.Material;

public class MaterialDTO {
	private Long materialId;
	private String materialName;

	public MaterialDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MaterialDTO(Long materialId, String materialName) {
		super();
		this.materialId = materialId;
		this.materialName = materialName;
	}

	public MaterialDTO(Material materialEntiy) {
		super();
		this.materialId = materialEntiy.getMaterialId();
		this.materialName = materialEntiy.getMaterialName();
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
		return "MaterialDTO [materialId=" + materialId + ", materialName=" + materialName + "]";
	}

}
