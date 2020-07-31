package testCases;

import org.testng.annotations.Test;


import Utility.AppstringsConstant;
import pages.VerifyLoginPage;
import pages.VerifyPreparationPage;
import webBase.BaseTest;


public class PreparationPageFunctionality extends BaseTest {


	AppstringsConstant appConst =new AppstringsConstant(); 

	VerifyPreparationPage prepare=new VerifyPreparationPage();
	
	@Test(priority=0)
	
	public void verifyAdminUser() throws Throwable {
		
		prepare.verifyPreparationPage("Verify preparation Page");
		prepare.verifyEnAttenteState();
		prepare.verifyPreparationState();
		prepare.verifyPreteState();
		prepare.verifyRestePrendeState();
		prepare.verifyClientAbsentState();
	
	}
	

}



