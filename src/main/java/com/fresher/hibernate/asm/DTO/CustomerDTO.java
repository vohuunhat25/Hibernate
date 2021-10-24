package com.fresher.hibernate.asm.DTO;

import com.fresher.hibernate.asm.entitis.Customer;

public class CustomerDTO {

	private Long customerId;
	private String customerName;
	private String customerAddress;
	private String customerPhoneNumber;

	public CustomerDTO() {
	}

	public CustomerDTO(Long customerId, String customerName, String customerAddress, String customerPhoneNumber) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerPhoneNumber = customerPhoneNumber;
	}

	public CustomerDTO(Customer customerEntity) {
		this.customerId = customerEntity.getCustomerId();
		this.customerName = customerEntity.getCustomerName();
		this.customerAddress = customerEntity.getCustomerAddress();
		this.customerPhoneNumber = customerEntity.getCustomerPhoneNumber();
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}

	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerAddress="
				+ customerAddress + ", customerPhoneNumber=" + customerPhoneNumber + "]";
	}

}
