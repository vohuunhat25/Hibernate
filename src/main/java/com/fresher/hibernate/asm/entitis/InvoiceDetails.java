package com.fresher.hibernate.asm.entitis;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fresher.hibernate.asm.DTO.InvoiceDetailsDTO;

@Entity
@Table(name = "invoice_details_table")
public class InvoiceDetails {

	@Id
	@Column(name = "invoice_details_id")
	private Long invoiceDetailId;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "price")
	private double price;

	@Column(name = "discount")
	private double discount;

	@Column(name = "total")
	private double total;

	@OneToOne
	@JoinColumn(name = "invoice_id", referencedColumnName = "invoice_id")
	private Invoice invoice;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "invoiceDetails")
	private Set<ProductInvoiceDetails> productInvoiceDetails;

	public InvoiceDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvoiceDetails(Long invoiceDetailId, int quantity, double price, double discount, double total,
			Invoice invoice) {
		super();
		this.invoiceDetailId = invoiceDetailId;
		this.quantity = quantity;
		this.price = price;
		this.discount = discount;
		this.total = total;
		this.invoice = invoice;
	}

	public InvoiceDetails(InvoiceDetailsDTO invoiceDetailsDTO) {
		super();
		this.invoiceDetailId = invoiceDetailsDTO.getInvoiceDetailId();
		this.quantity = invoiceDetailsDTO.getQuantity();
		this.price = invoiceDetailsDTO.getPrice();
		this.discount = invoiceDetailsDTO.getDiscount();
		this.total = invoiceDetailsDTO.getTotal();
		this.invoice = new Invoice(invoiceDetailsDTO.getInvoiceDTO());
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
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

	@Override
	public String toString() {
		return "InvoiceDetails [invoiceDetailId=" + invoiceDetailId + ", quantity=" + quantity + ", price=" + price
				+ ", discount=" + discount + ", total=" + total + ", invoice=" + invoice + "]";
	}

}
