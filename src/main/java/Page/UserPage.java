package Page;

import java.io.IOException;

import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Identifier.UserIdentifier;
import Utility.AppstringsConstant;
import Utility.Helper;
import WebBase.BasePage;
import WebBase.BaseTest;

public class UserPage extends BasePage {

	UserIdentifier UserId = new UserIdentifier();
	Helper help = new Helper();
	String Username = help.randomUsernameGenerator();
	String EditedUsername = help.randomUsernameGenerator();
	String SGId = help.randomSGIDGenerator();
	BaseTest baseT = new BaseTest();
	String EditSGId = help.randomSGIDGenerator();
	String className = "";
	public ExtentTest logger;

	public void Createuser() throws InterruptedException, IOException {
		className = this.getClass().getName();
		createDirectory("CAMAL"+className);
		logger = baseT.extent.startTest("User Test");
		UserId.getUsertab().click();
		UserId.getAdduser().click();
		Thread.sleep(2000);
		UserId.getUserfirstlastname().click();
		UserId.getUserfirstlastname().sendKeys(Username);
		UserId.getUserSGID().sendKeys(SGId);
		UserId.getUserrole().click();
		help.Dropdown(AppstringsConstant.USERROLEDROPDOWN);
		UserId.getUseraddbtn().click();
		Thread.sleep(5000);
		String expectedresultString = AppstringsConstant.CREATEUSERMSG;
		String actualresult = UserId.getUsersuccessmsg().getText();
		Assert.assertEquals(actualresult, expectedresultString);
		UserId.getUsersearch().sendKeys(Username);
		Thread.sleep(3000);
		if (expectedresultString.equals(actualresult) == true) {
			logger.log(LogStatus.PASS,
					"1:  Create user " + "<br/>" + "2 : Creation of new user. " + "<br/>"
							+ "<b>Result: New user is created successfully <b>"
							+ logger.addScreenCapture(captureScreenShot(driver, "Create new user")));
		} else {
			logger.log(LogStatus.FAIL, "Success message is not displayed.");
		}
	}

	public void Editeuser() throws InterruptedException, IOException {
		UserId.getUseredit().click();
		Thread.sleep(3000);
		UserId.getUserfirstlastname().clear();
		UserId.getUserfirstlastname().sendKeys(EditedUsername);
		UserId.getUserSGID().sendKeys(EditSGId);
		UserId.getUserrole().click();
		help.Dropdown(AppstringsConstant.USERROLEDROPDOWN);
		UserId.getUseraddbtn().click();
		Thread.sleep(5000);

		if (AppstringsConstant.EDITUSERMSG.equals(UserId.getUsersuccessmsg().getText()) == true) {
			logger.log(LogStatus.PASS,
					"1:  Edit user " + "<br/>" + "2 : Modification  of user. " + "<br/>"
							+ "<b>Result: Modification of  user is done successfully <b>"
							+ logger.addScreenCapture(captureScreenShot(driver, "Modify user")));
		} else {
			logger.log(LogStatus.FAIL, "Success message is not displayed.");
		}
	}

}
