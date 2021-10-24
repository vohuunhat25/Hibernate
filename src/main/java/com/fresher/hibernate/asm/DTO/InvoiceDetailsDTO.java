package com.fresher.hibernate.asm.DTO;

import com.fresher.hibernate.asm.entitis.InvoiceDetails;

public class InvoiceDetailsDTO {

	private Long invoiceDetailId;
	private int quantity;
	private double price;
	private double discount;
	private double total;
	private InvoiceDTO invoiceDTO;

	public InvoiceDetailsDTO() {
	}

	public InvoiceDetailsDTO(Long invoiceDetailId, int quantity, double price, double discount, double total,
			InvoiceDTO invoiceDTO) {
		super();
		this.invoiceDetailId = invoiceDetailId;
		this.quantity = quantity;
		this.price = price;
		this.discount = discount;
		this.total = total;
		this.invoiceDTO = invoiceDTO;
	}

	public InvoiceDetailsDTO(InvoiceDetails invoiceDetailsEntity) {
		super();
		this.invoiceDetailId = invoiceDetailsEntity.getInvoiceDetailId();
		this.quantity = invoiceDetailsEntity.getQuantity();
		this.price = invoiceDetailsEntity.getPrice();
		this.discount = invoiceDetailsEntity.getDiscount();
		this.total = invoiceDetailsEntity.getTotal();
		this.invoiceDTO = new InvoiceDTO(invoiceDetailsEntity.getInvoice());
	}

	public Long getInvoiceDetailId() {
		return invoiceDetailId;
	}

	public void setInvoiceDetailId(Long invoiceDetailId) {
		this.invoiceDetailId = invoiceDetailId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public InvoiceDTO getInvoiceDTO() {
		return invoiceDTO;
	}

	public void setInvoiceDTO(InvoiceDTO invoiceDTO) {
		this.invoiceDTO = invoiceDTO;
	}

	@Override
	public String toString() {
		return "InvoiceDetailsDTO [invoiceDetailId=" + invoiceDetailId + ", quantity=" + quantity + ", price=" + price
				+ ", discount=" + discount + ", total=" + total + ", invoiceDTO=" + invoiceDTO + "]";
	}

}
