package WebBase;
import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;


public class BaseTest extends webController{
	
	public static WebDriver Basetestdriver=null;
	public  static ExtentReports extent;	
	
	public BaseTest() 
	{
		BaseTest.Basetestdriver = webController.invokeWebController();
		PageFactory.initElements(Basetestdriver, this);
		
	}
	
@BeforeSuite
	
	public static  ExtentReports getReporter() {
		if (extent == null) {
		//	extent = new ExtentReports(System.getProperty("user.dir") +"/test-output/CAMAL.html", true);
			extent = new ExtentReports(System.getProperty("user.dir") +"/extentReports/index.html", true);
			extent.loadConfig(new File("/Users/admin/Desktop/untitled folder 2/CAMAL/test-output/extent-config.xml"));
			extent
			.addSystemInfo("Host Name", "CAMAL")
			.addSystemInfo("Environment", "QA")
			.addSystemInfo("Testapp", "WEB-APP");
			//extent.loadConfig(extent-config.xml);
		}
		return extent;
		
	}
	
@AfterSuite
public void closeextend()
{
	extent.flush();
}

}

