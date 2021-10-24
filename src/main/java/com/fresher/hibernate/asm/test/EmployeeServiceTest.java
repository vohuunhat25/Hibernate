package com.fresher.hibernate.asm.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fresher.hibernate.asm.DTO.DutyDTO;
import com.fresher.hibernate.asm.DTO.EmployeeDTO;
import com.fresher.hibernate.asm.service.DutyService;
import com.fresher.hibernate.asm.service.EmployeeService;

public class EmployeeServiceTest {

	EmployeeService employeeService = new EmployeeService();

	DutyService dutyService = new DutyService();

	@Test
	public void testAddNewEmployee() throws Exception {

		DutyDTO DutyDTO = new DutyDTO(4L, "thủ kho");
		EmployeeDTO testAddNewEmployee = new EmployeeDTO(20L, "nhân viên 6", "nam", "1997-08-08", "bình định",
				"2009-02-03", "đang làm việc", "123456789", DutyDTO);
		boolean success = false;
		employeeService.addNew(testAddNewEmployee);
		success = true;
		assertEquals(true, success);
		employeeService.deleteById(20L);
	}

	@Test
	public void testAddNewEmployee_IdNegative() {
		DutyDTO dutyDTO = new DutyDTO(4L, "thủ kho");
		EmployeeDTO testAddNewEmployeeIdNegative = new EmployeeDTO(-5L, "nguyễn văn a", "nam", "1997-08-08",
				"bình định", "2009-02-03", "đang làm việc", "123456789", dutyDTO);
		assertEquals(-5L, testAddNewEmployeeIdNegative.getEmployeeId());
		Assertions.assertThrows(Exception.class, () -> {
			employeeService.addNew(testAddNewEmployeeIdNegative);
		});
	}

	@Test
	public void testGetAllEmployee() {
		List<EmployeeDTO> testGetAllEmployeeDTO = employeeService.getAll();
		Assertions.assertFalse(testGetAllEmployeeDTO.isEmpty());
	}

	@Test
	public void testDeleteByEmployeeID() throws Exception {
		
		DutyDTO dutyDTO = new DutyDTO(4L,"thủ kho");	
		EmployeeDTO EmployeeDTO = new EmployeeDTO(20L, "nguyễn văn a", "nam", "1997-08-08", "bình định", "2009-02-03",
				"đang làm việc", "123456789", dutyDTO);
		
		employeeService.addNew(EmployeeDTO);

		Long idDeleteEmployee = 20L;
		employeeService.deleteById(idDeleteEmployee);

		Assertions.assertNotNull(EmployeeDTO.getEmployeeId());
		
		
	}

	@Test
	public void testDeleteEmployeeByID_IdNegative() {
		Long idDeleteEmployee = -2L;
		Assertions.assertThrows(Exception.class, () -> {
			employeeService.deleteById(idDeleteEmployee);
		});
	}

	@Test
	public void testGetEmployeeById() throws Exception {
		EmployeeDTO testGetEmployeeById = employeeService.getById(1L);
		assertEquals("nhân viên 1", testGetEmployeeById.getEmployeeName());
	}

	@Test
	public void testGetEmployeeById_IdNegative() {
		Assertions.assertThrows(Exception.class, () -> {
			employeeService.getById(-10L);
		});
	}

	@Test
	public void testSaveOrUpdateEmployee() throws Exception {

		DutyDTO dutyDTO = new DutyDTO(4L,"thủ kho");
		
		EmployeeDTO testSaveOrUpdateEmployeeIdNegative = new EmployeeDTO(5L, "nhân viên 5", "nam", "1993-05-01",
				"Đồng Nai", "2020-04-08", "đang làm việc", "123456789", dutyDTO);

		employeeService.saveOrUpdate(testSaveOrUpdateEmployeeIdNegative);
		EmployeeDTO testSaveOrUpdate = employeeService.getById(5L);
		assertEquals("nhân viên 5", testSaveOrUpdate.getEmployeeName());
	}

	@Test
	public void testGetByNameEmployee() {
		List<EmployeeDTO> testGetByNameEmployee = employeeService.getByNameEmployee("nhân viên 5");
		assertNotNull(testGetByNameEmployee);
	}

	@Test
	public void testGetEmployeeManager() {
		List<EmployeeDTO> testGetEmployeeManager = employeeService.GetEmployeeManager();
		assertNotNull(testGetEmployeeManager);
	}

	@Test
	public void testGetEmployeeWorking() {
		List<EmployeeDTO> testGetEmployeeWorking = employeeService.getEmployeeWorking();
		assertNotNull(testGetEmployeeWorking);
	}

	@Test
	public void testGetGenderEmployee() {
		List<EmployeeDTO> testGetGenderEmployee = employeeService.getGenderEmployee();
		assertNotNull(testGetGenderEmployee);
	}
}
