package com.fresher.hibernate.asm.entitis;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fresher.hibernate.asm.DTO.CustomerDTO;

@Entity
@Table(name = "customer_table")
public class Customer {

	@Id
	@Column(name = "customer_id")
	private Long customerId;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "customer_address")
	private String customerAddress;

	@Column(name = "customer_phone_number")
	private String customerPhoneNumber;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
	private Set<Invoice> invoice;

	public Customer() {
		
	}

	public Customer(Long customerId, String customerName, String customerAddress, String customerPhoneNumber) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerPhoneNumber = customerPhoneNumber;
	}
	
	
	public Customer(CustomerDTO customerDTO) {
		this.customerId = customerDTO.getCustomerId();
		this.customerName = customerDTO.getCustomerName();
		this.customerAddress = customerDTO.getCustomerAddress();
		this.customerPhoneNumber = customerDTO.getCustomerPhoneNumber();
	}

	public Set<Invoice> getInvoice() {
		return invoice;
	}

	public void setInvoice(Set<Invoice> invoice) {
		this.invoice = invoice;
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
