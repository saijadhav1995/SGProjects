package testCases;

import org.testng.annotations.Test;


import Utility.AppstringsConstant;
import pages.VerifyAdminPage;
import pages.VerifyLoginPage;
import webBase.BaseTest;


public class Loginfunctionality extends BaseTest {


	AppstringsConstant appConst =new AppstringsConstant(); 
	VerifyLoginPage loginpage=new VerifyLoginPage();

	
	@Test(priority=0)
	
	public void verifyAdminpage() throws Throwable {
		
	
	loginpage.open_chrome_browser_and_start_application("login Functionlaity For Admin User");
	loginpage.VerifyLoginFunctionalityForAdminUser(appConst.Admin_SGID,appConst.Admin_password);
	
	}
	

}



