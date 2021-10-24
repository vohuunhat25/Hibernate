package com.fresher.hibernate.asm.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fresher.hibernate.asm.DTO.CustomerDTO;
import com.fresher.hibernate.asm.service.CustomerService;

public class CustomerServiceTest {


	CustomerService customerService = new CustomerService();

	@Test
	public void testAddNewCustomer() throws Exception {

		CustomerDTO testCustomerDTO = new CustomerDTO(6L, "Hồ Chí Minh", "nha", "0365871481");
		customerService.addNew(testCustomerDTO);
		boolean success = false;
		customerService.addNew(testCustomerDTO);
		success = true;
		assertEquals(true, success);
		customerService.deleteById(6L);
	}

	@Test
	public void testAddNewCustomer_IDNegative() {

		CustomerDTO testCustomerDTOIDNegative = new CustomerDTO(-9L, "Hồ Chí Minh", "nha", "0365871481");
		assertEquals(-9L, testCustomerDTOIDNegative.getCustomerId());

		Assertions.assertThrows(Exception.class, () -> {
			customerService.addNew(testCustomerDTOIDNegative);
		});
	}

	@Test
	public void testGetAllCustomer() {
		List<CustomerDTO> customerTestGetALl = customerService.getAll();
		Assertions.assertFalse(customerTestGetALl.isEmpty());
	}

	@Test
	public void testGetByIDCustomer() throws Exception {
		CustomerDTO testGetByIDCustomer = customerService.getById(5L);
		assertEquals("nguyễn văn e", testGetByIDCustomer.getCustomerName());
	}

	@Test
	public void testGetByIDCustomer_IDNegative() throws Exception {

		Assertions.assertThrows(Exception.class, () -> {
			customerService.getById(-10L);
		});
	}

	@Test
	public void testDeleteCustomerByID() throws Exception {
		
		customerService.deleteById(2L);
		CustomerDTO testDeleteCustomer = new CustomerDTO(2L,"nguyễn văn b", "Hồ Chí Minh", "0147258369");
		Assertions.assertNotNull(testDeleteCustomer);
		customerService.addNew(testDeleteCustomer);
	}

	@Test
	public void testDeleteByIDCustomer_IDNegative() throws Exception {
		Assertions.assertThrows(Exception.class, () -> {
			customerService.deleteById(-2L);
		});
	}

	@Test
	public void testSaveOrUpdateCustomer() throws Exception {

		CustomerDTO testSaveOrUpdate = new CustomerDTO(1L, "nguyễn văn a","Hồ Chí Minh", "0365871481");
		customerService.saveOrUpdate(testSaveOrUpdate);
		CustomerDTO testSaveOrUpdate2 = customerService.getById(1L);
		assertEquals("nguyễn văn c", testSaveOrUpdate2.getCustomerName());
	}

	@Test
	public void testgetByNameCustomer() {
		List<CustomerDTO> testGetByName = customerService.getByNameCustomer("nguyễn văn d");
		assertNotNull(testGetByName);
	}

}
