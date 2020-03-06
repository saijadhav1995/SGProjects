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
	
	@Test(priority=8)
	public void LogOut() throws InterruptedException, IOException
	{
		EM.LogOutfromApp();
		
	}  
	
	@Test(priority=6)
	public void VerifymailOnsupplier() throws InterruptedException, IOException
	{
		//EM.verifyaddedEmailIdOnSupplier();
		
	}  
	
	@Test(priority=3)
	public void verifysearch() throws InterruptedException, IOException
	{
		EM.VerifyrReachrche();
		
	}  
	
	
	@Test(priority=4)
	public void VerifyNoteEdit() throws InterruptedException, IOException
	{
		EM.EditEmailText();
		
	}  
	
	@Test(priority=5)
	public void EmailFormatOnSupplier() throws InterruptedException, IOException
	{
		//EM.verifyeditedEmailFormatOnSupplier();
		
	}  
	
	@Test(priority=7)
	public void verifysearchonHistory() throws InterruptedException, IOException
	{
		EM.verifyReachrcheOnHistory();
		
	}  
	
	/*
	 * @Test(priority=3) public void verifyCreateMailError() throws
	 * InterruptedException, IOException { // EM.verifyErrorMassage();
	 * 
	 * }
	 */
}

