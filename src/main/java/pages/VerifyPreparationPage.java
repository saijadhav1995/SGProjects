package pages;



import org.testng.AssertJUnit;
import org.apache.xmlbeans.impl.xb.xsdschema.SelectorDocument.Selector.Xpath;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import com.relevantcodes.extentreports.LogStatus;

import Utility.AppstringsConstant;
import Utility.Helper;
import webBase.BaseTest;
import webBase.BasePage;
import webBase.BrowserFactory;
import webBase.Controller;
import webBase.ExcelConfig;
import webElements_Identifiers.Login_Identifiers;
import webElements_Identifiers.Preparation_Page_identifiers;

import com.relevantcodes.extentreports.ExtentTest;



public class VerifyPreparationPage extends BasePage   {
	
	
	
public ExtentTest logger;	
public Preparation_Page_identifiers prepare=new Preparation_Page_identifiers(driver);
public ExtentTest extentest;
public SoftAssert SAssert = new SoftAssert();
public PageFactory pf=new PageFactory();
BaseTest baseT = new BaseTest();
String className = "";
Helper helper=new Helper();
public static APICollection api=new APICollection();
public String loader="/html/body/div[3]";
static String GetQuantity="";

public AppstringsConstant appConst=new AppstringsConstant();



	

	public  void verifyPreparationPage(String TestName) throws Throwable {
		
	try {
		
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
	logger = baseT.extent.startTest(TestName);			
	prepare=	PageFactory.initElements(driver, Preparation_Page_identifiers.class);
	createDirectory("FACE"+TestName);

	
	String FACE= prepare.FACE_title.getText();
	
	System.out.println( FACE+" title");
	
	if (FACE.equals(appConst.FACE_title)) {
	
		helper.javaScriptHighlightWebElement(prepare.FACE_title);
		logger.log(LogStatus.PASS,"1:Open Preparation Page"+"<br/>"
				+"2: Actual FACE title is "+"<b>"+FACE+"</b>"+"<br/>"
				+"3: Expected FACE title is "+"<b>"+appConst.FACE_title+"</b>"+"<br/>"
				+"<b><font color='green'>Result:title has been matched <font/>"
 		+logger.addScreenCapture(captureScreenShot(driver, "FACETitle")));
		helper.javaScriptUn_HighlightWebElement(prepare.FACE_title);
		
		
	}else {
		

		helper.javaScriptHighlightWebElement(prepare.FACE_title);	
		logger.log(LogStatus.FAIL,"1:Open Preparation Page"+"<br/>"
				+"2: Actual FACE title is "+"<b>"+FACE+"</b>"+"<br/>"
				+"3: Expected FACE title is "+"<b>"+appConst.FACE_title+"</b>"+"<br/>"
				+"<b><font color='red'>Result:title has been Missmatched <font/>"
 		+logger.addScreenCapture(captureScreenShot(driver, "FACETitle")));
		helper.javaScriptUn_HighlightWebElement(prepare.FACE_title);
		
	}
	
	
 	int count= driver.findElements(By.xpath("//*[@id='list_order']/div/div/div/div/div/div/div[1]/h3")).size()+1;
	
 	int counter=1;
	 int arraycounter=0;

 	while(count>counter) {
 		
 		Thread.sleep(500);	
    WebElement TabsName =driver.findElement(By.xpath("//*[@id='list_order']/div/div/div["+counter+"]/div/div/div/div[1]/h3"));
	
 	
	 String castTabsName = (String) js.executeScript("return arguments[0].innerText;",TabsName);



	System.out.println(castTabsName);

	ArrayList<String> arrlist = new ArrayList<String>();
	 arrlist.add("En attente");
	 arrlist.add("En préparation");
	 arrlist.add("Prête");
	 

	while(arrlist.size()>arraycounter) {
			
	if(castTabsName.equalsIgnoreCase(arrlist.get(arraycounter))) {
		

		helper.javaScriptHighlightWebElement(TabsName);
		logger.log(LogStatus.PASS,"1:Tab name  is "+"<b>"+arrlist.get(arraycounter)+"</b>"+"<br/>"
				+"2:Actual Tab Name On App is "+"<b>"+castTabsName+"</b>"+"<br/>"
				+"<b><font color='green'>Result:Tab Name has been Matched <font/>"
				+logger.addScreenCapture(captureScreenShot(driver, "PreparationTab"+arraycounter)));
	
		helper.javaScriptUn_HighlightWebElement(TabsName);

		}else {
			
			helper.javaScriptHighlightWebElement(TabsName);
			logger.log(LogStatus.FAIL,"1:Tab name  is "+"<b>"+arrlist.get(arraycounter)+"</b>"+"<br/>"
					+"2:Actual Tab Name On App is "+"<b>"+castTabsName+"</b>"+"<br/>"
					+"<b><font color='red'>Result:Tab Name has been Matched <font/>"
					+logger.addScreenCapture(captureScreenShot(driver, "PreparationTab"+arraycounter)));
			helper.javaScriptUn_HighlightWebElement(TabsName);
			

		}
				break;
	
			}
	arraycounter=arraycounter+1;

 	counter=counter+1;
	
 		}
	
		} catch (Exception e) {
		
	System.out.println(e.getMessage());
	
	logger.log(LogStatus.FAIL,"<b><font color='red'>Result:getting Error while verifying Tab names <font/>"+e.getMessage()
			+logger.addScreenCapture(captureScreenShot(driver, "PreparationTab")));

	
		}
	
 	
	}	
	
	
public void verifyEnAttenteState() throws Throwable {
	
try {
	
	
	Thread.sleep(3000);
	
	//-------En Attente Tab----------------
 
	 logger.log(LogStatus.INFO,"<b><u><font color='blue'>Verifying En Attente State");

	JavascriptExecutor js=(JavascriptExecutor)driver;

	String Blnumber=api.BLNumber.replaceAll(" ", "");
	 
	 System.out.println(Blnumber+"TEST");
	 String mainBlnumber="//*[@id='list_order']/div/div/div/div/div/div/div[2]/div/div/div[1]/h4[contains(text(),'"+Blnumber+"')]";

	 System.out.println(mainBlnumber+"waiting");
	 
	 driver.findElement(By.xpath(mainBlnumber)).click();
	 
 driver.findElement(By.xpath("//*[@id='compose-modal']/div/div/div[2]/div[1]/ul/li[3]/a")).click();
 
 logger.log(LogStatus.PASS,"1:Order has been Created through Vega WebService  "+"<br/>"
			+"2:Order BL Number is"+"<b>"+Blnumber+"<b>"+"<br/>"
			 +"<b><font color='green'>Result:created Order SuccessFully Selected From En Attente State<font/>"
			+logger.addScreenCapture(captureScreenShot(driver, "En_attenteOrderCreated")));

 
 //-----Verify order others Details-------------------


 String En_attenteBlNumer= prepare.En_Attente_Tab_BlNumber.getText();
	
	System.out.println( En_attenteBlNumer+"En Attente Bl Number");
	
	if (En_attenteBlNumer.equals(Blnumber)) {
	
		helper.javaScriptHighlightWebElement(prepare.En_Attente_Tab_BlNumber);
		
		logger.log(LogStatus.PASS,"1:Verifying order Number on En attente Tab"+"<br/>"
				+"2: Actual BL Number is  "+"<b>"+Blnumber+"</b>"+"<br/>"
				+"3: Expected LB Number is  "+"<b>"+En_attenteBlNumer+"</b>"+"<br/>"
				+"<b><font color='green'>Result:Bl Number  has been matched <font/>"
		+logger.addScreenCapture(captureScreenShot(driver, "EnAttent_Tab_Blnumber")));
		helper.javaScriptUn_HighlightWebElement(prepare.En_Attente_Tab_BlNumber);
		
		
	}else {
		

		helper.javaScriptHighlightWebElement(prepare.En_Attente_Tab_BlNumber);
		logger.log(LogStatus.PASS,"1:Verifying order Number on En attente Tab"+"<br/>"
				+"2: Actual BL Number is  "+"<b>"+Blnumber+"</b>"+"<br/>"
				+"3: Expected LB Number is  "+"<b>"+En_attenteBlNumer+"</b>"+"<br/>"
				+"<b><font color='red'>Result:Bl Number is missmatched <font/>"
		+logger.addScreenCapture(captureScreenShot(driver, "EnAttent_Tab_Blnumber")));
		helper.javaScriptUn_HighlightWebElement(prepare.En_Attente_Tab_BlNumber);
	}
	
String getColor= prepare.En_Attente_Tab_Logo.getCssValue("background-color");

String convertColor= Color.fromString(getColor).asHex();
 
helper.javaScriptHighlightWebElement(prepare.En_Attente_Tab_Logo);

logger.log(LogStatus.PASS,"1:Verifying En Attente Tab logo"+"<br/>"
		+"2: fetching the background color of Logo and converted into Hex Code"+"<br/>"
		+"<b><font color='green'>Result:Color of En Attente Logo is :<font/>"+"<b>"+convertColor
+logger.addScreenCapture(captureScreenShot(driver, "EnAttent_Tab_Logo")));

helper.javaScriptUn_HighlightWebElement(prepare.En_Attente_Tab_Logo);

 
int count= driver.findElements(By.xpath("//*[@id='compose-modal']/div/div/div[1]/h3[2]/div/table/tbody/tr/td[2]/span")).size()+1;

	int counter=1;
 int arraycounter=0;

	while(count>counter) {
		
		Thread.sleep(500);	
WebElement Details =driver.findElement(By.xpath("//*[@id='compose-modal']/div/div/div[1]/h3[2]/div/table/tbody/tr["+counter+"]/td[2]/span"));

	
 String castDetails = (String) js.executeScript("return arguments[0].innerText;",Details);



System.out.println(castDetails);

ArrayList<String> arrlist = new ArrayList<String>();
 arrlist.add("Client Name");
 arrlist.add("Number of orders line are");
 arrlist.add("Date of Order	");
 

while(arrlist.size()>arraycounter) {
		
	

	helper.javaScriptHighlightWebElement(Details);
	logger.log(LogStatus.PASS,"1:"+arrlist.get(arraycounter)+"is: "+"<b>"+castDetails+"</b>"+"<br/>"
			+"<b><font color='green'>Result:Order Detail has been Displayed successfully<font/>"
			+logger.addScreenCapture(captureScreenShot(driver, "EnAttenteOtherDetails"+arraycounter)));
	
	helper.javaScriptUn_HighlightWebElement(Details);

			break;

		}
arraycounter=arraycounter+1;

	counter=counter+1;

		}



//-----------Verifying Tabs------------------------------------------------

	List<WebElement> ToggleButtons= driver.findElements(By.xpath(prepare.Article_toggle_buttonXpath));
 
	for (WebElement webElement : ToggleButtons) {
		
		 js.executeScript("arguments[0].click()",webElement );	
		
	}
	

	Thread.sleep(4000);
	
	 logger.log(LogStatus.PASS,"1:Article Tab has been selected From En Attente State"+"<br/>"
				 +"<b><font color='green'>Result:Articles Flags has been selected succefully<font/>"
				+logger.addScreenCapture(captureScreenShot(driver, "En_attente_Flages_verified")));

	
 List<WebElement> quantity=	driver.findElements(By.xpath(prepare.ArticleTab_get_QuantityXpath));
	
 List<WebElement>inputField=  driver.findElements(By.xpath(prepare.ArticleTab_input_FieldsXpath));
 

 List<String> list = new ArrayList();

 for (WebElement webElement : quantity) {
	

 GetQuantity=webElement.getText();
	 
  list.add(GetQuantity);
 }

 System.out.println(list);

 for (WebElement webElement : inputField) {
	

	 webElement.sendKeys("10");

WebElement element= driver.findElement(By.xpath("//*[@id='article_data']/table/tbody/tr[1]/td[3]")); 	 
Actions action=new Actions(driver);
action.moveToElement(element).click().perform();
	 	 	 
 }
 

 helper.waitingForLoaderDisappeared(loader);
 
 logger.log(LogStatus.PASS,"1:Article Tab has been selected From En Attente State"+"<br/>"
		+ "2:Article Total Quantity is "+"<b>"+list+"<br/>"
		 +"<b><font color='green'>Result:Articles Left Quantity successfully entered <font/>"
		+logger.addScreenCapture(captureScreenShot(driver, "En_attente_lefyQuantity_verified")));

 
 
Actions action=new Actions(driver);
action.moveToElement(prepare.summary_Tab).click().perform();
action.sendKeys(Keys.PAGE_DOWN).perform();
 
 Thread.sleep(3000);
 
 try {
	

 if (prepare.En_Attente_Fermer_Button.isDisplayed()) {
	
	 System.out.println("fermer button is dispayed");
	helper.javaScriptHighlightWebElement(prepare.En_Attente_Fermer_Button); 
	 logger.log(LogStatus.PASS,"1:Summary Tab has been selected From En Attente State"+"<br/>"
				 +"<b><font color='green'>Result:Fermer button is Displayed On Summary Tab <font/>"
				+logger.addScreenCapture(captureScreenShot(driver, "En_attente_SummaryTab_Fermer")));

		helper.javaScriptUn_HighlightWebElement(prepare.En_Attente_Fermer_Button);
}
 } catch (Exception fermerButton) {
		
	 logger.log(LogStatus.FAIL,"1:Summary Tab has been selected From En Attente State"+"<br/>"
			 +"<b><font color='red'>Result:Fermer button is Does not Displayed On Summary Tab <font/>"
			+logger.addScreenCapture(captureScreenShot(driver, "En_attente_SummaryTab_Fermer")));
 
	 
	}
	 

 try {
	

 
 if (prepare.En_Attnete_Order_Cancel_Button.isDisplayed()) {
	
	 System.out.println("cancenl order button is displayed");
		helper.javaScriptHighlightWebElement(prepare.En_Attnete_Order_Cancel_Button); 
	 logger.log(LogStatus.PASS,"1:Summary Tab has been selected From En Attente State"+"<br/>"
			 +"<b><font color='green'>Result:Order Cancel button is Displayed On Summary Tab <font/>"
			+logger.addScreenCapture(captureScreenShot(driver, "En_attente_SummaryTab_Cancel")));

		helper.javaScriptUn_HighlightWebElement(prepare.En_Attnete_Order_Cancel_Button);
		
} 
 } catch (Exception cancelButton) {

	 System.out.println("cancenl order button is displayed");
	 logger.log(LogStatus.FAIL,"1:Summary Tab has been selected From En Attente State"+"<br/>"
			 +"<b><font color='red'>Result:Order Cancel button is Does not Displayed On Summary Tab <font/>"
			+logger.addScreenCapture(captureScreenShot(driver, "En_attente_SummaryTab_Cancel")));

	}
 
action.moveToElement( prepare.Order_Assignment_Tab).click().perform();
 
helper.javaScriptHighlightWebElement(prepare.Order_Assignment_Tab); 
 
action.moveToElement( prepare.En_Attnete_Select_USer).click().perform();
 
helper.javaScriptHighlightWebElement( prepare.En_Attnete_Select_USer); 

prepare.En_Attnete_Enter_Comment.sendKeys(Keys.CONTROL+"a",Keys.BACK_SPACE);
prepare.En_Attnete_Enter_Comment.sendKeys("En Attente");
 
 helper.javaScriptHighlightWebElement( prepare.En_Attnete_Enter_Comment); 
 
 
 Select select=new Select(prepare.En_Attente_select_gate);
 
 select.selectByValue("1");
 helper.javaScriptHighlightWebElement( prepare.En_Attente_select_gate); 


 logger.log(LogStatus.PASS,"1:Assignment  Tab has been selected From En Attente State"+"<br/>"
		 +"2:User has been selected From Assigment Tab"+"<br/>"
		 +"3:Comment has been entered"+"<br/>"
		 +"4:Gate has been selected"+"<br/>"
		 +"<b><font color='green'>Result:Order is ready to move to Preparation State<font/>"
		+logger.addScreenCapture(captureScreenShot(driver, "En_attente_moveTo_Preparation")));

 
 
 prepare.En_Attente_PreparationButton.click();

	} catch (Exception e) {
	
		
		logger.log(LogStatus.FAIL,"<b><font color='red'>Result:getting Error While Verifying wating Tab content<font/>"+e.getMessage() 
				+logger.addScreenCapture(captureScreenShot(driver, "En_attente_SummaryTab_Cancel")));

		
}

 
}

//-----------preparation Tab-------------------

public void verifyPreparationState() throws Throwable { 
 

	
	logger.log(LogStatus.INFO,"<b><u><font color='blue'>Verifying preparation State");
	
	try {
		
	
	JavascriptExecutor js=(JavascriptExecutor)driver;

	String Blnumber=api.BLNumber.replaceAll(" ", "");
	 
	 System.out.println(Blnumber+"TEST");
	 String mainBlnumber="//*[@id='list_order']/div/div/div/div/div/div/div[2]/div/div/div[1]/h4[contains(text(),'"+Blnumber+"')]";

	 System.out.println(mainBlnumber+"preparation");
	 

	 helper.waitingForLoaderDisappeared(loader);
 
	 
	 
 WebElement clickOnOrder= driver.findElement(By.xpath(mainBlnumber));

 js.executeScript("arguments[0].click()",clickOnOrder );
  
 prepare.Preparation_Articles_Tab.click();

//-----Verify order others Details On Preparation State-------------------


String En_attenteBlNumer= prepare.Preparation_Tab_BlNumber.getText();
	
	System.out.println( En_attenteBlNumer+"En Attente Bl Number");
	
	if (En_attenteBlNumer.equals(Blnumber)) {
	
		helper.javaScriptHighlightWebElement(prepare.Preparation_Tab_BlNumber);
		
		logger.log(LogStatus.PASS,"1:Verifying order Number on En attente Tab"+"<br/>"
				+"2: Actual BL Number is  "+"<b>"+Blnumber+"</b>"+"<br/>"
				+"3: Expected LB Number is  "+"<b>"+En_attenteBlNumer+"</b>"+"<br/>"
				+"<b><font color='green'>Result:Bl Number  has been matched <font/>"
		+logger.addScreenCapture(captureScreenShot(driver, "Preparation_Tab_Blnumber")));
		helper.javaScriptUn_HighlightWebElement(prepare.Preparation_Tab_BlNumber);
		
		
	}else {
		

		helper.javaScriptHighlightWebElement(prepare.En_Attente_Tab_BlNumber);
		logger.log(LogStatus.PASS,"1:Verifying order Number on En attente Tab"+"<br/>"
				+"2: Actual BL Number is  "+"<b>"+Blnumber+"</b>"+"<br/>"
				+"3: Expected LB Number is  "+"<b>"+En_attenteBlNumer+"</b>"+"<br/>"
				+"<b><font color='red'>Result:Bl Number is missmatched <font/>"
		+logger.addScreenCapture(captureScreenShot(driver, "EnAttent_Tab_Blnumber")));
		helper.javaScriptUn_HighlightWebElement(prepare.En_Attente_Tab_BlNumber);
	}
	
String getColor= prepare.Preparation_Tab_Logo.getCssValue("background-color");

String convertColor= Color.fromString(getColor).asHex();

helper.javaScriptHighlightWebElement(prepare.Preparation_Tab_Logo);

logger.log(LogStatus.PASS,"1:Verifying En Attente Tab logo"+"<br/>"
		+"2: fetching the background color of Logo and converted into Hex Code"+"<br/>"
		+"<b><font color='green'>Result:Color of En Attente Logo is :<font/>"+"<b>"+convertColor
+logger.addScreenCapture(captureScreenShot(driver, "preparationTab_Logo")));

helper.javaScriptUn_HighlightWebElement(prepare.Preparation_Tab_Logo);


int count= driver.findElements(By.xpath("//*[@id='compose-modal2']/div/div/div[1]/h4/div/table/tbody/tr/td[2]")).size()+1;

	int counter=1;
int arraycounter=0;

	while(count>counter) {
		
		Thread.sleep(500);	
WebElement Details =driver.findElement(By.xpath("//*[@id='compose-modal2']/div/div/div[1]/h4/div/table/tbody/tr["+counter+"]/td[2]/span"));

	
String castDetails = (String) js.executeScript("return arguments[0].innerText;",Details);



System.out.println(castDetails);

ArrayList<String> arrlist = new ArrayList<String>();
arrlist.add("Client Name");
arrlist.add("Number of orders line are");
arrlist.add("Date of Order	");


while(arrlist.size()>arraycounter) {
		
	

	helper.javaScriptHighlightWebElement(Details);
	logger.log(LogStatus.PASS,"1:"+arrlist.get(arraycounter)+"is: "+"<b>"+castDetails+"</b>"+"<br/>"
			+"<b><font color='green'>Result:Order Detail has been Displayed successfully<font/>"
			+logger.addScreenCapture(captureScreenShot(driver, "PreparationOthersDetails"+arraycounter)));
	
	helper.javaScriptUn_HighlightWebElement(Details);

			break;

		}
arraycounter=arraycounter+1;

	counter=counter+1;

		}


 //--------------Verify Tabs--------------------
 
	List<WebElement> preparationToggleButton= driver.findElements(By.xpath(prepare.Preparation_Article_toggle_buttonXpath));

	for (WebElement webElement1 : preparationToggleButton) {
		
		 js.executeScript("arguments[0].click()",webElement1 );	
		
	}
	

	Thread.sleep(4000);
	
	 logger.log(LogStatus.PASS,"1:Order has been Selected From Preparation State"+"<br/>"
				+"2:Order BL Number is"+"<b>"+Blnumber+"<b>"+"<br/>"
				+"3:Article Tab has been selected From Preparation State"+"<br/>"
				 +"<b><font color='green'>Result:Articles Flags has been selected successfully<font/>"
				+logger.addScreenCapture(captureScreenShot(driver, "PreparationState_FlagsChecked")));

	
List<WebElement> preparation_Article_Get_Quantity=	driver.findElements(By.xpath(prepare.Preparation_ArticleTab_get_QuantityXpath));
	
List<WebElement>preparation_Article_inputField=  driver.findElements(By.xpath(prepare.Preparation_ArticleTab_input_FieldsXpath));


List<String> list = new ArrayList();

for (WebElement webElement : preparation_Article_Get_Quantity) {
	
	 System.out.println(webElement.getText());

list.add(webElement.getText());

}

for (WebElement webElement : preparation_Article_inputField) {
	
	
	 webElement.sendKeys(Keys.CONTROL+"a"+Keys.BACK_SPACE);
	 webElement.sendKeys("10");
	 
	 Actions action =new Actions(driver);
	 WebElement element1= driver.findElement(By.xpath("//*[@id='pre_tab_3']/div/table/tbody/tr[1]/td[3]")); 	 
	 action.moveToElement(element1).click().perform();

	 
	 
}

helper.waitingForLoaderDisappeared(loader);


logger.log(LogStatus.PASS,"1:Article Tab has been selected From Preparatiom State"+"<br/>"
		+ "2:Article Total Quantity is "+"<b>"+list+"<br/>"
		 +"<b><font color='green'>Result:Articles Left Quantity successfully entered <font/>"
		+logger.addScreenCapture(captureScreenShot(driver, "Preparation_left_Quantity_verified")));

prepare.Preparation_summary_Tab.click();

Thread.sleep(3000);

try {
	
if (prepare.preparation_Fermer_Button.isDisplayed()) {
	
	 System.out.println("fermer button is dispayed");
	 helper.javaScriptHighlightWebElement(prepare.preparation_Fermer_Button);

	 logger.log(LogStatus.PASS,"1:Summary Tab has been selected From Preparation State"+"<br/>"
			 +"<b><font color='green'>Result:Fermer button is Displayed On Summary Tab <font/>"
			+logger.addScreenCapture(captureScreenShot(driver, "Preparation_SummaryTab_Fermer")));

	 helper.javaScriptUn_HighlightWebElement(prepare.preparation_Fermer_Button);

	}
} catch (Exception fermerButton) {
	
 logger.log(LogStatus.FAIL,"1:Summary Tab has been selected From Preparation State"+"<br/>"
		 +"<b><font color='red'>Result:Fermer button is Does not Displayed On Summary Tab <font/>"
		+logger.addScreenCapture(captureScreenShot(driver, "PrerationTab_Fermer")));

}

try {
	
if (prepare.preparation_Order_Cancel_Button.isDisplayed()) {
	
System.out.println("cancenl order button is displayed");
helper.javaScriptHighlightWebElement(prepare.preparation_Order_Cancel_Button);

logger.log(LogStatus.PASS,"1:Summary Tab has been selected From Preparation State"+"<br/>"
		 +"<b><font color='green'>Result:Order Cancel button is Displayed On Summary Tab <font/>"
		+logger.addScreenCapture(captureScreenShot(driver, "Preparation_Cancel")));

helper.javaScriptUn_HighlightWebElement(prepare.preparation_Order_Cancel_Button);

	} 
} catch (Exception cancelButton) {

System.out.println("cancenl order button is displayed");
logger.log(LogStatus.FAIL,"1:Summary Tab has been selected From Preparation State"+"<br/>"
		 +"<b><font color='red'>Result:Order Cancel button is Does not Displayed On Summary Tab <font/>"
		+logger.addScreenCapture(captureScreenShot(driver, "Preparation_Cancel")));


} 



prepare.preparation_Assignment_Tab.click();

helper.javaScriptHighlightWebElement(prepare.preparation_Assignment_Tab);

prepare.Preparation_Select_USer.click();
helper.javaScriptHighlightWebElement(prepare.Preparation_Select_USer);

prepare.Preparation_Enter_Comment.sendKeys(Keys.CONTROL+"a",Keys.BACK_SPACE);
prepare.Preparation_Enter_Comment.sendKeys("test Preparation");
helper.javaScriptHighlightWebElement(prepare.Preparation_Enter_Comment);


Select select1=new Select(prepare.Preparation_select_gate);
helper.javaScriptHighlightWebElement(prepare.Preparation_select_gate);

select1.selectByValue("1");

logger.log(LogStatus.PASS,"1:Assignment  Tab has been selected From Preparation State"+"<br/>"
		 +"2:User has been selected From Assigment Tab"+"<br/>"
		 +"3:Comment has been entered"+"<br/>"
		 +"4:Gate has been selected"+"<br/>"
		 +"<b><font color='green'>Result:Order is ready to move to Prete State<font/>"
		+logger.addScreenCapture(captureScreenShot(driver, "Preparation_moveTo_Prete")));

prepare.Preparation_Prete_State_Button.click();

	} catch (Exception e) {
		logger.log(LogStatus.FAIL,"<b><font color='red'>Result:getting Error While Verifying preparation Tab content<font/>"+e.getMessage() 
		+logger.addScreenCapture(captureScreenShot(driver, "En_attente_SummaryTab_Cancel")));

	}


}

//---------Prete----------------------

public void verifyPreteState() throws Throwable { 
	
	logger.log(LogStatus.INFO,"<b><u><font color='blue'>Verifying Prete State");

	try {
		
	JavascriptExecutor js=(JavascriptExecutor)driver;

	String Blnumber=api.BLNumber.replaceAll(" ", "");
	 
	 System.out.println(Blnumber+"TEST");
	 String mainBlnumber="//*[@id='list_order']/div/div/div/div/div/div/div[2]/div/div/div[1]/h4[contains(text(),'"+Blnumber+"')]";

	 System.out.println(mainBlnumber+"prete");
	 


helper.waitingForLoaderDisappeared(loader);


WebElement clickOnOrder= driver.findElement(By.xpath(mainBlnumber));

js.executeScript("arguments[0].click()",clickOnOrder );


prepare.Prete__Articles_Tab.click();

//-------Verify others Details---------------------------

String En_attenteBlNumer= prepare.Prete_Tab_BlNumber.getText();

System.out.println( En_attenteBlNumer+"En Attente Bl Number");

if (En_attenteBlNumer.equals(Blnumber)) {

	helper.javaScriptHighlightWebElement(prepare.Prete_Tab_BlNumber);
	
	logger.log(LogStatus.PASS,"1:Verifying order Number on Prete Tab"+"<br/>"
			+"2: Actual BL Number is  "+"<b>"+Blnumber+"</b>"+"<br/>"
			+"3: Expected LB Number is  "+"<b>"+En_attenteBlNumer+"</b>"+"<br/>"
			+"<b><font color='green'>Result:Bl Number  has been matched <font/>"
	+logger.addScreenCapture(captureScreenShot(driver, "PreteTab_BlNumber")));
	helper.javaScriptUn_HighlightWebElement(prepare.Prete_Tab_BlNumber);
	
	
}else {
	

	logger.log(LogStatus.PASS,"1:Verifying order Number on Prete Tab"+"<br/>"
			+"2: Actual BL Number is  "+"<b>"+Blnumber+"</b>"+"<br/>"
			+"3: Expected LB Number is  "+"<b>"+En_attenteBlNumer+"</b>"+"<br/>"
			+"<b><font color='red'>Result:Bl Number is missmatched <font/>"
	+logger.addScreenCapture(captureScreenShot(driver, "PreteTab_BlNumber")));
}

String getColor= prepare.Prete_Tab_Logo.getCssValue("background-color");

String convertColor= Color.fromString(getColor).asHex();

helper.javaScriptHighlightWebElement(prepare.Prete_Tab_Logo);

logger.log(LogStatus.PASS,"1:Verifying En Attente Tab logo"+"<br/>"
	+"2: fetching the background color of Logo and converted into Hex Code"+"<br/>"
	+"<b><font color='green'>Result:Color of Prete tab Logo is :<font/>"+"<b>"+convertColor
+logger.addScreenCapture(captureScreenShot(driver, "Prete_Logo")));

helper.javaScriptUn_HighlightWebElement(prepare.Prete_Tab_Logo);


int count= driver.findElements(By.xpath("//*[@id='compose-modal3']/div/div/div[1]/h4/div/table/tbody/tr/td[2]")).size()+1;

int counter=1;
int arraycounter=0;

while(count>counter) {
	
	Thread.sleep(500);	
WebElement Details =driver.findElement(By.xpath("//*[@id='compose-modal3']/div/div/div[1]/h4/div/table/tbody/tr["+counter+"]/td[2]/span"));


String castDetails = (String) js.executeScript("return arguments[0].innerText;",Details);



System.out.println(castDetails);

ArrayList<String> arrlist = new ArrayList<String>();
arrlist.add("Client Name");
arrlist.add("Number of orders line are");
arrlist.add("Date of Order	");


while(arrlist.size()>arraycounter) {
	


helper.javaScriptHighlightWebElement(Details);
logger.log(LogStatus.PASS,"1:"+arrlist.get(arraycounter)+"is: "+"<b>"+castDetails+"</b>"+"<br/>"
		+"<b><font color='green'>Result:Order Detail has been Displayed successfully<font/>"
		+logger.addScreenCapture(captureScreenShot(driver, "PreteOthersDetails"+arraycounter)));

helper.javaScriptUn_HighlightWebElement(Details);

		break;

	}
arraycounter=arraycounter+1;

counter=counter+1;

	}


//--------------Verify Tabs--------------------



	List<WebElement> PreteToggleButton= driver.findElements(By.xpath(prepare.Prete_Article_toggle_buttonXpath));

	for (WebElement webElement : PreteToggleButton) {
		
		
		 js.executeScript("arguments[0].click()",webElement );	

	}
	
	 	
	Thread.sleep(4000);
	
	logger.log(LogStatus.PASS,"1:Order has been Selected From Prete State"+"<br/>"
			+"2:Order BL Number is"+"<b>"+Blnumber+"<b>"+"<br/>"
			+"3:Article Tab has been selected From Prete State"+"<br/>"
			 +"<b><font color='green'>Result:Articles Flags has been selected successfully<font/>"
			+logger.addScreenCapture(captureScreenShot(driver, "PreteState_FlagsChecked")));


List<WebElement> Prete_Article_get_Quantity=	driver.findElements(By.xpath(prepare.Prete_ArticleTab_get_QuantityXpath));
	
List<WebElement>Prete_Article_inputField=  driver.findElements(By.xpath(prepare.Prete_ArticleTab_input_FieldsXpath));

List<String> list = new ArrayList();


for (WebElement webElement : Prete_Article_get_Quantity) {
	
	 System.out.println(webElement.getText());

list.add(webElement.getText());
}

for (WebElement webElement : Prete_Article_inputField) {
	
	
	 webElement.sendKeys(Keys.CONTROL+"a"+Keys.BACK_SPACE);
	 webElement.sendKeys("10");
	 
	 Actions action=new Actions(driver);
	 WebElement element1= driver.findElement(By.xpath("//*[@id='done_tab_3']/div/table/tbody/tr[1]/td[3]")); 	 
	 action.moveToElement(element1).click().perform();	 
}

helper.waitingForLoaderDisappeared(loader);

logger.log(LogStatus.PASS,"1:Article Tab has been selected From Prete State"+"<br/>"
		+ "2:Article Total Quantity is "+"<b>"+list+"<br/>"
		 +"<b><font color='green'>Result:Articles Left Quantity successfully entered <font/>"
		+logger.addScreenCapture(captureScreenShot(driver, "Prete_left_Quantity_verified")));


prepare.Prete__summary_Tab.click();

Thread.sleep(3000);

try {
	
if (prepare.Prete_Fermer_Button.isDisplayed()) {
	
	 System.out.println("fermer button is dispayed");
	 helper.javaScriptHighlightWebElement(prepare.Prete_Fermer_Button);

	 logger.log(LogStatus.PASS,"1:Summary Tab has been selected From Prete State"+"<br/>"
			 +"<b><font color='green'>Result:Fermer button is Displayed On Summary Tab <font/>"
			+logger.addScreenCapture(captureScreenShot(driver, "Prete_SummaryTab_Fermer")));

	 helper.javaScriptUn_HighlightWebElement(prepare.Prete_Fermer_Button);

	}
} catch (Exception fermerButton) {
	
 logger.log(LogStatus.FAIL,"1:Summary Tab has been selected From Prete State"+"<br/>"
		 +"<b><font color='red'>Result:Fermer button is Does not Displayed On Summary Tab <font/>"
		+logger.addScreenCapture(captureScreenShot(driver, "Prete_SummaryTab_Fermer")));

}

try {
	
if (prepare.Prete_Order_Cancel_Button.isDisplayed()) {
	
	 System.out.println("cancenl order button is displayed");
	 logger.log(LogStatus.PASS,"1:Summary Tab has been selected From Prete State"+"<br/>"
			 +"<b><font color='green'>Result:Order Cancel button is Displayed On Summary Tab <font/>"
			+logger.addScreenCapture(captureScreenShot(driver, "Prete_SummaryTab_Cancel")));

	} 
	 } catch (Exception cancelButton) {

	 System.out.println("cancenl order button is displayed");
	 logger.log(LogStatus.FAIL,"1:Summary Tab has been selected From Prete State"+"<br/>"
			 +"<b><font color='red'>Result:Order Cancel button is Does not Displayed On Summary Tab <font/>"
			+logger.addScreenCapture(captureScreenShot(driver, "Prete_SummaryTab_Cancel")));

	}


prepare.Prete_Assignment_Tab.click();
helper.javaScriptHighlightWebElement(prepare.Prete_Assignment_Tab);

prepare.Prete_Select_USer.click();
helper.javaScriptHighlightWebElement(prepare.Prete_Select_USer);

prepare.Prete_Enter_Comment.sendKeys(Keys.CONTROL+"a",Keys.BACK_SPACE);
prepare.Prete_Enter_Comment.sendKeys("test Prete");
helper.javaScriptHighlightWebElement(prepare.Prete_Enter_Comment);


Select select2=new Select(prepare.Prete_select_gate);
helper.javaScriptHighlightWebElement(prepare.Prete_Enter_Comment);

select2.selectByValue("1");


logger.log(LogStatus.PASS,"1:Assignment  Tab has been selected From Prete State"+"<br/>"
		 +"2:User has been selected From Assigment Tab"+"<br/>"
		 +"3:Comment has been entered"+"<br/>"
		 +"4:Gate has been selected"+"<br/>"
		 +"<b><font color='green'>Result:Order is ready to move to Reste Prende State<font/>"
		+logger.addScreenCapture(captureScreenShot(driver, "Prete_moveTo_RestePrende")));


prepare.Reste_Prende_State_Button_in_PreteTab.click();

	} catch (Exception e) {
		logger.log(LogStatus.FAIL,"<b><font color='red'>Result:getting Error While Verifying prete Tab content<font/>"+e.getMessage() 
		+logger.addScreenCapture(captureScreenShot(driver, "En_attente_SummaryTab_Cancel")));

	}


 
}

//-----------Reste Prende-----------------------

public void verifyRestePrendeState() throws Throwable { 
	 
	logger.log(LogStatus.INFO,"<b><u><font color='blue'>Verifying Reste Prende State");

	try {
		
	
	JavascriptExecutor js=(JavascriptExecutor)driver;

	String Blnumber=api.BLNumber.replaceAll(" ", "");
	 
	 System.out.println(Blnumber+"TEST");
	 String mainBlnumber="//*[@id='list_order']/div/div/div/div/div/div/div[2]/div/div/div[1]/h4[contains(text(),'"+Blnumber+"')]";

	 System.out.println(mainBlnumber+"prete");
	 


helper.waitingForLoaderDisappeared(loader);


WebElement clickOnOrder= driver.findElement(By.xpath(mainBlnumber));

js.executeScript("arguments[0].click()",clickOnOrder );


prepare.Reste_Prende_Articles_Tab.click();
	
//-------Verify others Details---------------------------

String En_attenteBlNumer= prepare.RestePrende_Tab_BlNumber.getText();

System.out.println( En_attenteBlNumer+"En Attente Bl Number");

if (En_attenteBlNumer.equals(Blnumber)) {

	helper.javaScriptHighlightWebElement(prepare.RestePrende_Tab_BlNumber);
	
	logger.log(LogStatus.PASS,"1:Verifying order Number on RestePrende Tab"+"<br/>"
			+"2: Actual BL Number is  "+"<b>"+Blnumber+"</b>"+"<br/>"
			+"3: Expected LB Number is  "+"<b>"+En_attenteBlNumer+"</b>"+"<br/>"
			+"<b><font color='green'>Result:Bl Number  has been matched <font/>"
	+logger.addScreenCapture(captureScreenShot(driver, "RestePrende_Tab_BlNumber")));
	helper.javaScriptUn_HighlightWebElement(prepare.RestePrende_Tab_BlNumber);
	
	
}else {
	

	logger.log(LogStatus.PASS,"1:Verifying order Number on RestePrende Tab"+"<br/>"
			+"2: Actual BL Number is  "+"<b>"+Blnumber+"</b>"+"<br/>"
			+"3: Expected LB Number is  "+"<b>"+En_attenteBlNumer+"</b>"+"<br/>"
			+"<b><font color='red'>Result:Bl Number is missmatched <font/>"
	+logger.addScreenCapture(captureScreenShot(driver, "RestePrende_Tab_BlNumber")));
}

String getColor= prepare.RestePrende_Tab_Logo.getCssValue("background-color");

String convertColor= Color.fromString(getColor).asHex();

helper.javaScriptHighlightWebElement(prepare.RestePrende_Tab_Logo);

logger.log(LogStatus.PASS,"1:Verifying En Attente Tab logo"+"<br/>"
	+"2: fetching the background color of Logo and converted into Hex Code"+"<br/>"
	+"<b><font color='green'>Result:Color of Prete tab Logo is :<font/>"+"<b>"+convertColor
+logger.addScreenCapture(captureScreenShot(driver, "Prete_Logo")));

helper.javaScriptUn_HighlightWebElement(prepare.RestePrende_Tab_Logo);


int count= driver.findElements(By.xpath("//*[@id='compose-modal6']/div/div/div[1]/h4/div/table/tbody/tr/td[2]")).size()+1;

int counter=1;
int arraycounter=0;

while(count>counter) {
	
	Thread.sleep(500);	
WebElement Details =driver.findElement(By.xpath("//*[@id='compose-modal6']/div/div/div[1]/h4/div/table/tbody/tr["+counter+"]/td[2]/span"));


String castDetails = (String) js.executeScript("return arguments[0].innerText;",Details);



System.out.println(castDetails);

ArrayList<String> arrlist = new ArrayList<String>();
arrlist.add("Client Name");
arrlist.add("Number of orders line are");
arrlist.add("Date of Order	");


while(arrlist.size()>arraycounter) {
	


helper.javaScriptHighlightWebElement(Details);
logger.log(LogStatus.PASS,"1:"+arrlist.get(arraycounter)+"is: "+"<b>"+castDetails+"</b>"+"<br/>"
		+"<b><font color='green'>Result:Order Detail has been Displayed successfully<font/>"
		+logger.addScreenCapture(captureScreenShot(driver, "RestePrende_OtherDetails"+arraycounter)));

helper.javaScriptUn_HighlightWebElement(Details);

		break;

	}
arraycounter=arraycounter+1;

counter=counter+1;

	}


//--------------Verify Tabs--------------------

List<WebElement> PreteToggleButton= driver.findElements(By.xpath(prepare.Reste_Prende_toggle_buttonXpath));

	for (WebElement webElement : PreteToggleButton) {
		
		
		 js.executeScript("arguments[0].click()",webElement );	

	}
	

	Thread.sleep(4000);
	
	logger.log(LogStatus.PASS,"1:Order has been Selected From Reste Prende State"+"<br/>"
			+"2:Order BL Number is"+"<b>"+Blnumber+"<b>"+"<br/>"
			+"3:Article Tab has been selected From Reste Prende State"+"<br/>"
			 +"<b><font color='green'>Result:Articles Flags has been selected successfully<font/>"
			+logger.addScreenCapture(captureScreenShot(driver, "RestePrendeState_FlagsChecked")));
	
List<WebElement> Prete_Article_get_Quantity=	driver.findElements(By.xpath(prepare.Reste_Prende_Tab_get_QuantityXpath));
	
List<WebElement>Prete_Article_inputField=  driver.findElements(By.xpath(prepare.Reste_Prende_Tab_input_FieldsXpath));


List<String> list = new ArrayList();

for (WebElement webElement : Prete_Article_get_Quantity) {
	
	 System.out.println(webElement.getText());

		list.add(webElement.getText());

}

for (WebElement webElement : Prete_Article_inputField) {
	
	
	 webElement.sendKeys(Keys.CONTROL+"a"+Keys.BACK_SPACE);
	 webElement.sendKeys("10");
	 
	 Actions action=new Actions(driver);
	 WebElement element1= driver.findElement(By.xpath("//*[@id='left_tab_3']/div/table/tbody/tr[1]/td[3]")); 	 
	 action.moveToElement(element1).click().perform();	 
}

helper.waitingForLoaderDisappeared(loader);

logger.log(LogStatus.PASS,"1:Article Tab has been selected From Reste Prende State"+"<br/>"
		+ "2:Article Total Quantity is "+"<b>"+list+"<br/>"
		 +"<b><font color='green'>Result:Articles Left Quantity successfully entered <font/>"
		+logger.addScreenCapture(captureScreenShot(driver, "RestePrende_Quantity_verified")));


prepare.Reste_Prende_summary_Tab.click();

Thread.sleep(3000);

try {
	
if (prepare.Reste_Prende_Fermer_Button.isDisplayed()) {
	
	 System.out.println("fermer button is dispayed");
	 helper.javaScriptHighlightWebElement(prepare.Reste_Prende_Fermer_Button);

	 logger.log(LogStatus.PASS,"1:Summary Tab has been selected From Reste Prende State"+"<br/>"
			 +"<b><font color='green'>Result:Fermer button is Displayed On Summary Tab <font/>"
			+logger.addScreenCapture(captureScreenShot(driver, "Reste Prende_SummaryTab_Fermer")));

	 helper.javaScriptUn_HighlightWebElement(prepare.Reste_Prende_Fermer_Button);

}
} catch (Exception fermerButton) {
	
 logger.log(LogStatus.FAIL,"1:Summary Tab has been selected From Reste Prende State"+"<br/>"
		 +"<b><font color='red'>Result:Fermer button is Does not Displayed On Summary Tab <font/>"
		+logger.addScreenCapture(captureScreenShot(driver, "Reste PrendeSummaryTab_Fermer")));


}

try {
	

if (prepare.Reste_Prende__Cancel_Button.isDisplayed()) {
	
	 System.out.println("cancenl order button is displayed");
	 helper.javaScriptHighlightWebElement(prepare.Reste_Prende__Cancel_Button);

	 logger.log(LogStatus.PASS,"1:Summary Tab has been selected From Reste Prende State"+"<br/>"
			 +"<b><font color='green'>Result:Order Cancel button is Displayed On Summary Tab <font/>"
			+logger.addScreenCapture(captureScreenShot(driver, "Reste Prende_SummaryTab_Cancel")));

	 helper.javaScriptUn_HighlightWebElement(prepare.Reste_Prende__Cancel_Button);

	} 
	 } catch (Exception cancelButton) {

	 System.out.println("cancenl order button is displayed");
	 logger.log(LogStatus.FAIL,"1:Summary Tab has been selected From Reste Prende State"+"<br/>"
			 +"<b><font color='red'>Result:Order Cancel button is Does not Displayed On Summary Tab <font/>"
			+logger.addScreenCapture(captureScreenShot(driver, "Reste Prende_SummaryTab_Cancel")));

} 

prepare.Reste_Prende_Assignment_Tab.click();

helper.javaScriptHighlightWebElement(prepare.Reste_Prende_Assignment_Tab);

prepare.Reste_Prende_USer.click();
helper.javaScriptHighlightWebElement(prepare.Reste_Prende_USer);


prepare.Reste_Prende_Comment.sendKeys(Keys.CONTROL+"a",Keys.BACK_SPACE);
prepare.Reste_Prende_Comment.sendKeys("Reste Prende");
helper.javaScriptHighlightWebElement(prepare.Reste_Prende_Comment);


Select select2=new Select(prepare.Reste_Prende_select_gate);
helper.javaScriptHighlightWebElement(prepare.Reste_Prende_select_gate);

select2.selectByValue("2");

logger.log(LogStatus.PASS,"1:Assignment  Tab has been selected From Reste Prende State"+"<br/>"
		 +"2:User has been selected From Assigment Tab"+"<br/>"
		 +"3:Comment has been entered"+"<br/>"
		 +"4:Gate has been selected"+"<br/>"
		 +"<b><font color='green'>Result:Order is ready to move to Prete State<font/>"
		+logger.addScreenCapture(captureScreenShot(driver, "Reste Prende_moveTo_Prete")));

prepare.Reste_Prende_Prete_State_button.click();


//-------again go to the prete state---------------

helper.waitingForLoaderDisappeared(loader);


WebElement clickOnOrder1= driver.findElement(By.xpath(mainBlnumber));

js.executeScript("arguments[0].click()",clickOnOrder1 );

Thread.sleep(4000);
logger.log(LogStatus.PASS,"<b><font color='green'>Result:Order has been move from prete To Client Absent State<font/>"
		+logger.addScreenCapture(captureScreenShot(driver, "Reste Prende_moveTo_ClientAbsent")));
prepare.Prete_Assignment_Tab.click();
prepare.ClientAbsent_State_Button.click();

	} catch (Exception e) {
		logger.log(LogStatus.FAIL,"<b><font color='red'>Result:getting Error While Verifying Reste prende Tab content<font/>"+e.getMessage() 
		+logger.addScreenCapture(captureScreenShot(driver, "En_attente_SummaryTab_Cancel")));
	}


}


//---------Client Absent----------------------

public void verifyClientAbsentState() throws Throwable { 

	logger.log(LogStatus.INFO,"<b><u><font color='blue'>Verifying Client Absent State");
 
	try {
		
	
	JavascriptExecutor js=(JavascriptExecutor)driver;

	String Blnumber=api.BLNumber.replaceAll(" ", "");
	 
	 System.out.println(Blnumber+"TEST");
	 String mainBlnumber="//*[@id='list_order']/div/div/div/div/div/div/div[2]/div/div/div[1]/h4[contains(text(),'"+Blnumber+"')]";

	 System.out.println(mainBlnumber+"prete");
	 


helper.waitingForLoaderDisappeared(loader);


WebElement clickOnOrder= driver.findElement(By.xpath(mainBlnumber));

js.executeScript("arguments[0].click()",clickOnOrder );


prepare.Client_absent_Articles_Tab.click();
	

//-------Verify others Details---------------------------

String En_attenteBlNumer= prepare.ClientAbsent_Tab_BlNumber.getText();

System.out.println( En_attenteBlNumer+"En Attente Bl Number");

if (En_attenteBlNumer.equals(Blnumber)) {

	helper.javaScriptHighlightWebElement(prepare.ClientAbsent_Tab_BlNumber);
	
	logger.log(LogStatus.PASS,"1:Verifying order Number on ClientAbsent  Tab"+"<br/>"
			+"2: Actual BL Number is  "+"<b>"+Blnumber+"</b>"+"<br/>"
			+"3: Expected LB Number is  "+"<b>"+En_attenteBlNumer+"</b>"+"<br/>"
			+"<b><font color='green'>Result:Bl Number  has been matched <font/>"
	+logger.addScreenCapture(captureScreenShot(driver, "ClientAbsent_Tab_BlNumber")));
	helper.javaScriptUn_HighlightWebElement(prepare.ClientAbsent_Tab_BlNumber);
	
	
}else {
	

	logger.log(LogStatus.PASS,"1:Verifying order Number on ClientAbsent Tab"+"<br/>"
			+"2: Actual BL Number is  "+"<b>"+Blnumber+"</b>"+"<br/>"
			+"3: Expected LB Number is  "+"<b>"+En_attenteBlNumer+"</b>"+"<br/>"
			+"<b><font color='red'>Result:Bl Number is missmatched <font/>"
	+logger.addScreenCapture(captureScreenShot(driver, "ClientAbsentBlNumber")));
}

String getColor= prepare.ClientAbsent_Tab_Logo.getCssValue("background-color");

String convertColor= Color.fromString(getColor).asHex();

helper.javaScriptHighlightWebElement(prepare.ClientAbsent_Tab_Logo);

logger.log(LogStatus.PASS,"1:Verifying En Attente Tab logo"+"<br/>"
	+"2: fetching the background color of Logo and converted into Hex Code"+"<br/>"
	+"<b><font color='green'>Result:Color of ClientAbsent_Tab_Logo  is :<font/>"+"<b>"+convertColor
+logger.addScreenCapture(captureScreenShot(driver, "ClientAbsent_Tab_Logo")));

helper.javaScriptUn_HighlightWebElement(prepare.ClientAbsent_Tab_Logo);


int count= driver.findElements(By.xpath("//*[@id='compose-modal5']/div/div/div[1]/h4/div/table/tbody/tr/td[2]")).size()+1;

int counter=1;
int arraycounter=0;

while(count>counter) {
	
	Thread.sleep(500);	
WebElement Details =driver.findElement(By.xpath("//*[@id='compose-modal5']/div/div/div[1]/h4/div/table/tbody/tr["+counter+"]/td[2]/span"));


String castDetails = (String) js.executeScript("return arguments[0].innerText;",Details);



System.out.println(castDetails);

ArrayList<String> arrlist = new ArrayList<String>();
arrlist.add("Client Name");
arrlist.add("Number of orders line are");
arrlist.add("Date of Order	");


while(arrlist.size()>arraycounter) {
	


helper.javaScriptHighlightWebElement(Details);
logger.log(LogStatus.PASS,"1:"+arrlist.get(arraycounter)+"is: "+"<b>"+castDetails+"</b>"+"<br/>"
		+"<b><font color='green'>Result:Order Detail has been Displayed successfully<font/>"
		+logger.addScreenCapture(captureScreenShot(driver, "ClientAbsent_otherDetails"+arraycounter)));

helper.javaScriptUn_HighlightWebElement(Details);

		break;

	}
arraycounter=arraycounter+1;

counter=counter+1;

	}


//--------------Verify Tabs--------------------


List<WebElement> PreteToggleButton= driver.findElements(By.xpath(prepare.Client_absent_toggle_buttonXpath));

	for (WebElement webElement : PreteToggleButton) {
		
		
		 js.executeScript("arguments[0].click()",webElement );	

	}
	

	Thread.sleep(4000);
	
	logger.log(LogStatus.PASS,"1:Order has been Selected From Client Absent State"+"<br/>"
			+"2:Order BL Number is"+"<b>"+Blnumber+"<b>"+"<br/>"
			+"3:Article Tab has been selected From Client Absent State"+"<br/>"
			 +"<b><font color='green'>Result:Articles Flags has been selected successfully<font/>"
			+logger.addScreenCapture(captureScreenShot(driver, "ClientAbsentState_FlagsChecked")));
	
List<WebElement> Prete_Article_get_Quantity=	driver.findElements(By.xpath(prepare.Client_absent_Tab_get_QuantityXpath));
	
List<WebElement>Prete_Article_inputField=  driver.findElements(By.xpath(prepare.Client_absent_Tab_input_FieldsXpath));


List<String> list = new ArrayList();

for (WebElement webElement : Prete_Article_get_Quantity) {
	
	 System.out.println(webElement.getText());
	 list.add(webElement.getText());

}

for (WebElement webElement : Prete_Article_inputField) {
	
	
	 webElement.sendKeys(Keys.CONTROL+"a"+Keys.BACK_SPACE);
	 webElement.sendKeys("10");
	 
	 Actions action=new Actions(driver);
	 WebElement element1= driver.findElement(By.xpath("//*[@id='absent_tab_3']/div/table/tbody/tr[1]/td[3]")); 	 
	 action.moveToElement(element1).click().perform();	 
}

helper.waitingForLoaderDisappeared(loader);

logger.log(LogStatus.PASS,"1:Article Tab has been selected From Client Absent State"+"<br/>"
		+ "2:Article Total Quantity is "+"<b>"+list+"<br/>"
		 +"<b><font color='green'>Result:Articles Left Quantity successfully entered <font/>"
		+logger.addScreenCapture(captureScreenShot(driver, "clientAbsent_Quantity_verified")));



prepare.Client_absent_summary_Tab.click();

Thread.sleep(3000);

try {
	
if (prepare.Client_absent_Fermer_Button.isDisplayed()) {
	
	 System.out.println("fermer button is dispayed");
	 helper.javaScriptHighlightWebElement(prepare.Client_absent_Fermer_Button);

	 logger.log(LogStatus.PASS,"1:Summary Tab has been selected From Client Absent State"+"<br/>"
			 +"<b><font color='green'>Result:Fermer button is Displayed On Summary Tab <font/>"
			+logger.addScreenCapture(captureScreenShot(driver, "Client Absent_SummaryTab_Fermer")));
	 helper.javaScriptUn_HighlightWebElement(prepare.Client_absent_Fermer_Button);

}
} catch (Exception fermerButton) {
	
 logger.log(LogStatus.FAIL,"1:Summary Tab has been selected From Client Absent State"+"<br/>"
		 +"<b><font color='red'>Result:Fermer button is Does not Displayed On Summary Tab <font/>"
		+logger.addScreenCapture(captureScreenShot(driver, "Client Absent_SummaryTab_Fermer")));


}

try {
	
if (prepare.Client_absent_Cancel_Button.isDisplayed()) {
	
	 System.out.println("cancenl order button is displayed");
	 helper.javaScriptHighlightWebElement(prepare.Client_absent_Cancel_Button);

	 logger.log(LogStatus.PASS,"1:Summary Tab has been selected From Client Absent State"+"<br/>"
			 +"<b><font color='green'>Result:Order Cancel button is Displayed On Summary Tab <font/>"
			+logger.addScreenCapture(captureScreenShot(driver, "Client Absent_SummaryTab_Cancel")));
	 helper.javaScriptUn_HighlightWebElement(prepare.Client_absent_Cancel_Button);

	} 
	 } catch (Exception cancelButton) {

	 System.out.println("cancenl order button is displayed");
	 logger.log(LogStatus.FAIL,"1:Summary Tab has been selected From Client Absent State"+"<br/>"
			 +"<b><font color='red'>Result:Order Cancel button is Does not Displayed On Summary Tab <font/>"
			+logger.addScreenCapture(captureScreenShot(driver, "Client Absent_SummaryTab_Cancel")));

} 

prepare.Client_absent_Assignment_Tab.click();
helper.javaScriptHighlightWebElement(prepare.Client_absent_Assignment_Tab);

prepare.Client_absent_USer.click();
helper.javaScriptHighlightWebElement(prepare.Client_absent_USer);

prepare.Client_absent_Comment.sendKeys(Keys.CONTROL+"a",Keys.BACK_SPACE);
prepare.Client_absent_Comment.sendKeys("test Absent");
helper.javaScriptHighlightWebElement(prepare.Client_absent_Comment);


Select select2=new Select(prepare.Client_absent_select_gate);
helper.javaScriptHighlightWebElement(prepare.Client_absent_select_gate);

select2.selectByValue("1");

logger.log(LogStatus.PASS,"1:Assignment  Tab has been selected From Client Absent State"+"<br/>"
		 +"2:User has been selected From Assigment Tab"+"<br/>"
		 +"3:Comment has been entered"+"<br/>"
		 +"4:Gate has been selected"+"<br/>"
		 +"<b><font color='green'>Result:Order is ready to move to Client Absent State<font/>"
		+logger.addScreenCapture(captureScreenShot(driver, "ClientAbsent_moveTo_Terminate")));


prepare.Client_absent_Terminate_State_button.click();

logger.log(LogStatus.PASS,"<b><font color='green'>Result:Order has been Terminated Successfully!!");


	} catch (Exception e) {
		logger.log(LogStatus.FAIL,"<b><font color='red'>Result:getting Error While client absent Tab content<font/>"+e.getMessage() 
		+logger.addScreenCapture(captureScreenShot(driver, "En_attente_SummaryTab_Cancel")));

	}

}



 

				
}		

	
