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
import utilities.ExcelUtilityforAdmin;
import utilities.RandomDataUtility;

public class AdminTest extends Base{
	
	@Test(priority=1,description="User ia able to add new user in admin page")
	 public void verifyNewWUserInAdminPage() throws IOException
	 {
		
			String usernameValue=ExcelUtility.getStringData(0, 0,Constants.LOGINSHEET);
			String passwordValue=ExcelUtility.getStringData(0, 1,Constants.LOGINSHEET);
			
			LoginPage login= new LoginPage(driver);
			login.enterUsernameonUsernameField(usernameValue);
			login.enterPasswordonPasswordField(passwordValue);
			login.clickOnLoginButton();
			
			AdminPage admin=new AdminPage(driver);
			RandomDataUtility randomdata=new RandomDataUtility();
			String newusername=randomdata.randomUsername();
			String newpassword=randomdata.randomPassword();
			
			HomePage homepage=new HomePage(driver);
			homepage.adminUserTileClick();
			admin.newUserButtonClick();
			admin.enterusername(newusername);
			admin.enterpassword(newpassword);
			admin.selectUserType();
			admin.clickSaveButton();
			boolean alertmessage=admin.isAlertMessageFound();
			Assert.assertTrue(alertmessage,"User is unable to create a new user");
	}
	@Test(priority=-1,description="User ia able to add new user in admin page")
	public void verifySearchInAdminPage() throws IOException
	{
		String usernameValue=ExcelUtility.getStringData(0, 0,Constants.LOGINSHEET);
		String passwordValue=ExcelUtility.getStringData(0, 1,Constants.LOGINSHEET);
		LoginPage login= new LoginPage(driver);
		login.enterUsernameonUsernameField(usernameValue);
		login.enterPasswordonPasswordField(passwordValue);
		login.clickOnLoginButton();
	
		AdminPage admin=new AdminPage(driver);
		HomePage homepage=new HomePage(driver);
		homepage.adminUserTileClick();
		admin.newUserButtonClick();
		admin.searchButtonInAdminPage();
		//admin.enterUsernmaeInSearchField();
		//admin.enterUserTypeInSearchField();
		admin.searchInSearchField();
	    String user=ExcelUtilityforAdmin.getStringData(0, 0,"AdminSheet");
	    String type=ExcelUtilityforAdmin.getStringData(0, 1,"AdminSheet");
	    admin.searchUsernameInAdmin(user);
	    admin.searchInAdminPage(type);
	    admin.searchUserInAdminPage();
		boolean search=admin.searchUserInAdminPage();
		Assert.assertTrue(search,"User is not in admin page");
	}
	@Test(priority=0,description="User ia able to add new user in admin page")
	public void verifyResetInAdminPage() throws IOException
	{
		String usernameValue=ExcelUtility.getStringData(0, 0,Constants.LOGINSHEET);
		String passwordValue=ExcelUtility.getStringData(0, 1,Constants.LOGINSHEET);
		LoginPage login= new LoginPage(driver);
		login.enterUsernameonUsernameField(usernameValue);
		login.enterPasswordonPasswordField(passwordValue);
		login.clickOnLoginButton();
		AdminPage admin=new AdminPage(driver);
		HomePage homepage=new HomePage(driver);
		homepage.adminUserTileClick();
		admin.resetInAdminPage();
		boolean reset=admin.isResetTableFound();
		Assert.assertTrue(reset, "User is not in admin page");
		
	}
	
}
