package com.fresher.hibernate.asm.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fresher.hibernate.asm.DTO.MaterialDTO;
import com.fresher.hibernate.asm.DTO.ProductDTO;
import com.fresher.hibernate.asm.service.ProductService;

public class ProductServiceTest {
	ProductService productService = new ProductService();

	@Test
	public void testAddNewProduct() throws Exception {

		MaterialDTO materialDTO = new MaterialDTO(3L, "kaki");
		ProductDTO productDTO = new ProductDTO(8L, "áo thun 3 lỗ", 50, 2000, 5000, "không", materialDTO);
		boolean success = false;
		productService.addnew(productDTO);
		success = true;
		assertEquals(true, success);
		productService.deleteById(8L);
	}
	
	@Test
	public void testAddNewProduct_IDNegative() {

		MaterialDTO materialDTO = new MaterialDTO(3L, "kaki");
		ProductDTO productDTO = new ProductDTO(-8L, "áo thun 3 lỗ", 50, 2000, 5000, "không", materialDTO);
		
		assertEquals(-8L, productDTO.getProductId());

		Assertions.assertThrows(Exception.class, () -> {
			productService.addnew(productDTO);
		});
	}
	
	@Test
	public void testGetAllProduct() {
		List<ProductDTO> testGetAllProduct = productService.getAll();
		Assertions.assertFalse(testGetAllProduct.isEmpty());
	}
	
	@Test
	public void testGetByIDproduct() throws Exception {
		ProductDTO productDTO = productService.getById(3L);
		assertEquals("quần gấm", productDTO.getProductName());
	}

	@Test
	public void testGetByIDproduct_IDNegative() throws Exception {
		Assertions.assertThrows(Exception.class, () -> {
			productService.getById(-2L);
		});
	}
	
	@Test
	public void testDeleteProductByID() throws Exception {
		productService.deleteById(2L);
		
		MaterialDTO materialDTO = new MaterialDTO(1L, "thun");
		ProductDTO productDTO = new ProductDTO(2L, "áo thun bông", 10, 5000, 10000, "không", materialDTO);

		Assertions.assertNotNull(productDTO.getProductId());
		
		productService.addnew(productDTO);
	}

	@Test
	public void testDeleteProductByID_IDNegative() throws Exception {
		Assertions.assertThrows(Exception.class, () -> {
			productService.deleteById(-2L);
		});
	}
	
	@Test
	public void testSaveOrUpdateProduct() throws Exception {

		MaterialDTO materialDTO = new MaterialDTO(3L, "kaki");
		ProductDTO productDTO = new ProductDTO(1L, "áo thun", 50, 2000, 5000, "không", materialDTO);
		
		productService.saveOrUpdate(productDTO);
		ProductDTO testSaveOrUpdateProduct = productService.getById(1L);
		assertEquals("áo dài nhung", testSaveOrUpdateProduct.getProductName());
	}

	@Test
	public void testGetByNameProduct() {
		List<ProductDTO> testGetByName = productService.getByNameProduct("áo thun 3 lỗ");
		assertNotNull(testGetByName);
	}
	
	@Test
	public void testGetTop3ProductBiggestPrice() {
		List<ProductDTO> testGetByName = productService.getTop3ProductBiggestPrice();
		assertNotNull(testGetByName);
	}
	
	
}
