package com.fresher.hibernate.asm.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fresher.hibernate.asm.DTO.CustomerDTO;
import com.fresher.hibernate.asm.DTO.DutyDTO;
import com.fresher.hibernate.asm.DTO.EmployeeDTO;
import com.fresher.hibernate.asm.DTO.InvoiceDTO;
import com.fresher.hibernate.asm.DTO.InvoiceDetailsDTO;
import com.fresher.hibernate.asm.DTO.MaterialDTO;
import com.fresher.hibernate.asm.DTO.ProductDTO;

public class ReadFile {

	/**
	 * Read Customer.txt
	 * 
	 * @return List Customer in file Customer.txt
	 */

	public List<CustomerDTO> readCustomer() {

		List<CustomerDTO> listOfCustomerDTO = new ArrayList<>();

		File file = new File("Customer.txt");
		BufferedReader br = null;

		try {

			br = new BufferedReader(new FileReader(file));
			String st;

			while ((st = br.readLine()) != null) {
				String[] line = st.split("-");
				Long customerID = Long.parseLong(line[0]);
				String customerAdress = line[1];
				String customerName = line[2];
				String customerNumberPhone = line[3];

				CustomerDTO customerDTO = new CustomerDTO(customerID, customerName, customerAdress,
						customerNumberPhone);
				listOfCustomerDTO.add(customerDTO);

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listOfCustomerDTO;
	}

	/**
	 * Read file ID.txt
	 * 
	 * 
	 * @return List Id
	 */
	public List<Long> readId() {

		List<Long> listId = new ArrayList<>();
		File file = new File("ID.txt");
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(file));

			String st;
			while ((st = br.readLine()) != null) {

				String[] line = st.split("-");
				Long ID = Long.parseLong(line[0]);
				Long id = ID;
				listId.add(id);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listId;

	}

	/**
	 * Read file Customername.txt
	 * 
	 * @return List Customer Name in file Customername.txt
	 */

	public List<String> readName() {

		List<String> listId = new ArrayList<>();
		File file = new File("Customername.txt");
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(file));

			String st;
			while ((st = br.readLine()) != null) {

				String[] line = st.split("-");
				String name = line[0];
				String getName = name;
				listId.add(getName);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listId;
	}

	/**
	 * Read Duty
	 * 
	 * @return List Duty in file Duty.txt
	 * @throws IOException
	 */
	public List<DutyDTO> ReadDuty() throws IOException {

		List<DutyDTO> listOfDutyDTO = new ArrayList<>();

		File file = new File("Duty.txt");
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(file));

			String st;

			while ((st = br.readLine()) != null) {

				String[] line = st.split("-");
				Long DutyID = Long.parseLong(line[0]);
				String DutyName = line[1];

				DutyDTO dutyDTO = new DutyDTO(DutyID, DutyName);

				listOfDutyDTO.add(dutyDTO);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listOfDutyDTO;
	}

	/**
	 * Read DutyName.txt
	 * 
	 * @return List Duty Name in file DutyName.txt
	 */

	public List<String> readNameDuty() {

		List<String> listName = new ArrayList<>();
		File file = new File("DutyName.txt");
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(file));

			String st;
			while ((st = br.readLine()) != null) {

				String[] line = st.split("-");
				String name = line[0];
				String getName = name;
				listName.add(getName);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listName;
	}

	/**
	 * Read file Employee.txt
	 * 
	 * @return List Employee in file Employee.txt
	 */

	public List<EmployeeDTO> readEmployee() {

		List<EmployeeDTO> listOfEmployeeDTO = new ArrayList<>();

		File file = new File("Employee.txt");
		BufferedReader br = null;

		try {

			br = new BufferedReader(new FileReader(file));
			String st;

			while ((st = br.readLine()) != null) {
				String[] line = st.split("-");
				Long employeeID = Long.parseLong(line[0]);
				String employeeName = line[1];
				String employeeGender = line[2];
				String employeeDate = line[3];
				String employeeAdress = line[4];
				String employeeWorkingDay = line[5];
				String employeeStatus = line[6];
				String employeeNumberPhone = line[7];

				DutyDTO dutyId = new DutyDTO();
				dutyId.setDutyId(Long.parseLong(line[8]));

				EmployeeDTO employeeDTO = new EmployeeDTO(employeeID, employeeName, employeeGender, employeeDate,
						employeeAdress, employeeWorkingDay, employeeStatus, employeeNumberPhone, dutyId);

				listOfEmployeeDTO.add(employeeDTO);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listOfEmployeeDTO;
	}

	/**
	 * Read file EmployeeName.txt
	 * 
	 * @return List Name Employee in file EmployeeName.txt
	 */
	public List<String> readNameEmployee() {

		List<String> listName = new ArrayList<>();
		File file = new File("EmployeeName.txt");
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(file));

			String st;
			while ((st = br.readLine()) != null) {

				String[] line = st.split("-");
				String name = line[0];
				String getName = name;
				listName.add(getName);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listName;
	}

	/**
	 * Read file InvoiceDetails.txt
	 * 
	 * @return List InvoiceDetails in file InvoiceDetails.txt
	 */
	public List<InvoiceDetailsDTO> readInvoiceDetails() {

		List<InvoiceDetailsDTO> listOfInvoiceDetailsDTO = new ArrayList<>();

		File file = new File("InvoiceDetails.txt");
		BufferedReader br = null;

		try {

			br = new BufferedReader(new FileReader(file));
			String st;

			while ((st = br.readLine()) != null) {
				String[] line = st.split("-");

				Long invoiceDetailId = Long.parseLong(line[0]);
				int quantity = Integer.parseInt(line[1]);
				Double price = Double.parseDouble(line[2]);
				Double discount = Double.parseDouble(line[3]);
				Double total = Double.parseDouble(line[4]);

				DutyDTO dutyDTO = new DutyDTO(1L, "quản lý");

				CustomerDTO customerDTO = new CustomerDTO(1L, "Hồ Chí Minh", "trang", "0365871481");

				EmployeeDTO employeeDTO = new EmployeeDTO(1L, "bình định", "1997-08-08", "nam", "nguyễn văn a",
						"123456789", "đang làm việc", "2009-02-03", dutyDTO);

				InvoiceDTO invoiceId = new InvoiceDTO(Long.parseLong(line[5]), "2020-5-6", 5000, customerDTO,
						employeeDTO);

				InvoiceDetailsDTO invoiceDetailsDTO = new InvoiceDetailsDTO(invoiceDetailId, quantity, price, discount,
						total, invoiceId);

				listOfInvoiceDetailsDTO.add(invoiceDetailsDTO);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listOfInvoiceDetailsDTO;
	}

	/**
	 * Read file Invoice.txt
	 * 
	 * @return List Invoice in file Invoice.txt
	 */

	public List<InvoiceDTO> readInvoice() {

		List<InvoiceDTO> listOfInvoiceDTO = new ArrayList<>();

		File file = new File("Invoice.txt");
		BufferedReader br = null;

		try {

			br = new BufferedReader(new FileReader(file));
			String st;

			while ((st = br.readLine()) != null) {
				String[] line = st.split("-");

				Long invoiceId = Long.parseLong(line[0]);
				String dayOfSales = line[1];
				double total = Double.parseDouble(line[2]);

				DutyDTO dutyDTO = new DutyDTO(1L, "quản lý");

				CustomerDTO customerId = new CustomerDTO(Long.parseLong(line[3]), "Hồ Chí Minh", "trang", "0365871481");

				EmployeeDTO employeeId = new EmployeeDTO(Long.parseLong(line[4]), "bình định", "1997-08-08", "nam",
						"nguyễn văn a", "123456789", "đang làm việc", "2009-02-03", dutyDTO);

				InvoiceDTO invoiceDTO = new InvoiceDTO(invoiceId, dayOfSales, total, customerId, employeeId);

				listOfInvoiceDTO.add(invoiceDTO);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listOfInvoiceDTO;
	}

	/**
	 * read file Material.txt
	 * 
	 * @return List Material in file Material.txt
	 * @throws IOException
	 */

	public List<MaterialDTO> ReadMaterial() throws IOException {

		List<MaterialDTO> listOfMaterialDTO = new ArrayList<>();

		File file = new File("Material.txt");
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(file));

			String st;

			while ((st = br.readLine()) != null) {

				String[] line = st.split("-");
				Long MaterialID = Long.parseLong(line[0]);
				String MaterialName = line[1];

				MaterialDTO materialDTO = new MaterialDTO(MaterialID, MaterialName);

				listOfMaterialDTO.add(materialDTO);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listOfMaterialDTO;
	}

	/**
	 * read file MaterialName.txt
	 * 
	 * @return list Material Name in file MaterialName.txt
	 */
	public List<String> readMaterialName() {

		List<String> listName = new ArrayList<>();
		File file = new File("MaterialName.txt");
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(file));

			String st;
			while ((st = br.readLine()) != null) {

				String[] line = st.split("-");
				String name = line[0];
				String getName = name;
				listName.add(getName);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listName;
	}

	/**
	 * read file ProductName.txt
	 * 
	 * @return List Product Name in file ProductName.txt
	 */
	public List<String> readProductName() {

		List<String> listName = new ArrayList<>();
		File file = new File("ProductName.txt");
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(file));

			String st;
			while ((st = br.readLine()) != null) {

				String[] line = st.split("-");
				String name = line[0];
				String getName = name;
				listName.add(getName);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listName;
	}

	public List<ProductDTO> readProduct() {

		List<ProductDTO> listOfProductDTO = new ArrayList<ProductDTO>();

		File file = new File("ReadProduct.txt");

		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(file));

			String st;

			while ((st = br.readLine()) != null) {
				String[] line = st.split("-");

				Long productId = Long.parseLong(line[0]);

				String productName = line[1];

				int productQuantity = Integer.parseInt(line[2]);

				double productImportPrice = Double.parseDouble(line[3]);

				double productPrice = Double.parseDouble(line[4]);

				String note = line[5];

				MaterialDTO MaterialDTO = new MaterialDTO();

				MaterialDTO.setMaterialId(Long.parseLong(line[6]));

				ProductDTO productDTO = new ProductDTO(productId, productName, productQuantity, productImportPrice,
						productPrice, note, MaterialDTO);

				listOfProductDTO.add(productDTO);
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listOfProductDTO;

	}

}
