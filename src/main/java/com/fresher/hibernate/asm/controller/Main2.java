package com.fresher.hibernate.asm.controller;

import com.fresher.hibernate.asm.DTO.CustomerDTO;
import com.fresher.hibernate.asm.service.CustomerService;

public class Main2 {
	public static void main(String[] args) {
		CustomerService customerService = new CustomerService();
		
		CustomerDTO cus = new CustomerDTO(5L, "khac hang 5", "HCM","0123456789");
		
		customerService.saveOrUpdate(cus);
	}
}
