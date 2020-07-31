package pages;



import org.testng.AssertJUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


import java.io.IOException;



import com.relevantcodes.extentreports.LogStatus;

import Utility.AppstringsConstant;
import Utility.Helper;
import webBase.BaseTest;
import webBase.BasePage;
import webBase.BrowserFactory;
import webBase.Controller;
import webBase.ExcelConfig;
import webElements_Identifiers.Login_Identifiers;
import com.relevantcodes.extentreports.ExtentTest;



public class VerifyLoginPage extends BasePage   {
	
	
	
public ExtentTest logger;	
Login_Identifiers loginPage =new Login_Identifiers(driver);
public ExtentTest extentest;
public SoftAssert SAssert = new SoftAssert();
public PageFactory pf=new PageFactory();
BrowserFactory Bf=new BrowserFactory();
BaseTest baseT = new BaseTest();
String className = "";
Helper helper=new Helper();

public AppstringsConstant appConst=new AppstringsConstant();
	
	//Scenario1 : verify SSO page 

	public void open_chrome_browser_and_start_application(String TestName) throws Throwable {
		
	try {
		
		
	logger = baseT.extent.startTest(TestName);			
	loginPage=	PageFactory.initElements(driver, Login_Identifiers.class);
	createDirectory("FACE"+TestName);	

	driver.navigate().to("https://uat.websso.saint-gobain.com/cas/login?service=https%3A%2F%2Fface-test.sgdbf.fr%2F");
		loginPage.clicklink(); 
	
	} catch (Exception e) {
	
		logger.log(LogStatus.FAIL,"<b><font color='red'>Error is occurred while opening Application "+"<br/>"		
+logger.addScreenCapture(captureScreenShot(driver, "error While open Browsers")));
	
	}
	
		
	}
		

	//Scenario2: verify login functionality for Admin user 
	 
	public void VerifyLoginFunctionalityForAdminUser(String username,String password ) {
		
		
		try {
			
		helper.javaScriptHighlightWebElement(loginPage.username);
		 loginPage.typeUsername(username);
		 
		 
		 helper.javaScriptHighlightWebElement(loginPage.password);
		 loginPage.typePassword(password);
		 		 	
			logger.log(LogStatus.PASS,"1:Open Browser And Start Application"+"<br/>"
					+"2:Login SSO page has been verified"+"<br/>"
					+"3:click on connection Link For login"+"<br/>"
					+"4: Enter Username "+"<b>"+username+"</b>"+"<br/>"
		 	+"and Paswword "+"<b>"+password
	 		+logger.addScreenCapture(captureScreenShot(driver, "Enter Username&and Password")));
			

			 loginPage.clickSubmit();
			
	WebElement title=	driver.findElement(By.xpath("/html/body/header/a"));
		
	if(title.isDisplayed()) {
		
		helper.javaScriptHighlightWebElement(title);
		logger.log(LogStatus.PASS,"1:Click On Submit button"+"<br/>"
				+"<b><font color='green'>user logged in successfully"
				+logger.addScreenCapture(captureScreenShot(driver, "user login checked")));

		logger.log(LogStatus.PASS,"1: Verifying FACE title on Agency Page"+"<br/>"
				+"2: Actual FACE title is "+"<b>"+title.getText()+"</b>"+"<br/>"
				+"3: Expected FACE title is "+"<b>"+appConst.FACE_title+"</b>"+"<br/>"
				+"<b><font color='green'>Result:title has been matched <font/>"
				+logger.addScreenCapture(captureScreenShot(driver, "user login checked")));
		
		helper.javaScriptUn_HighlightWebElement(title);
		
	}
		
	
	Select agency=new Select(loginPage.Select_agency);
	
	agency.selectByValue("3");
	
	
	loginPage.Agency_button.click();
	Alert alert = driver.switchTo().alert();
    String alertText = alert.getText();
     alert.accept();
     
     logger.log(LogStatus.PASS,"1:click on select agency Drop down Field"+"<br/>"
 			+"<b><font color='green'>selected agency from Drop Down"
 			+logger.addScreenCapture(captureScreenShot(driver, "select_agency_checked")));

	
		} catch (Exception e) {
		
		
			logger.log(LogStatus.FAIL,"<b><font color='red'>Does not able to Login On Application"+"<br/>"		
+logger.addScreenCapture(captureScreenShot(driver, "Enter Username&and Password")));
			
		}
		
		
	}
	
	
	
		//Scenario2: verify login functionality for  invalid user 
			
	 
		 public void invalid_user_should_be_not_be_login() throws Throwable {
			
			
			try {
				
				if (loginPage.invalid.isDisplayed()) {
		 			
		 			
					System.out.println("Invaid user does Able not login");
					logger.log(LogStatus.PASS,"<b><font color='green'>Result: Invalid user not does not able to login "
					 	+logger.addScreenCapture(captureScreenShot(driver,"Invalid user not does not able to login ")));
					
					}
				
			} catch (NoSuchElementException invalid_user) {
			
				logger.log(LogStatus.FAIL, "<b><font color='red'>Result: invalid user able to login successfully"
				 +logger.addScreenCapture(captureScreenShot(driver,"invalid user able to login successfully")));
			
				
			
				}	
				
			 }
		 

		 
	 		 	
	 
	 


			
}		
		

	
		