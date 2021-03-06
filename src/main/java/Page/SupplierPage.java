package Page;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Identifier.LoginIdentifier;
import Utility.AppstringsConstant;
import Utility.ExcelImport;
import Utility.Helper;
import WebBase.BasePage;
import WebBase.BaseTest;

import WebBase.webController;

public class SupplierPage extends BasePage {

	LoginIdentifier testID = new LoginIdentifier();
	Helper help = new Helper();
	String supEmail = help.randomEmailGenerator();
	String Editemail = help.randomEmailGenerator();
	BaseTest baseT = new BaseTest();
	webController contrl=new webController();
	String pathwhileCreate=System.getProperty("user.dir")+"/Files/Abc.pdf";
	String pathwhileEdit=System.getProperty("user.dir")+"/Files/ABCDE.pdf";
	//String pathwhileCreate = "C:\\Users\\a5417458\\.eclipse\\Desktop\\backup\\CAMAL\\Files\\Abc.pdf";
	//String pathwhileEdit ="C:\\Users\\a5417458\\.eclipse\\Desktop\\backup\\CAMAL\\Files\\ABCDE.pdf";
	private static String downloadPath = "/Users/admin/Downloads";

	String className = "";
	public ExtentTest logger;

	public void CAMLLogin() throws IOException {
		testID.getConnectbutton().click();
		String actualresult = AppstringsConstant.PAGETITLE;
		String expectedresultString = Basepagedriver.getTitle();
		Assert.assertEquals(actualresult, expectedresultString);
		help.getscreenshots();
	}

	public void CreateSupplier() throws InterruptedException, IOException {
		className = this.getClass().getName();
		createDirectory("CAMAL"+className);
		logger = baseT.extent.startTest("Supplier Test");
        String ActualType, ActualRejectmail, ActualEmail, ActualSGDBFmail, ActualObservation, ActualValidationMandatory,
				Actualentity;
		testID.getSuppliertab().click();
		testID.getNewsupplier().click();
		Thread.sleep(5000);
		testID.getMailAddress().sendKeys(supEmail);
		Thread.sleep(2000);
		testID.getSuppliertype().click();
		help.Dropdown(AppstringsConstant.SUPPLIERTYPELIST);
		testID.getRejectMailAddress().sendKeys(supEmail);
		testID.getSGDBFSuppliertype().sendKeys(supEmail);
		testID.getSuppliercomment().sendKeys(AppstringsConstant.SUPPLIEREXPECTEDOBSERVATION);
		testID.getMandatoryvalid().click();
		help.Dropdown(AppstringsConstant.SUPPLIERVALIDATIONMANDATORYLIST);
		testID.getEntity().click();
		help.Dropdown(AppstringsConstant.SUPPLIERENTITYLIST);
		testID.getSupplierPDF().sendKeys(pathwhileCreate);
		testID.getButtonSave().click();
		Thread.sleep(5000);
		testID.getSearchField().sendKeys(supEmail);
		Thread.sleep(5000);
		WebElement Result=contrl.driver.findElement(By.xpath("//td[text()='"+supEmail+"']"));
		if(help.isElementPresent(Result))
		{
			logger.log(LogStatus.PASS,
					"1: Create New Supplier " + "<br/>" + "2 : Verify all fields are present " + "<br/>"
							+ "<b>Result: Supplier creation success message is displayed <b>"
							+ logger.addScreenCapture(captureScreenShot(driver, "verify Suppier create successfully")));
		}
		else
		{
			System.out.println("fail");
		}
			}

	public void CheckLOGforcreation() throws InterruptedException, IOException {
		String ActualUserID, ActualUserAction, Actualsuppliermail, Expectedsuppliermail;
		testID.getHistort_Tab().click();
		testID.getLogsearch().sendKeys(supEmail);
		Thread.sleep(2000);
		ActualUserID = testID.getTbl_SGID().getText();
		ActualUserAction = testID.getTbl_action().getText();
		Actualsuppliermail = testID.getTbl_mailOfSupplier().getText();
		Expectedsuppliermail = supEmail;
		try{Assert.assertEquals(Actualsuppliermail, Expectedsuppliermail);
		Assert.assertEquals(Actualsuppliermail, supEmail, "Strings are not matching");
		Assert.assertEquals(ActualUserAction, ActualUserAction, "Strings are not matching");
		Assert.assertEquals(ActualUserID, AppstringsConstant.USERSGIDLOG, "Strings are not matching");}catch(Error e){
			logger.log(LogStatus.FAIL, "Assert Fail :Log for creation of new supplier is not displayed");
		}
		if (ActualUserAction.equals(ActualUserAction) == true) {
			logger.log(LogStatus.PASS,
					"1: Log for Newly created  Supplier " + "<br/>" + "2 : Verify all fields on Log screen are present "
							+ "<br/>" + "<b>Result: Log for creation of new supplier is displayed <b>"
							+ logger.addScreenCapture(captureScreenShot(driver, "Suppier creation Log ")));
		}
		else {
			logger.log(LogStatus.FAIL, "Log for creation of new supplier is not displayed");

		}

	}

	public void EditnewSupplier() throws InterruptedException, IOException {
		testID.getSuppliertab().click();
		Thread.sleep(2000);
		testID.getSearchField().sendKeys(supEmail);
		Thread.sleep(2000);
		testID.getBtn_supplieEdit().click();
		Thread.sleep(2000);
		testID.getMailAddress().click();
		testID.getMailAddress().clear();
		testID.getMailAddress().sendKeys(Editemail);
		Thread.sleep(2000);
		help.Dropdown(AppstringsConstant.SUPPLIERTYPELIST);
		testID.getRejectMailAddress().clear();
		testID.getRejectMailAddress().sendKeys(Editemail);
		testID.getSGDBFSuppliertype().clear();
		testID.getSGDBFSuppliertype().sendKeys(Editemail);
		help.Dropdown(AppstringsConstant.SUPPLIERVALIDATIONMANDATORYLIST);
		help.Dropdown(AppstringsConstant.SUPPLIERENTITYLIST);
		testID.getSupplierPDF().sendKeys(pathwhileEdit);
		testID.getButtonSave().click();
		Thread.sleep(3000);
		String expectedresultString = AppstringsConstant.SUPPLIERUPDATIONMSG;
		String actualresult = testID.getSupplierSuccessMsg().getText();
		Assert.assertEquals(actualresult, expectedresultString);
		if (actualresult.equals(expectedresultString) == true) {
			// log.info("verify home page");
			logger.log(LogStatus.PASS,
					"1: Edit New Supplier " + "<br/>" + "2 : Verify all fields are present " + "<br/>"
							+ "<b>Result: Supplier Modification  success message is displayed <b>"
							+ logger.addScreenCapture(captureScreenShot(driver, "verify Suppier modification")));
			}
		else {
			logger.log(LogStatus.FAIL, "Modification of  new supplier  fail");
		}
	}

	public void CheckLOGformodification() throws InterruptedException, IOException {
		String ActualUserID, ActualUserAction, Actualsuppliermail, Expectedsuppliermail;
		testID.getHistort_Tab().click();
		testID.getLogsearch().sendKeys(Editemail);
		Thread.sleep(2000);
		ActualUserID = testID.getTbl_SGID().getText();
		ActualUserAction = testID.getTbl_action().getText();
		Actualsuppliermail = testID.getTbl_mailOfSupplier().getText();
		Expectedsuppliermail = Editemail;
		try{Assert.assertEquals(Actualsuppliermail, Expectedsuppliermail);
		Assert.assertEquals(Actualsuppliermail, Editemail, "Strings are not matching");
		Assert.assertEquals(ActualUserAction, AppstringsConstant.MODIFICATIONLOG, "Strings are not matching");
		Assert.assertEquals(ActualUserID, AppstringsConstant.USERSGIDLOG, "Strings are not matching");}catch(Error e){
			logger.log(LogStatus.FAIL, "Log for modification of  supplier is not displayed");
		}
		if (ActualUserAction.equals(AppstringsConstant.MODIFICATIONLOG) == true) {
			logger.log(LogStatus.PASS,
					"1: Log for modification of   Supplier " + "<br/>"
							+ "2 : Verify all fields on Log screen are present " + "<br/>"
							+ "<b>Result: Log for modification  of supplier is displayed <b>"
							+ logger.addScreenCapture(captureScreenShot(driver, "Modification LOG")));
		}
		else {
			logger.log(LogStatus.FAIL, "Log for modification of  supplier is not displayed");
		}
	}

	public void SendMailToSupplier() throws InterruptedException, IOException {
		testID.getSuppliertab().click();
		testID.getSearchField().sendKeys(Editemail);
		Thread.sleep(3000);
		testID.getBtn_supplieMail().click();
		Thread.sleep(3000);
		testID.getButtonYes().click();
		Thread.sleep(5000);		
			if (testID.getSupplierSuccessMsg().getText().equals(AppstringsConstant.SUPPLIERMAILSENDMSG) == true) {
			logger.log(LogStatus.PASS,
					"1: Send Email to  Supplier " + "<br/>"
							+ "<b>Result: Email send message to supplier is displayed <b>"
							+ logger.addScreenCapture(captureScreenShot(driver, "Send Email")));
		}
		else {
			logger.log(LogStatus.FAIL, "email send message  to supplier is missing");
		}
	}

	public void DeleteSupplier() throws InterruptedException, IOException {
		testID.getSearchField().sendKeys(Editemail);
		Thread.sleep(5000);
		testID.getBtn_supplieDelete().click();
		Basepagedriver.switchTo().alert().accept();
		Thread.sleep(5000);
		
		if (testID.getSupplierSuccessMsg().getText().equals(AppstringsConstant.SUPPLIERDELETEMSG) == true) {
			logger.log(LogStatus.PASS,
					"1: Delete Supplier " + "<br/>" + "<b>Result: Supplier deleted message is displayed <b>"
							+ logger.addScreenCapture(captureScreenShot(driver, "Delete supplier")));
		}
		else {
			logger.log(LogStatus.FAIL, "Supplier deleted message is not displayed ");
		}
	}

	public void CheckLOGfordelete() throws Exception {
		String ActualUserID, ActualUserAction, Actualsuppliermail, Expectedsuppliermail;
		testID.getHistort_Tab().click();
		testID.getLogsearch().sendKeys(Editemail);
		Thread.sleep(2000);
		ActualUserID = testID.getTbl_SGID().getText();
		ActualUserAction = testID.getTbl_action().getText();
		Actualsuppliermail = testID.getTbl_mailOfSupplier().getText();
		Expectedsuppliermail = Editemail;
		if (ActualUserAction.equals(AppstringsConstant.DELETIONLOG) == true) {
			System.out.println("Pass");
			logger.log(LogStatus.PASS,
					"1: Log for deleteion of   Supplier " + "<br/>" + "2 : Verify all fields on Log screen are present "
							+ "<br/>" + "<b>Result: Log for deletion of supplier is displayed <b>"
							+ logger.addScreenCapture(captureScreenShot(driver, "Deletion LOG")));
		}
		else {
			System.out.println("FAIL");
			logger.log(LogStatus.FAIL, "Log for deletion of supplier is not displayed");

		}
	}
	
	public void verifyPdfDownload() throws InterruptedException
	{
		testID.Pdfdownload.get(0).click();
		//File getLatestFile = getLatestFilefromDir(downloadPath);
		Thread.sleep(7000);
	    File getLatestFile = help.getLatestFilefromDir(downloadPath);
		String fileName = getLatestFile.getName();
		System.out.println("latest file is"+fileName);
		Thread.sleep(2000);
		if (fileName.contains("Abc")) {
			logger.log(LogStatus.PASS,
					"1: Log for deleteion of   Supplier " + "<br/>" + "2 :Click on supplier page "+ "<br/>" +"3:Click on Pdf download option any of the listed mail"
							+ "<br/>" + "<b>Result: File get downloaded successfully <b>"
							+ logger.addScreenCapture(captureScreenShot(driver, "downlaod  pdf")));
	}
		else
		{
			logger.log(LogStatus.FAIL,
					"1: Log for deleteion of   Supplier " + "<br/>" + "2 :Click on supplier page "+ "<br/>" +"3:Click on Pdf download option any of the listed mail"
							+ "<br/>" + "<b>Result: File not  get downloaded successfully <b>"
							+ logger.addScreenCapture(captureScreenShot(driver, "pdf file download  pdf")));

		}
	}
	
	public void verifyExcelDownload() throws InterruptedException
	{
		testID.Excel_btn.click();
		//File getLatestFile = getLatestFilefromDir(downloadPath);
		Thread.sleep(7000);
	    File getLatestFile = help.getLatestFilefromDir(downloadPath);
		String fileName = getLatestFile.getName();
		System.out.println("latest file is"+fileName);
		Thread.sleep(2000);
		if (fileName.contains("CAML")) {
			logger.log(LogStatus.PASS,
					"1: Log for deleteion of   Supplier " + "<br/>" + "2 :Click on supplier page "+ "<br/>" +"3:Click on Excel download option any of the listed mail"
							+ "<br/>" + "<b>Result: File not  get downloaded successfully <b>"
							+ logger.addScreenCapture(captureScreenShot(driver, "Excel file download  pdf")));
           	}
		else
		{
			logger.log(LogStatus.FAIL,
					"1: Log for deleteion of   Supplier " + "<br/>" + "2 :Click on supplier page "+ "<br/>" +"3:Click on excel download option any of the listed mail"
							+ "<br/>" + "<b>Result: File not  get downloaded successfully <b>"
							+ logger.addScreenCapture(captureScreenShot(driver, "Excel file download  pdf")));

		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
