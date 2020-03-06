
package Identifier;



import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import WebBase.BasePage;

public class EmailManagementIdentifier extends BasePage {
	
	@FindBy(xpath = "//*[@id=\"navigation\"]/ul/li[3]/a/span")
	public WebElement EmailTab;
	
	@FindBy(id = "btn_add")
	public WebElement EmailAdd;
	
	@FindBy(id = "supplier_type")
	public WebElement Email_supplierType;
	
	@FindBy(id = "mail_address")
	public WebElement Email_mailaddress;
	
	@FindBy(id = "btn-save")
	public WebElement EmailsaveButton;
	
	@FindBy(id = "btn_reset")
	public WebElement EmailResetButton;
		
	@FindBy(xpath = "//*[@id=\"rejection_mail_copy_filter\"]/label/input")
	public WebElement EmailSearch;
	
	
	@FindBy(xpath = "//*[@id=\"rejection_mail_copy\"]/tbody/tr[1]/td[3]/button")
	public WebElement EmaileditID;
	
	
	@FindBy(xpath = "/html/body/div[2]/div/div[1]/strong")
	public WebElement Emailsuccessmessage;
	
	
	@FindBy(xpath = "//*[@id=\"rejection_mail_copy\"]/tbody/tr[1]/td[1]")
	public WebElement Tbl_supplieremailtype;
	
	
	@FindBy(xpath = "//*[@id=\"rejection_mail_copy\"]/tbody/tr[1]/td[2]")
	public WebElement Tbl_supplieraddressmail;
	
	@FindBy(id = "mail_sender")
	public WebElement EmailSenderID;
	
	
	@FindBy(xpath = "//button[@id='btn-no']")
	public WebElement NonBtn;
	
	@FindBy(id = "//button[@class='close']")
	public List<WebElement> closeBtn;
	
	@FindBy(id = "mail_objet")
	public WebElement Emailobject;
	
	@FindBy(xpath = "//*[@id=\"inforamtion_mail\"]/div/div[2]/div[3]/div/div[3]/div[2]")
	public WebElement Emailbody;
	
	@FindBy(xpath = "//button[@id='information_mail_submit']")
	public WebElement EmailSubmitbtn;
	
		
	@FindBy(xpath = "//*[@id=\"topnav\"]/div[1]/div/div[2]/ul/li[2]/a")
	public WebElement PageTopusername;
	
	@FindBy(xpath = "//*[@id=\"topnav\"]/div[1]/div/div[2]/ul/li[2]/div/a")
	public WebElement logoutbutton;
	
	@FindBy(id = "title")
	public WebElement logoutpage;
	
	
	@FindBy(xpath = "//td[text()='Suppression']")
	public List<WebElement> SearchText;
	
	@FindBy(xpath = "//input[@type='search']")
	public WebElement SearchTextbox;
	
	@FindBy(xpath = "//button[@id='btn-reset']")
	public WebElement AnnularBtn;
	
	@FindBy(xpath = "//span[@class='supplier_type error']")
	public WebElement supplier_Error;
	
	
	@FindBy(xpath = "//span[@class='mail_address error']")
	public WebElement mail_address_Error;
	
	
	@FindBy(xpath = "//input[@type='search']")
	public WebElement Search_Textbox;
	
	
	@FindBy(xpath = "//div[@class='alert alert-success']")
	public WebElement MailSuccesssg;
	
	@FindBy(xpath = "//span[@id='mail_libelle']")
	public WebElement UpadtedMailContents;
	
	@FindBy(xpath = "//button[@class='fa fa-envelope open_mail_modal button']")
	public List<WebElement> Mail_List;
	
	@FindBy(xpath = "//div[@class='note-editable panel-body']")
	public WebElement noteeditable;
	
	@FindBy(xpath = "//table/tbody/tr[@role='row']/td[2]")
	public WebElement RowData;
	
	@FindBy(xpath = "//input[@name='mail_sender']")
	public WebElement mail_sender;
	
	
	@FindBy(xpath = "//button[@id='information_mail_submit']")
	public WebElement subitBtn;
	
	public WebElement getLogoutpage() {
		return logoutpage;
	}

	public void setLogoutpage(WebElement logoutpage) {
		this.logoutpage = logoutpage;
	}

	public WebElement getPageTopusername() {
		return PageTopusername;
	}

	public void setPageTopusername(WebElement pageTopusername) {
		PageTopusername = pageTopusername;
	}

	public WebElement getLogoutbutton() {
		return logoutbutton;
	}

	public void setLogoutbutton(WebElement logoutbutton) {
		this.logoutbutton = logoutbutton;
	}

	public WebElement getEmailsuccessmessage() {
		return Emailsuccessmessage;
	}

	public void setEmailsuccessmessage(WebElement emailsuccessmessage) {
		Emailsuccessmessage = emailsuccessmessage;
	}

	public WebElement getEmailTab() {
		return EmailTab;
	}

	public void setEmailTab(WebElement emailTab) {
		EmailTab = emailTab;
	}

	public WebElement getEmailAdd() {
		return EmailAdd;
	}

	public void setEmailAdd(WebElement emailAdd) {
		EmailAdd = emailAdd;
	}

	
	
	public WebElement getEmail_supplierType() {
		return Email_supplierType;
	}

	public void setEmail_supplierType(WebElement email_supplierType) {
		Email_supplierType = email_supplierType;
	}

	public WebElement getEmail_mailaddress() {
		return Email_mailaddress;
	}

	public void setEmail_mailaddress(WebElement email_mailaddress) {
		Email_mailaddress = email_mailaddress;
	}

	public WebElement getEmailsaveButton() {
		return EmailsaveButton;
	}

	public void setEmailsaveButton(WebElement emailsaveButton) {
		EmailsaveButton = emailsaveButton;
	}

	public WebElement getEmailResetButton() {
		return EmailResetButton;
	}

	public void setEmailResetButton(WebElement emailResetButton) {
		EmailResetButton = emailResetButton;
	}

	public WebElement getEmailSearch() {
		return EmailSearch;
	}

	public void setEmailSearch(WebElement emailSearch) {
		EmailSearch = emailSearch;
	}

	public WebElement getEmaileditID() {
		return EmaileditID;
	}

	public void setEmaileditID(WebElement emaileditID) {
		EmaileditID = emaileditID;
	}

	public WebElement getTbl_supplieremailtype() {
		return Tbl_supplieremailtype;
	}

	public void setTbl_supplieremailtype(WebElement tbl_supplieremailtype) {
		Tbl_supplieremailtype = tbl_supplieremailtype;
	}

	public WebElement getTbl_supplieraddressmail() {
		return Tbl_supplieraddressmail;
	}

	public void setTbl_supplieraddressmail(WebElement tbl_supplieraddressmail) {
		Tbl_supplieraddressmail = tbl_supplieraddressmail;
	}

	public WebElement getEmailSenderID() {
		return EmailSenderID;
	}

	public void setEmailSenderID(WebElement emailSenderID) {
		EmailSenderID = emailSenderID;
	}

	public WebElement getEmailobject() {
		return Emailobject;
	}

	public void setEmailobject(WebElement emailobject) {
		Emailobject = emailobject;
	}

	public WebElement getEmailbody() {
		return Emailbody;
	}

	public void setEmailbody(WebElement emailbody) {
		Emailbody = emailbody;
	}

	public WebElement getEmailSubmitbtn() {
		return EmailSubmitbtn;
	}

	public void setEmailSubmitbtn(WebElement emailSubmitbtn) {
		EmailSubmitbtn = emailSubmitbtn;
	}
	
	
}


