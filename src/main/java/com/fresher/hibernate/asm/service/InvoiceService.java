package com.fresher.hibernate.asm.service;

import java.util.ArrayList;
import java.util.List;

import com.fresher.hibernate.asm.DAO.InvoiceDAO;
import com.fresher.hibernate.asm.DTO.InvoiceDTO;
import com.fresher.hibernate.asm.entitis.Invoice;

public class InvoiceService {
	InvoiceDAO invoiceDAO = new InvoiceDAO();

	/**
	 * Add new a Invoice
	 * 
	 * @param invoiceDto
	 * @throws Exception
	 */

	public void addNew(InvoiceDTO invoiceDTO) throws Exception {

		if (invoiceDTO.getInvoiceId() <= 0) {
			throw new Exception("You can't use ID less 0");
		}
		Invoice invoice = new Invoice(invoiceDTO);

		invoiceDAO.addNew(invoice);
	}

	/**
	 * Get All Invoice
	 * 
	 * @return List Invoice
	 */

	public List<InvoiceDTO> getAll() {

		List<InvoiceDTO> listInvoiceDTO = new ArrayList<>();
		List<Invoice> listInvoiceEntity = invoiceDAO.getAll();
		
		
		for(Invoice invoice :listInvoiceEntity) {
			InvoiceDTO invoiceDTO = new InvoiceDTO(invoice);
			listInvoiceDTO.add(invoiceDTO);
		}
		return listInvoiceDTO;
	
	}

	/**
	 * Get Invoice By ID
	 * 
	 * @param id
	 * @return List Invoice Get By Id
	 * @throws Exception
	 */

	public InvoiceDTO getById(Long id) throws Exception {

		if (id <= 0) {
			throw new Exception("You can't use ID less 0");
		}

		Invoice invoice = invoiceDAO.getById(id);
		InvoiceDTO invoiceDTO = new InvoiceDTO(invoice);

		return invoiceDTO;
	}

	/**
	 * Delete Invoice by ID
	 * 
	 * @param id
	 * @throws Exception
	 */

	public void deleteById(Long id) throws Exception {

		if (id <= 0) {
			throw new Exception("You can't delete ID less 0");
		}
		invoiceDAO.deleteById(id);
	}

	/**
	 * saveOrUpdate Invoice
	 * 
	 * @param invoiceDTO
	 */

	public void saveOrUpdate(InvoiceDTO invoiceDTO) {

		Invoice invoice = new Invoice(invoiceDTO);
		invoiceDAO.saveOrUpdate(invoice);
	}

	/**
	 * Get Invoice Total with Money
	 * 
	 * @param momey
	 * @return List Invoice Total with Money
	 */
	
	public List<InvoiceDTO> GetInvoiceTotal() {

		List<InvoiceDTO> listInvoiceDTO = new ArrayList<>();
		List<Invoice> listInvoiceEntity = invoiceDAO.GetInvoiceTotal(2000);

		for (Invoice invoice : listInvoiceEntity) {
			InvoiceDTO dto = new InvoiceDTO(invoice);
			listInvoiceDTO.add(dto);
		}
		return listInvoiceDTO;

	}
}
