package com.fresher.hibernate.asm.DAO;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.fresher.hibernate.asm.entitis.Duty;
import com.fresher.hibernate.asm.entitis.Employee;
import com.fresher.hibernate.asm.util.HibernateUtil;

public class EmployeeDAO extends AbstractDAO<Employee> {

	public EmployeeDAO() {
		super(Employee.class);
	}

	/**
	 * Get Manager in Employee
	 * 
	 * @return List Manager in Employee
	 */

	public List<Employee> GetEmployeeManager() {

		Session session = HibernateUtil.getSessionFactory().openSession();

		List<Employee> resultGetManager = null;

		try {

			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
			Root<Employee> root = criteriaQuery.from(Employee.class);

			Join<Employee, Duty> employeeJoin1 = root.join("duty", JoinType.INNER);

			criteriaQuery.select(root);

			criteriaQuery.where(criteriaBuilder.equal(employeeJoin1.get("dutyName"), "quản lý"));

			resultGetManager = session.createQuery(criteriaQuery).getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}

		return resultGetManager;
	}

	/**
	 * Get Employee By Name
	 * 
	 * @param name
	 * @return List employee Get By Name
	 */

	public List<Employee> getByName(String name) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		List<Employee> employeeByName = null;

		try {

			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

			CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);

			Root<Employee> root = criteriaQuery.from(Employee.class);

			criteriaQuery.select(root);

			criteriaQuery.where(criteriaBuilder.equal(root.get("employeeName"), name));

			employeeByName = session.createQuery(criteriaQuery).getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return employeeByName;
	}

	/**
	 * Get employee Working
	 * 
	 * @return List Employee Working
	 */

	public List<Employee> getEmployeeWorking() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Employee> resultGetEmployeeWorking = null;

		try {

			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
			Root<Employee> root = criteriaQuery.from(Employee.class);

			criteriaQuery.select(root);

			criteriaQuery.where(criteriaBuilder.equal(root.get("employeeStatus"), "đang làm việc"));

			resultGetEmployeeWorking = session.createQuery(criteriaQuery).getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();

		} finally {
			session.close();
		}
		return resultGetEmployeeWorking;

	}

	
	/**
	 * Get Employee has Gender is nam
	 * 
	 * @return List Employee has Gender nam
	 */
	public List<Employee> getGenderEmployee() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		List<Employee> resultGetGenderEmployee = null;

		try {

			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
			Root<Employee> root = criteriaQuery.from(Employee.class);
			criteriaQuery.select(root);
			criteriaQuery.where(criteriaBuilder.equal(root.get("employeeGender"), "nam"));
			resultGetGenderEmployee = session.createQuery(criteriaQuery).getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();

		} finally {
			session.close();
		}
		return resultGetGenderEmployee;
	}

}
