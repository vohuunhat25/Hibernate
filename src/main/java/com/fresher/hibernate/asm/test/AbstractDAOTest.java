package com.fresher.hibernate.asm.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.hibernate.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.fresher.hibernate.asm.DAO.CustomerDAO;
import com.fresher.hibernate.asm.entitis.Customer;
import com.fresher.hibernate.asm.util.HibernateUtil;

public class AbstractDAOTest {
	static Customer customer;

	Session session = HibernateUtil.getSessionFactory().openSession();

	@Test
	public void AbstractDAOTestAddNew() {

		Customer customer = new Customer(20L, "Nguyen Huu Minh", "xxx", "1111");
		CustomerDAO customerDAO = new CustomerDAO();
		boolean success = false;
		customerDAO.addNew(customer);
		success = true;
		assertEquals(true, success);
		customerDAO.deleteById(20L);
	}

	@Test
	public void AbstractDAOTestAddNew_Exception() {

		Customer customer = new Customer(1L, "Nguyen Huu Minh", "xxx", "1111");

		CustomerDAO customerDAO = new CustomerDAO();

		Customer customer2 = customerDAO.getById(1L);

		customerDAO.addNew(customer);

		Assertions.assertNotNull(customer2);

	}

	@Test
	public void AbstractDAOTestGetAll() throws Exception {

		List<Customer> resultList;
		CustomerDAO customerDAO = new CustomerDAO();
		resultList = customerDAO.getAll();
		Assertions.assertFalse(resultList.isEmpty());
	}

	@Test
	public void AbstractDAOTestGetById() throws Exception {

		long id = 2L;
		CustomerDAO customerDAO = new CustomerDAO();
		Customer customer = customerDAO.getById(id);

		assertEquals("nguyễn văn b", customer.getCustomerName());
	}

	@Test
	public void AbstractDAOTestGetById_IdNull() throws Exception {

		long id = 200L;
		CustomerDAO customerDAO = new CustomerDAO();
		Customer customer = customerDAO.getById(id);
		Assertions.assertNull(customer);
	}

	@Test
	public void AbstractDAOTestSaveOrUpdate() throws Exception {

		long id = 5L;
		Customer customer1 = new Customer(id, "Hung Lay", "xxxx", "3333");
		CustomerDAO customerDAO = new CustomerDAO();
		customerDAO.saveOrUpdate(customer1);

		Customer customer2 = customerDAO.getById(id);

		assertEquals("nguyễn văn e", customer2.getCustomerName());
	}

	@Test
	public void AbstractDAOTestSaveOrUpdate_Exception() throws Exception {
		
		CustomerDAO customerDAO = new CustomerDAO();
		Customer customer1 = new Customer(3L, "Hung Lay", "xxxx", "3333");
		customerDAO.saveOrUpdate(customer1);	
		Customer customer2 = customerDAO.getById(3L);
		Assertions.assertNotNull(customer2);
	}

	@Test
	public void AbstractDAOTestDeleteById() throws Exception {
		
		CustomerDAO customerDAO = new CustomerDAO();
		
		Customer customer = new Customer(6L,"nguyễn văn e" ,"Hồ Chí Minh","0159357741");
		
		customerDAO.addNew(customer);
		
		customerDAO.deleteById(6L);

		Assertions.assertNotNull(customer.getCustomerId());
	}



}
