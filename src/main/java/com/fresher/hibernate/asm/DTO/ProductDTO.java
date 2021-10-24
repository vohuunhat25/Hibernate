package com.fresher.hibernate.asm.DTO;

import com.fresher.hibernate.asm.entitis.Product;

public class ProductDTO {

	private Long productId;
	private String productName;
	private int productQuantity;
	private double productImportPrice;
	private double productPrice;
	private String note;
	private MaterialDTO materialDTO;

	public ProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductDTO(Long productId, String productName, int productQuantity, double productImportPrice,
			double productPrice, String note, MaterialDTO materialDTO) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productQuantity = productQuantity;
		this.productImportPrice = productImportPrice;
		this.productPrice = productPrice;
		this.note = note;
		this.materialDTO = materialDTO;
	}

	public ProductDTO(Product productEntity) {
		super();
		this.productId = productEntity.getProductId();
		this.productName = productEntity.getProductName();
		this.productQuantity = productEntity.getProductQuantity();
		this.productImportPrice = productEntity.getProductImportPrice();
		this.productPrice = productEntity.getProductImportPrice();
		this.note = productEntity.getNote();
		this.materialDTO = new MaterialDTO(productEntity.getMaterial());
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

	public MaterialDTO getMaterialDTO() {
		return materialDTO;
	}

	public void setMaterialDTO(MaterialDTO materialDTO) {
		this.materialDTO = materialDTO;
	}

	@Override
	public String toString() {
		return "ProductDTO [productId=" + productId + ", productName=" + productName + ", productQuantity="
				+ productQuantity + ", productImportPrice=" + productImportPrice + ", productPrice=" + productPrice
				+ ", note=" + note + ", materialDTO=" + materialDTO + "]";
	}

}
