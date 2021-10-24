package com.fresher.hibernate.asm.DAO;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Query;
import org.hibernate.Session;


import com.fresher.hibernate.asm.entitis.Product;
import com.fresher.hibernate.asm.util.HibernateUtil;

public class ProductDAO extends AbstractDAO<Product> {

	public ProductDAO() {
		super(Product.class);
	}

	/**
	 * Get product by Name
	 * 
	 * @param name
	 * @return List product by name
	 */
	public List<Product> getByNameProduct(String name) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		List<Product> productByName = null;

		try {

			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

			CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);

			Root<Product> root = criteriaQuery.from(Product.class);

			criteriaQuery.select(root);

			criteriaQuery.where(criteriaBuilder.equal(root.get("productName"), name));

			productByName = session.createQuery(criteriaQuery).getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return productByName;
	}
	
	/**
	 * Get top 3 product biggest price
	 * 
	 * @return List product top 3 biggest price
	 */

	public List<Product> getTop3ProductBiggestPrice() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		
		
		List<Product> resultTopProduct = null;
		
		try {

			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

			CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);

			Root<Product> root = criteriaQuery.from(Product.class);
			
			criteriaQuery.select(root);
			
			criteriaQuery.orderBy(criteriaBuilder.desc(root.get("productPrice")));
			
			Query<Product> query = session.createQuery(criteriaQuery);
			
			query.setFirstResult((1 - 1) * 3);
			query.setMaxResults(3);	
			
			resultTopProduct = query.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return resultTopProduct;

	}

}
