package com.fresher.hibernate.asm.DTO;


import com.fresher.hibernate.asm.entitis.Employee;

public class EmployeeDTO {

	private Long employeeId;
	private String employeeName;
	private String employeeGender;
	private String employeeDate;
	private String employeeAddress;
	private String employeeWorkingDay;
	private String employeeStatus;
	private String employeePhoneNumber;
	private DutyDTO dutyDTO;

	public EmployeeDTO() {
	}

	public EmployeeDTO(Long employeeId, String employeeName, String employeeGender, String employeeDate,
			String employeeAddress, String employeeWorkingDay, String employeeStatus, String employeePhoneNumber,
			DutyDTO dutyDTO) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeGender = employeeGender;
		this.employeeDate = employeeDate;
		this.employeeAddress = employeeAddress;
		this.employeeWorkingDay = employeeWorkingDay;
		this.employeeStatus = employeeStatus;
		this.employeePhoneNumber = employeePhoneNumber;
		this.dutyDTO = dutyDTO;
	}

	public EmployeeDTO(Employee employeeEntity) {
		super();
		this.employeeId = employeeEntity.getEmployeeId();
		this.employeeName = employeeEntity.getEmployeeName();
		this.employeeGender = employeeEntity.getEmployeeGender();
		this.employeeDate = employeeEntity.getEmployeeDate();
		this.employeeAddress = employeeEntity.getEmployeeAddress();
		this.employeeWorkingDay = employeeEntity.getEmployeeWorkingDay();
		this.employeeStatus = employeeEntity.getEmployeeStatus();
		this.employeePhoneNumber = employeeEntity.getEmployeePhoneNumber();
		this.dutyDTO = new DutyDTO(employeeEntity.getDuty());
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

	public DutyDTO getDutyDTO() {
		return dutyDTO;
	}

	public void setDutyDTO(DutyDTO dutyDTO) {
		this.dutyDTO = dutyDTO;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeGender="
				+ employeeGender + ", employeeDate=" + employeeDate + ", employeeAddress=" + employeeAddress
				+ ", employeeWorkingDay=" + employeeWorkingDay + ", employeeStatus=" + employeeStatus
				+ ", employeePhoneNumber=" + employeePhoneNumber + ", dutyDTO=" + dutyDTO + "]";
	}

}