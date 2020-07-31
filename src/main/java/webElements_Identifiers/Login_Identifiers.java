package webElements_Identifiers;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import webBase.BasePage;





public class Login_Identifiers extends BasePage{

	
public WebDriver driver;
	
	
//Login page Identifiers	
	
	@FindBy(how=How.XPATH,using="//*[@class='link text-primary d-inline-block']")
	@CacheLookup
	public WebElement link;
	
	
	@FindBy(how=How.XPATH,using="//input[@id='username']")
	@CacheLookup
	public WebElement username;
	
	
	@FindBy(how=How.XPATH,using="//input[@id='password']")
	@CacheLookup
	public WebElement password;
	
	
	@FindBy(how=How.XPATH,using="//input[@type='submit']")
	@CacheLookup
	public	WebElement submit;

	
	
	
	@FindBy(how=How.XPATH,using="//*[contains(text(),'Déconnexion')]")
	@CacheLookup
	public	WebElement logout;
	
	
	@FindBy(how=How.XPATH,using="//*[contains(text(),'Connexion refusée')]")
	@CacheLookup
	public	WebElement refuse;
	
	
	
	
	@FindBy(how=How.XPATH,using="//*[contains(text(),'Invalid credentials.')]")
	@CacheLookup
	public	WebElement invalid;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='sel_agency']")
	@CacheLookup
	public	WebElement Select_agency;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='login-box']/form/div[2]/button")
	@CacheLookup
	public	WebElement Agency_button;
	
	
	
	
	
	
public  Login_Identifiers(WebDriver dr) {
		
		this.driver=dr;
	}
	
		
		
	
// Define Actions for each Identifiers
	
	public void clicklink() {
		
		link.click();

		
	}
	
		
public void typeUsername(String username1 ) {
		
	username.clear();
	username.sendKeys(username1);
		
		
	}
	
public void typePassword(String passowrd2) {
		
	password.clear();
	password.sendKeys(passowrd2);
	}
public void clickSubmit() {
	
	submit.click();
}



public void logOut() {
	
	logout.click();
}



}
