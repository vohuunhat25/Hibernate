package com.fresher.hibernate.asm.entitis;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fresher.hibernate.asm.DTO.DutyDTO;

@Entity
@Table(name = "duty_table")
public class Duty {

	@Id
	@Column(name = "duty_id", length = 10, nullable = true)
	private Long dutyId;

	@Column(name = "duty_name", nullable = true)
	private String dutyName;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "duty")
	private Set<Employee> employee;

	public Duty() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Duty(Long dutyId, String dutyName) {
		super();
		this.dutyId = dutyId;
		this.dutyName = dutyName;
	}
	
	public Duty(DutyDTO dutyDTO) {
		this.dutyId = dutyDTO.getDutyId();
		this.dutyName = dutyDTO.getDutyName();
	}

	public Set<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(Set<Employee> employee) {
		this.employee = employee;
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
