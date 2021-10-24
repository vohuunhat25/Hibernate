package com.fresher.hibernate.asm.service;

import java.util.ArrayList;
import java.util.List;

import com.fresher.hibernate.asm.DAO.MaterialDAO;
import com.fresher.hibernate.asm.DTO.MaterialDTO;
import com.fresher.hibernate.asm.entitis.Material;

public class MaterialService {
	MaterialDAO materialDAO = new MaterialDAO();

	/**
	 * Add new a Material
	 * 
	 * @param materialDTO
	 * @throws Exception
	 */

	public void addNew(MaterialDTO materialDTO) throws Exception {

		if (materialDTO.getMaterialId() <= 0) {
			throw new Exception("You can't use ID less 0");
		}

		Material material = new Material(materialDTO);
		materialDAO.addNew(material);
	}

	/**
	 * Get All Material
	 * 
	 * @return List Material
	 */

	public List<MaterialDTO> getAll() {

		List<MaterialDTO> listMaterialDTO = new ArrayList<>();
		List<Material> listMaterialEntity = materialDAO.getAll();

		for (Material material : listMaterialEntity) {
			MaterialDTO dto = new MaterialDTO(material);
			listMaterialDTO.add(dto);
		}
		return listMaterialDTO;
	}

	/**
	 * Get Material By ID
	 * 
	 * @param id
	 * @return Material Get By Id
	 * @throws Exception
	 */

	public MaterialDTO getById(Long id) throws Exception {

		if (id <= 0) {
			throw new Exception("You can't use ID less 0");
		}
		
		Material material = materialDAO.getById(id);
		MaterialDTO materialDTO = new MaterialDTO(material);

		return materialDTO;
	}

	/**
	 * Delete Material by ID
	 * 
	 * @param id
	 * @throws Exception
	 */

	public void deleteById(Long id) throws Exception {

		if (id <= 0) {
			throw new Exception("You can't delete ID less 0");
		}

		materialDAO.deleteById(id);
	}

	/**
	 * saveOrUpdate Material
	 * 
	 * @param materialDTO
	 */

	public void saveOrUpdate(MaterialDTO materialDTO) {

		Material material = new Material(materialDTO);
		materialDAO.saveOrUpdate(material);
	}

	/**
	 * Get Material By Name
	 * 
	 * @param name
	 * @return List Material By Name
	 */

	public List<MaterialDTO> getByNameMaterial(String name) {

		List<MaterialDTO> listMaterialDTO = new ArrayList<>();
		List<Material> listMaterialEntity = materialDAO.getByName(name);

		for (Material material : listMaterialEntity) {
			MaterialDTO dto = new MaterialDTO(material);
			listMaterialDTO.add(dto);
		}
		return listMaterialDTO;

	}
}
