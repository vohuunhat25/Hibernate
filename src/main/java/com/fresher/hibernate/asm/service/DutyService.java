package com.fresher.hibernate.asm.service;

import java.util.ArrayList;
import java.util.List;

import com.fresher.hibernate.asm.DAO.DutyDAO;
import com.fresher.hibernate.asm.DTO.DutyDTO;
import com.fresher.hibernate.asm.entitis.Duty;

public class DutyService {
	DutyDAO dutyDAO = new DutyDAO();

	/**
	 * Add new a Duty
	 * 
	 * @param dutyDTO
	 * @throws Exception
	 */

	public void addNew(DutyDTO dutyDTO) throws Exception {

		if (dutyDTO.getDutyId() <= 0) {
			throw new Exception("you can't leave the name blank ");
		}
		
		Duty duty = new Duty(dutyDTO);
		dutyDAO.addNew(duty);
	}

	/**
	 * Get All Duty
	 * 
	 * @return List All Duty
	 */

	public List<DutyDTO> getAll() {

		List<DutyDTO> listDutyDTO = new ArrayList<>();

		List<Duty> listDutyEntity = dutyDAO.getAll();

		for (Duty duty : listDutyEntity) {
			DutyDTO dto = new DutyDTO(duty);
			listDutyDTO.add(dto);
		}
		return listDutyDTO;
	}

	/**
	 * Get Duty By ID
	 * 
	 * @param id
	 * @return List Duty Get By ID
	 * @throws Exception
	 */

	public DutyDTO getById(Long id) throws Exception {

		if (id <= 0) {
			throw new Exception("You can't use ID less 0");
		}

		Duty dutyEntity = dutyDAO.getById(id);
		DutyDTO dutyDTO = new DutyDTO(dutyEntity);
		
		return dutyDTO;
	}

	/**
	 * Delete Duty by ID
	 * 
	 * @param id
	 * @throws Exception
	 */

	public void deleteById(Long id) throws Exception {

		if (id <= 0) {
			throw new Exception("You can't delete ID less 0");
		}

		dutyDAO.deleteById(id);
	}
	
	/**
	 * saveOrUpdate Duty
	 * 
	 * @param dutyDTO
	 */

	public void saveOrUpdate(DutyDTO dutyDTO) {

		Duty duty = new Duty(dutyDTO);

		dutyDAO.saveOrUpdate(duty);
	}
	
	/**
	 * Get Duty by name
	 * 
	 * @param name
	 * @return list duty get by name
	 */

	public List<DutyDTO> getByNameDuty (String name) {

		List<DutyDTO> listDutyDTO = new ArrayList<>();

		List<Duty> listDutyEntity = dutyDAO.getByNameDuty(name);

		for (Duty duty : listDutyEntity) {
			DutyDTO dto = new DutyDTO(duty);
			listDutyDTO.add(dto);
		}
		return listDutyDTO;
	}
}
