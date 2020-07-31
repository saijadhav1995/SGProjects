package testCases;

import org.testng.annotations.Test;


import Utility.AppstringsConstant;
import pages.VerifyAdminPage;
import pages.VerifyLoginPage;
import webBase.BaseTest;


public class AdminPageFunctionality extends BaseTest {


	AppstringsConstant appConst =new AppstringsConstant(); 
	VerifyAdminPage admin=new VerifyAdminPage();
	
	@Test(priority=0)
	
	public void verifyAdminUser() throws Throwable {
	
		admin.verifyAdminPage("Admin page");
		admin.verifyingBoardContent();
		admin.verifyingDrawerContent();
		admin.brandMenu();
		admin.roleMenu();
		admin.agencyMenu();
		admin.usersMenu();
		admin.loadingZone();
		admin.bLMenu();
		
		

			}
	

}



