package com.fresher.hibernate.asm.DAO;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.fresher.hibernate.asm.entitis.Duty;
import com.fresher.hibernate.asm.util.HibernateUtil;

public class DutyDAO extends AbstractDAO<Duty> {

	public DutyDAO() {
		super(Duty.class);
	}

	/**
	 * Get Duty By Name
	 * 
	 * @param name
	 * @return List Duty Get By Name
	 */

	public List<Duty> getByNameDuty (String name) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		List<Duty> dutyByName = null;

		try {

			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

			CriteriaQuery<Duty> criteriaQuery = criteriaBuilder.createQuery(Duty.class);

			Root<Duty> root = criteriaQuery.from(Duty.class);

			criteriaQuery.select(root);

			criteriaQuery.where(criteriaBuilder.equal(root.get("dutyName"), name));

			dutyByName = session.createQuery(criteriaQuery).getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return dutyByName;
	}
}
