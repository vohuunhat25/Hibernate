package com.fresher.hibernate.asm.entitis;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fresher.hibernate.asm.DTO.ProductInvoiceDetailsDTO;

@Entity
@Table(name = "product_invoice_details")
public class ProductInvoiceDetails implements Serializable {

	@Id
	@ManyToOne
	@JoinColumn(name = "product_id", referencedColumnName = "product_id")
	private Product product;

	@Id
	@ManyToOne
	@JoinColumn(name = "invoice_details_id", referencedColumnName = "invoice_details_id")
	private InvoiceDetails invoiceDetails;

	public ProductInvoiceDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductInvoiceDetails(Product product, InvoiceDetails invoiceDetails) {
		super();
		this.product = product;
		this.invoiceDetails = invoiceDetails;
	}

	public ProductInvoiceDetails(ProductInvoiceDetailsDTO productInvoiceDetailsDTO) {
		super();
		this.product = new Product(productInvoiceDetailsDTO.getProductDTO());
		this.invoiceDetails = new InvoiceDetails(productInvoiceDetailsDTO.getInvoiceDetailsDTO());
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public InvoiceDetails getInvoiceDetails() {
		return invoiceDetails;
	}

	public void setInvoiceDetails(InvoiceDetails invoiceDetails) {
		this.invoiceDetails = invoiceDetails;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((invoiceDetails == null) ? 0 : invoiceDetails.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductInvoiceDetails other = (ProductInvoiceDetails) obj;
		if (invoiceDetails == null) {
			if (other.invoiceDetails != null)
				return false;
		} else if (!invoiceDetails.equals(other.invoiceDetails))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductInvoiceDetails [product=" + product + ", invoiceDetails=" + invoiceDetails + "]";
	}

}
