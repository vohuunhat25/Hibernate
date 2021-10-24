package com.fresher.hibernate.asm.service;

import java.util.ArrayList;
import java.util.List;

import com.fresher.hibernate.asm.DAO.EmployeeDAO;
import com.fresher.hibernate.asm.DTO.EmployeeDTO;
import com.fresher.hibernate.asm.entitis.Employee;

public class EmployeeService {

	EmployeeDAO employeeDAO = new EmployeeDAO();

	/**
	 * Add new a employee
	 * 
	 * @param employeeDto
	 * @throws Exception
	 */

	public void addNew(EmployeeDTO employeeDTO) throws Exception {

		if (employeeDTO.getEmployeeId() <= 0) {
			throw new Exception("You can't use ID less 0");
		}

		Employee employee = new Employee(employeeDTO);

		employeeDAO.addNew(employee);
	}

	/**
	 * Get All Employee
	 * 
	 * @return List Employee
	 */

	public List<EmployeeDTO> getAll() {

		List<EmployeeDTO> listEmployeeDTO = new ArrayList<>();
		List<Employee> listEmployeeEntity = employeeDAO.getAll();

		for (Employee employee : listEmployeeEntity) {
			EmployeeDTO dto = new EmployeeDTO(employee);
			listEmployeeDTO.add(dto);
		}
		return listEmployeeDTO;
	}

	/**
	 * Get Employee By ID
	 * 
	 * @param id
	 * @return List Employee Get By ID
	 * @throws Exception
	 */

	public EmployeeDTO getById(Long id) throws Exception {

		if (id <= 0) {
			throw new Exception("You can't use ID less 0");
		}

		Employee employeeEntity = employeeDAO.getById(id);
		EmployeeDTO employeeDTO = new EmployeeDTO(employeeEntity);

		return employeeDTO;
	}

	/**
	 * Delete employee by ID
	 * 
	 * @param id
	 * @throws Exception
	 */

	public void deleteById(Long id) throws Exception {

		if (id <= 0) {
			throw new Exception("You can't delete ID less 0");
		}	
		employeeDAO.deleteById(id);
	}

	/**
	 * saveOrUpdate employee
	 * 
	 * @param employeeDTO
	 */

	public void saveOrUpdate(EmployeeDTO employeeDTO) {

		Employee employee = new Employee(employeeDTO);

		employeeDAO.saveOrUpdate(employee);
	}

	/**
	 * Get employee by name
	 * 
	 * @param name
	 * @return list employee get by name
	 */

	public List<EmployeeDTO> getByNameEmployee(String name) {

		List<EmployeeDTO> listEmployeeDTO = new ArrayList<>();

		List<Employee> listEmployeeEntity = employeeDAO.getByName(name);

		for (Employee employee : listEmployeeEntity) {
			EmployeeDTO dto = new EmployeeDTO(employee);
			listEmployeeDTO.add(dto);
		}
		return listEmployeeDTO;
	}

	/**
	 * Get Employee Manager
	 * 
	 * @return List Employee Manager
	 */

	public List<EmployeeDTO> GetEmployeeManager() {

		List<EmployeeDTO> listEmployeeDTO = new ArrayList<>();

		List<Employee> listEmployeeEntity = employeeDAO.GetEmployeeManager();

		for (Employee employee : listEmployeeEntity) {
			EmployeeDTO dto = new EmployeeDTO(employee);
			listEmployeeDTO.add(dto);
		}
		return listEmployeeDTO;
	}

	/**
	 * Get employee Working at Shop
	 * 
	 * @return List employee Working at Shop
	 */
	public List<EmployeeDTO> getEmployeeWorking() {

		List<EmployeeDTO> listEmployeeDTO = new ArrayList<>();

		List<Employee> listEmployeeEntity = employeeDAO.getEmployeeWorking();

		for (Employee employee : listEmployeeEntity) {
			EmployeeDTO dto = new EmployeeDTO(employee);
			listEmployeeDTO.add(dto);
		}
		return listEmployeeDTO;
	}
	
	/**
	 * Get Employee has Gender is nam
	 * 
	 * @return List Employee has Gender nam
	 */

	public List<EmployeeDTO> getGenderEmployee() {
		
		List<EmployeeDTO> listEmployeeDTO = new ArrayList<>();
		List<Employee> listEmployeeEntity = employeeDAO.getGenderEmployee();

		for (Employee employee : listEmployeeEntity) {
			EmployeeDTO dto = new EmployeeDTO(employee);
			listEmployeeDTO.add(dto);
		}
		return listEmployeeDTO;

	}

}
