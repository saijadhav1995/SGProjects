package test.java;
import java.io.IOException;

import org.testng.annotations.Test;

import Page.SupplierPage;
import WebBase.BaseTest;

public class supplierTest extends BaseTest{
	
	SupplierPage SP = new SupplierPage();
	
	@Test(priority=1)
	public void CreateNewSupplier() throws InterruptedException, IOException
	{
		
		SP.CreateSupplier();
	
	}
	
	@Test(priority=2)
	public void CheckLOGforcreation() throws InterruptedException, IOException
	{
		
		SP.CheckLOGforcreation();
	
	}
	
	@Test(priority=3)
	public void EditNewSupplier() throws InterruptedException, IOException
	{
		
		SP.EditnewSupplier();
	
	}
	
	@Test(priority=4)
	public void CheckLOGformodification() throws InterruptedException, IOException
	{
		
		SP.CheckLOGformodification();
	
	}
	
	@Test(priority=5)
	public void SendMailToSupplier() throws InterruptedException, IOException
	{
		
		SP.SendMailToSupplier();
	
	}
	
	@Test(priority=6)
	public void DeleteSupplier() throws InterruptedException, IOException
	{
		
		SP.DeleteSupplier();
	
	}
	
	@Test(priority=7)
	public void CheckLOGfordelete() throws Exception
	{
		
		SP.CheckLOGfordelete();
	
	}

}
