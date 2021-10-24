package com.fresher.hibernate.asm.DTO;

import java.util.Objects;

import com.fresher.hibernate.asm.entitis.ProductInvoiceDetails;

public class ProductInvoiceDetailsDTO {

	private ProductDTO productDTO;
	private InvoiceDetailsDTO invoiceDetailsDTO;

	public ProductInvoiceDetailsDTO() {
	}

	public ProductInvoiceDetailsDTO(ProductDTO productDTO, InvoiceDetailsDTO invoiceDetailsDTO) {
		super();
		this.productDTO = productDTO;
		this.invoiceDetailsDTO = invoiceDetailsDTO;
	}

	public ProductInvoiceDetailsDTO(ProductInvoiceDetails productInvoiceDetailsEntity) {
		super();
		this.productDTO = new ProductDTO(productInvoiceDetailsEntity.getProduct());
		this.invoiceDetailsDTO = new InvoiceDetailsDTO(productInvoiceDetailsEntity.getInvoiceDetails());
	}

	public ProductDTO getProductDTO() {
		return productDTO;
	}

	public void setProductDTO(ProductDTO productDTO) {
		this.productDTO = productDTO;
	}

	public InvoiceDetailsDTO getInvoiceDetailsDTO() {
		return invoiceDetailsDTO;
	}

	public void setInvoiceDetailsDTO(InvoiceDetailsDTO invoiceDetailsDTO) {
		this.invoiceDetailsDTO = invoiceDetailsDTO;
	}

	@Override
	public int hashCode() {
		return Objects.hash(invoiceDetailsDTO, productDTO);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductInvoiceDetailsDTO other = (ProductInvoiceDetailsDTO) obj;
		return Objects.equals(invoiceDetailsDTO, other.invoiceDetailsDTO)
				&& Objects.equals(productDTO, other.productDTO);
	}

	@Override
	public String toString() {
		return "ProductInvoiceDetailsDTO [productDTO=" + productDTO + ", invoiceDetailsDTO=" + invoiceDetailsDTO + "]";
	}

}
