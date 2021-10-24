package com.fresher.hibernate.asm.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fresher.hibernate.asm.DTO.CustomerDTO;
import com.fresher.hibernate.asm.DTO.DutyDTO;
import com.fresher.hibernate.asm.DTO.EmployeeDTO;
import com.fresher.hibernate.asm.DTO.InvoiceDTO;
import com.fresher.hibernate.asm.service.InvoiceService;

public class InvoiceServiceTest {

	InvoiceService invoiceService = new InvoiceService();

	@Test
	public void testAddNewInvoice() throws Exception {

		InvoiceService invoiceService = new InvoiceService();

		CustomerDTO CustomerDTO = new CustomerDTO(3L, "Hồ Chí Minh", "nha", "0365871481");

		DutyDTO DutyDTO = new DutyDTO(3L, "nhân viên");

		EmployeeDTO EmployeeDTO = new EmployeeDTO(2L, "nguyễn văn a", "nam", "1997-08-08", "bình định", "2009-02-03",
				"đang làm việc", "123456789", DutyDTO);

		InvoiceDTO invoiceDTO = new InvoiceDTO(20L, "2020-12-14", 5000, CustomerDTO, EmployeeDTO);
		boolean success = false;
		invoiceService.addNew(invoiceDTO);
		success = true;
		assertEquals(true, success);
		invoiceService.deleteById(20L);

	}

	@Test
	public void testGetInvoiceId_IDNegative() {

		CustomerDTO CustomerDTO = new CustomerDTO(3L, "Hồ Chí Minh", "nha", "0365871481");

		DutyDTO DutyDTO = new DutyDTO(3L, "nhân viên");

		EmployeeDTO EmployeeDTO = new EmployeeDTO(2L, "nguyễn văn a", "nam", "1997-08-08", "bình định", "2009-02-03",
				"đang làm việc", "123456789", DutyDTO);

		InvoiceDTO invoiceDTO = new InvoiceDTO(-8L, "2020-12-14", 5000, CustomerDTO, EmployeeDTO);
		assertEquals(-8L, invoiceDTO.getInvoiceId());

		Assertions.assertThrows(Exception.class, () -> {
			invoiceService.addNew(invoiceDTO);
		});
	}

	@Test
	public void testGetInvoiceByID() throws Exception {
		InvoiceDTO testGetInvoiceByID = invoiceService.getById(1L);
		assertEquals(1L, testGetInvoiceByID.getInvoiceId());
	}

	@Test
	public void testGetInvoiceByID_IDNegative() {
		Assertions.assertThrows(Exception.class, () -> {
			invoiceService.getById(-100L);
		});
	}

	@Test
	public void testDeleteInvoiceByID() throws Exception {

		CustomerDTO CustomerDTO = new CustomerDTO(3L, "Hồ Chí Minh", "nha", "0365871481");

		DutyDTO DutyDTO = new DutyDTO(3L, "nhân viên");

		EmployeeDTO EmployeeDTO = new EmployeeDTO(2L, "nguyễn văn a", "nam", "1997-08-08", "bình định", "2009-02-03",
				"đang làm việc", "123456789", DutyDTO);

		InvoiceDTO invoiceDTO = new InvoiceDTO(20L, "2020-12-14", 5000, CustomerDTO, EmployeeDTO);

		invoiceService.addNew(invoiceDTO);

		invoiceService.deleteById(20L);

		Assertions.assertNotNull(invoiceDTO.getInvoiceId());

	}

	@Test
	public void testDeleteInvoiceByID_IDNegative() {
		Assertions.assertThrows(Exception.class, () -> {
			invoiceService.deleteById(-100L);
		});
	}

	@Test
	public void testSaveOrUpdateInvoice() throws Exception {

		CustomerDTO CustomerDTO = new CustomerDTO(3L, "Hồ Chí Minh", "nha", "0365871481");

		DutyDTO DutyDTO = new DutyDTO(3L, "nhân viên");

		EmployeeDTO EmployeeDTO = new EmployeeDTO(2L, "nguyễn văn a", "nam", "1997-08-08", "bình định", "2009-02-03",
				"đang làm việc", "123456789", DutyDTO);

		InvoiceDTO testSaveOrUpdateInvoice = new InvoiceDTO(2L, "2020-12-14", 5000, CustomerDTO, EmployeeDTO);
		invoiceService.saveOrUpdate(testSaveOrUpdateInvoice);
		InvoiceDTO invoiceDTO = invoiceService.getById(2L);
		assertEquals(2L, invoiceDTO.getInvoiceId());
	}

	@Test
	public void testGetInvoiceTotal() {
		List<InvoiceDTO> testGetInvoiceTotal = invoiceService.GetInvoiceTotal();
		Assertions.assertFalse(testGetInvoiceTotal.isEmpty());
	}

	@Test
	public void testGetAllInvoice() {
		List<InvoiceDTO> testGetAllInvoice = invoiceService.getAll();
		Assertions.assertFalse(testGetAllInvoice.isEmpty());
	}

}
