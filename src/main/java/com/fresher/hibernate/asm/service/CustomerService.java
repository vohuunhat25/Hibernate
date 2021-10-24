package com.fresher.hibernate.asm.service;

import java.util.ArrayList;
import java.util.List;

import com.fresher.hibernate.asm.DAO.CustomerDAO;
import com.fresher.hibernate.asm.DTO.CustomerDTO;
import com.fresher.hibernate.asm.entitis.Customer;

public class CustomerService {
	CustomerDAO customerDAO = new CustomerDAO();

	/**
	 * Add new a customer
	 * 
	 * @param customerDto
	 * @throws Exception 
	 */

	public void addNew(CustomerDTO customerDTO) throws Exception {
		
		if (customerDTO.getCustomerId() <= 0) {
			throw new Exception("You can't use ID less 0");
		}

		
		Customer customer = new Customer(customerDTO);

		customerDAO.addNew(customer);
	}

	/**
	 * Get All Customer
	 * 
	 * @return List Customer
	 */

	public List<CustomerDTO> getAll() {

		List<CustomerDTO> listCustomerDTO = new ArrayList<>();

		List<Customer> listCustomerEntity = customerDAO.getAll();

		for (Customer customer : listCustomerEntity) {
			CustomerDTO dto = new CustomerDTO(customer);
			listCustomerDTO.add(dto);
		}
		return listCustomerDTO;
	}

	/**
	 * Get Customer By ID
	 * 
	 * @param id
	 * @return List Customer Get By Id
	 * @throws Exception 
	 */

	public CustomerDTO getById(Long id) throws Exception {
		
		if (id <= 0) {
			throw new Exception("You can't use ID less 0");
		}

		Customer customerEntity = customerDAO.getById(id);

		CustomerDTO customerDTO = new CustomerDTO(customerEntity);

		return customerDTO;
	}

	/**
	 * Delete Customer by ID
	 * 
	 * @param id
	 * @throws Exception 
	 */

	public void deleteById(Long id) throws Exception {
		
		if (id <= 0) {
			throw new Exception("You can't delete ID less 0");
		}
		
		customerDAO.deleteById(id);
	}

	/**
	 * saveOrUpdate Customer
	 * 
	 * @param customerDTO
	 */

	public void saveOrUpdate(CustomerDTO customerDTO) {

		Customer customer = new Customer(customerDTO);
		customerDAO.saveOrUpdate(customer);
	}
	
	/**
	 * Get customer by name
	 * 
	 * @param name
	 * @return list customer get by name
	 */

	public List<CustomerDTO> getByNameCustomer(String name) {

		List<CustomerDTO> listCustomerDTO = new ArrayList<>();
		List<Customer> listCustomerEntity = customerDAO.getByNameCustomer(name);

		for (Customer customerEntity : listCustomerEntity) {
			CustomerDTO customerDto = new CustomerDTO(customerEntity);
			listCustomerDTO.add(customerDto);
		}
		return listCustomerDTO;
	}

}
