package com.fresher.hibernate.asm.service;

import java.util.ArrayList;
import java.util.List;

import com.fresher.hibernate.asm.DAO.InvoiceDetailsDAO;
import com.fresher.hibernate.asm.DTO.InvoiceDetailsDTO;
import com.fresher.hibernate.asm.entitis.InvoiceDetails;

public class InvoiceDetailsService {
	
	InvoiceDetailsDAO invoiceDetailsDAO = new InvoiceDetailsDAO();
	
	/**
	 * Add new a invoiceDetails
	 * 
	 * @param invoiceDetailsDTO
	 * @throws Exception 
	 */

	public void addNew(InvoiceDetailsDTO invoiceDetailsDTO) throws Exception {
		
		if (invoiceDetailsDTO.getInvoiceDetailId() <= 0) {
			throw new Exception("You can't use ID less 0");
		}	
		InvoiceDetails invoiceDetails = new InvoiceDetails (invoiceDetailsDTO);

		invoiceDetailsDAO.addNew(invoiceDetails);
	}
	
	/**
	 * Get All InvoiceDetails
	 * 
	 * @return List InvoiceDetails
	 */

	public List<InvoiceDetailsDTO> getAll() {

		List<InvoiceDetailsDTO> listInvoiceDetailsDTO = new ArrayList<>();
		List<InvoiceDetails> listInvoiceDetailsEntity = invoiceDetailsDAO.getAll();
		
		for (InvoiceDetails invoiceDetails : listInvoiceDetailsEntity) {
			InvoiceDetailsDTO invoiceDetailsDTO = new InvoiceDetailsDTO(invoiceDetails);
			listInvoiceDetailsDTO.add(invoiceDetailsDTO);
		}
		
		return listInvoiceDetailsDTO;
	}
	
	/**
	 * Get invoiceDetails By ID
	 * 
	 * @param id
	 * @return List InvoiceDetails Get By ID
	 * @throws Exception 
	 */

	public InvoiceDetailsDTO getById(Long id) throws Exception {
		
		if (id <= 0) {
			throw new Exception("You can't use ID less 0");
		}

		InvoiceDetails invoiceDetails = invoiceDetailsDAO.getById(id);
		InvoiceDetailsDTO invoiceDetailsDTO = new InvoiceDetailsDTO(invoiceDetails);

		return invoiceDetailsDTO;
	}
	
	/**
	 * Delete invoiceDetails by ID
	 * 
	 * @param id
	 * @throws Exception 
	 */

	public void deleteById(Long id) throws Exception {
		
		if (id <= 0) {
			throw new Exception("You can't delete ID less 0");
		}

		invoiceDetailsDAO.deleteById(id);
	}
	
	/**
	 * saveOrUpdate InvoiceDetails
	 * 
	 * @param invoiceDetailsDTO
	 */

	public void saveOrUpdate(InvoiceDetailsDTO invoiceDetailsDTO) {

		InvoiceDetails invoiceDetails = new InvoiceDetails(invoiceDetailsDTO);

		invoiceDetailsDAO.saveOrUpdate(invoiceDetails);
	}
	
	
}
