package com.fresher.hibernate.asm.DAO;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;


import com.fresher.hibernate.asm.entitis.Invoice;
import com.fresher.hibernate.asm.util.HibernateUtil;

public class InvoiceDAO extends AbstractDAO<Invoice> {

	public InvoiceDAO() {
		super(Invoice.class);
	}
	
	/**
	 * Get Invoice Total with Money
	 * 
	 * @param momey
	 * @return List Invoice Total with Money
	 */

	public List<Invoice> GetInvoiceTotal(long momey){
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		List<Invoice> resultGetInvoice = null;
		
		try {
			
			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<Invoice> criteriaQuery = criteriaBuilder.createQuery(Invoice.class);

			Root<Invoice> root = criteriaQuery.from(Invoice.class);
			
			criteriaQuery.groupBy(root.get("invoiceId"), root.get("dayOfSales"), root.get("total"));
			
			criteriaQuery.having(criteriaBuilder.gt(root.<Long>get("total"), momey));
			
			resultGetInvoice = session.createQuery(criteriaQuery).getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return resultGetInvoice;
		
	}
	
}
