package webElements_Identifiers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import webBase.BasePage;

public class Admin_Page_identifiers extends BasePage{

	
public WebDriver driver;
	
public  Admin_Page_identifiers(WebDriver dr) {
	
	this.driver=dr;
}
	


	
@FindBy(how=How.XPATH,using="//*[contains(text(),'Déconnexion')]")
@CacheLookup
public	WebElement logout;

@FindBy(how=How.XPATH,using="/html/body/header/a")
@CacheLookup
public	WebElement FACE_title;

@FindBy(how=How.XPATH,using="/html/body/header/nav/div/ul/li/a")
@CacheLookup
public	WebElement UserIcon;


@FindBy(how=How.XPATH,using="/html/body/header/nav/div/ul/li/ul/li[2]/div/div/div[1]/div/a")
@CacheLookup
public	WebElement AdminMenuButton;

@FindBy(how=How.XPATH,using="/html/body/div[2]/aside[2]/section[1]/h1")
@CacheLookup
public	WebElement BoardTableLabel;

@FindBy(how=How.XPATH,using="//*[@id='agency_details']")
@CacheLookup
public	WebElement BoardTableAgencydropDown;

//value =2|3|PP - IDF|3238|POINT P NANTERRE

@FindBy(how=How.XPATH,using="//*[@id='example1']")
@CacheLookup
public	WebElement OrderBoardTable;


@FindBy(how=How.XPATH,using="/html/body/div[2]/aside[2]/section[1]/ol/li/a[1]")
@CacheLookup
public	WebElement OrderSearchLink;


@FindBy(how=How.XPATH,using="/html/body/div[2]/aside[2]/section[1]/ol/li/a[2]")
@CacheLookup
public	WebElement GotoPreparationPageLink;


@FindBy(how=How.XPATH,using="/html/body/div[2]/aside[2]/section[2]/div[1]/div/div/a")
@CacheLookup
public	WebElement CustomerPageLink;


//-------------Drawers identifiers-----------
@FindBy(how=How.XPATH,using="/html/body/div[2]/aside[1]/section/div/div[2]/p")
@CacheLookup
public	WebElement UserNameOnDrawer;

@FindBy(how=How.XPATH,using="/html/body/div[2]/aside[1]/section/ul/li[1]/a/span")
@CacheLookup
public	WebElement OrderBoardTableOnDrawer;


public By BrandOnDrawer = By.xpath("/html/body/div[2]/aside[1]/section/ul/li[2]/a/span");

public By BrandCreationLink = By.xpath("/html/body/div[2]/aside[1]/section/ul/li[2]/ul/li[1]/a");


public By BrandListsLink = By.xpath("/html/body/div[2]/aside[1]/section/ul/li[2]/ul/li[2]/a");



public By RolesLink = By.xpath("/html/body/div[2]/aside[1]/section/ul/li[3]/a/span");



public By RolesCreationLink = By.xpath("/html/body/div[2]/aside[1]/section/ul/li[3]/ul/li[1]/a");


public By RolesListLink = By.xpath("/html/body/div[2]/aside[1]/section/ul/li[3]/ul/li[2]/a");


public By UsersLink = By.xpath("/html/body/div[2]/aside[1]/section/ul/li[4]/a/span");


public By UsersCreationLink = By.xpath("/html/body/div[2]/aside[1]/section/ul/li[4]/ul/li[1]/a");

public By UsersListLink = By.xpath("/html/body/div[2]/aside[1]/section/ul/li[4]/ul/li[2]/a");

public By AgencyLink = By.xpath("/html/body/div[2]/aside[1]/section/ul/li[5]/a/span");

public By AgencyCreationLink = By.xpath("/html/body/div[2]/aside[1]/section/ul/li[5]/ul/li[1]/a");

public By AgencyListsLink = By.xpath("/html/body/div[2]/aside[1]/section/ul/li[5]/ul/li[2]/a");


public By ZoneLink = By.xpath("/html/body/div[2]/aside[1]/section/ul/li[6]/a/span");


public By BLLink = By.xpath("/html/body/div[2]/aside[1]/section/ul/li[7]/a/span");

public By BLlistLink = By.xpath("/html/body/div[2]/aside[1]/section/ul/li[7]/ul/li/a");


//---------Brand Menu-----------------

@FindBy(how=How.XPATH,using="/html/body/div[2]/aside[2]/section[2]/div/div[2]/div/div/h3")
@CacheLookup
public	WebElement BrandMenuLabel;


public By NomField = By.xpath("//*[@id='name']");

public  By BranduserFiles = By.xpath("//*[@id='userfile']");

public  By BrandSaveButton = By.xpath("//*[@id='brand_submit']");


public  By BrandSuccessMessage = By.xpath("//*[@id='success']");


public  By RechercherField = By.xpath("//*[@id='example1_filter']/label/input");

public  By SortingArrows = By.xpath("//*[@id='example1']/thead/tr/th[1]");

public  By EditButton = By.xpath("//*[@id='example1']/tbody/tr/td[2]/a[1]");

public  By DeleteButton = By.xpath("//*[@id='example1']/tbody/tr/td[2]/a[2]");

//*[@id='duplicate_brnd_logo_text']
public  By logoAlreadyExist = By.xpath("//*[@id='duplicate_brnd_logo_text']");

public  By PaginationDropDown = By.xpath("//*[@id='example1_length']/label/select");

//--------Role menu-------



public  By user_type_submit = By.xpath("//*[@id='user_type_submit']");

//-----------users Menu----------
 
public By user_submit=By.xpath("//*[@id='user_submit']");

public By users_sgid=By.xpath("//*[@id='sgid']");

public By users_name=By.xpath("//*[@id='name']");

public By users_last_name=By.xpath("//*[@id='last_name']");

public By users_type=By.xpath("//*[@id='user_type']");

public By users_agency=By.xpath("//*[@id='agency']");

public By users_zone=By.xpath("//*[@id='zone']");

public By users_Active_InactiveButton=By.xpath("//*[@id='example1']/tbody/tr/td[8]/div/a[2]");

public By users_EditButton=By.xpath("//*[@id='example1']/tbody/tr/td[8]/div/a[1]");


//---------Agency Menu------------

public By CreationAgencyLabel =By.xpath("/html/body/div[2]/aside[2]/section[2]/div/div[2]/div/div/h3");


public By agency_code=By.xpath("//*[@id='agency_code']");


public By agency_name=By.xpath("//*[@id='agency_name']");


public By agency_brand=By.xpath("//*[@id='agency_brand']");
//value 1



public By gate=By.xpath("//*[@id='gate']");


public By agency_submit=By.xpath("//*[@id='agency_submit']");


public By agency_ListLabel=By.xpath("//*[@id='agency_ListLabel']");

public By agencyList_SorrtingArrows=By.xpath("//*[@id='example1']/thead/tr/th[1]");

public By agency_DeleteButton=By.xpath("//*[@id='example1']/tbody/tr/td[5]/div/a[2]");

public By agency_EditButton=By.xpath("//*[@id='example1']/tbody/tr/td[5]/div/a[1]");


//-----loading zone menu---------------


public By Zone_agency_DropDown=By.xpath("//*[@id='agency_details']");


public By zone_add=By.xpath("//*[@id='zone_add']");


public By zone_code=By.xpath("//*[@id='zone_code']");

public By zone_name=By.xpath("//*[@id='zone_name']");

public By insert=By.xpath("//*[@id='insert']");

public By cancel=By.xpath("//*[@id='cancel']");

public By error=By.xpath("//*[@id='error']");

public By loadingZoneInlineEdit=By.xpath("//*[@id='zone_management']/tbody/tr[1]/td[2]/div");


public By loadingZoneInclickCode=By.xpath("//*[@id='zone_management']/tbody/tr[1]/td[1]");

public By loadingZonerechercherField=By.xpath("//*[@id='zone_management_filter']/label/input");



//---------BL Menu-------------

@FindBy(how=How.XPATH,using="//*[@id='order_list_table_length']/label/select")
@CacheLookup
public	WebElement orderListPaginationDropDwon;

@FindBy(how=How.XPATH,using="//*[@id='order_list_table_filter']/label/input")
@CacheLookup
public	WebElement orderListRechercherField;


@FindBy(how=How.XPATH,using="//*[@id='order_list_table']/thead/tr/th[2]")
@CacheLookup
public	WebElement orderListsorrtingArrow;


@FindBy(how=How.XPATH,using="//*[@id='order_list_table']/tbody/tr[1]/td[10]/a[1]")
@CacheLookup
public	WebElement orderListEditButton;

@FindBy(how=How.XPATH,using="//*[@id='order_list_table']/tbody/tr[1]/td[10]/a[2]")
@CacheLookup
public	WebElement orderListDeleteButton;

@FindBy(how=How.XPATH,using="//*[@id='cancel_order']")
@CacheLookup
public	WebElement cancel_order;


@FindBy(how=How.XPATH,using="//*[@id='order_num']")
@CacheLookup
public	WebElement order_num;


@FindBy(how=How.XPATH,using="//*[@id='status']")
@CacheLookup
public	WebElement status;



@FindBy(how=How.XPATH,using="//*[@id='origin']")
@CacheLookup
public	WebElement origin;



@FindBy(how=How.XPATH,using="//*[@id='creation_date']")
@CacheLookup
public	WebElement creation_date;


@FindBy(how=How.XPATH,using="//*[@id='creation_date_bl']")
@CacheLookup
public	WebElement creation_date_bl;


@FindBy(how=How.XPATH,using="//*[@id='customer']")
@CacheLookup
public	WebElement customer;




@FindBy(how=How.XPATH,using="//*[@id='company']")
@CacheLookup
public	WebElement company;

@FindBy(how=How.XPATH,using="//*[@id='client_code']")
@CacheLookup
public	WebElement client_code;

@FindBy(how=How.XPATH,using="//*[@id='size']")
@CacheLookup
public	WebElement size;

public By agency=By.xpath("//*[@id='agency']");

public By user=By.xpath("//*[@id='user']");


//value 98

@FindBy(how=How.XPATH,using="//*[@id='comment']")
@CacheLookup
public	WebElement comment;





}
