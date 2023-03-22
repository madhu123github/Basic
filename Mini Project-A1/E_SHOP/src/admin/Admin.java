package admin;

import java.util.Scanner;

import adminDatabaseOperations.InsertSingleProduct;
import adminDatabaseOperations.ProductQuantityDetails;
import adminDatabaseOperations.RegisteredUser;
import adminDatabaseOperations.UserHistory;

public class Admin implements AdminInterface {
	Scanner sc = new Scanner(System.in);
	
		public void getAdminOptions(){
			
			System.out.println("1] Add Product Item");
			System.out.println("2] Check Quantity");
			System.out.println("3] Check Registered User");
			System.out.println("4] Check the Particular User History\n");
			
			System.out.println("Please Choose Your Option :");
			
			int op= sc.nextInt();
		if(op==1 || op==2 || op==3 || op==4) {
			selectOption(op);
		}
		else {
			System.out.println("Please Choose Correct Option!!!");
			getAdminOptions();
		}
		}
		public void selectOption(int op) {
			if(op==1) {
				addProductItem();
			}
			else if(op==2) {
				checkQuantity();
			}
			else if(op==3) {
				checkRegisteredUser();
			}
			else if(op==4) {
				checkParticularUserHistory();
			}
			else {
				System.out.println("Please Choose Correct Option !!!");
				selectOption(op);
			}
		}
		
		public void addProductItem(){
		
		InsertSingleProduct.insertSingleProduct();
		
		}
		
//		public void showTotalAmountToUser() {
//			System.out.println(ShowPurchaseHistory.getTotalBill());
//		}
		
		public void checkQuantity() {
			
			ProductQuantityDetails.getAllProductQuantity();
		
		}
		
		public void checkRegisteredUser() {
			
			RegisteredUser ru = new RegisteredUser();
			ru.getAllRegisteredUser();
		
		}
		
		public void checkParticularUserHistory() {
			
			RegisteredUser ru= new RegisteredUser();
			ru.getRegisteredName();
			
			System.out.println();
			System.out.println("Choose Any Option : ");
			
			Scanner sc = new Scanner(System.in);
			int customer_id=sc.nextInt();
			
			if(customer_id<=6 || customer_id>=1) {
			UserHistory uh= new UserHistory();
			uh.getParticularUserHistory(customer_id);
			}
			else {
				System.out.println("Please Choose Correct Option!!! ");
				checkParticularUserHistory();
			}
			
		}
	
}
