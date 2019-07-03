package test.java;


import java.io.IOException;

import org.testng.annotations.Test;

import Page.EmailPage;

import WebBase.BaseTest;

public class EmailManagerTest extends BaseTest{

	
	
	EmailPage EM = new EmailPage();
	
	
	
	@Test(priority=1)
	public void CreateEmail() throws InterruptedException, IOException
	{
		EM.CreatesupplieremailID();
		
	}  
	
	@Test(priority=2)
	public void EditEmail() throws InterruptedException, IOException
	{
		EM.EditsupplieremailID();
		
	}  
	
	@Test(priority=3)
	public void LogOut() throws InterruptedException, IOException
	{
		EM.LogOutfromApp();
		
	}  
}

