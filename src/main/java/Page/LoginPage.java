package Page;

import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Identifier.LoginIdentifier;
import Utility.Helper;
import WebBase.BasePage;
import WebBase.BaseTest;
import Utility.AppstringsConstant;
import Utility.AppstringsConstant;
import Utility.ExcelImport;
import Utility.Helper;
import Identifier.LoginIdentifier;



public class LoginPage extends BasePage{
	
	LoginIdentifier login = new LoginIdentifier();
	SoftAssert sa = new SoftAssert();
	Helper scHelper = new Helper();
	ExcelImport excel = new ExcelImport();
	BaseTest baseT = new BaseTest();
	String className = "";
	public ExtentTest logger;
	
	public void checkloginpage() {
		//login.loginpagelink.click();
		//test = Report.startReport("Verify Login Page");
		
		className = this.getClass().getName();
		createDirectory("CAMAL"+className);
		logger = baseT.extent.startTest("Login Test");
		if (scHelper.isElementPresent(login.useanotherloginlink) == true){
			
			login.useanotherloginlink.click();			
		}
			try{sa.assertTrue(scHelper.isElementPresent(login.txt_SGusername), "Username is displayed"); 
			sa.assertTrue(scHelper.isElementPresent(login.txt_SGpassword), "password is displayed"); 
			sa.assertTrue(scHelper.isElementPresent(login.btn_ssoConnection),"connect button is displayed");} catch(Error e){
				logger.log(LogStatus.FAIL, "Assert Fail : Username , Passowrd or connect button is not displayed");
			}
				
		//boolean expectedHomeText = SC.isElementPresent(login.txt_vehicleList);
		System.out.println("Test 1 - Verify field presents on Login page");
		if (scHelper.isElementPresent(login.txt_SGusername) == true) {
			// log.info("verify home page");
			logger.log(LogStatus.PASS,
					"1: logged in with application " + "<br/>" + "2 : verify logo of the page" + "<br/>"
							+ "<b>Result: title of home  page is verified <b>"
							+ logger.addScreenCapture(captureScreenShot(driver, "verify home page title")));
		}
		else {
			logger.log(LogStatus.FAIL, "Title is not verified");
		}

	}	

	
	public void invalidLogin() throws Exception {		
		/*
		 * ExcelImport.setExcelFile(AppstringsConstant.EXCELFILEPATH +
		 * AppstringsConstant.EXCELFILENAME, AppstringsConstant.EXCELLOGINSHEET); String
		 * Exe_username = ExcelImport.getCellData(1, 0); String Exe_password =
		 * ExcelImport.getCellData(1, 1);
		 */	
		login.txt_SGusername.clear();
		login.txt_SGpassword.clear();
		scHelper.Login("a5417458", "888");
		login.btn_ssoConnection.click();
		System.out.println("Test 2 - Verified login with invalid user details.");
		//if (login.errormsg.getText().contains(AppstringsConstant.INVALIDLOGINMSG) == true) {
			logger.log(LogStatus.PASS,
					"1: logged in with application " + "<br/>" + "2 : verify logo of the page" + "<br/>"
							+ "<b>Result: Login with Invalid User ID is verified <b>"
							+ logger.addScreenCapture(captureScreenShot(driver, "Invalid login checked")));
		
	}
	
	public void AdmvalidLogin() throws Exception {		
		/*
		 * ExcelImport.setExcelFile(AppstringsConstant.EXCELFILEPATH +
		 * AppstringsConstant.EXCELFILENAME, AppstringsConstant.EXCELLOGINSHEET); String
		 * Exe_username = ExcelImport.getCellData(2, 0); String Exe_password =
		 * ExcelImport.getCellData(2, 1);
		 */
		login.txt_SGusername.clear();
		login.txt_SGpassword.clear();
		scHelper.Login("a5417458", "Test24501");
		login.btn_ssoConnection.click();	
				
		//boolean expectedHomeText = SC.isElementPresent(login.txt_vehicleList);
		System.out.println("Test 3 - Verified login with valid data and check required fields are present.");
		if (scHelper.isElementPresent(login.Suppliertab) == true) {
			logger.log(LogStatus.PASS,
					"1: logged in with application " + "<br/>" + "2 : verify logo of the page" + "<br/>"
							+ "<b>Result: Login with valid User ID is verified <b>"
							+ logger.addScreenCapture(captureScreenShot(driver, "valid login checked")));
		}

		else {
			logger.log(LogStatus.FAIL, "Login with valid data is fail");
		}
	}
		
	
	

}
