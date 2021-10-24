package com.fresher.hibernate.asm.entitis;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fresher.hibernate.asm.DTO.InvoiceDTO;

@Entity
@Table(name = "invoice_table")
public class Invoice {

	@Id
	@Column(name = "invoice_id")
	private Long invoiceId;

	@Column(name = "day_of_sales")
	private String dayOfSales;

	@Column(name = "total")
	private double total;

	@OneToOne(mappedBy = "invoice")
	private InvoiceDetails invoiceDetails;

	@ManyToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
	private Employee employee;

	public Invoice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Invoice(Long invoiceId, String dayOfSales, double total, Customer customer, Employee employee) {
		super();
		this.invoiceId = invoiceId;
		this.dayOfSales = dayOfSales;
		this.total = total;
		this.customer = customer;
		this.employee = employee;
	}

	public Invoice(InvoiceDTO invoiceDto) {
		super();
		this.invoiceId = invoiceDto.getInvoiceId();
		this.dayOfSales = invoiceDto.getDayOfSales();
		this.total = invoiceDto.getTotal();
		this.customer = new Customer (invoiceDto.getCustomerDTO());
		this.employee = new Employee(invoiceDto.getEmployeeDTO());
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public InvoiceDetails getInvoiceDetails() {
		return invoiceDetails;
	}

	public void setInvoiceDetails(InvoiceDetails invoiceDetails) {
		this.invoiceDetails = invoiceDetails;
	}

	public Long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Long invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getDayOfSales() {
		return dayOfSales;
	}

	public void setDayOfSales(String dayOfSales) {
		this.dayOfSales = dayOfSales;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Invoice [invoiceId=" + invoiceId + ", dayOfSales=" + dayOfSales + ", total=" + total + "]";
	}

}
