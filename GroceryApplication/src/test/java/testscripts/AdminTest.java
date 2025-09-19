package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminTest extends Base{
	
	@Test
	 public void verifyNewWUserInAdminPage() throws IOException
	 {
		
			String usernameValue=ExcelUtility.getStringData(0, 0, "LoginPage");
			String passwordValue=ExcelUtility.getStringData(0, 1, "LoginPage");
			
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
	@Test
	public void verifySearchInAdminPage() throws IOException
	{
		String usernameValue=ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage login= new LoginPage(driver);
		login.enterUsernameonUsernameField(usernameValue);
		login.enterPasswordonPasswordField(passwordValue);
		login.clickOnLoginButton();
	
		AdminPage admin=new AdminPage(driver);
		HomePage homepage=new HomePage(driver);
		homepage.adminUserTileClick();
		admin.newUserButtonClick();
		admin.searchButtonInAdminPage();
		admin.enterUsernmaeInSearchField();
		admin.enterUserTypeInSearchField();
		admin.searchInSearchField();
		boolean search=admin.searchUserInAdminPage();
		Assert.assertTrue(search,"User is not in admin page");
	}
	@Test
	public void verifyResetInAdminPage() throws IOException
	{
		String usernameValue=ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue=ExcelUtility.getStringData(0, 1, "LoginPage");
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
