package Identifier;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import WebBase.BasePage;


public class UserIdentifier extends BasePage {
	
	@FindBy(xpath = "//*[@id=\"navigation\"]/ul/li[2]/a/span")
	public WebElement usertab;
	
	@FindBy(id = "btn_add")
	public WebElement adduser;
	
	
	@FindBy(xpath="//button[@id='btn-reset']")
	public WebElement ResetBtn;
	
	
	
	
		
	@FindBy(xpath = "//*[@id=\"users_filter\"]/label/input")
	public WebElement usersearch;
	
	@FindBy(id = "usr_name")
	public WebElement userfirstlastname;
	
	@FindBy(id = "usr_sgid")
	public WebElement userSGID;
	
	@FindBy(id = "usr_role")
	public WebElement userrole;
	
	@FindBy(id = "btn-save")
	public WebElement useraddbtn;
	
	@FindBy(id = "add_reset")
	public WebElement userResetbtn;
	
	@FindBy(xpath = "//button[@aria-label='Close']")
	public WebElement Closetbtn;
	
	@FindBy(xpath = "//span[@class='usr_name error']")
	public WebElement usr_nameerror;
	
	@FindBy(xpath = "//span[@class='usr_sgid error']")
	public WebElement Sgid_ErrorMassage;
	
	@FindBy(xpath = "//span[@class='usr_role error']")
	public WebElement usr_roleErrorMassage;
	
	@FindBy(xpath = "//input[@type='search']")
	public WebElement Reacharcher_TextBox;
	
	@FindBy(xpath = "//td[text()='A5417458']")
	public WebElement UserSgid;	
	
	
	@FindBy(xpath = "//*[@id=\"users\"]/tbody/tr[1]/td[4]/button")
	public WebElement useredit;
	
	@FindBy(xpath = "//*[@id=\"users\"]/tbody/tr[1]/td[1]")
	public WebElement tbl_username;
	
	@FindBy(xpath = "//*[@id=\"users\"]/tbody/tr[1]/td[2]")
	public WebElement tbl_userSGID;

	@FindBy(xpath = "//*[@id=\"users\"]/tbody/tr[1]/td[3]")
	public WebElement tbl_userRole;
	
	@FindBy(xpath = "/html/body/div[2]/div/div[1]/strong")
	public WebElement usersuccessmsg;
	
	
			
	
	public WebElement getUsersuccessmsg() {
		return usersuccessmsg;
	}

	public void setUsersuccessmsg(WebElement usersuccessmsg) {
		this.usersuccessmsg = usersuccessmsg;
	}

	public WebElement getUsertab() {
		return usertab;
	}

	public void setUsertab(WebElement usertab) {
		this.usertab = usertab;
	}

	public WebElement getAdduser() {
		return adduser;
	}

	public void setAdduser(WebElement adduser) {
		this.adduser = adduser;
	}

	public WebElement getUsersearch() {
		return usersearch;
	}

	public void setUsersearch(WebElement usersearch) {
		this.usersearch = usersearch;
	}

	public WebElement getUserfirstlastname() {
		return userfirstlastname;
	}

	public void setUserfirstlastname(WebElement userfirstlastname) {
		this.userfirstlastname = userfirstlastname;
	}

	public WebElement getUserSGID() {
		return userSGID;
	}

	public void setUserSGID(WebElement userSGID) {
		this.userSGID = userSGID;
	}

	public WebElement getUserrole() {
		return userrole;
	}

	public void setUserrole(WebElement userrole) {
		this.userrole = userrole;
	}

	public WebElement getUseraddbtn() {
		return useraddbtn;
	}

	public void setUseraddbtn(WebElement useraddbtn) {
		this.useraddbtn = useraddbtn;
	}

	public WebElement getUserResetbtn() {
		return userResetbtn;
	}

	public void setUserResetbtn(WebElement userResetbtn) {
		this.userResetbtn = userResetbtn;
	}

	public WebElement getUseredit() {
		return useredit;
	}

	public void setUseredit(WebElement useredit) {
		this.useredit = useredit;
	}

	public WebElement getTbl_username() {
		return tbl_username;
	}

	public void setTbl_username(WebElement tbl_username) {
		this.tbl_username = tbl_username;
	}

	public WebElement getTbl_userSGID() {
		return tbl_userSGID;
	}

	public void setTbl_userSGID(WebElement tbl_userSGID) {
		this.tbl_userSGID = tbl_userSGID;
	}

	public WebElement getTbl_userRole() {
		return tbl_userRole;
	}

	public void setTbl_userRole(WebElement tbl_userRole) {
		this.tbl_userRole = tbl_userRole;
	}

	
}
