package com.fresher.hibernate.asm.DAO;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.fresher.hibernate.asm.util.HibernateUtil;

public class AbstractDAO<T> {

	private Class<T> entityClass;

	public AbstractDAO(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	/**
	 * Add new communication
	 * 
	 * @param t
	 */
	public void addNew(T t) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.save(t);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			if (session != null) {
				session.close();
			}

		}
	}

	/**
	 * Get all communication
	 * 
	 * @return List Communication Get
	 */
	public List<T> getAll() {

		Session session = HibernateUtil.getSessionFactory().openSession();

		List<T> result = null;

		try {

			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(this.entityClass);
			Root<T> root = criteriaQuery.from(this.entityClass);
			criteriaQuery.select(root);

			result = session.createQuery(criteriaQuery).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return result;
	}

	/**
	 * Get By Id Communication
	 * 
	 * @param id
	 * @return Communication Entity Get By Id
	 */
	public T getById(Long id) {

		T entityById = null;

		Session session = HibernateUtil.getSessionFactory().openSession();

		try {

			entityById = session.get(entityClass, id);

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}

		return entityById;
	}

	/**
	 * Delete Communication By Id
	 * 
	 * @param id
	 */
	public void deleteById(Long id) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.getTransaction().begin();
			T t = getById(id);
			session.remove(t);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	/**
	 * Update communication
	 * 
	 * @param t
	 */
	public void saveOrUpdate(T t) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();	
			session.update(t);			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

}
