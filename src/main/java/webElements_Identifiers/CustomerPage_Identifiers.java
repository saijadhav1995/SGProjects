package webElements_Identifiers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import webBase.BasePage;

public class CustomerPage_Identifiers extends BasePage{

	
public WebDriver driver;
	
public  CustomerPage_Identifiers(WebDriver dr) {
	
	this.driver=dr;
}

public By logo=By.xpath("/html/body/header/a/img");
 
public By Columns=By.xpath("//*[@id='order_list_div']/div/div/div/div/ul/li[6]/table/tbody/tr/th");	
	



}
