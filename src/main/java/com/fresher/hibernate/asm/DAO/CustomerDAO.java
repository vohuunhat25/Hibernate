package com.fresher.hibernate.asm.DAO;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.fresher.hibernate.asm.DTO.CustomerDTO;
import com.fresher.hibernate.asm.entitis.Customer;
import com.fresher.hibernate.asm.util.HibernateUtil;

public class CustomerDAO extends AbstractDAO<Customer>{

	public CustomerDAO() {
		super(Customer.class);
	}
	
	/**
	 * List customer get by name
	 * 
	 * @param name
	 * @return
	 */

	public List<Customer> getByNameCustomer (String name) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		List<Customer> customerByName = null;
		
		CustomerDTO customerDTO;

		try {

			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			
			CriteriaQuery<Customer> criteriaQuery = criteriaBuilder.createQuery(Customer.class);
			
			Root<Customer> root = criteriaQuery.from(Customer.class);
			
			criteriaQuery.select(root);
			
			criteriaQuery.where(criteriaBuilder.equal(root.get("customerName"), name));
			
			customerByName = session.createQuery(criteriaQuery).getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return customerByName;
	}

}
