package com.fresher.hibernate.asm.test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fresher.hibernate.asm.DTO.CustomerDTO;
import com.fresher.hibernate.asm.DTO.DutyDTO;
import com.fresher.hibernate.asm.DTO.EmployeeDTO;
import com.fresher.hibernate.asm.DTO.InvoiceDTO;
import com.fresher.hibernate.asm.DTO.InvoiceDetailsDTO;
import com.fresher.hibernate.asm.service.InvoiceDetailsService;

public class InvoiceDetailsServiceTest {

	InvoiceDetailsService invoiceDetailsService = new InvoiceDetailsService();

	@Test
	public void testGetAllInvoiceDetails() {
		List<InvoiceDetailsDTO> invoiceDetailsDTO = invoiceDetailsService.getAll();
		assertFalse(invoiceDetailsDTO.isEmpty());
	}

	@Test
	public void testAddNewInvoiceDetailsService() throws Exception {

		CustomerDTO CustomerDTO = new CustomerDTO(5L, "nguyễn văn e", "Hồ Chí Minh", "0159357741");

		DutyDTO dutyDTO = new DutyDTO(4L, "thủ kho");

		EmployeeDTO employeeDTO = new EmployeeDTO(5L, "nhân viên 5", "nam", "1993-05-01", "Đồng Nai", "2020-04-08",
				"đang làm việc", "123456789", dutyDTO);

		InvoiceDTO invoiceDTO = new InvoiceDTO(4L, "2020-12-14", 5000, CustomerDTO, employeeDTO);

		InvoiceDetailsDTO invoiceDetailsDTO = new InvoiceDetailsDTO(20L, 10, 200, 5000, 4800, invoiceDTO);

		boolean success = false;
		invoiceDetailsService.addNew(invoiceDetailsDTO);
		success = true;
		assertEquals(true, success);
		invoiceDetailsService.deleteById(20L);
	}

	@Test
	public void testAddNewInvoiceDetailsService_IdNegative() {

		CustomerDTO customerDTO = new CustomerDTO(5L, "nguyễn văn e", "Hồ Chí Minh", "0159357741");

		DutyDTO dutyDTO = new DutyDTO(4L, "thủ kho");

		EmployeeDTO employeeDTO = new EmployeeDTO(5L, "nhân viên 5", "nam", "1993-05-01", "Đồng Nai", "2020-04-08",
				"đang làm việc", "123456789", dutyDTO);

		InvoiceDTO invoiceDTO = new InvoiceDTO(4L, "2020-12-14", 5000, customerDTO, employeeDTO);

		InvoiceDetailsDTO invoiceDetailsDTO = new InvoiceDetailsDTO(-6L, 10, 200, 5000, 4800, invoiceDTO);

		assertEquals(-6L, invoiceDetailsDTO.getInvoiceDetailId());

		Assertions.assertThrows(Exception.class, () -> {
			invoiceDetailsService.addNew(invoiceDetailsDTO);
		});
	}

	@Test
	public void testGetByIDInvoiceDetails() throws Exception {
		InvoiceDetailsDTO testGetByIDInvoiceDetails = invoiceDetailsService.getById(3L);
		assertEquals(3L, testGetByIDInvoiceDetails.getInvoiceDetailId());
	}

	@Test
	public void testGetByIDInvoiceDetails_IDNegative() throws Exception {
		Assertions.assertThrows(Exception.class, () -> {
			invoiceDetailsService.getById(-2L);
		});
	}

	@Test
	public void testDeleteInvoiceDetailsByID() throws Exception {

		CustomerDTO CustomerDTO = new CustomerDTO(5L, "nguyễn văn e", "Hồ Chí Minh", "0159357741");

		DutyDTO dutyDTO = new DutyDTO(4L, "thủ kho");

		EmployeeDTO employeeDTO = new EmployeeDTO(5L, "nhân viên 5", "nam", "1993-05-01", "Đồng Nai", "2020-04-08",
				"đang làm việc", "123456789", dutyDTO);

		InvoiceDTO invoiceDTO = new InvoiceDTO(4L, "2021-09-02", 3600, CustomerDTO, employeeDTO);

		InvoiceDetailsDTO invoiceDetailsDTO = new InvoiceDetailsDTO(20L, 50, 5000, 300, 4700, invoiceDTO);

		invoiceDetailsService.addNew(invoiceDetailsDTO);

		invoiceDetailsService.deleteById(20L);

		Assertions.assertNotNull(invoiceDetailsDTO.getInvoiceDetailId());

	}

	@Test
	public void testDeleteByID_IdNegative() {

		Assertions.assertThrows(Exception.class, () -> {
			invoiceDetailsService.deleteById(-2L);
		});
	}

	@Test
	public void testSaveOrUpdateInvoiceDetails() throws Exception {

		CustomerDTO CustomerDTO = new CustomerDTO(5L, "nguyễn văn e", "Hồ Chí Minh", "0159357741");

		DutyDTO dutyDTO = new DutyDTO(4L, "thủ kho");

		EmployeeDTO employeeDTO = new EmployeeDTO(5L, "nhân viên 5", "nam", "1993-05-01", "Đồng Nai", "2020-04-08",
				"đang làm việc", "123456789", dutyDTO);

		InvoiceDTO invoiceDTO = new InvoiceDTO(4L, "2021-09-02", 3600, CustomerDTO, employeeDTO);

		InvoiceDetailsDTO invoiceDetailsDTO = new InvoiceDetailsDTO(5L, 50, 5000, 300, 4700, invoiceDTO);
		
		invoiceDetailsService.saveOrUpdate(invoiceDetailsDTO);
		InvoiceDetailsDTO testSaveOrUpdateInvoiceDetails = invoiceDetailsService.getById(5L);
		assertEquals(4000, testSaveOrUpdateInvoiceDetails.getPrice());
	}
}
