package webElements_Identifiers;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import webBase.BasePage;





public class Preparation_Page_identifiers extends BasePage{

	
public WebDriver driver;
	
public  Preparation_Page_identifiers(WebDriver dr) {
	
	this.driver=dr;
}


//Login page Identifiers	
	

@FindBy(how=How.XPATH,using="/html/body/div/aside/section/ol/li/text()")
@CacheLookup
public	WebElement agency_Title;

	
	@FindBy(how=How.XPATH,using="//*[contains(text(),'Déconnexion')]")
	@CacheLookup
	public	WebElement logout;
	

	
	@FindBy(how=How.XPATH,using="/html/body/header/nav/div/ul/li/a")
	@CacheLookup
	public	WebElement Userlogout_Toggle_Button;
	
	
	
	@FindBy(how=How.XPATH,using="/html/body/header/a")
	@CacheLookup
	public	WebElement FACE_title;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='sel_user_pre_97']")
	@CacheLookup
	public	WebElement Select_User;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='txt_comment_pre']")
	@CacheLookup
	public	WebElement Comment_section;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='order_gate_select']")
	@CacheLookup
	public	WebElement Select_Gate;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='frm_status_pre']/div[2]/button[1]")
	@CacheLookup
	public	WebElement Fermer_Button;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='frm_status_pre']/div[2]/button[2]")
	@CacheLookup
	public	WebElement EnAttente_Button;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='frm_status_pre']/div[2]/button[3]")
	@CacheLookup
	public	WebElement Prete_Button;
	
	//----- En attente identifiers-----
	
	@FindBy(how=How.XPATH,using="//*[@id='compose-modal']/div/div/div[2]/div[1]/ul/li[1]/a")
	@CacheLookup
	public	WebElement Order_Assignment_Tab;
	
	@FindBy(how=How.XPATH,using="//*[@id='compose-modal']/div/div/div[2]/div[1]/ul/li[2]/a")
	@CacheLookup
	public	WebElement summary_Tab;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='compose-modal']/div/div/div[2]/div[1]/ul/li[3]/a")
	@CacheLookup
	public	WebElement Articles_Tab;
	
	
	public static final String Article_toggle_buttonXpath="//*[@id='attend_tab_3']/div/table/tbody/tr/td/div/button[1]";
	
	public static final String ArticleTab_get_QuantityXpath="//*[@id='attend_tab_3']/div/table/tbody/tr/td[4]/div/p[1]";
	
	public static final String ArticleTab_input_FieldsXpath="//*[@id='attend_tab_3']/div/table/tbody/tr/td[4]/div/p[2]/input";
	
	
	
	@FindBy(how=How.XPATH,using="//*[@id='attend_tab_3']/div/table/tbody/tr/td/div/button[1]")
	@CacheLookup
	public	WebElement ArticleTab_toggle_Button;
	
	
	
	@FindBy(how=How.XPATH,using="//*[@id='attend_tab_3']/div/table/tbody/tr/td[4]/div/p[1]")
	@CacheLookup
	public	WebElement ArticleTab_get_Quantity;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='attend_tab_3']/div/table/tbody/tr/td[4]/div/p[2]")
	@CacheLookup
	public	WebElement ArticleTab_input_Fields;
	
	@FindBy(how=How.XPATH,using="//*[@id='attend_tab_2']/form/div[2]/button")
	@CacheLookup
	public	WebElement En_Attente_Fermer_Button;
	
	@FindBy(how=How.XPATH,using="//*[@id='attend_tab_2']/form/div[2]/a")
	@CacheLookup
	public	WebElement En_Attnete_Order_Cancel_Button;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='sel_user_attend_97']")
	@CacheLookup
	public	WebElement En_Attnete_Select_USer;
	
	@FindBy(how=How.XPATH,using="//*[@id='txt_comment_attend']")
	@CacheLookup
	public	WebElement En_Attnete_Enter_Comment;
	

	@FindBy(how=How.XPATH,using="//*[@id='frm_status_attend']/div[1]/div/div[@class='input-group']/select[@id='order_gate_select']")
	@CacheLookup
	public	WebElement En_Attente_select_gate;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='frm_status_attend']/div[2]/button[2]")
	@CacheLookup
	public	WebElement En_Attente_PreparationButton;
	
	

		
	
	//--------Preparation state---------
	
	
	
	@FindBy(how=How.XPATH,using="//*[@id='compose-modal2']/div/div/div[2]/div[1]/ul/li[1]/a")
	@CacheLookup
	public	WebElement preparation_Assignment_Tab;
	
	@FindBy(how=How.XPATH,using="//*[@id='compose-modal2']/div/div/div[2]/div[1]/ul/li[2]/a")
	@CacheLookup
	public	WebElement Preparation_summary_Tab;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='compose-modal2']/div/div/div[2]/div[1]/ul/li[3]/a")
	@CacheLookup
	public	WebElement Preparation_Articles_Tab;
	
	
	public static final String Preparation_Article_toggle_buttonXpath="//*[@id='pre_tab_3']/div/table/tbody/tr/td/div/button[1]";
	
	public static final String Preparation_ArticleTab_get_QuantityXpath="//*[@id='pre_tab_3']/div/table/tbody/tr/td[4]/div/p[1]";
	
	public static final String Preparation_ArticleTab_input_FieldsXpath="//*[@id='pre_tab_3']/div/table/tbody/tr/td[4]/div/p[2]/input";
	
	public static final String preparation_Article_click="//*[@id='pre_tab_3']/div/table/tbody/tr[1]/td[3]";
	
	@FindBy(how=How.XPATH,using="//*[@id='pre_tab_2']/form/div[2]/button")
	@CacheLookup
	public	WebElement preparation_Fermer_Button;
	
	@FindBy(how=How.XPATH,using="//*[@id='pre_tab_2']/form/div[2]/a")
	@CacheLookup
	public	WebElement preparation_Order_Cancel_Button;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='sel_user_pre_97']")
	@CacheLookup
	public	WebElement Preparation_Select_USer;
	
	@FindBy(how=How.XPATH,using="//*[@id='txt_comment_pre']")
	@CacheLookup
	public	WebElement Preparation_Enter_Comment;
	

	@FindBy(how=How.XPATH,using="//*[@id='frm_status_pre']/div[1]/div/div[@class='input-group']/select[@id='order_gate_select']")
	@CacheLookup
	public	WebElement Preparation_select_gate;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='frm_status_pre']/div[2]/button[2]")
	@CacheLookup
	public	WebElement En_Attente_State_Button;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='frm_status_pre']/div[2]/button[3]")
	@CacheLookup
	public	WebElement Preparation_Prete_State_Button ;
	
	@FindBy(how=How.XPATH,using="//*[@id='frm_status_pre']/div[2]/button[1]")
	@CacheLookup
	public	WebElement Prete_Fermer_ButtonOn_assignmentTab ;
		
		
	
	
	//-----------Prete-------------------------
	
	
	@FindBy(how=How.XPATH,using="//*[@id='compose-modal3']/div/div/div[2]/div[1]/ul/li[1]/a")
	@CacheLookup
	public	WebElement Prete_Assignment_Tab;
	
	@FindBy(how=How.XPATH,using="//*[@id='compose-modal3']/div/div/div[2]/div[1]/ul/li[2]/a")
	@CacheLookup
	public	WebElement  Prete__summary_Tab;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='compose-modal3']/div/div/div[2]/div[1]/ul/li[3]/a")
	@CacheLookup
	public	WebElement  Prete__Articles_Tab;
	
	
	public static final String  Prete_Article_toggle_buttonXpath="//*[@id='done_tab_3']/div/table/tbody/tr/td/div/button[1]";
	
	public static final String  Prete_ArticleTab_get_QuantityXpath="//*[@id='done_tab_3']/div/table/tbody/tr/td[4]/div/p[1]";
	
	public static final String  Prete_ArticleTab_input_FieldsXpath="//*[@id='done_tab_3']/div/table/tbody/tr/td[4]/div/p[2]/input";
	
	
	@FindBy(how=How.XPATH,using="//*[@id='done_tab_2']/form/div[2]/button")
	@CacheLookup
	public	WebElement Prete_Fermer_Button;
	
	@FindBy(how=How.XPATH,using="//*[@id='done_tab_2']/form/div[2]/a")
	@CacheLookup
	public	WebElement Prete_Order_Cancel_Button;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='sel_user_done_98']")
	@CacheLookup
	public	WebElement Prete_Select_USer;
	
	@FindBy(how=How.XPATH,using="//*[@id='txt_comment_done']")
	@CacheLookup
	public	WebElement Prete_Enter_Comment;
	

	@FindBy(how=How.XPATH,using="//*[@id='frm_status_done']/div[1]/div/div[@class='input-group']/select[@id='order_gate_select']")
	@CacheLookup
	public	WebElement Prete_select_gate;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='frm_status_done']/div[2]/div[1]/button")
	@CacheLookup
	public	WebElement En_Preparation_State_Button;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='frm_status_done']/div[2]/div[2]/button")
	@CacheLookup
	public	WebElement terminate_State_Button ;
	
	@FindBy(how=How.XPATH,using="//*[@id='frm_status_done']/div[2]/div[3]/button")
	@CacheLookup
	public	WebElement Reste_Prende_State_Button_in_PreteTab ;
		
	
	@FindBy(how=How.XPATH,using="//*[@id='frm_status_done']/div[2]/div[4]/button")
	@CacheLookup
	public	WebElement ClientAbsent_State_Button ;
	
	@FindBy(how=How.XPATH,using="//*[@id='frm_status_done']/div[2]/div[5]/button")
	@CacheLookup
	public	WebElement Fermer_State_Button ;
	
	
	
	
	//-----------Reste a Prende-------------------------
	
	
		@FindBy(how=How.XPATH,using="//*[@id='compose-modal6']/div/div/div[2]/div[1]/ul/li[1]/a")
		@CacheLookup
		public	WebElement Reste_Prende_Assignment_Tab;
		
		@FindBy(how=How.XPATH,using="//*[@id='compose-modal6']/div/div/div[2]/div[1]/ul/li[2]/a")
		@CacheLookup
		public	WebElement  Reste_Prende_summary_Tab;
		
		
		@FindBy(how=How.XPATH,using="//*[@id='compose-modal6']/div/div/div[2]/div[1]/ul/li[3]/a")
		@CacheLookup
		public	WebElement  Reste_Prende_Articles_Tab;
		
		
		public static final String  Reste_Prende_toggle_buttonXpath="//*[@id='left_tab_3']/div/table/tbody/tr/td/div/button[1]";
		
		public static final String  Reste_Prende_Tab_get_QuantityXpath="//*[@id='left_tab_3']/div/table/tbody/tr/td[4]/div/p[1]";
		
		public static final String  Reste_Prende_Tab_input_FieldsXpath="//*[@id='left_tab_3']/div/table/tbody/tr/td[4]/div/p[2]/input";
		
		
		@FindBy(how=How.XPATH,using="//*[@id='left_tab_2']/form/div[2]/button")
		@CacheLookup
		public	WebElement Reste_Prende_Fermer_Button;
		
		@FindBy(how=How.XPATH,using="//*[@id='left_tab_2']/form/div[2]/a")
		@CacheLookup
		public	WebElement Reste_Prende__Cancel_Button;
		
		
		@FindBy(how=How.XPATH,using="//*[@id='sel_user_left_97']")
		@CacheLookup
		public	WebElement Reste_Prende_USer;
		
		@FindBy(how=How.XPATH,using="//*[@id='txt_comment_left']")
		@CacheLookup
		public	WebElement Reste_Prende_Comment;
		

		@FindBy(how=How.XPATH,using="//*[@id='frm_status_left']/div[1]/div/div[@class='input-group']/select[@id='order_gate_select']")
		@CacheLookup
		public	WebElement Reste_Prende_select_gate;
		
		
		@FindBy(how=How.XPATH,using="//*[@id='frm_status_left']/div[2]/button[1]")
		@CacheLookup
		public	WebElement Reste_Prende_Fermer_State_Button;
		
		
		@FindBy(how=How.XPATH,using="//*[@id='frm_status_left']/div[2]/button[2]")
		@CacheLookup
		public	WebElement Reste_Prende_Prete_State_button ;
		
		
		@FindBy(how=How.XPATH,using="//*[@id='frm_status_left']/div[2]/button[3]")
		@CacheLookup
		public	WebElement Reste_Prende_Terminate_State_button ;
		
		
		




		//-----------Client Absent-------------------------
		
		
			@FindBy(how=How.XPATH,using="//*[@id='compose-modal5']/div/div/div[2]/div[1]/ul/li[1]/a")
			@CacheLookup
			public	WebElement Client_absent_Assignment_Tab;
			
			@FindBy(how=How.XPATH,using="//*[@id='compose-modal5']/div/div/div[2]/div[1]/ul/li[2]/a")
			@CacheLookup
			public	WebElement  Client_absent_summary_Tab;
			
			
			@FindBy(how=How.XPATH,using="//*[@id='compose-modal5']/div/div/div[2]/div[1]/ul/li[3]/a")
			@CacheLookup
			public	WebElement  Client_absent_Articles_Tab;
			
			
			public static final String  Client_absent_toggle_buttonXpath="//*[@id='absent_tab_3']/div/table/tbody/tr/td/div/button[1]";
			
			public static final String  Client_absent_Tab_get_QuantityXpath="//*[@id='absent_tab_3']/div/table/tbody/tr/td[4]/div/p[1]";
			
			public static final String  Client_absent_Tab_input_FieldsXpath="//*[@id='absent_tab_3']/div/table/tbody/tr/td[4]/div/p[2]/input";
			
			
			@FindBy(how=How.XPATH,using="//*[@id='absent_tab_2']/form/div[2]/button")
			@CacheLookup
			public	WebElement Client_absent_Fermer_Button;
			
			@FindBy(how=How.XPATH,using="//*[@id='absent_tab_2']/form/div[2]/a")
			@CacheLookup
			public	WebElement Client_absent_Cancel_Button;
			
			
			@FindBy(how=How.XPATH,using="//*[@id='sel_user_absent_97']")
			@CacheLookup
			public	WebElement Client_absent_USer;
			
			@FindBy(how=How.XPATH,using="//*[@id='txt_comment_absent']")
			@CacheLookup
			public	WebElement Client_absent_Comment;
			

			@FindBy(how=How.XPATH,using="//*[@id='frm_status_absent']/div[1]/div/div[@class='input-group']/select[@id='order_gate_select']")
			@CacheLookup
			public	WebElement Client_absent_select_gate;
			
			
			@FindBy(how=How.XPATH,using="//*[@id='frm_status_absent']/div[2]/button[1]")
			@CacheLookup
			public	WebElement Client_absent_Fermer_State_Button;
			
			
			@FindBy(how=How.XPATH,using="//*[@id='frm_status_absent']/div[2]/button[2]")
			@CacheLookup
			public	WebElement Client_absent_Prete_State_button ;
			
			
			@FindBy(how=How.XPATH,using="//*[@id='frm_status_absent']/div[2]/button[3]")
			@CacheLookup
			public	WebElement Client_absent_Terminate_State_button ;
			
			
			
	//------------All State other Details--------------------		
			
//en attente
			@FindBy(how=How.XPATH,using="//*[@id='compose-modal']/div/div/div[1]/h3[1]/span")
			@CacheLookup
			public	WebElement En_Attente_Tab_BlNumber;
			
			
			@FindBy(how=How.XPATH,using="//*[@id='compose-modal']/div/div/div[1]/h3[2]/span")
			@CacheLookup
			public	WebElement En_Attente_Tab_Logo;
			
			
			@FindBy(how=How.XPATH,using="//*[@id='compose-modal']/div/div/div[1]/h3[2]/div/table/tbody/tr/td[2]/span")
			@CacheLookup
			public	WebElement En_Attente_Tab_OrderDetails;
			
			
//----------preparation tab-----------			
			@FindBy(how=How.XPATH,using="//*[@id='compose-modal2']/div/div/div[1]/h3[1]/span")
			@CacheLookup
			public	WebElement Preparation_Tab_BlNumber;
			
			
			@FindBy(how=How.XPATH,using="//*[@id='compose-modal2']/div/div/div[1]/h4/span")
			@CacheLookup
			public	WebElement Preparation_Tab_Logo;
			
			
			@FindBy(how=How.XPATH,using="//*[@id='compose-modal2']/div/div/div[1]/h4/div/table/tbody/tr/td[2]")
			@CacheLookup
			public	WebElement Prepararion_Tab_OrderDetails;
			
//-------------prete tab-------------
			
			@FindBy(how=How.XPATH,using="//*[@id='compose-modal3']/div/div/div[1]/h3[1]/span")
			@CacheLookup
			public	WebElement Prete_Tab_BlNumber;
			
			
			@FindBy(how=How.XPATH,using="//*[@id='compose-modal3']/div/div/div[1]/h4/span")
			@CacheLookup
			public	WebElement Prete_Tab_Logo;
			
			
			@FindBy(how=How.XPATH,using="//*[@id='compose-modal3']/div/div/div[1]/h4/div/table/tbody/tr/td[2]")
			@CacheLookup
			public	WebElement Prete_Tab_OrderDetails;
			
			
//------------Reste Prende-------------
			
			@FindBy(how=How.XPATH,using="//*[@id='compose-modal6']/div/div/div[1]/h3[1]/span")
			@CacheLookup
			public	WebElement RestePrende_Tab_BlNumber;
			
			
			@FindBy(how=How.XPATH,using="//*[@id='compose-modal6']/div/div/div[1]/h4/span")
			@CacheLookup
			public	WebElement RestePrende_Tab_Logo;
			
			
			@FindBy(how=How.XPATH,using="//*[@id='compose-modal6']/div/div/div[1]/h4/div/table/tbody/tr/td[2]")
			@CacheLookup
			public	WebElement RestePrende_Tab_OrderDetails;

			
//----------------Client Absent----------
			
			
			@FindBy(how=How.XPATH,using="//*[@id='compose-modal5']/div/div/div[1]/h3[1]/span")
			@CacheLookup
			public	WebElement ClientAbsent_Tab_BlNumber;
			
			
			@FindBy(how=How.XPATH,using="//*[@id='compose-modal5']/div/div/div[1]/h4/span")
			@CacheLookup
			public	WebElement ClientAbsent_Tab_Logo;
			
			
			@FindBy(how=How.XPATH,using="//*[@id='compose-modal5']/div/div/div[1]/h4/div/table/tbody/tr/td[2]")
			@CacheLookup
			public	WebElement ClientAbsent_Tab_OrderDetails;
			
			

			
}
