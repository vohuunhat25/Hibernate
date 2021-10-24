package com.fresher.hibernate.asm.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fresher.hibernate.asm.DTO.DutyDTO;
import com.fresher.hibernate.asm.service.DutyService;

public class DutyServiceTest {

	DutyService dutyService = new DutyService();

	@Test
	public void testGetDutyById() throws Exception {
		DutyDTO a = dutyService.getById(1L);
		assertEquals("quản lý", a.getDutyName());
	}

	@Test
	public void testGetDutyById_IdNegative() {
		Assertions.assertThrows(Exception.class, () -> {
			dutyService.getById(-10L);
		});
	}
	
	@Test
	public void testGetAllDuty() {
		List<DutyDTO> testGetAllDutyDTO = dutyService.getAll();
		Assertions.assertFalse(testGetAllDutyDTO.isEmpty());
	}
	
	@Test
	public void testAddNewDuty() throws Exception {
		DutyDTO testAddNewDutyDTO = new DutyDTO(20L,"quản lý cao cap");
		boolean success = false;
		dutyService.addNew(testAddNewDutyDTO);
		success = true;
		assertEquals(true, success);
		dutyService.deleteById(20L);	
	}

	@Test
	public void testAddNewDuty_IdNegative() {
		DutyDTO testAddNewDutyDTOIdNegative = new DutyDTO(-4L,"quản lý cao cap");
		assertEquals(-4L, testAddNewDutyDTOIdNegative.getDutyId());
		
		Assertions.assertThrows(Exception.class, () -> {
			dutyService.addNew(testAddNewDutyDTOIdNegative);
		});
	}
	
	@Test
	public void testDeleteByID() throws Exception {
		
		DutyDTO dutyDTO = new DutyDTO(6L,"alalala");
		
		dutyService.addNew(dutyDTO);
		
		Long idDeleteDuty = 6L;
		
		dutyService.deleteById(idDeleteDuty);	
		
		Assertions.assertNotNull(dutyDTO.getDutyId());
		
		
	}
	
	@Test
	public void testDeleteByID_IdNegative() {
		Long idDeleteDuty = -2L;
		Assertions.assertThrows(Exception.class, () -> {
			dutyService.deleteById(idDeleteDuty);
		});
	}
	
	@Test
	public void testSaveOrUpdateDuty() throws Exception {

		DutyDTO testSaveOrUpdate = new DutyDTO(4L, "quản lý cao cấp");
		dutyService.saveOrUpdate(testSaveOrUpdate);
		DutyDTO testSaveOrUpdate2 = dutyService.getById(4L);
		assertEquals("thủ kho", testSaveOrUpdate2.getDutyName());
	}
	
	@Test
	public void testGetByNameDuty() {
		List<DutyDTO> testGetByName = dutyService.getByNameDuty("quản lý");
		assertNotNull(testGetByName);
	}
}
