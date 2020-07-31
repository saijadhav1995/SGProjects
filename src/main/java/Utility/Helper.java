package Utility;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

import groovyjarjarantlr.ActionTransInfo;
import webBase.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Helper extends Controller {
	
	 int i=1;

	Controller contr=new Controller();
	public String randomEmailGenerator() {

		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(10000000);
		String emailID = "testUser" + randomInt + "@gmail.com";
		return emailID;

	}
	public File getLatestFilefromDir(String dirPath){
	    File dir = new File(dirPath);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        return null;
	    }
	    
	   
	    File lastModifiedFile = files[0];
	    for (int i = 1; i < files.length; i++) {
	       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
	     
	    	   
	    	   
	    	   lastModifiedFile = files[i];
	       }
	    }
	    return lastModifiedFile;
	}
	
	 public void JavaScriptClick(WebElement Element)
		{
			JavascriptExecutor jse = (JavascriptExecutor)Controller.driver;
			jse.executeScript("arguments[0].click();", Element);
		}
	 
	 
	 public void javaScriptHighlightWebElement(WebElement Element) {
			JavascriptExecutor jse = (JavascriptExecutor)Controller.driver;
	jse.executeScript("arguments[0].setAttribute('style', 'border: 2px solid yellow;');",Element);

		 
	 }
	 
	 public void javaScriptUn_HighlightWebElement(WebElement Element) {
		 
		 JavascriptExecutor jse = (JavascriptExecutor)Controller.driver;
		 jse.executeScript("arguments[0].removeAttribute('style','')", Element);

	 }
	 
	
	public String randomUsernameGenerator() {

		String randomInt = RandomStringUtils.random(5,
				"ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		String UserName = "username" + randomInt ;
		return UserName;

	}
	
	public boolean isElementPresent(WebElement element) {
		try {
			element.isDisplayed();
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			
			e.printStackTrace();
			return false;
		}
	}
	
	
	public boolean isElementEnabled(WebElement element) {
		try {
			element.isEnabled();
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			return false;
		}
	}
		
	
	
/*public void Login(String username,String password){
		
	testID.txt_SGusername.sendKeys(username);
	testID.txt_SGpassword.sendKeys(password);
		
	}*/

	public String randomSGIDGenerator() {

		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(10000000);
		String randomString = RandomStringUtils.random(1,
				"ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		String SGID = randomString + randomInt;
		return SGID;

	}
	
	public void Dropdown(String Locator) {

		List<WebElement> selectoption =  Controller.driver.findElements(By.xpath(""+Locator+""));
		Random random = new Random();
		int index = random.nextInt(selectoption.size());
		if (index == 0)
		{
			index = index + 1;
		}
		selectoption.get(index).click();
		
	}
	 
	public void getscreenshots() throws IOException
	{
		
		File scfile = ((TakesScreenshot)Controller.driver).getScreenshotAs(OutputType.FILE);
		 String filename =  new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		 File DestFile=new File("C:\\dexter\\CAMAL\\Screenshots\\"+ filename + "Test"+i+++".png");
		 FileUtils.copyFile(scfile, DestFile);
	}
	
	
	public String waitingForLoaderDisappeared(String loader) {
		
		 WebDriverWait wait = new WebDriverWait(driver, 30 );

		// wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(loader)));
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(loader))); 
		 System.out.println("loader has been disappeared");
		 
		return loader;

		
	}


	public By waitingForElementClikable(By element) {
		
		 WebDriverWait wait = new WebDriverWait(driver, 20 );

		 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(element)));
		 System.out.println("element is clickable");
		 
		return element;

		
	}

	
	
	
	public WebElement SelectvalueFromDropDown(By element,String value ) {
		
		WebElement ele= driver.findElement(element);
		
		Select select=new Select(ele);
		
		select.selectByValue(value);
		
		return ele;
		
		
	}
	
	public void handleAcceptAlert() {
		
	
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		alert.accept();
	}
	
	public void handleAcceptDimiss() {
		
		
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		alert.dismiss();
	}
	
	
	

}
 


