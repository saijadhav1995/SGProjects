package pages;



import org.testng.AssertJUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
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
import webElements_Identifiers.Admin_Page_identifiers;
import webElements_Identifiers.Login_Identifiers;
import com.relevantcodes.extentreports.ExtentTest;



public class VerifyAdminPage extends BasePage   {
	
	
	
public ExtentTest logger;	

public Admin_Page_identifiers admin=new Admin_Page_identifiers(driver);
public ExtentTest extentest;
public SoftAssert SAssert = new SoftAssert();
public PageFactory pf=new PageFactory();
BrowserFactory Bf=new BrowserFactory();
BaseTest baseT = new BaseTest();
String className = "";
Helper helper=new Helper();

public AppstringsConstant appConst=new AppstringsConstant();
	
	 

	public void verifyAdminPage(String TestName) throws Throwable {
		
	
		try {
			
		
	logger = baseT.extent.startTest(TestName);			
	admin=	PageFactory.initElements(driver, Admin_Page_identifiers.class);
	createDirectory("FACE"+TestName);
	
Thread.sleep(10000);

admin.FACE_title.click();
admin.UserIcon.click();

helper.javaScriptHighlightWebElement(admin.AdminMenuButton);

logger.log(LogStatus.PASS,"1:Redirected to Preparation page"+"<br/>"
		+"2:click on user Icon"+"<br/>"
		+"<b><font color='green'>Result:successfully click on Admin Page button from user PopUp" 
	+logger.addScreenCapture(captureScreenShot(driver, "goToAdminPage")));


admin.AdminMenuButton.click();

		} catch (Exception e) {
			logger.log(LogStatus.FAIL,"<b><font color='red'>Result:getting Error While Verifying Admin Menu<font/>"+e.getMessage() 
			+logger.addScreenCapture(captureScreenShot(driver, "Admin Menu")));

			
		} 
	
	}

//verifying board page

public void verifyingBoardContent() throws Throwable {
	try {
		
	
if (admin.BoardTableLabel.isDisplayed()) {
	
	System.out.println("board label is displayed");
	
	helper.javaScriptHighlightWebElement(admin.BoardTableLabel);

	logger.log(LogStatus.PASS,"1:Redirected to Admin page"+"<br/>"
			+"<b><font color='green'>Result:Board Table Label has been verified on Admin page" 
		+logger.addScreenCapture(captureScreenShot(driver, "BoardTableLabel")));
	helper.javaScriptUn_HighlightWebElement(admin.BoardTableLabel);
	
} 
	

if (admin.OrderSearchLink.isDisplayed()) {
	
	System.out.println("order search link is displayed");
	
	helper.javaScriptHighlightWebElement(admin.OrderSearchLink);
	logger.log(LogStatus.PASS,"1:Redirected to Admin page"+"<br/>"
			+"<b><font color='green'>Result:order search link has been verified on Admin page" 
		+logger.addScreenCapture(captureScreenShot(driver, "OrderSearchLink")));

	helper.javaScriptUn_HighlightWebElement(admin.OrderSearchLink);
	
} 
	

if (admin.GotoPreparationPageLink.isDisplayed()) {
	
	System.out.println("preparation link is displayed");
	
	helper.javaScriptHighlightWebElement(admin.GotoPreparationPageLink);
	logger.log(LogStatus.PASS,"1:Redirected to Admin page"+"<br/>"
			+"<b><font color='green'>Result:preparation link has been verified on Admin page" 
		+logger.addScreenCapture(captureScreenShot(driver, "GotoPreparationPageLink")));
	
	helper.javaScriptUn_HighlightWebElement(admin.GotoPreparationPageLink);
	
} 

if (admin.CustomerPageLink.isDisplayed()) {
	
	System.out.println("CustomerPage link is displayed");
	
	helper.javaScriptHighlightWebElement(admin.CustomerPageLink);
	
	logger.log(LogStatus.PASS,"1:Redirected to Admin page"+"<br/>"
			+"<b><font color='green'>Result:CustomerPage link has been verified on Admin page" 
		+logger.addScreenCapture(captureScreenShot(driver, "CustomerPageLink")));
	
	helper.javaScriptUn_HighlightWebElement(admin.CustomerPageLink);
	
} 

if (admin.BoardTableAgencydropDown.isDisplayed()) {

	Select select=new Select(admin.BoardTableAgencydropDown);
	select.selectByValue("2|3|PP - IDF|3238|POINT P NANTERRE");
	
Thread.sleep(4000);
}

if(	admin.OrderBoardTable.isDisplayed()) {
	
	helper.javaScriptHighlightWebElement(admin.OrderBoardTable);

	logger.log(LogStatus.PASS,"1:Redirected to Admin page"+"<br/>"
	+"1:Agency has been selected from Agency Drop Down"+"<br/>"
			+"1:Verifying Board Table"+"<br/>"
			+"<b><font color='green'>Result:Board Table has been Verified on Admin page" 
		+logger.addScreenCapture(captureScreenShot(driver, "OrderBoardTable")));

	helper.javaScriptUn_HighlightWebElement(admin.OrderBoardTable);
	
	}

	} catch (Exception e) {
		logger.log(LogStatus.FAIL,"<b><font color='red'>Result:getting Error While Verifying Admin Board Content<font/>"+e.getMessage() 
		+logger.addScreenCapture(captureScreenShot(driver, "Admin Menu")));

	}
	
}
//----verify Drawer Icon---------

public void verifyingDrawerContent() throws Throwable{
	
try {
	

	
helper.javaScriptHighlightWebElement(admin.OrderBoardTableOnDrawer);

logger.log(LogStatus.PASS,"1:Redirected to Admin page"+"<br/>"
+"2:Verifying Drawer Details"+"<br/>"
		+"<b><font color='green'>Result:Order Board Table is Displayed On Drawer" 
	+logger.addScreenCapture(captureScreenShot(driver, "OrderBoardTableOnDrawer")));

helper.javaScriptUn_HighlightWebElement(admin.OrderBoardTableOnDrawer);


helper.javaScriptHighlightWebElement(admin.UserNameOnDrawer);
logger.log(LogStatus.PASS,"1:Redirected to Admin page"+"<br/>"
+"2:Verifying Drawer Details"+"<br/>"
		+"<b><font color='green'>Result:User Name is Displayed On Drawer" 
	+logger.addScreenCapture(captureScreenShot(driver, "UserNameOnDrawer")));
helper.javaScriptUn_HighlightWebElement(admin.UserNameOnDrawer);

driver.findElement(admin.BrandOnDrawer).click();
helper.javaScriptHighlightWebElement(driver.findElement(admin.BrandOnDrawer));
helper.javaScriptHighlightWebElement(driver.findElement(admin.BrandCreationLink));
helper.javaScriptHighlightWebElement(driver.findElement(admin.BrandCreationLink));
	
System.out.println("brand is displayed on drawer");

logger.log(LogStatus.PASS,"1:Verifying Drawer Details"+"<br/>"
+"2:click on Brand tab"+"<br/>"
		+"<b><font color='green'>Result:Brand tab & their child tabs Brand Creation & Brand List is Displayed On Drawer" 
	+logger.addScreenCapture(captureScreenShot(driver, "BrandOnDrawer")));

helper.javaScriptUn_HighlightWebElement(driver.findElement(admin.BrandOnDrawer));
helper.javaScriptUn_HighlightWebElement(driver.findElement(admin.BrandCreationLink));
helper.javaScriptUn_HighlightWebElement(driver.findElement(admin.BrandCreationLink));
driver.findElement(admin.BrandOnDrawer).click();

driver.findElement(admin.RolesLink).click();
helper.javaScriptHighlightWebElement(driver.findElement(admin.RolesLink));
helper.javaScriptHighlightWebElement(driver.findElement(admin.RolesCreationLink));
helper.javaScriptHighlightWebElement(driver.findElement(admin.RolesListLink));	
System.out.println("Roles is displayed on drawer");
logger.log(LogStatus.PASS,"1:Verifying Drawer Details"+"<br/>"
+"2:click on Brand tab"+"<br/>"
		+"<b><font color='green'>Result: Roles tab & their child tabs Roles Creation & Roles List is Displayed On Drawer" 
	+logger.addScreenCapture(captureScreenShot(driver, "RolesLink")));


helper.javaScriptUn_HighlightWebElement(driver.findElement(admin.RolesLink));
helper.javaScriptUn_HighlightWebElement(driver.findElement(admin.RolesCreationLink));
helper.javaScriptUn_HighlightWebElement(driver.findElement(admin.RolesListLink));
driver.findElement(admin.RolesLink).click();


driver.findElement(admin.UsersLink).click();
helper.javaScriptHighlightWebElement(driver.findElement(admin.UsersLink));
helper.javaScriptHighlightWebElement(driver.findElement(admin.UsersCreationLink));	
helper.javaScriptHighlightWebElement(driver.findElement(admin.UsersListLink));	
System.out.println("users is displayed on drawer");
logger.log(LogStatus.PASS,"1:Verifying Drawer Details"+"<br/>"
+"2:click on Brand tab"+"<br/>"
		+"<b><font color='green'>Result: Users tab & their child tabs Users Creation & Users List is Displayed On Drawer" 
	+logger.addScreenCapture(captureScreenShot(driver, "UsersLink")));

helper.javaScriptUn_HighlightWebElement(driver.findElement(admin.UsersLink));
helper.javaScriptUn_HighlightWebElement(driver.findElement(admin.UsersCreationLink));	
helper.javaScriptUn_HighlightWebElement(driver.findElement(admin.UsersListLink));
driver.findElement(admin.UsersLink).click();


driver.findElement(admin.AgencyLink).click();
helper.javaScriptHighlightWebElement(driver.findElement(admin.AgencyLink));
helper.javaScriptHighlightWebElement(driver.findElement(admin.AgencyCreationLink));	
helper.javaScriptHighlightWebElement(driver.findElement(admin.AgencyListsLink));	
System.out.println("users is displayed on drawer");
logger.log(LogStatus.PASS,"1:Verifying Drawer Details"+"<br/>"
+"2:click on Brand tab"+"<br/>"
		+"<b><font color='green'>Result: Agency tab & their child tabs Agency Creation & Agency List is Displayed On Drawer" 
	+logger.addScreenCapture(captureScreenShot(driver, "AgencyLink")));


helper.javaScriptUn_HighlightWebElement(driver.findElement(admin.AgencyLink));
helper.javaScriptUn_HighlightWebElement(driver.findElement(admin.AgencyCreationLink));	
helper.javaScriptUn_HighlightWebElement(driver.findElement(admin.AgencyListsLink));
driver.findElement(admin.AgencyLink).click();


helper.javaScriptHighlightWebElement(driver.findElement(admin.ZoneLink));
	
System.out.println("loading zone is displayed on drawer");
logger.log(LogStatus.PASS,"1:Verifying Drawer Details"+"<br/>"
+"2:click on Brand tab"+"<br/>"
		+"<b><font color='green'>Result: Zone tab is Displayed On Drawer" 
	+logger.addScreenCapture(captureScreenShot(driver, "ZoneLink")));

helper.javaScriptUn_HighlightWebElement(driver.findElement(admin.ZoneLink));

driver.findElement(admin.BLLink).click();

WebElement bLlinklist = driver.findElement(admin.BLlistLink);
bLlinklist.click();

helper.javaScriptHighlightWebElement(driver.findElement(admin.BLLink));
helper.javaScriptHighlightWebElement(driver.findElement(admin.BLlistLink));
	
System.out.println("agency is displayed on drawer");
logger.log(LogStatus.PASS,"1:Verifying Drawer Details"+"<br/>"
+"2:click on Brand tab"+"<br/>"
		+"<b><font color='green'>Result: BL tab & their child tab BL List is Displayed On Drawer" 
	+logger.addScreenCapture(captureScreenShot(driver, "BLLink")));

helper.javaScriptUn_HighlightWebElement(driver.findElement(admin.BLLink));
helper.javaScriptUn_HighlightWebElement(driver.findElement(admin.BLlistLink));


} catch (Exception e) {
	logger.log(LogStatus.FAIL,"<b><font color='red'>Result:getting Error While Verifying Drawer Content<font/>"+e.getMessage() 
	+logger.addScreenCapture(captureScreenShot(driver, "Admin Menu")));


	}

}

//-------brand menu------------

public void brandMenu() throws Throwable {
	
	try {
		
	
logger.log(LogStatus.INFO,"<b><U>Verifying Brand Menu");


driver.findElement(admin.BrandOnDrawer).click();
driver.findElement(admin.BrandCreationLink).click();
driver.findElement(admin.NomField).sendKeys("AutomationTest");
Actions action=new Actions(driver);
WebElement fileInput = driver.findElement(By.id("userfile"));
fileInput.sendKeys(System.getProperty("user.dir")+"\\Files\\API.png");

helper.javaScriptHighlightWebElement(driver.findElement(admin.NomField));
helper.javaScriptHighlightWebElement(driver.findElement(By.id("userfile")));
helper.javaScriptHighlightWebElement(driver.findElement(admin.BrandSaveButton));

driver.findElement(admin.BrandSaveButton).click();

helper.waitingForElementClikable(admin.logoAlreadyExist);

WebElement logodisplayed =driver.findElement(admin.logoAlreadyExist);


if( logodisplayed.isDisplayed() && logodisplayed.isEnabled() ) {
	
	System.out.println("brand already exist");
	
	logger.log(LogStatus.PASS,"<b>Case:</b> Verifying Brand Creation Menu"+"<br/>"
			+"1:click on Brand Tab"+"<br/>"
			+"2:click on Brand Creation child Tab"+"<br/>"
			+"3:Enter Brand Name On Brand Name Field"+"<br/>"
			+"4:Select PNG File From System"+"<br/>"
			+"5:Click On Create Button"+"<br/>"		
					+"<b><font color='green'>Result: Brand Logo is Already Exist" 
				+logger.addScreenCapture(captureScreenShot(driver, "logoAlreadyExist")));

	
}else {
	
	driver.findElement(admin.BrandSuccessMessage).isDisplayed();

	logger.log(LogStatus.PASS,"<b>Case:</b> Verifying Brand Creation Menu"+"<br/>"
			+"1:click on Brand Tab"+"<br/>"
			+"2:click on Brand Creation child Tab"+"<br/>"
			+"3:Enter Brand Name On Brand Name Field"+"<br/>"
			+"4:Select PNG File From System"+"<br/>"
			+"5:Click On Create Button"+"<br/>"		
					+"<b><font color='green'>Result: Brand Success Fully Created" 
				+logger.addScreenCapture(captureScreenShot(driver, "BrandSuccessMessage")));

	System.out.println("brand created");
}

Thread.sleep(3000);

driver.findElement(admin.BrandListsLink).click();

driver.findElement(admin.SortingArrows).click();
Thread.sleep(2000);
driver.findElement(admin.SortingArrows).click();


helper.SelectvalueFromDropDown(admin.PaginationDropDown, "25");

driver.findElement(admin.RechercherField).sendKeys("BRO-LVB");

helper.javaScriptHighlightWebElement(driver.findElement(admin.SortingArrows));
helper.javaScriptHighlightWebElement(driver.findElement(admin.PaginationDropDown));
helper.javaScriptHighlightWebElement(driver.findElement(admin.RechercherField));
helper.javaScriptHighlightWebElement(driver.findElement(admin.EditButton));
helper.javaScriptHighlightWebElement(driver.findElement(admin.DeleteButton));

logger.log(LogStatus.PASS,"<b>Case:</b>Verifying Content present On Brand List Menu"+"<br/>"
		+"1:click on Brand Tab"+"<br/>"
		+"2:click on Brand Lsit child Tab"+"<br/>"
		+"3:Selecting Sortting Arrows"+"<br/>"
		+"4:Selecting Rows from Pagination drop Down"+"<br/>"
		+"5:Enter Brand name on Rechercher Field"+"<br/>"
		+"6:Delete & Edit Button Has been Verified"+"<br/>"
				+"<b><font color='green'>Result:Content has been Verified On Brand List Menu " 
			+logger.addScreenCapture(captureScreenShot(driver, "BrandListsLink")));


helper.javaScriptUn_HighlightWebElement(driver.findElement(admin.SortingArrows));
helper.javaScriptUn_HighlightWebElement(driver.findElement(admin.PaginationDropDown));
helper.javaScriptUn_HighlightWebElement(driver.findElement(admin.RechercherField));
helper.javaScriptUn_HighlightWebElement(driver.findElement(admin.EditButton));
helper.javaScriptUn_HighlightWebElement(driver.findElement(admin.DeleteButton));


driver.findElement(admin.EditButton).click();

driver.findElement(admin.NomField).clear();
driver.findElement(admin.NomField).sendKeys("BRO-LVB");
driver.findElement(admin.BranduserFiles).isDisplayed();
driver.findElement(admin.BrandSaveButton).click();
driver.findElement(admin.BrandSuccessMessage).isDisplayed();

helper.javaScriptHighlightWebElement(driver.findElement(admin.NomField));
helper.javaScriptHighlightWebElement(driver.findElement(By.id("userfile")));
helper.javaScriptHighlightWebElement(driver.findElement(admin.BrandSaveButton));

logger.log(LogStatus.PASS,"<b>Case:</b>Verifying Edit Brand Menu"+"<br/>"
		+"1:click on Brand Tab"+"<br/>"
		+"2:click on Brand Lsit child Tab"+"<br/>"
		+"3:click on Edit Button"+"<br/>"
		+"4:Enter Brand name in Nom Field"+"<br/>"
		+"5:Selecting File From System"+"<br/>"
		+"6:click on Save Button"+"<br/>"
				+"<b><font color='green'>Result: Brand Successfully Edited" 
			+logger.addScreenCapture(captureScreenShot(driver, "BrandEditButton")));



driver.navigate().back();
driver.findElement(admin.RechercherField).sendKeys(Keys.ENTER);

logger.log(LogStatus.PASS,"<b>Case:</b>Verifying Delete Brand Functionality "+"<br/>"
		+"1:navigate back to the Brand List menu"+"<br/>"
		+"2:search for Brand Name"+"<br/>"
		+"3:click on Delete Button"+"<br/>"
		+"4:Confirmation PopUp is Displayed"+"<br/>"
				+"<b><font color='green'>Result: Brand Successfully Deleted" 
			+logger.addScreenCapture(captureScreenShot(driver, "BrandDeleteButton")));

driver.findElement(admin.DeleteButton).click();
helper.handleAcceptDimiss();

	} catch (Exception e) {
		logger.log(LogStatus.FAIL,"<b><font color='red'>Result:getting Error While Verifying Brand Menu<font/>"+e.getMessage() 
		+logger.addScreenCapture(captureScreenShot(driver, "Admin Menu")));

	}
	

}
  
//---------Roles Menu------------
 

public void roleMenu()throws Throwable {
	
	try {
		
	
logger.log(LogStatus.INFO,"<b><U>Verifying Roles Menu");

  driver.findElement(admin.RolesLink).click();
  
  driver.findElement(admin.RolesCreationLink).click();

  

  driver.findElement(admin.NomField).sendKeys("AutomationRole");
  driver.findElement(admin.user_type_submit).click();
  driver.findElement(admin.BrandSuccessMessage).isDisplayed();

  helper.javaScriptHighlightWebElement(driver.findElement(admin.NomField));
  helper.javaScriptHighlightWebElement(driver.findElement(admin.user_type_submit));
  
  logger.log(LogStatus.PASS,"<b>Case:</b>Verifying Role Creation Menu"+"<br/>"
			+"1:click on Roles Tab"+"<br/>"
			+"2:click on Roles Creation child Tab"+"<br/>"
			+"3:Enter Role Name On Role Nom Field"+"<br/>"
			+"4:Click On Create Button"+"<br/>"		
					+"<b><font color='green'>Result: Role SuccessFully Created" 
				+logger.addScreenCapture(captureScreenShot(driver, "RolesCreationLink")));

  
  
 driver.findElement(admin.RolesListLink).click();
driver.findElement(admin.SortingArrows).click();
Thread.sleep(2000);
driver.findElement(admin.SortingArrows).click();

helper.SelectvalueFromDropDown(admin.PaginationDropDown, "25");

driver.findElement(admin.RechercherField).sendKeys("AutomationRole");

helper.javaScriptHighlightWebElement(driver.findElement(admin.SortingArrows));
helper.javaScriptHighlightWebElement(driver.findElement(admin.PaginationDropDown));
helper.javaScriptHighlightWebElement(driver.findElement(admin.RechercherField));
helper.javaScriptHighlightWebElement(driver.findElement(admin.EditButton));
helper.javaScriptHighlightWebElement(driver.findElement(admin.DeleteButton));



logger.log(LogStatus.PASS,"<b>Case:</b>Verifying Content present On Roles List Menu"+"<br/>"
		+"1:click on Roles Tab"+"<br/>"
		+"2:click on Roles List child Tab"+"<br/>"
		+"3:Selecting Sortting Arrows"+"<br/>"
		+"4:Selecting Rows from Pagination drop Down"+"<br/>"
		+"5:Enter Role name on Rechercher Field"+"<br/>"
		+"6:Delete & Edit Button Has been Verified"+"<br/>"
				+"<b><font color='green'>Result:Content has been Verified On Role List Menu " 
			+logger.addScreenCapture(captureScreenShot(driver, "RolesListLink")));


helper.javaScriptUn_HighlightWebElement(driver.findElement(admin.SortingArrows));
helper.javaScriptUn_HighlightWebElement(driver.findElement(admin.PaginationDropDown));
helper.javaScriptUn_HighlightWebElement(driver.findElement(admin.RechercherField));
helper.javaScriptUn_HighlightWebElement(driver.findElement(admin.EditButton));
helper.javaScriptUn_HighlightWebElement(driver.findElement(admin.DeleteButton));


driver.findElement(admin.EditButton).click();
driver.findElement(admin.NomField).clear();
driver.findElement(admin.NomField).sendKeys("AutomationRole");
driver.findElement(admin.user_type_submit).click();
driver.findElement(admin.BrandSuccessMessage).isDisplayed();

helper.javaScriptHighlightWebElement(driver.findElement(admin.NomField));
helper.javaScriptHighlightWebElement(driver.findElement(admin.user_type_submit));

logger.log(LogStatus.PASS,"<b>Case:</b>Verifying Edit Role Menu"+"<br/>"
		+"1:click on Role Tab"+"<br/>"
		+"2:click on Role Lsit child Tab"+"<br/>"
		+"3:click on Edit Button"+"<br/>"
		+"4:Enter Role name in Nom Field"+"<br/>"
		+"6:click on Save Button"+"<br/>"
				+"<b><font color='green'>Result: Role Successfully Edited" 
			+logger.addScreenCapture(captureScreenShot(driver, "RoleEditButton")));


driver.navigate().back();
driver.findElement(admin.RechercherField).sendKeys(Keys.ENTER);

logger.log(LogStatus.PASS,"<b>Case:</b>Verifying Delete Role Functionality "+"<br/>"
		+"1:navigate back to the Role List menu"+"<br/>"
		+"2:search for Role Name"+"<br/>"
		+"3:click on Delete Button"+"<br/>"
		+"4:Confirmation PopUp is Displayed"+"<br/>"
				+"<b><font color='green'>Result: Role Successfully Deleted" 
			+logger.addScreenCapture(captureScreenShot(driver, "RoleDeleteButton")));

driver.findElement(admin.DeleteButton).click();

helper.handleAcceptAlert();

Thread.sleep(3000);

helper.handleAcceptAlert();

	} catch (Exception e) {
	
		logger.log(LogStatus.FAIL,"<b><font color='red'>Result:getting Error While Verifying Role Menu<font/>"+e.getMessage() 
		+logger.addScreenCapture(captureScreenShot(driver, "Admin Menu")));


	
	}

}
 
 //---------agency--------------
 

public void agencyMenu() throws Throwable {
	
	try {
		
	
logger.log(LogStatus.INFO,"<b><U>Verifying Agency Menu");

driver.findElement(admin.AgencyLink).click();

 driver.findElement(admin.AgencyCreationLink).click();
 
 driver.findElement(admin.agency_code).sendKeys("1234");
 driver.findElement( admin.agency_name).sendKeys("Automation");
  
 helper.SelectvalueFromDropDown(admin.agency_brand, "1");
 
 driver.findElement( admin.gate).sendKeys("2");
 

 driver.findElement(admin.agency_submit).click();
 
 
 helper.javaScriptHighlightWebElement(driver.findElement(admin.agency_code));
 helper.javaScriptHighlightWebElement(driver.findElement(admin.agency_name));
 helper.javaScriptHighlightWebElement(driver.findElement(admin.agency_brand));
 helper.javaScriptHighlightWebElement(driver.findElement(admin.gate));
 helper.javaScriptHighlightWebElement(driver.findElement(admin.agency_submit));
 
 
 //helper.waitingForElementClikable(admin.BrandSuccessMessage);
 
 logger.log(LogStatus.PASS,"<b>Case:</b>Verifying Agency Creation Menu"+"<br/>"
			+"1:click on agency Tab"+"<br/>"
			+"2:click on Agency Creation child Tab"+"<br/>"
			+"3:Enter Agency Name On Agency Nom Field"+"<br/>"
			+"3:Enter Agency code On Agency Code Field"+"<br/>"
			+"3:Select Agency Brand  &  No. of Gates"+"<br/>"
			+"4:Click On Create Button"+"<br/>"		
					+"<b><font color='green'>Result: Agency SuccessFully Created" 
				+logger.addScreenCapture(captureScreenShot(driver, "AgencyCreationLink")));


 
 driver.findElement(admin.AgencyListsLink).click();
 driver.findElement(admin.agencyList_SorrtingArrows).click();
 Thread.sleep(2000);
 driver.findElement(admin.agencyList_SorrtingArrows).click();
 driver.findElement(admin.RechercherField).sendKeys("1234");

 
 
 helper.javaScriptHighlightWebElement(driver.findElement(admin.SortingArrows));
 helper.javaScriptHighlightWebElement(driver.findElement(admin.PaginationDropDown));
 helper.javaScriptHighlightWebElement(driver.findElement(admin.RechercherField));
 helper.javaScriptHighlightWebElement(driver.findElement(admin.agency_EditButton));
 helper.javaScriptHighlightWebElement(driver.findElement(admin.agency_DeleteButton));
 
 logger.log(LogStatus.PASS,"<b>Case:</b>Verifying Content present On Agency List Menu"+"<br/>"
			+"1:click on Agency Tab"+"<br/>"
			+"2:click on Agency List child Tab"+"<br/>"
			+"3:Selecting Sortting Arrows"+"<br/>"
			+"4:Selecting Rows from Pagination drop Down"+"<br/>"
			+"5:Enter Agency name on Rechercher Field"+"<br/>"
			+"6:Delete & Edit Button Has been Verified"+"<br/>"
					+"<b><font color='green'>Result:Content has been Verified On Role List Menu " 
				+logger.addScreenCapture(captureScreenShot(driver, "AgencyListLink")));

 helper.javaScriptUn_HighlightWebElement(driver.findElement(admin.SortingArrows));
 helper.javaScriptUn_HighlightWebElement(driver.findElement(admin.PaginationDropDown));
 helper.javaScriptUn_HighlightWebElement(driver.findElement(admin.RechercherField));
 helper.javaScriptUn_HighlightWebElement(driver.findElement(admin.agency_EditButton));
 helper.javaScriptUn_HighlightWebElement(driver.findElement(admin.agency_DeleteButton));
 
 
driver.findElement(admin.agency_EditButton).click();
driver.findElement(admin.agency_code).clear(); 
driver.findElement( admin.agency_code).sendKeys("1234");

driver.findElement(admin.agency_name).clear(); 
driver.findElement( admin.agency_name).sendKeys("Automation");


 helper.SelectvalueFromDropDown(admin.agency_brand, "2");
 
 driver.findElement(admin.gate).clear(); 
 driver.findElement( admin.gate).sendKeys("3");

 driver.findElement(admin.agency_submit).click();

 //helper.waitingForElementClikable(admin.BrandSuccessMessage);
 logger.log(LogStatus.PASS,"<b>Case:</b>Verifying Edit Role Menu"+"<br/>"
			+"1:click on agency Tab"+"<br/>"
			+"2:click on Agency Creation child Tab"+"<br/>"
			+"3:Enter Agency Name On Agency Nom Field"+"<br/>"
			+"3:Enter Agency code On Agency Code Field"+"<br/>"
			+"3:Select Agency Brand  &  No. of Gates"+"<br/>"
			+"4:Click On Create Button"+"<br/>"		
					+"<b><font color='green'>Result: Agency SuccessFully Edited" 
				+logger.addScreenCapture(captureScreenShot(driver, "agency_EditButton")));


 driver.findElement(admin.BrandSuccessMessage).isDisplayed(); driver.navigate().back();
 driver.findElement(admin.RechercherField).sendKeys(Keys.ENTER);
 
 Thread.sleep(2000);
 
 logger.log(LogStatus.PASS,"<b>Case:</b>Verifying Delete Agency Functionality "+"<br/>"
			+"1:navigate back to the Agency List menu"+"<br/>"
			+"2:search for Agency Code"+"<br/>"
			+"3:click on Delete Button"+"<br/>"
			+"4:Confirmation PopUp is Displayed"+"<br/>"
					+"<b><font color='green'>Result: Role Successfully Deleted" 
				+logger.addScreenCapture(captureScreenShot(driver, "AgencyDeleteButton")));


 driver.findElement(admin.agency_DeleteButton).click();
 
 helper.handleAcceptAlert();
Thread.sleep(3000);
helper.handleAcceptAlert();
 
	} catch (Exception e) {
		
		logger.log(LogStatus.FAIL,"<b><font color='red'>Result:getting Error While Verifying agency Menu<font/>"+e.getMessage() 
		+logger.addScreenCapture(captureScreenShot(driver, "Admin Menu")));


	
	}
	

}

//------------------users Menu-------------------

public void usersMenu() throws Throwable {
	
 
	try {
		
logger.log(LogStatus.INFO,"<b><U>Verifying Users Menu");


 driver.findElement(admin.UsersLink).click();

 driver.findElement(admin.UsersCreationLink).click();
 
 
 
 driver.findElement(admin.users_sgid).sendKeys("S1234567");
 driver.findElement( admin.users_name).sendKeys("Qa");
 driver.findElement(admin.users_last_name).sendKeys("automation");
 
 
 helper.SelectvalueFromDropDown(admin.users_type, "1");
 helper.SelectvalueFromDropDown(admin.users_agency, "30");
 
 Thread.sleep(4000);
 
 if (driver.findElement(admin.users_zone).isEnabled()) {
	
	 helper.SelectvalueFromDropDown(admin.users_zone, "184");
	 
	 
}else {
	
	System.out.println("zone is disabled");
}
 
 driver.findElement(admin.user_submit).click();

 helper.javaScriptHighlightWebElement(driver.findElement(admin.users_sgid));
 helper.javaScriptHighlightWebElement(driver.findElement(admin.users_name));
 helper.javaScriptHighlightWebElement(driver.findElement(admin.users_last_name));
 helper.javaScriptHighlightWebElement(driver.findElement(admin.users_type));
 helper.javaScriptHighlightWebElement(driver.findElement(admin.users_agency));
 helper.javaScriptHighlightWebElement(driver.findElement(admin.users_zone));
 helper.javaScriptHighlightWebElement(driver.findElement(admin.user_submit));

 
 
 logger.log(LogStatus.PASS,"<b>Case:</b>Verifying USer Creation Menu"+"<br/>"
			+"1:click on User Tab"+"<br/>"
			+"2:click on User Creation child Tab"+"<br/>"
			+"3:Enter User First & Last Name On User Nom Field"+"<br/>"
			+"5:Enter User SGID On User SGID Field"+"<br/>"
			+"6:Select user Type "+"<br/>"
			+"7:Select user Agency & Zone "+"<br/>"
			+"8:Click On Create Button"+"<br/>"		
					+"<b><font color='green'>Result: User SuccessFully Created" 
				+logger.addScreenCapture(captureScreenShot(driver, "usersCreationLink")));

 
 
 driver.findElement(admin.UsersListLink).click();
 
 driver.findElement(admin.SortingArrows).click();
 Thread.sleep(2000);
 driver.findElement(admin.SortingArrows).click();
 
 driver.findElement(admin.RechercherField).sendKeys("S1234567");

 helper.javaScriptHighlightWebElement(driver.findElement(admin.SortingArrows));
 helper.javaScriptHighlightWebElement(driver.findElement(admin.PaginationDropDown));
 helper.javaScriptHighlightWebElement(driver.findElement(admin.RechercherField));
 helper.javaScriptHighlightWebElement(driver.findElement(admin.users_EditButton));
 helper.javaScriptHighlightWebElement(driver.findElement(admin.users_Active_InactiveButton));
 
 logger.log(LogStatus.PASS,"<b>Case:</b>Verifying Content present On Users List Menu"+"<br/>"
			+"1:click on Users Tab"+"<br/>"
			+"2:click on Users List child Tab"+"<br/>"
			+"3:Selecting Sortting Arrows"+"<br/>"
			+"4:Selecting Rows from Pagination drop Down"+"<br/>"
			+"5:Enter Users SGID on Rechercher Field"+"<br/>"
			+"6:Delete & Edit Button Has been Verified"+"<br/>"
					+"<b><font color='green'>Result:Content has been Verified On Users List Menu " 
				+logger.addScreenCapture(captureScreenShot(driver, "UsersListLink")));

 helper.javaScriptUn_HighlightWebElement(driver.findElement(admin.SortingArrows));
 helper.javaScriptUn_HighlightWebElement(driver.findElement(admin.PaginationDropDown));
 helper.javaScriptUn_HighlightWebElement(driver.findElement(admin.RechercherField));
 helper.javaScriptUn_HighlightWebElement(driver.findElement(admin.users_EditButton));
 helper.javaScriptUn_HighlightWebElement(driver.findElement(admin.users_Active_InactiveButton));

 
 
driver.findElement(admin.users_EditButton).click();
driver.findElement(admin.users_sgid).clear();
driver.findElement(admin.users_sgid).sendKeys("S1234567");

driver.findElement(admin.users_name).clear();
driver.findElement( admin.users_name).sendKeys("Qa");

driver.findElement(admin.users_last_name).clear();
driver.findElement(admin.users_last_name).sendKeys("automation");


helper.SelectvalueFromDropDown(admin.users_type, "1");
helper.SelectvalueFromDropDown(admin.users_agency, "30");

Thread.sleep(4000);


driver.findElement(admin.user_submit).click();

helper.waitingForElementClikable(admin.BrandSuccessMessage);
logger.log(LogStatus.PASS,"<b>Case:</b>Verifying Edit User Menu"+"<br/>"
			+"1:click on User Tab"+"<br/>"
			+"2:click on User Creation child Tab"+"<br/>"
			+"3:Enter User First & Last Name On User Nom Field"+"<br/>"
			+"5:Enter User SGID On User SGID Field"+"<br/>"
			+"6:Select user Type "+"<br/>"
			+"7:Select user Agency & Zone "+"<br/>"
			+"8:Click On Create Button"+"<br/>"		
					+"<b><font color='green'>Result: User SuccessFully Edited" 
				+logger.addScreenCapture(captureScreenShot(driver, "user_EditButton")));

	} catch (Exception e) {

		
		logger.log(LogStatus.FAIL,"<b><font color='red'>Result:getting Error While Verifying USers Menu<font/>"+e.getMessage() 
		+logger.addScreenCapture(captureScreenShot(driver, "Admin Menu")));


	}


}



//---------------Loading Zone------------------------

public void loadingZone() throws Throwable{

	try {
		
	
logger.log(LogStatus.INFO,"<b><U>Verifying Loading Zone Menu");

driver.findElement(admin.ZoneLink).click();

helper.SelectvalueFromDropDown(admin.Zone_agency_DropDown, "30|3323|QA RELEASE26");

Thread.sleep(4000);

driver.findElement(admin.zone_add).click();
driver.findElement(admin.zone_code).isDisplayed();
driver.findElement(admin.zone_name).sendKeys("automation");
helper.javaScriptHighlightWebElement(driver.findElement(admin.zone_add));
helper.javaScriptHighlightWebElement(driver.findElement(admin.zone_code));
helper.javaScriptHighlightWebElement(driver.findElement(admin.zone_name));
helper.javaScriptHighlightWebElement(driver.findElement(admin.insert));
helper.javaScriptHighlightWebElement(driver.findElement(admin.cancel));

logger.log(LogStatus.PASS,"<b>Case:</b>Verifying Zone Creation Menu"+"<br/>"
		+"1:click on Laoding zone Tab"+"<br/>"
		+"3:Enter Zone Code & Zone Name On Zone Field"+"<br/>"
		+"8:Click On Insert Button"+"<br/>"		
				+"<b><font color='green'>Result: Zone SuccessFully Created" 
			+logger.addScreenCapture(captureScreenShot(driver, "ZoneCreationLink")));

helper.javaScriptUn_HighlightWebElement(driver.findElement(admin.zone_add));
helper.javaScriptUn_HighlightWebElement(driver.findElement(admin.zone_code));
helper.javaScriptUn_HighlightWebElement(driver.findElement(admin.zone_name));
helper.javaScriptUn_HighlightWebElement(driver.findElement(admin.insert));
helper.javaScriptUn_HighlightWebElement(driver.findElement(admin.cancel));


driver.findElement(admin.insert).click();
Thread.sleep(8000);


Actions action7=new Actions(driver);

action7.moveToElement(driver.findElement(admin.loadingZoneInlineEdit)).doubleClick().sendKeys("EditAutomatin").perform();


driver.findElement(admin.loadingZoneInclickCode).click();



helper.handleAcceptAlert();

Thread.sleep(8000);

	} catch (Exception e) {
		logger.log(LogStatus.FAIL,"<b><font color='red'>Result:getting Error While Verifying Loading zone Menu<font/>"+e.getMessage() 
		+logger.addScreenCapture(captureScreenShot(driver, "Admin Menu")));


		
		
	}
	

}
//------------------------ BL Menu-----------------------------

public void bLMenu()throws Throwable {

	try {
		
	
logger.log(LogStatus.INFO,"<b><U>Verifying BL  Menu");

driver.findElement(admin.BLLink).click();
driver.findElement(admin.BLlistLink).click();

admin.orderListRechercherField.sendKeys("F509515");

logger.log(LogStatus.PASS,"<b>Case:</b>Verifying BL Order Lists Menu"+"<br/>"
		+"1: click on Bl List Link"+"<br/>"
			+"2:"+"<br/>"		
				+"<b><font color='green'>Result: Bl order Menu has been verified" 
			+logger.addScreenCapture(captureScreenShot(driver, "BLListOrder")));

Thread.sleep(4000);
admin.orderListEditButton.click();


if (admin.order_num.getAttribute("readonly") != null) {
	
	helper.javaScriptHighlightWebElement(admin.order_num);
	logger.log(LogStatus.PASS,"<b>Case:</b>Verifying Order num field is Disabled or not On BL Edit Order Form"+"<br/>"
			+"1: click on Edit Button"+"<br/>"
					+"<b><font color='green'>Result: Order number field is Disabled" 
				+logger.addScreenCapture(captureScreenShot(driver, "order_num")));

	helper.javaScriptUn_HighlightWebElement(admin.order_num);
}else {
	
	logger.log(LogStatus.FAIL,"<b>Case:</b>Verifying Order num field is Disabled or not On BL Edit Order Form"+"<br/>"
			+"1: click on Edit Button"+"<br/>"
					+"<b><font color='red'>Result: Order number field is Enabled" 
				+logger.addScreenCapture(captureScreenShot(driver, "order_num")));

}

if (admin.status.getAttribute("readonly") != null) {
	
	helper.javaScriptHighlightWebElement(admin.status);

	logger.log(LogStatus.PASS,"<b>Case:</b>Verifying status  field is Disabled or not On BL Edit Order Form"+"<br/>"
			+"1: click on Edit Button"+"<br/>"
					+"<b><font color='green'>Result: status  field is Disabled" 
				+logger.addScreenCapture(captureScreenShot(driver, "status")));

	System.out.println("status is enabled test case failed");

	helper.javaScriptUn_HighlightWebElement(admin.status);

}else {
	
	logger.log(LogStatus.FAIL,"<b>Case:</b>Verifying status  field is Disabled or not On BL Edit Order Form"+"<br/>"
			+"1: click on Edit Button"+"<br/>"
					+"<b><font color='red'>Result: status  field is Enabled" 
				+logger.addScreenCapture(captureScreenShot(driver, "status")));

	System.out.println("status is disabled test case pass");
}


if (admin.origin.getAttribute("readonly") != null) {

	helper.javaScriptHighlightWebElement(admin.origin);

	logger.log(LogStatus.PASS,"<b>Case:</b>Verifying origin  field is Disabled or not On BL Edit Order Form"+"<br/>"
			+"1: click on Edit Button"+"<br/>"
					+"<b><font color='green'>Result: origin  field is Disabled" 
				+logger.addScreenCapture(captureScreenShot(driver, "origin")));

	helper.javaScriptUn_HighlightWebElement(admin.origin);
	System.out.println("origin is enabled test case failed");
	 
}else {
	
	logger.log(LogStatus.PASS,"<b>Case:</b>Verifying origin  field is Disabled or not On BL Edit Order Form"+"<br/>"
			+"1: click on Edit Button"+"<br/>"
					+"<b><font color='red'>Result: origin  field is Enabled" 
				+logger.addScreenCapture(captureScreenShot(driver, "origin")));

	System.out.println("origin is disabled test case pass");
}

if (admin.creation_date.getAttribute("readonly") != null) {

	
	helper.javaScriptHighlightWebElement(admin.creation_date);

	logger.log(LogStatus.PASS,"<b>Case:</b>Verifying creation_date  field is Disabled or not On BL Edit Order Form"+"<br/>"
			+"1: click on Edit Button"+"<br/>"
					+"<b><font color='green'>Result: creation_date  field is Disabled" 
				+logger.addScreenCapture(captureScreenShot(driver, "creation_date")));

	System.out.println("creation_date is enabled test case failed");

	helper.javaScriptUn_HighlightWebElement(admin.creation_date);

}else {

	logger.log(LogStatus.FAIL,"<b>Case:</b>Verifying creation_date  field is Disabled or not On BL Edit Order Form"+"<br/>"
			+"1: click on Edit Button"+"<br/>"
					+"<b><font color='green'>Result: creation_date  field is Enabled" 
				+logger.addScreenCapture(captureScreenShot(driver, "creation_date")));

	System.out.println("creation_date is disabled test case pass");
}

if (admin.creation_date_bl.getAttribute("readonly") != null) {
	
	helper.javaScriptHighlightWebElement(admin.creation_date_bl);

	logger.log(LogStatus.PASS,"<b>Case:</b>Verifying creation_date_bl  field is Disabled or not On BL Edit Order Form"+"<br/>"
			+"1: click on Edit Button"+"<br/>"
					+"<b><font color='green'>Result: creation_date_bl  field is Disabled" 
				+logger.addScreenCapture(captureScreenShot(driver, "creation_date_bl")));

	System.out.println("creation_date_bl is enabled test case failed");
	 
	helper.javaScriptUn_HighlightWebElement(admin.creation_date_bl);

}else {

	logger.log(LogStatus.FAIL,"<b>Case:</b>Verifying creation_date_bl  field is Disabled or not On BL Edit Order Form"+"<br/>"
			+"1: click on Edit Button"+"<br/>"
					+"<b><font color='green'>Result: creation_date_bl  field is Enabled" 
				+logger.addScreenCapture(captureScreenShot(driver, "creation_date_bl")));


	System.out.println("creation_date_bl is disabled test case pass");
}





if (admin.customer.isDisplayed() && admin.customer.isEnabled()) {

	
	helper.javaScriptHighlightWebElement(admin.customer);

	logger.log(LogStatus.PASS,"<b>Case:</b>Verifying Customer Field on BL Order Edit Form"+"<br/>"
			+"1: click on Edit Button"+"<br/>"
					+"<b><font color='green'>Result: customer  field is enabled" 
				+logger.addScreenCapture(captureScreenShot(driver, "creation_date_bl")));

	helper.javaScriptUn_HighlightWebElement(admin.customer);

}else {

	logger.log(LogStatus.FAIL,"<b>Case:</b>Verifying Customer Field on BL Order Edit Form"+"<br/>"
			+"1: click on Edit Button"+"<br/>"
					+"<b><font color='red'>Result: customer  field is Disabled" 
				+logger.addScreenCapture(captureScreenShot(driver, "creation_date_bl")));
}




if (admin.company.isDisplayed() && admin.company.isEnabled()) {

	admin.company.sendKeys("test");
	helper.javaScriptHighlightWebElement(admin.company);

	logger.log(LogStatus.PASS,"<b>Case:</b>Verifying company Field on BL Order Edit Form"+"<br/>"
			+"1: click on Edit Button"+"<br/>"
					+"<b><font color='green'>Result: company  field is enabled" 
				+logger.addScreenCapture(captureScreenShot(driver, "company")));
	helper.javaScriptUn_HighlightWebElement(admin.company);

}else {

	logger.log(LogStatus.FAIL,"<b>Case:</b>Verifying company Field on BL Order Edit Form"+"<br/>"
			+"1: click on Edit Button"+"<br/>"
					+"<b><font color='red'>Result: company  field is Disabled" 
				+logger.addScreenCapture(captureScreenShot(driver, "company")));
}



if (admin.client_code.isDisplayed() && admin.client_code.isEnabled()) {

	admin.client_code.click();
	helper.javaScriptHighlightWebElement(admin.client_code);
	
	logger.log(LogStatus.PASS,"<b>Case:</b>Verifying client_code Field on BL Order Edit Form"+"<br/>"
			+"1: click on Edit Button"+"<br/>"
					+"<b><font color='green'>Result: client_code  field is enabled" 
				+logger.addScreenCapture(captureScreenShot(driver, "client_code")));
	helper.javaScriptUn_HighlightWebElement(admin.client_code);
	 
}else {

	logger.log(LogStatus.FAIL,"<b>Case:</b>Verifying client_code Field on BL Order Edit Form"+"<br/>"
			+"1: click on Edit Button"+"<br/>"
					+"<b><font color='red'>Result: client_code  field is Disabled" 
				+logger.addScreenCapture(captureScreenShot(driver, "client_code")));
}

if (admin.size.isDisplayed() && admin.size.isEnabled()) {

	admin.size.click();
	helper.javaScriptHighlightWebElement(admin.size);

	logger.log(LogStatus.PASS,"<b>Case:</b>Verifying size Field on BL Order Edit Form"+"<br/>"
			+"1: click on Edit Button"+"<br/>"
					+"<b><font color='green'>Result: size  field is enabled" 
				+logger.addScreenCapture(captureScreenShot(driver, "size")));
	helper.javaScriptUn_HighlightWebElement(admin.size);
	 
}else {

	logger.log(LogStatus.FAIL,"<b>Case:</b>Verifying size Field on BL Order Edit Form"+"<br/>"
			+"1: click on Edit Button"+"<br/>"
					+"<b><font color='red'>Result: size  field is Disabled" 
				+logger.addScreenCapture(captureScreenShot(driver, "size")));

}



if (driver.findElement(admin.agency).isDisplayed() && driver.findElement(admin.agency).isEnabled()) {

	driver.findElement(admin.agency).click();
	helper.javaScriptHighlightWebElement(driver.findElement(admin.agency));

	logger.log(LogStatus.PASS,"<b>Case:</b>Verifying agency Field on BL Order Edit Form"+"<br/>"
			+"1: click on Edit Button"+"<br/>"
					+"<b><font color='green'>Result: agency  field is enabled" 
				+logger.addScreenCapture(captureScreenShot(driver, "agency")));
	
	helper.javaScriptUn_HighlightWebElement(driver.findElement(admin.agency));

	
}else {

	logger.log(LogStatus.FAIL,"<b>Case:</b>Verifying agency Field on BL Order Edit Form"+"<br/>"
			+"1: click on Edit Button"+"<br/>"
					+"<b><font color='red'>Result: agency  field is Disabled" 
				+logger.addScreenCapture(captureScreenShot(driver, "agency")));
}


if (driver.findElement(admin.user).isDisplayed() && driver.findElement(admin.user).isEnabled()) {

	driver.findElement(admin.user).click();
	helper.javaScriptHighlightWebElement(driver.findElement(admin.user));

	logger.log(LogStatus.PASS,"<b>Case:</b>Verifying user Field on BL Order Edit Form"+"<br/>"
			+"1: click on Edit Button"+"<br/>"
					+"<b><font color='green'>Result: user  field is enabled" 
				+logger.addScreenCapture(captureScreenShot(driver, "user")));
	helper.javaScriptUn_HighlightWebElement(driver.findElement(admin.user));
 
}else {

	logger.log(LogStatus.FAIL,"<b>Case:</b>Verifying user Field on BL Order Edit Form"+"<br/>"
			+"1: click on Edit Button"+"<br/>"
					+"<b><font color='red'>Result: user  field is Disabled" 
				+logger.addScreenCapture(captureScreenShot(driver, "user")));
}


if (admin.comment.isDisplayed() && admin.comment.isEnabled()) {

	admin.comment.sendKeys("test");

	helper.javaScriptHighlightWebElement(admin.comment);

	logger.log(LogStatus.PASS,"<b>Case:</b>Verifying comment Field on BL Order Edit Form"+"<br/>"
			+"1: click on Edit Button"+"<br/>"
					+"<b><font color='green'>Result: comment  field is enabled" 
				+logger.addScreenCapture(captureScreenShot(driver, "comment")));

	helper.javaScriptUn_HighlightWebElement(admin.comment);

}else {

	logger.log(LogStatus.FAIL,"<b>Case:</b>Verifying comment Field on BL Order Edit Form"+"<br/>"
			+"1: click on Edit Button"+"<br/>"
					+"<b><font color='red'>Result: comment  field is Disabled" 
				+logger.addScreenCapture(captureScreenShot(driver, "comment")));
}



if (driver.findElement(admin.user_submit).isDisplayed() && driver.findElement(admin.user_submit).isEnabled()) {

	driver.findElement(admin.user_submit).click();

	helper.javaScriptHighlightWebElement(driver.findElement(admin.user_submit));
	
	logger.log(LogStatus.PASS,"<b>Case:</b>Verifying user_submit Field on BL Order Edit Form"+"<br/>"
			+"1: click on Edit Button"+"<br/>"
					+"<b><font color='green'>Result: user_submit  field is enabled" 
				+logger.addScreenCapture(captureScreenShot(driver, "user_submit")));

	helper.javaScriptUn_HighlightWebElement(driver.findElement(admin.user_submit));
	
}else {

	logger.log(LogStatus.FAIL,"<b>Case:</b>Verifying user_submit Field on BL Order Edit Form"+"<br/>"
			+"1: click on Edit Button"+"<br/>"
					+"<b><font color='red'>Result: user_submit  field is Disabled" 
				+logger.addScreenCapture(captureScreenShot(driver, "user_submit")));
}


helper.waitingForElementClikable(admin.BrandSuccessMessage);

	logger.log(LogStatus.PASS,"<b>Case:</b>Verifying success Message  on BL Order Edit Form"+"<br/>"
			+"1: click on Edit Button"+"<br/>"
					+"<b><font color='green'>Result: Success Message has been Verified" 
				+logger.addScreenCapture(captureScreenShot(driver, "user_successMessage")));
	 



driver.navigate().back();

	} catch (Exception e) {
	
		logger.log(LogStatus.FAIL,"<b><font color='red'>Result:getting Error While Verifying BL order Menu<font/>"+e.getMessage() 
		+logger.addScreenCapture(captureScreenShot(driver, "Admin Menu")));


	}
	
			}	

	}			
		

	