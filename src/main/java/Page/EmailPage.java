package Page;

import java.io.IOException;

import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Identifier.EmailManagementIdentifier;
import Utility.AppstringsConstant;
import Utility.Helper;
import WebBase.BasePage;
import WebBase.BaseTest;

public class EmailPage extends BasePage{
	 
	EmailManagementIdentifier email = new EmailManagementIdentifier();
	Helper help = new Helper();
	String supEmail = help.randomEmailGenerator();
	String Editemail = help.randomEmailGenerator();
	String userSGID = help.randomSGIDGenerator();
	String usermail = help.randomEmailGenerator();
	BaseTest baseT = new BaseTest();
	String className = "";
	public ExtentTest logger;
	
	public void CreatesupplieremailID() throws InterruptedException, IOException
	{
		className = this.getClass().getName();
		createDirectory("CAMAL"+className);
		logger = baseT.extent.startTest("Mail Test");
		email.getEmailTab().click();
		Thread.sleep(5000);
		email.getEmailAdd().click();
		Thread.sleep(2000);
		email.getEmail_supplierType().click();
		help.Dropdown(AppstringsConstant.SUPPLIEREMAILCREATION);
		email.getEmail_mailaddress().sendKeys(supEmail);
		email.getEmailsaveButton().click();
		Thread.sleep(2000);
		 if (AppstringsConstant.MAILCREATIONSUCCESS.equals(email.getEmailsuccessmessage().getText()) == true) {
				logger.log(LogStatus.PASS,
						"1: Create new supplier Mail " + "<br/>" + "2 : Creation of new supplier email. " + "<br/>"
								+ "<b>Result: New mail created  successfully <b>"
								+ logger.addScreenCapture(captureScreenShot(driver, "Create new mail")));
			} else {
				logger.log(LogStatus.FAIL, "Success message is not displayed.");
			}
		email.getEmailSearch().sendKeys(supEmail);
		Thread.sleep(2000);		
		
		}
	
	public void EditsupplieremailID() throws InterruptedException, IOException
	{
		email.getEmaileditID().click();
		Thread.sleep(2000);
		email.getEmail_supplierType().click();
		help.Dropdown(AppstringsConstant.SUPPLIEREMAILCREATION);
		email.getEmail_mailaddress().clear();
		email.getEmail_mailaddress().sendKeys(Editemail);
		email.getEmailsaveButton().click();
		Thread.sleep(2000);
		 if (AppstringsConstant.MAILEDITSUCCESS.equals(email.getEmailsuccessmessage().getText()) == true) {
				logger.log(LogStatus.PASS,
						"1: edit supplier Mail " + "<br/>" + "2 : modification of  supplier email. " + "<br/>"
								+ "<b>Result: modification of  mail done  successfully <b>"
								+ logger.addScreenCapture(captureScreenShot(driver, "edit mail")));
			} else {
				logger.log(LogStatus.FAIL, "Success message is not displayed.");
			}
			
	}
	
	public void LogOutfromApp() throws InterruptedException, IOException
	{
		
		email.getPageTopusername().click();
		email.getLogoutbutton().click();
		Thread.sleep(3000);
		
		if (AppstringsConstant.LOGOUTPAGEHEADER.equals(email.getLogoutpage().getText()) == true) {
			logger.log(LogStatus.PASS,
					"1: Logout from app " + "<br/>" + "2 : Log out . " + "<br/>"
							+ "<b>Result: Logout successfully from the app <b>"
							+ logger.addScreenCapture(captureScreenShot(driver, "LogOut App")));
		} else {
			logger.log(LogStatus.FAIL, "App is not logout.");
		}		
	}

}
