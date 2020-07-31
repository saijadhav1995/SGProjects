package pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.AppstringsConstant;
import Utility.Helper;
import webBase.BasePage;
import webBase.BaseTest;
import webBase.BrowserFactory;
import webElements_Identifiers.CustomerPage_Identifiers;
import webElements_Identifiers.Login_Identifiers;

public class CustomerPage extends BasePage   {
	
	
	
public ExtentTest logger;	
CustomerPage_Identifiers customer =new CustomerPage_Identifiers(driver);
public ExtentTest extentest;
public SoftAssert SAssert = new SoftAssert();
public PageFactory pf=new PageFactory();
BaseTest baseT = new BaseTest();
String className = "";
Helper helper=new Helper();
public AppstringsConstant appConst=new AppstringsConstant();

public void customerPage(String TestName) throws Throwable {
	
	JavascriptExecutor js=(JavascriptExecutor)driver;

	logger = baseT.extent.startTest(TestName);			
	customer=	PageFactory.initElements(driver, CustomerPage_Identifiers.class);
	createDirectory("TELEVENTE"+TestName);	

	
	
	driver.findElement(By.id("login.submit.id")).click();
	
driver.navigate().to("https://face-test.sgdbf.fr/customer?agency=3");



if (driver.findElement(customer.logo).isDisplayed()) {
	
	helper.javaScriptHighlightWebElement(driver.findElement(customer.logo));
	logger.log(LogStatus.PASS,"1:navigate to customer page "+"<br/>"
			+"<b><font color='green'>Result:POINT P Logo has been Displayed <font/>"
			+logger.addScreenCapture(captureScreenShot(driver, "PointP")));
	helper.javaScriptUn_HighlightWebElement(driver.findElement(customer.logo));
}


int count= driver.findElements(By.xpath("//*[@id='order_list_div']/div/div/div/div/ul/li[6]/table/tbody/tr/th")).size()+1;

	int counter=1;
 int arraycounter=0;

	while(count>counter) {
		
		Thread.sleep(500);	
WebElement TabsName =driver.findElement(By.xpath("//*[@id='order_list_div']/div/div/div/div/ul/li[6]/table/tbody/tr/th["+counter+"]"));

	
String castTabsName= TabsName.getText(); 

System.out.println(castTabsName);

ArrayList<String> arrlist = new ArrayList<String>();
 arrlist.add("No.");
 arrlist.add("Nom");
 arrlist.add("Bl number");
 arrlist.add("Status");
 arrlist.add("gate");
 arrlist.add("loading Zone");

 

while(arrlist.size()>arraycounter) {
		
	logger.log(LogStatus.PASS,"1:"+arrlist.get(arraycounter)+"column is Displayed on Customer Page as "+"<br/>" 
			+"<font color='green'>Result:<b> "+castTabsName +"<font/>");
	}
	
break;
		}
arraycounter=arraycounter+1;

System.out.println(counter);
	counter=counter+1;

		}




}


