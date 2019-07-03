package Identifier;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import WebBase.BasePage;

public class LoginIdentifier extends BasePage {

	@FindBy(id = "buttonConnect")
	public WebElement Connectbutton;

	@FindBy(xpath = "/html/body/header/div[2]/div/div/ul/li[1]/a/span")
	public WebElement Suppliertab;

	@FindBy(id = "btn_add")
	public WebElement newsupplier;

	@FindBy(id = "mail_address")
	public WebElement MailAddress;

	@FindBy(id = "supplier_code")
	public WebElement SupplierCode;

	@FindBy(id = "supplier_type")
	public WebElement Suppliertype;

	@FindBy(name = "multi_mail")
	public WebElement RejectMailAddress;

	@FindBy(xpath = "(//input[@name='multi_mail'])[2]")
	public WebElement SGDBFSuppliertype;

	@FindBy(id = "supplier_comment")
	public WebElement suppliercomment;

	@FindBy(id = "mandatory_valid")
	public WebElement mandatoryvalid;

	@FindBy(id = "btn-save")
	public WebElement buttonSave;
	
	@FindBy(id = "btn-no")
	public  WebElement buttonNo;

	

	@FindBy(id = "btn-yes")
	static WebElement buttonYes;
	
	@FindBy(xpath = "/html/body/div[2]/div/div[1]/strong")
	public WebElement SupplierSuccessMsg;

	@FindBy(xpath = "//*[@id=\"supplier_data\"]/tbody/tr/td[1]")
	public  WebElement Tbl_supplierMail;
	
	@FindBy(xpath = "//*[@id=\"supplier_data\"]/tbody/tr/td[2]")
	public WebElement Tbl_suppliecode;
	
	@FindBy(xpath = "//*[@id=\"supplier_data\"]/tbody/tr/td[3]")
	public WebElement Tbl_supplieType;
	
	@FindBy(xpath = "//*[@id=\"supplier_data\"]/tbody/tr/td[4]")
	public WebElement Tbl_supplierejectMail;
	
	@FindBy(xpath = "//*[@id=\"supplier_data\"]/tbody/tr/td[5]")
	public WebElement Tbl_supplieSGDBFMail;
	
	@FindBy(xpath = "//*[@id=\"supplier_data\"]/tbody/tr/td[6]")
	public WebElement Tbl_supplieObservation;
	
	@FindBy(xpath = "//*[@id=\"supplier_data\"]/tbody/tr/td[7]")
	public WebElement Tbl_mandtoryValidation;
	
	@FindBy(xpath = "//*[@id=\"supplier_data\"]/tbody/tr/td[8]")
	public WebElement Tbl_supplieEntity;
	
	@FindBy(xpath = "//*[@id=\"supplier_data\"]/tbody/tr/td[9]/button[1]")
	public WebElement btn_supplieEdit;
	
	@FindBy(id = "delete_supplier")
	public WebElement btn_supplieDelete;
	
	@FindBy(xpath = "//*[@id=\"supplier_data\"]/tbody/tr/td[9]/button[3]")
	public WebElement btn_supplieMail;
	
	@FindBy(xpath = "//*[@id=\"supplier_data\"]/tbody/tr/td[9]/button[4]")
	public WebElement btn_suppliePDF;
	
	@FindBy(xpath= "//*[@id=\"logs_data_filter\"]/label/input")
	public WebElement logsearch;
		
	@FindBy(xpath= "//*[@id=\"navigation\"]/ul/li[4]/a")
	public WebElement histort_Tab;
	
	@FindBy(xpath= "//*[@id=\"logs_data\"]/tbody/tr[1]/td[1]")
	public WebElement Tbl_SGID;
	
	@FindBy(xpath= "//*[@id=\"logs_data\"]/tbody/tr[1]/td[2]")
	public WebElement Tbl_Date;
	
	@FindBy(xpath= "//*[@id=\"logs_data\"]/tbody/tr[1]/td[3]")
	public WebElement Tbl_action;
	
	@FindBy(xpath= "//*[@id=\"logs_data\"]/tbody/tr[1]/td[4]")
	public WebElement Tbl_mailOfSupplier;
	
	@FindBy(id="buttonConnect")
	public WebElement btn_ssoConnection;
	
	@FindBy(xpath ="//*[@id=\"links\"]/a")
	public WebElement loginpagelink;
	
	@FindBy(xpath ="//*[@id=\"error\"]/span")
	public WebElement errormsg;
	
	@FindBy(xpath ="//*[@id=\"formAutoLogin\"]/a")
	public WebElement useanotherloginlink;		
	
	@FindBy(id="password")
	public WebElement txt_SGpassword;
	
	@FindBy(id="username")
	public WebElement txt_SGusername;
	
	
	
	
	public WebElement getTbl_SGID() {
		return Tbl_SGID;
	}

	public void setTbl_SGID(WebElement tbl_SGID) {
		Tbl_SGID = tbl_SGID;
	}

	public WebElement getTbl_Date() {
		return Tbl_Date;
	}

	public void setTbl_Date(WebElement tbl_Date) {
		Tbl_Date = tbl_Date;
	}

	public WebElement getTbl_action() {
		return Tbl_action;
	}

	public void setTbl_action(WebElement tbl_action) {
		Tbl_action = tbl_action;
	}

	public WebElement getTbl_mailOfSupplier() {
		return Tbl_mailOfSupplier;
	}

	public void setTbl_mailOfSupplier(WebElement tbl_mailOfSupplier) {
		Tbl_mailOfSupplier = tbl_mailOfSupplier;
	}

	public WebElement getLogsearch() {
		return logsearch;
	}

	public void setLogsearch(WebElement logsearch) {
		this.logsearch = logsearch;
	}

	public WebElement getHistort_Tab() {
		return histort_Tab;
	}

	public void setHistort_Tab(WebElement histort_Tab) {
		this.histort_Tab = histort_Tab;
	}

	public WebElement getButtonYes() {
		return buttonYes;
	}

	public void setButtonYes(WebElement buttonYes) {
		this.buttonYes = buttonYes;
	}

	public  WebElement getButtonNo() {
		return buttonNo;
	}

	public  void setButtonNo(WebElement buttonNo) {
		buttonYes = buttonNo;
	}

	public WebElement getBtn_supplieEdit() {
		return btn_supplieEdit;
	}

	public void setBtn_supplieEdit(WebElement btn_supplieEdit) {
		this.btn_supplieEdit = btn_supplieEdit;
	}

	public WebElement getBtn_supplieDelete() {
		return btn_supplieDelete;
	}

	public void setBtn_supplieDelete(WebElement btn_supplieDelete) {
		this.btn_supplieDelete = btn_supplieDelete;
	}

	public WebElement getBtn_supplieMail() {
		return btn_supplieMail;
	}

	public void setBtn_supplieMail(WebElement btn_supplieMail) {
		this.btn_supplieMail = btn_supplieMail;
	}

	public WebElement getBtn_suppliePDF() {
		return btn_suppliePDF;
	}

	public void setBtn_suppliePDF(WebElement btn_suppliePDF) {
		this.btn_suppliePDF = btn_suppliePDF;
	}


	
	
	

	public WebElement getTbl_suppliecode() {
		return Tbl_suppliecode;
	}

	public void setTbl_suppliecode(WebElement tbl_suppliecode) {
		Tbl_suppliecode = tbl_suppliecode;
	}

	public WebElement getTbl_supplieType() {
		return Tbl_supplieType;
	}

	public void setTbl_supplieType(WebElement tbl_supplieType) {
		Tbl_supplieType = tbl_supplieType;
	}

	public WebElement getTbl_supplierejectMail() {
		return Tbl_supplierejectMail;
	}

	public void setTbl_supplierejectMail(WebElement tbl_supplierejectMail) {
		Tbl_supplierejectMail = tbl_supplierejectMail;
	}

	public WebElement getTbl_supplieSGDBFMail() {
		return Tbl_supplieSGDBFMail;
	}

	public void setTbl_supplieSGDBFMail(WebElement tbl_supplieSGDBFMail) {
		Tbl_supplieSGDBFMail = tbl_supplieSGDBFMail;
	}

	public WebElement getTbl_supplieObservation() {
		return Tbl_supplieObservation;
	}

	public void setTbl_supplieObservation(WebElement tbl_supplieObservation) {
		Tbl_supplieObservation = tbl_supplieObservation;
	}

	public WebElement getTbl_mandtoryValidation() {
		return Tbl_mandtoryValidation;
	}

	public void setTbl_mandtoryValidation(WebElement tbl_mandtoryValidation) {
		Tbl_mandtoryValidation = tbl_mandtoryValidation;
	}

	public WebElement getTbl_supplieEntity() {
		return Tbl_supplieEntity;
	}

	public void setTbl_supplieEntity(WebElement tbl_supplieEntity) {
		Tbl_supplieEntity = tbl_supplieEntity;
	}

	@FindBy(css = "input[type=\"search\"]")
	static WebElement searchField;
	
	

	public WebElement getSearchField() {
		return searchField;
	}

	public static void setSearchField(WebElement searchField) {
		LoginIdentifier.searchField = searchField;
	}

	public WebElement getTbl_supplierMail() {
		return Tbl_supplierMail;
	}

	public  void setTbl_supplierMail(WebElement tbl_supplierMail) {
		Tbl_supplierMail = tbl_supplierMail;
	}

	public WebElement getSupplierSuccessMsg() {
		return SupplierSuccessMsg;
	}

	public  void setSupplierSuccessMsg(WebElement supplierSuccessMsg) {
		SupplierSuccessMsg = supplierSuccessMsg;
	}

	public WebElement getButtonSave() {
		return buttonSave;
	}

	public  void setButtonSave(WebElement buttonSave) {
		this.buttonSave = buttonSave;
	}

	public static WebElement getButtonreset() {
		return buttonreset;
	}

	public static void setButtonreset(WebElement buttonreset) {
		LoginIdentifier.buttonreset = buttonreset;
	}

	@FindBy(id = "btn-reset")
	static WebElement buttonreset;

	public WebElement getSupplierPDF() {
		return supplierPDF;
	}

	public static void setSupplierPDF(WebElement supplierPDF) {
		LoginIdentifier.supplierPDF = supplierPDF;
	}

	@FindBy(id = "supplier_pdf")
	static WebElement supplierPDF;

	public WebElement getRejectMailAddress() {
		return RejectMailAddress;
	}

	public  void setRejectMailAddress(WebElement rejectMailAddress) {
		RejectMailAddress = rejectMailAddress;
	}

	public WebElement getSGDBFSuppliertype() {
		return SGDBFSuppliertype;
	}

	public  void setSGDBFSuppliertype(WebElement sGDBFSuppliertype) {
		SGDBFSuppliertype = sGDBFSuppliertype;
	}

	public WebElement getSuppliercomment() {
		return suppliercomment;
	}

	public  void setSuppliercomment(WebElement suppliercomment) {
		this.suppliercomment = suppliercomment;
	}

	public WebElement getMandatoryvalid() {
		return mandatoryvalid;
	}

	public  void setMandatoryvalid(WebElement mandatoryvalid) {
		this.mandatoryvalid = mandatoryvalid;
	}

	public WebElement getEntity() {
		return entity;
	}

	public static void setEntity(WebElement entity) {
		LoginIdentifier.entity = entity;
	}

	@FindBy(id = "entity")
	static WebElement entity;

	public WebElement getSuppliertype() {
		return Suppliertype;
	}

	public  void setSuppliertype(WebElement suppliertype) {
		Suppliertype = suppliertype;
	}

	public WebElement getSuppliertab() {
		return Suppliertab;
	}

	public  void setSuppliertab(WebElement suppliertab) {
		Suppliertab = suppliertab;
	}

	public WebElement getNewsupplier() {
		return newsupplier;
	}

	public  void setNewsupplier(WebElement newsupplier) {
		this.newsupplier = newsupplier;
	}

	public WebElement getMailAddress() {
		return MailAddress;
	}

	public  void setMailAddress(WebElement mailAddress) {
		MailAddress = mailAddress;
	}

	public WebElement getSupplierCode() {
		return SupplierCode;
	}

	public  void setSupplierCode(WebElement supplierCode) {
		SupplierCode = supplierCode;
	}

	public WebElement getConnectbutton() {
		return Connectbutton;
	}

	public  void setConnectbutton(WebElement connectbutton) {
		Connectbutton = connectbutton;
	}

}
