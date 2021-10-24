package com.fresher.hibernate.asm.DTO;


import com.fresher.hibernate.asm.entitis.Invoice;

public class InvoiceDTO {

	private Long invoiceId;
	private String dayOfSales;
	private double total;
	private CustomerDTO customerDTO;
	private EmployeeDTO employeeDTO;

	public InvoiceDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvoiceDTO(Long invoiceId, String dayOfSales, double total, CustomerDTO customerDTO,
			EmployeeDTO employeeDTO) {
		super();
		this.invoiceId = invoiceId;
		this.dayOfSales = dayOfSales;
		this.total = total;
		this.customerDTO = customerDTO;
		this.employeeDTO = employeeDTO;
	}

	public InvoiceDTO(Invoice invoiceEntity) {
		super();
		this.invoiceId = invoiceEntity.getInvoiceId();
		this.dayOfSales = invoiceEntity.getDayOfSales();
		this.total = invoiceEntity.getTotal();
		this.customerDTO = new CustomerDTO(invoiceEntity.getCustomer());
		this.employeeDTO = new EmployeeDTO(invoiceEntity.getEmployee());
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

	public CustomerDTO getCustomerDTO() {
		return customerDTO;
	}

	public void setCustomerDTO(CustomerDTO customerDTO) {
		this.customerDTO = customerDTO;
	}

	public EmployeeDTO getEmployeeDTO() {
		return employeeDTO;
	}

	public void setEmployeeDTO(EmployeeDTO employeeDTO) {
		this.employeeDTO = employeeDTO;
	}

	@Override
	public String toString() {
		return "InvoiceDTO [invoiceId=" + invoiceId + ", dayOfSales=" + dayOfSales + ", total=" + total
				+ ", customerDTO=" + customerDTO + ", employeeDTO=" + employeeDTO + "]";
	}

}
