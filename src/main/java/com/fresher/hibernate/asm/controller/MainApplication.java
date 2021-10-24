package com.fresher.hibernate.asm.controller;

import java.io.IOException;
import java.util.Scanner;

import com.fresher.hibernate.asm.service.CustomerService;
import com.fresher.hibernate.asm.service.DutyService;
import com.fresher.hibernate.asm.service.EmployeeService;
import com.fresher.hibernate.asm.service.InvoiceDetailsService;
import com.fresher.hibernate.asm.service.InvoiceService;
import com.fresher.hibernate.asm.service.MaterialService;
import com.fresher.hibernate.asm.service.ProductService;
import com.fresher.hibernate.asm.service.ReadFile;

public class MainApplication {

	public static void main(String[] args) {

		CustomerService customerService = new CustomerService();

		DutyService dutyService = new DutyService();

		EmployeeService employeeService = new EmployeeService();

		InvoiceDetailsService invoiceDetailsService = new InvoiceDetailsService();

		InvoiceService invoiceService = new InvoiceService();

		MaterialService materialService = new MaterialService();

		ProductService productService = new ProductService();
		
		ReadFile readFile = new ReadFile();

		System.out.println("--------------MANAGER SHOP-----------------");
		System.out.println("Chosse one:");
		System.out.println("1. Communication Customer ");
		System.out.println("2. Communication Duty ");
		System.out.println("3. Communication Employee ");
		System.out.println("4. Communication Invoice Details ");
		System.out.println("5. Communication Invoice ");
		System.out.println("6. Communication Material ");
		System.out.println("7. Communication Product ");

		Scanner sc = new Scanner(System.in);
		int chosse = sc.nextInt();
		
		switch (chosse) {
		case 1:
			System.out.println("What do you want to do with Customers? ");
			System.out.println("1: Add new Customer");
			System.out.println("2: Get all Customer: ");
			System.out.println("3: Get Customer By Id");
			System.out.println("4: Delete Customer By ID");
			System.out.println("5: Save or Update Customer");
			System.out.println("6: Get Customer By Name");
			int chosseCustomer = sc.nextInt();

			switch (chosseCustomer) {
			case 1:
				System.out.println("Add new Customer");
				try {
					customerService.addNew(readFile.readCustomer().get(0));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				System.out.println("Get all Customer: ");
				System.out.println(customerService.getAll());
				break;
			case 3:
				System.out.println("Get Customer By Id");
				try {
					System.out.println(customerService.getById(readFile.readId().get(0)));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 4:
				System.out.println("Delete Customer By ID");
				try {
					customerService.deleteById(readFile.readId().get(1));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 5:
				System.out.println("Save or Update Customer");
				customerService.saveOrUpdate(readFile.readCustomer().get(3));
				break;
			case 6:
				System.out.println("Get Customer By Name");
				System.out.println( customerService.getByNameCustomer(readFile.readName().get(0)));
				break;
			}
			break;

		case 2:
			System.out.println("What do you want to do with Duty ? ");
			System.out.println("1: Add new Duty");
			System.out.println("2: Get all Duty");
			System.out.println("3: Get Duty By Id");
			System.out.println("4: Delete Duty By ID");
			System.out.println("5: Save or Update Duty");
			System.out.println("6: Get Duty By Name");
			int chosseDuty = sc.nextInt();

			switch (chosseDuty) {
			case 1:
				System.out.println("Add new Duty");
				try {
					dutyService.addNew(readFile.ReadDuty().get(0));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				System.out.println("Get all Duty: ");
				System.out.println(dutyService.getAll());
				break;
			case 3:
				System.out.println("Get Duty By Id");
				try {
					System.out.println(dutyService.getById(readFile.readId().get(0)));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 4:
				System.out.println("Delete Duty By ID");
				try {
					dutyService.deleteById(readFile.readId().get(5));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 5:
				System.out.println("Save or Update Duty");
				try {
					dutyService.saveOrUpdate(readFile.ReadDuty().get(3));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 6:
				System.out.println("Get Duty By Name");
				System.out.println(dutyService.getByNameDuty(readFile.readNameDuty().get(0)));
				break;
			}
			break;

		case 3:
			System.out.println("What do you want to do with Employee ? ");
			System.out.println("1: Add new Employee");
			System.out.println("2: Get all Employee ");
			System.out.println("3: Get Employee By Id");
			System.out.println("4: Delete Employee By ID");
			System.out.println("5: Save or Update Employee");
			System.out.println("6: Get Employee By Name");
			System.out.println("7: Get Employee Manager");
			System.out.println("8: Get Employee Working");
			System.out.println("9: Get Gender Employee");
			int chosseEmployee = sc.nextInt();

			switch (chosseEmployee) {
			case 1:
				System.out.println("Add new Employee");
				try {
					employeeService.addNew(readFile.readEmployee().get(0));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				System.out.println("Get all Employee ");
				employeeService.getAll();
				break;
			case 3:
				System.out.println("Get Employee By Id");
				try {
					employeeService.getById(readFile.readId().get(0));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 4:
				System.out.println("Delete Employee By ID");
				try {
					employeeService.deleteById(readFile.readId().get(1));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 5:
				System.out.println("Save or Update Employee");
				employeeService.saveOrUpdate(readFile.readEmployee().get(1));
				break;
			case 6:
				System.out.println("Get Employee By Name");
				System.out.println(employeeService.getByNameEmployee(readFile.readNameEmployee().get(0)));
				break;
			case 7:
				System.out.println("Get Employee Manager");
				System.out.println(employeeService.GetEmployeeManager());
				break;
			case 8:
				System.out.println("Get Employee Working");
				System.out.println(employeeService.getEmployeeWorking());
				break;
			case 9:
				System.out.println("Get Gender Employee");
				System.out.println(employeeService.getGenderEmployee());
				break;
			}
			break;

		case 4:
			System.out.println("What do you want to do with InvoiceDetails? ");
			System.out.println("1: Add new InvoiceDetails");
			System.out.println("2: Get all InvoiceDetails");
			System.out.println("3: Get InvoiceDetails By Id");
			System.out.println("4: Delete InvoiceDetails By ID");
			System.out.println("5: Save or Update InvoiceDetails");
			int chosseInvoiceDetails = sc.nextInt();

			switch (chosseInvoiceDetails) {
			case 1:
				System.out.println("Add new InvoiceDetails");
				try {
					invoiceDetailsService.addNew(readFile.readInvoiceDetails().get(0));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				System.out.println("Get all InvoiceDetails");
				System.out.println(invoiceDetailsService.getAll());
				break;
			case 3:
				System.out.println("Get InvoiceDetails By Id");
				try {
					System.out.println(invoiceDetailsService.getById(readFile.readId().get(0)));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 4:
				System.out.println("Delete InvoiceDetails By ID");
				try {
					invoiceDetailsService.deleteById(readFile.readId().get(1));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 5:
				System.out.println("Save or Update InvoiceDetails");
				invoiceDetailsService.saveOrUpdate(readFile.readInvoiceDetails().get(0));
				break;
			}
			break;
		case 5: 
			System.out.println("What do you want to do with Invoice ? ");
			System.out.println("1: Add new Invoice");
			System.out.println("2: Get all Invoice ");
			System.out.println("3: Get Invoice By Id");
			System.out.println("4: Delete Invoice By ID");
			System.out.println("5: Save or Update Invoice");
			System.out.println("6: Get Invoice Total With Money 2000");
			
			int chosseInvoice = sc.nextInt();

			switch (chosseInvoice) {
			case 1:
				System.out.println("Add new Invoice");
				try {
					invoiceService.addNew(readFile.readInvoice().get(0));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				System.out.println("Get all Invoice ");
				System.out.println(invoiceService.getAll());
				break;
			case 3:
				System.out.println("Get Invoice By Id");
				try {
					invoiceService.getById(readFile.readId().get(0));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 4:
				System.out.println("Delete Invoice By ID");
				try {
					invoiceService.deleteById(readFile.readId().get(1));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 5:
				System.out.println("Save or Update Invoice");
				invoiceService.saveOrUpdate(readFile.readInvoice().get(0));
				break;
			case 6:
				System.out.println("Get Invoice Total With Money 2000");
				invoiceService.GetInvoiceTotal();
				break;
			}
			break;
		case 6:
			System.out.println("What do you want to do with Material ? ");
			System.out.println("1: Add new Material");
			System.out.println("2: Get all Material ");
			System.out.println("3: Get Material By Id");
			System.out.println("4: Delete Material By ID");
			System.out.println("5: Save or Update Material");
			System.out.println("6: Get Material By Name");
			int chosseMaterial = sc.nextInt();

			switch (chosseMaterial) {
			case 1:
				System.out.println("Add new Material");
				try {
					materialService.addNew(readFile.ReadMaterial().get(0));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				System.out.println("Get all Material ");
				System.out.println(materialService.getAll());
				break;
			case 3:
				System.out.println("Get Material By Id");
				try {
					System.out.println(materialService.getById(readFile.readId().get(0)));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 4:
				System.out.println("Delete Material By ID");
				try {
					materialService.deleteById(readFile.readId().get(2));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 5:
				System.out.println("Save or Update Material");
				try {
					materialService.saveOrUpdate(readFile.ReadMaterial().get(0));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 6:
				System.out.println("Get Material By Name");
				System.out.println( materialService.getByNameMaterial(readFile.readMaterialName().get(0)));
				break;
			}
			break;
		case 7:
			System.out.println("What do you want to do with Product ? ");
			System.out.println("1: Add new Product");
			System.out.println("2: Get all Product ");
			System.out.println("3: Get Product By Id");
			System.out.println("4: Delete Product By ID");
			System.out.println("5: Save or Update Product");
			System.out.println("6: Get Product By Name");
			System.out.println("7: Get Top 3 Product Best Saler");
			int chosseProduct = sc.nextInt();

			switch (chosseProduct) {
			case 1:
				System.out.println("Add new Product");
				try {
					productService.addnew(readFile.readProduct().get(0));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				System.out.println("Get all Product ");
				System.out.println(productService.getAll());
				break;
			case 3:
				System.out.println("Get Product By Id");
				try {
					System.out.println(productService.getById(readFile.readId().get(0)));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 4:
				System.out.println("Delete Product By ID");
				try {
					productService.deleteById(readFile.readId().get(3));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 5:
				System.out.println("Save or Update Product");
				productService.saveOrUpdate(readFile.readProduct().get(0));
				break;
			case 6:
				System.out.println("Get Product By Name");
				System.out.println( productService.getByNameProduct(readFile.readProductName().get(0)));
				break;
			case 7: 
				System.out.println("Get Top 3 Product Best Saler");
				System.out.println( productService.getTop3ProductBiggestPrice());
			}
			break;
		}
	}
}