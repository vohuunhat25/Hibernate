package com.fresher.hibernate.asm.service;

import java.util.ArrayList;
import java.util.List;

import com.fresher.hibernate.asm.DAO.ProductDAO;
import com.fresher.hibernate.asm.DTO.ProductDTO;
import com.fresher.hibernate.asm.entitis.Product;

public class ProductService {
	ProductDAO productDAO = new ProductDAO();

	/**
	 * Add new product
	 * 
	 * @param productDTO
	 * @throws Exception
	 */
	public void addnew(ProductDTO productDTO) throws Exception {

		if (productDTO.getProductId() <= 0) {
			throw new Exception("You can't use ID less 0");
		}

		Product Product = new Product(productDTO);
		productDAO.addNew(Product);
	}

	/**
	 * Get All Product
	 * 
	 * @return List Product
	 */

	public List<ProductDTO> getAll() {

		List<ProductDTO> listProductDTO = new ArrayList<>();
		List<Product> listProductEntity = productDAO.getAll();

		for (Product product : listProductEntity) {
			ProductDTO dto = new ProductDTO(product);
			listProductDTO.add(dto);
		}
		return listProductDTO;
	}

	/**
	 * Get Product By ID
	 * 
	 * @param id
	 * @return List Product Get By Id
	 * @throws Exception
	 */

	public ProductDTO getById(Long id) throws Exception {

		if (id <= 0) {
			throw new Exception("You can't use ID less 0");
		}

		Product product = productDAO.getById(id);
		ProductDTO productDTO = new ProductDTO(product);

		return productDTO;
	}

	/**
	 * Delete Product by ID
	 * 
	 * @param id
	 * @throws Exception
	 */

	public void deleteById(Long id) throws Exception {

		if (id <= 0) {
			throw new Exception("You can't delete ID less 0");
		}

		productDAO.deleteById(id);
	}

	/**
	 * saveOrUpdate Product
	 * 
	 * @param productDTO
	 */

	public void saveOrUpdate(ProductDTO productDTO) {

		Product product = new Product(productDTO);
		productDAO.saveOrUpdate(product);
	}

	/**
	 * Get Product by Name
	 * 
	 * @param name
	 * @return List product by name
	 */
	public List<ProductDTO> getByNameProduct(String name) {
		
		List<ProductDTO> listProductDTO = new ArrayList<>();
		List<Product> listProductEntity = productDAO.getByNameProduct(name);

		for (Product product : listProductEntity) {
			ProductDTO dto = new ProductDTO(product);
			listProductDTO.add(dto);
		}
		return listProductDTO;
	}
	
	/**
	 * Get top 3 product biggest price
	 * 
	 * @return List product top 3 biggest price
	 */

	public List<ProductDTO> getTop3ProductBiggestPrice() {
		
		List<ProductDTO> listProductDTO = new ArrayList<>();
		List<Product> listProductEntity = productDAO.getTop3ProductBiggestPrice();

		for (Product product : listProductEntity) {
			ProductDTO dto = new ProductDTO(product);
			listProductDTO.add(dto);
		}
		return listProductDTO;
	}
}
