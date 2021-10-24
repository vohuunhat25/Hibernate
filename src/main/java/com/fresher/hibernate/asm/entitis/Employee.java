package com.fresher.hibernate.asm.entitis;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fresher.hibernate.asm.DTO.EmployeeDTO;

@Entity
@Table(name = "employee_table")
public class Employee {

	@Id
	@Column(name = "employee_id")
	private Long employeeId;

	@Column(name = "employee_name")
	private String employeeName;

	@Column(name = "employee_gender")
	private String employeeGender;

	@Column(name = "employee_date")
	private String employeeDate;

	@Column(name = "employee_address")
	private String employeeAddress;

	@Column(name = "employee_working_day")
	private String employeeWorkingDay;

	@Column(name = "employee_status")
	private String employeeStatus;

	@Column(name = "employee_phone_number")
	private String employeePhoneNumber;

	@ManyToOne
	@JoinColumn(name = "duty_id", referencedColumnName = "duty_id")
	private Duty duty;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employee")
	private Set<Invoice> invoice;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(Long employeeId, String employeeName, String employeeGender, String employeeDate,
			String employeeAddress, String employeeWorkingDay, String employeeStatus, String employeePhoneNumber,
			Duty duty) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeGender = employeeGender;
		this.employeeDate = employeeDate;
		this.employeeAddress = employeeAddress;
		this.employeeWorkingDay = employeeWorkingDay;
		this.employeeStatus = employeeStatus;
		this.employeePhoneNumber = employeePhoneNumber;
		this.duty = duty;
	}
	
	public Employee(EmployeeDTO employDto) {
		
		this.employeeId = employDto.getEmployeeId();
		this.employeeName = employDto.getEmployeeName();
		this.employeeGender = employDto.getEmployeeGender();
		this.employeeDate = employDto.getEmployeeDate();
		this.employeeAddress = employDto.getEmployeeAddress();
		this.employeeWorkingDay = employDto.getEmployeeWorkingDay();
		this.employeeStatus = employDto.getEmployeeStatus();
		this.employeePhoneNumber = employDto.getEmployeePhoneNumber();
		this.duty = new Duty(employDto.getDutyDTO());
	}

	public Duty getDuty() {
		return duty;
	}

	public void setDuty(Duty duty) {
		this.duty = duty;
	}

	public Set<Invoice> getInvoice() {
		return invoice;
	}

	public void setInvoice(Set<Invoice> invoice) {
		this.invoice = invoice;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeGender() {
		return employeeGender;
	}

	public void setEmployeeGender(String employeeGender) {
		this.employeeGender = employeeGender;
	}

	public String getEmployeeDate() {
		return employeeDate;
	}

	public void setEmployeeDate(String employeeDate) {
		this.employeeDate = employeeDate;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public String getEmployeeWorkingDay() {
		return employeeWorkingDay;
	}

	public void setEmployeeWorkingDay(String employeeWorkingDay) {
		this.employeeWorkingDay = employeeWorkingDay;
	}

	public String getEmployeeStatus() {
		return employeeStatus;
	}

	public void setEmployeeStatus(String employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

	public String getEmployeePhoneNumber() {
		return employeePhoneNumber;
	}

	public void setEmployeePhoneNumber(String employeePhoneNumber) {
		this.employeePhoneNumber = employeePhoneNumber;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeGender="
				+ employeeGender + ", employeeDate=" + employeeDate + ", employeeAddress=" + employeeAddress
				+ ", employeeWorkingDay=" + employeeWorkingDay + ", employeeStatus=" + employeeStatus
				+ ", employeePhoneNumber=" + employeePhoneNumber + "]";
	}

}
