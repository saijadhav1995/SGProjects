package Utility;



public class AppstringsConstant {
	//Page Header
	public final static String  PAGETITLE = "CAPTUREMAIL";
	
	//Supplier constant
	public final static String  SUPPLIEREXPETEDTYPE = "M"; 
	public final static  String  SUPPLIEREXPECTEDOBSERVATION = "Testing is in progress";
	public final static  String  SUPPLIEREXPECTEDVALIDATIONMANDATORY = "1";
	public final static  String  SUPPLIEREXPECTEDENTITY = "351";
	//public final static  String  SUPPLIERPDFPATH = "C:\\Users\\S6670405\\Desktop\\New folder\\Automation\\CAMAL\\Files\\Abc.pdf";
	public final static  String  SUPPLIERCREATIONMSG = "11Fournisseur créé avec succès";
	public final static  String  SUPPLIERUPDATIONMSG = "Fournisseur mis à jour avec succès";
	public final static  String  SUPPLIERMAILSENDMSG = "Email envoyé avec succès.";
	public final static  String  SUPPLIERDELETEMSG   = "Fournisseur supprimé avec succès";
	//public final static  String  EDITSUPPLIERPDFPATH = "C:\\Users\\S6670405\\Desktop\\New folder\\Automation\\CAMAL\\Files\\ABCDE.pdf";
	
	// Locators object
	public final static  String  SUPPLIERTYPELIST = "//*[@id=\"supplier_type\"]/option";
	public final static  String  SUPPLIERVALIDATIONMANDATORYLIST = "//*[@id=\"mandatory_valid\"]/option";
	public final static  String  SUPPLIERENTITYLIST = "//*[@id=\"entity\"]/option";
	public final static  String  USERROLEDROPDOWN = "//*[@id=\"usr_role\"]/option";
	
	
	//User
	public final static  String  USERROLE = "Administrateur";
	public final static  String  CREATEUSERMSG = "Utilisateur créé avec succès";
	public final static  String  EDITUSERMSG = "Utilisateur mis à jour avec succès";
	
	//Action Log
	public final static  String  CREATIONLOG = "Création";
	public final static  String  MODIFICATIONLOG = "Modification";
	public final static  String  DELETIONLOG = "Suppression";
	public final static  String  USERSGIDLOG = "A5417458";
	
	//EmailTab
	public final static  String  SUPPLIEREMAILCREATION = "//*[@id=\"supplier_type\"]/option";
	public final static  String MAILCREATIONSUCCESS = "Copie Mail d´information créé avec succès";
	public final static  String MAILEDITSUCCESS = "Copie Mail d´information mis à jour avec succès";

	//Logout
	public final static  String LOGOUTPAGEHEADER = "LOGIN PAGE";
	public final static  String INVALIDLOGINMSG = "SSO_002: The Saint-Gobain Identifier or the password is incorrect.";
	
	//Excel
	public static final String EXCELFILEPATH = "/Users/admin/WEB/CAMAL/";
	public static final String EXCELFILENAME= "Test_Data.xlsx";
	public static final String EXCELLOGINSHEET= "Login";
}
