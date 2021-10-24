package com.fresher.hibernate.asm.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.hibernate.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fresher.hibernate.asm.DTO.CustomerDTO;
import com.fresher.hibernate.asm.DTO.MaterialDTO;
import com.fresher.hibernate.asm.service.MaterialService;

public class MaterialServiceTest {

	private Session session;

	MaterialService materialService = new MaterialService();

	@Test
	public void testAddNewMaterial() throws Exception {
		MaterialDTO materialDTO = new MaterialDTO(20L, "bong ali");
		boolean success = false;
		materialService.addNew(materialDTO);
		success = true;
		assertEquals(true, success);
		materialService.deleteById(20L);
	}

	@Test
	public void testAddNewMaterial_IDNegative() {

		MaterialDTO materialDTO = new MaterialDTO(-8L, "bong ali");
		assertEquals(-8L, materialDTO.getMaterialId());

		Assertions.assertThrows(Exception.class, () -> {
			materialService.addNew(materialDTO);
		});
	}

	@Test
	public void testGetAllMaterial() {
		List<MaterialDTO> testGetAllMaterialDTO = materialService.getAll();
		Assertions.assertFalse(testGetAllMaterialDTO.isEmpty());
	}

	@Test
	public void testGetMaterialByID() throws Exception {
		MaterialDTO testGetMaterialByID = materialService.getById(2L);
		assertEquals("nhung", testGetMaterialByID.getMaterialName());
	}

	@Test
	public void testGetMaterialByID_IDNegative() throws Exception {
		Assertions.assertThrows(Exception.class, () -> {
			materialService.getById(-2L);
		});
	}

	@Test
	public void testDeleteMaterialByID() throws Exception {
		
		MaterialDTO materialDTO = new MaterialDTO(20L, "kaki");
		
		materialService.addNew(materialDTO);
		
		materialService.deleteById(20L);

		Assertions.assertNotNull(materialDTO.getMaterialId());

	}

	@Test
	public void testDeleteMaterialByID_IDNegative() throws Exception {
		Assertions.assertThrows(Exception.class, () -> {
			materialService.deleteById(-2L);
		});
	}
	
	@Test
	public void testSaveOrUpdateMaterial() throws Exception {

		MaterialDTO materialDTO = new MaterialDTO(5L, "kakii");
		
		materialService.saveOrUpdate(materialDTO);
		MaterialDTO testSaveOrUpdateMaterial = materialService.getById(5L);
		assertEquals("kaki", testSaveOrUpdateMaterial.getMaterialName());
	}
	
	@Test
	public void testGetMaterialByName() {
		List<MaterialDTO> testGetMaterialByName = materialService.getByNameMaterial("thun");
		assertNotNull(testGetMaterialByName);
	}
}
