package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constant.Constants;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

import utilities.RandomDataUtility;

public class AdminTest extends Base{
	HomePage homepage;
	AdminPage admin;
	
	@Test(priority=1,description="User is able to add new user in admin page")
	 public void verifyNewWUserInAdminPage() throws IOException
	 {
		
			String usernameValue=ExcelUtility.getStringData(0, 0,Constants.LOGINSHEET);
			String passwordValue=ExcelUtility.getStringData(0, 1,Constants.LOGINSHEET);
			
			LoginPage login= new LoginPage(driver);
			login.enterUsernameonUsernameField(usernameValue).enterPasswordonPasswordField(passwordValue);
			homepage=login.clickOnLoginButton();
			admin=homepage.adminUserTileClick();
			RandomDataUtility randomdata=new RandomDataUtility();
			String newusername=randomdata.randomUsername();
			String newpassword=randomdata.randomPassword();
		    admin.newUserButtonClick().enterusername(newusername).enterpassword(newpassword).selectUserType().clickSaveButton();
			boolean alertmessage=admin.isAlertMessageFound();
			Assert.assertTrue(alertmessage,Constants.USERCREATIONFAILURE);
	}
	@Test(priority=-1,description="User is able to search existing user in admin page")
	public void verifySearchInAdminPage() throws IOException
	{
		String usernameValue=ExcelUtility.getStringData(0, 0,Constants.LOGINSHEET);
		String passwordValue=ExcelUtility.getStringData(0, 1,Constants.LOGINSHEET);
		LoginPage login= new LoginPage(driver);
		login.enterUsernameonUsernameField(usernameValue).enterPasswordonPasswordField(passwordValue);
		homepage=login.clickOnLoginButton();
		admin=homepage.adminUserTileClick();
		admin.newUserButtonClick().searchButtonInAdminPage().searchInSearchField();
	    String user=ExcelUtility.getStringData(0, 0,"AdminPage");
	    String type=ExcelUtility.getStringData(0, 1,"AdminPage");
	    admin.searchUsernameInAdmin(user).searchInAdminPage(type).searchInSearchField();
		boolean search=admin.searchUserInAdminPage();
		Assert.assertTrue(search,Constants.NOTINADMINPAGE);
	}
	@Test(priority=0,description="User is able to reset admin page")
	public void verifyResetInAdminPage() throws IOException
	{
		String usernameValue=ExcelUtility.getStringData(0, 0,Constants.LOGINSHEET);
		String passwordValue=ExcelUtility.getStringData(0, 1,Constants.LOGINSHEET);
		LoginPage login= new LoginPage(driver);
		login.enterUsernameonUsernameField(usernameValue).enterPasswordonPasswordField(passwordValue);
		homepage=login.clickOnLoginButton();
		admin=homepage.adminUserTileClick();
		admin.resetInAdminPage();
		boolean reset=admin.isResetTableFound();
		Assert.assertTrue(reset, Constants.NOTINADMINPAGE);
		
	}
	
}
