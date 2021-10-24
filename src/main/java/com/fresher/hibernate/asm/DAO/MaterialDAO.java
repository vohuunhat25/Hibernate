package com.fresher.hibernate.asm.DAO;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.fresher.hibernate.asm.entitis.Material;
import com.fresher.hibernate.asm.util.HibernateUtil;

public class MaterialDAO extends AbstractDAO<Material> {

	public MaterialDAO() {
		super(Material.class);
	}

	/**
	 * Get Material By Name
	 * 
	 * @param name
	 * @return List Material By Name
	 */
	public List<Material> getByName(String name) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		List<Material> materialByName = null;

		try {

			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

			CriteriaQuery<Material> criteriaQuery = criteriaBuilder.createQuery(Material.class);

			Root<Material> root = criteriaQuery.from(Material.class);

			criteriaQuery.select(root);

			criteriaQuery.where(criteriaBuilder.equal(root.get("materialName"), name));

			materialByName = session.createQuery(criteriaQuery).getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return materialByName;
	}

}
