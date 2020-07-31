package testCases;

import org.testng.annotations.Test;

import Utility.AppstringsConstant;
import pages.CustomerPage;
import pages.VerifyLoginPage;
import webBase.BaseTest;

public class CustomerPageFunctionality extends BaseTest {


		AppstringsConstant appConst =new AppstringsConstant(); 
		CustomerPage customer=new CustomerPage();

		
		@Test(priority=0)
		
		public void customerPage() throws Throwable {
			
			customer.customerPage("Verifying Customer page");
			
		}
	
}
