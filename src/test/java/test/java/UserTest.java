
package test.java;

import java.io.IOException;

import org.testng.annotations.Test;

import Page.SupplierPage;
import Page.UserPage;
import WebBase.BaseTest;

public class UserTest extends BaseTest {
	
	UserPage US =new UserPage();
	SupplierPage SP = new SupplierPage();
	

	
	
	@Test(priority=1)
	public void CreateNewUser() throws InterruptedException, IOException
	{
		
		US.Createuser();
	
	}
	
	@Test(priority=2)
	public void EditNewUser() throws InterruptedException, IOException
	{
		
		US.Editeuser();
	
	}
}
