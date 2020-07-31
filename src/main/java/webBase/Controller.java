package webBase;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;

import com.sun.javafx.print.Units;



public class Controller {

	public static WebDriver driver=null;
	static String imagesDirectory = "";
	static String relativePathforImage = "";

	public static WebDriver InvokeWebDriver() {
		
		
		if (driver != null) {
			return driver;
		}

		System.setProperty("webdriver.chrome.driver",
		System.getProperty("user.dir")+"\\Drivers\\chromedriver_win32 (2)\\chromedriver.exe");

		
		driver = new ChromeDriver();
		System.out.println("Driver Created");

		driver.get("https://uat.websso.saint-gobain.com/cas/login?service=https%3A%2F%2Fface-test.sgdbf.fr%2F");

		System.out.println("Website Open");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
		return driver;
	}

	
		
	
}  


