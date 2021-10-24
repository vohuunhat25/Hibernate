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

import com.fresher.hibernate.asm.DTO.ProductDTO;

@Entity
@Table(name = "product_table")
public class Product {

	@Id
	@Column(name = "product_id")
	private Long productId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "product_quantity")
	private int productQuantity;

	@Column(name = "product_improt_price")
	private double productImportPrice;

	@Column(name = "product_price")
	private double productPrice;

	@Column(name = "note")
	private String note;

	@ManyToOne
	@JoinColumn(name = "material_id", referencedColumnName = "material_id")
	private Material material;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
	private Set<ProductInvoiceDetails> productInvoiceDetails;

	public Product() {
		super();
	}

	public Product(Long productId, String productName, int productQuantity, double productImportPrice,
			double productPrice, String note, Material material) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productQuantity = productQuantity;
		this.productImportPrice = productImportPrice;
		this.productPrice = productPrice;
		this.note = note;
		this.material = material;
	}

	public Product(ProductDTO productDto) {
		super();
		this.productId = productDto.getProductId();
		this.productName = productDto.getProductName();
		this.productQuantity = productDto.getProductQuantity();
		this.productImportPrice = productDto.getProductImportPrice();
		this.productPrice = productDto.getProductPrice();
		this.note = productDto.getNote();
		this.material = new Material(productDto.getMaterialDTO());
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public double getProductImportPrice() {
		return productImportPrice;
	}

	public void setProductImportPrice(double productImportPrice) {
		this.productImportPrice = productImportPrice;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Set<ProductInvoiceDetails> getProductInvoiceDetails() {
		return productInvoiceDetails;
	}

	public void setProductInvoiceDetails(Set<ProductInvoiceDetails> productInvoiceDetails) {
		this.productInvoiceDetails = productInvoiceDetails;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productQuantity="
				+ productQuantity + ", productImportPrice=" + productImportPrice + ", productPrice=" + productPrice
				+ ", note=" + note + ", material=" + material + "]";
	}

}
