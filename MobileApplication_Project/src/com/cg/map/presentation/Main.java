package com.cg.map.presentation;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.map.exception.MPException;
import com.cg.map.model.MobileDetails;
import com.cg.map.model.Mobiles;
import com.cg.map.service.MAPService;
import com.cg.map.service.MapServiceImpl;

public class Main {
	static Logger logger = Logger.getLogger(Main.class);

	public static void main(String[] args) {

		PropertyConfigurator.configure("resources/log4j.properties");

		Scanner scanner = null;
		int choice = 0;
		boolean choiceFlag = false;

		do {
			scanner = new Scanner(System.in);
			System.out.println("*****Mobile Purchase System*****");
			System.out.println("1.Enter the  purchase details");
			System.out.println("2.Delete mobiles based on id");
			System.out.println("3.Details of all the mobiles");

			System.out.println("Enter your choice:");

			try {
				choice = scanner.nextInt();
				choiceFlag = true;

				switch (choice) {
				case 1:

				
					scanner.nextLine();
					System.out.println("Enter the customer name:");
					String Customer_Name = scanner.nextLine();
					System.out.println("Enter the mailid:");
					String MailId = scanner.nextLine();
					System.out.println("Enter the phone number");
					Long Phone_Number = scanner.nextLong();
					scanner.nextLine();
					System.out.println("enter the mobile id");
					Integer Mobile_id = scanner.nextInt();

					MobileDetails details = new MobileDetails();
					details.setCustomer_Name(Customer_Name);
					details.setMailId(MailId);
					details.setPhone_Number(Phone_Number);
					
					details.setMobile_id(Mobile_id);

					MAPService service = new MapServiceImpl();

					try {
						boolean validateFlag = service.validateFields(details);
						if (validateFlag) {
							int id = service.addPurchaseDetails(details);
							System.out.println("rows inserted" + id);
						}
					} catch (MPException e) {
						e.printStackTrace();
					}
					break;


				case 2:

					scanner.nextLine();
					System.out.println("enter the mobile id");
					int mobileid = scanner.nextInt();

					Mobiles mobiles2 = new Mobiles();
					mobiles2.setMobileid(mobileid);

					MAPService mapService2 = new MapServiceImpl();

					try {
					int id = mapService2.deleteBasedonId(mobiles2);
					} catch (MPException e) {
						System.err.println(e.getMessage());
					}

					break;
				case 3:

					break;

				default:
					choiceFlag = false;
					System.out.println("input choice must be between (1 to 4)");
					System.out.println("Enter your input again");
					break;
				}
			} catch (InputMismatchException e) {
				System.err.println("Enter only Digits");
				System.out.println("Enter your input again");
			}
		} while (!choiceFlag);
		scanner.close();

	}

}
