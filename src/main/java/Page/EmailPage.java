package Page;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Identifier.EmailManagementIdentifier;
import Utility.AppstringsConstant;
import Utility.Helper;
import WebBase.BasePage;
import WebBase.BaseTest;
//import WebBase.Controller;
import WebBase.webController;

public class EmailPage extends BasePage {

	EmailManagementIdentifier email = new EmailManagementIdentifier();
	Helper help = new Helper();
	String supEmail = help.randomEmailGenerator();
	String Editemail = help.randomEmailGenerator();
	String userSGID = help.randomSGIDGenerator();
	String usermail = help.randomEmailGenerator();
	BaseTest baseT = new BaseTest();
	webController contr = new webController();
	String className = "";
	public ExtentTest logger;

	public void CreatesupplieremailID() throws InterruptedException, IOException {
		className = this.getClass().getName();
		createDirectory("CAMAL" + className);
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

	public void EditsupplieremailID() throws InterruptedException, IOException {
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

	public void LogOutfromApp() throws InterruptedException, IOException {

		Thread.sleep(1000);
		email.getPageTopusername().click();
		email.getLogoutbutton().click();
		Thread.sleep(3000);

		// if
		// (AppstringsConstant.LOGOUTPAGEHEADER.equals(email.getLogoutpage().getText())
		// == true) {
		logger.log(LogStatus.PASS,
				"1: Logout from app " + "<br/>" + "2 : Log out . " + "<br/>"
						+ "<b>Result: Logout successfully from the app <b>"
						+ logger.addScreenCapture(captureScreenShot(driver, "LogOut App")));

	}

	public void VerifyrReachrche() throws InterruptedException {
		Thread.sleep(2000);
		email.Search_Textbox.sendKeys(AppstringsConstant.SEARCHVALUE);
		Thread.sleep(2000);
		if (email.RowData.getText().contains(AppstringsConstant.SEARCHVALUE)) {
			logger.log(LogStatus.PASS,
					"1: Log for deleteion of   Supplier " + "<br/>" + "2 :Click on Getion du mail " + "<br/>"
							+ "3:Insert data in search" + "<br/>"
							+ "<b>Result: Resultant data get showing succesfuly<b>"
							+ logger.addScreenCapture(captureScreenShot(driver, "search  on Getion du mail ")));
		} else {
			logger.log(LogStatus.FAIL,
					"1: Log for deleteion of   Supplier " + "<br/>" + "2 :Click on Getion du mail " + "<br/>"
							+ "3:Insert date in search" + "<br/>"
							+ "<b>Result: Resultant data not  get showing succesfully<b>"
							+ logger.addScreenCapture(captureScreenShot(driver, "search  on Getion du mail ")));
		}
	}

	public void EditEmailText() {
		email.noteeditable.clear();
		email.noteeditable.sendKeys(AppstringsConstant.EDITMAILTEXT);
		String mailText = email.noteeditable.getText();
		email.mail_sender.clear();
		email.mail_sender.sendKeys(AppstringsConstant.EDITMAILID);
	
		help.JavaScriptClick(email.EmailSubmitbtn);
		if (help.isElementPresent(email.MailSuccesssg)) {
			logger.log(LogStatus.PASS,
					"1: Log for deleteion of   Supplier " + "<br/>" + "2 :Click on Getion du mail " + "<br/>"
							+ "3:Edit content of mail" + "<br/>" + "<b>Result: Content of mail updaed successfully<b>"
							+ logger.addScreenCapture(captureScreenShot(driver, "Content of mail updated ")));
		} else {
			logger.log(LogStatus.FAIL,
					"1: Log for deleteion of   Supplier " + "<br/>" + "2 :Click on Getion du mail " + "<br/>"
							+ "3:Edit content of mail" + "<br/>"
							+ "<b>Result: Content of  mail not get  updaed successfully<b>"
							+ logger.addScreenCapture(captureScreenShot(driver, "Content of mail updated ")));
		}

	}

	public void verifyeditedEmailFormatOnSupplier() throws InterruptedException {
		contr.driver.navigate().to("https://capturemail.mutlp.test.pointp.saint-gobain.net/supplier");
		Thread.sleep(2000);
		email.Mail_List.get(0).click();
		Thread.sleep(1000);
		String data = email.UpadtedMailContents.getText();
		System.out.println(data);
		if (data.contains(AppstringsConstant.SUPPLIEREMAILCREATION)) {
			logger.log(LogStatus.PASS,
					"1: Log for deleteion of   Supplier " + "<br/>" + "2 :Click on Getion du mail " + "<br/>"
							+ "3:Edit content of mail" + "<br/>" + "4:Verify content of edited mail on supplier page"
							+ "<br/>" + "<b>Result: Content of  mail   updated successfully on supplier page<b>"
							+ logger.addScreenCapture(captureScreenShot(driver, "Content of mail updated ")));
		} else {
			logger.log(LogStatus.FAIL,
					"1: Log for deleteion of   Supplier " + "<br/>" + "2 :Click on Getion du mail " + "<br/>"
							+ "3:Edit content of mail" + "<br/>" + "4:Verify content of edited mail on supplier page"
							+ "<br/>" + "<b>Result: Content of  mail  not  updated successfully on supplier page<b>"
							+ logger.addScreenCapture(captureScreenShot(driver, "Content of mail updated ")));
		}
		Thread.sleep(2000);

	}

	public void verifyaddedEmailIdOnSupplier() throws InterruptedException {
		Thread.sleep(1000);
		WebElement CCmail = contr.driver.findElement(By.xpath("//input[@value='" + Editemail + "']"));
		Thread.sleep(1000);
		if (help.isElementPresent(CCmail)) {
			logger.log(LogStatus.PASS,
					"1: Log for deleteion of   Supplier " + "<br/>" + "2 :Click on Getion du mail " + "<br/>"
							+ "3:Add  mail id " + "<br/>" + "4:Verify added mail on supplier page" + "<br/>"
							+ "<b>Result: Mail addedd  successfully on supplier page<b>"
							+ logger.addScreenCapture(captureScreenShot(driver, "  mail updated ")));
		} else {
			logger.log(LogStatus.FAIL,
					"1: Log for deleteion of   Supplier " + "<br/>" + "2 :Click on Getion du mail " + "<br/>"
							+ "3:Add mail id " + "<br/>" + "4:Verify added mail on supplier page" + "<br/>"
							+ "<b>Result: Mail addedd  successfully  on supplier page<b>"
							+ logger.addScreenCapture(captureScreenShot(driver, " mail updated ")));

		}
		email.NonBtn.click();

	}

	public void verifyReachrcheOnHistory() throws InterruptedException {

		contr.driver.navigate().to("https://capturemail.mutlp.test.pointp.saint-gobain.net/app_logs");
		Thread.sleep(1000);
		email.SearchTextbox.sendKeys(AppstringsConstant.Suppression);
		if (help.isElementPresent(email.SearchText.get(0))) {
			logger.log(LogStatus.PASS,
					"1: Log for deleteion of   Supplier " + "<br/>" + "2 :Click on history Tab " + "<br/>"
							+ "3:Insert serach data in search text box " + "<br/>"
							+ "<b>Result: Appropriate result get showing<b>"
							+ logger.addScreenCapture(captureScreenShot(driver, "History search tab ")));

		} else {
			logger.log(LogStatus.FAIL,
					"1: Log for deleteion of   Supplier " + "<br/>" + "2 :Click on history Tab " + "<br/>"
							+ "3:Insert serach data in search text box " + "<br/>"
							+ "<b>Result: Appropriate result not  get showing<b>"
							+ logger.addScreenCapture(captureScreenShot(driver, "History search tab ")));

		}

	}

	/*
	 * public void verifyErrorMassage() throws InterruptedException {
	 * email.getEmailAdd().click(); Thread.sleep(2000);
	 * email.getEmailsaveButton().click(); Thread.sleep(2000); String
	 * supplierTypeError=email.supplier_Error.getText();
	 * System.out.println(supplierTypeError); String
	 * MailTypeError=email.mail_address_Error.getText();
	 * System.out.println(MailTypeError); Thread.sleep(3500);
	 * help.JavaScriptClick(email.closeBtn.get(5));
	 * 
	 * }
	 */

	public void SearchTextBox() {

	}

}
