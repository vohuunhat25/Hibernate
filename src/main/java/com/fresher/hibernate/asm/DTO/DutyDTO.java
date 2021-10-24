package com.fresher.hibernate.asm.DTO;

import com.fresher.hibernate.asm.entitis.Duty;

public class DutyDTO {

	private Long dutyId;
	private String dutyName;
	
	public DutyDTO() {
	}
	
	public DutyDTO(Long dutyId, String dutyName) {
		this.dutyId = dutyId;
		this.dutyName = dutyName;
	}
	
	public DutyDTO(Duty dutyEntity) {
		this.dutyId = dutyEntity.getDutyId();
		this.dutyName = dutyEntity.getDutyName();
	}
	
	public Long getDutyId() {
		return dutyId;
	}

	public void setDutyId(Long dutyId) {
		this.dutyId = dutyId;
	}

	public String getDutyName() {
		return dutyName;
	}

	public void setDutyName(String dutyName) {
		this.dutyName = dutyName;
	}

	@Override
	public String toString() {
		return "Duty [dutyId=" + dutyId + ", dutyName=" + dutyName + "]";
	}

}
