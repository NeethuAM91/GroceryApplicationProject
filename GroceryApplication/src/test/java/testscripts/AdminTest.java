package testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import automationcore.Base;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

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
			admin.adminUserTileClick();
			admin.newUserButtonClick();
			admin.enterusername();
			admin.verifyenterpassword();
			admin.selectUserType();
			admin.clickSaveButton();
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
		admin.adminUserTileClick();
		admin.newUserButtonClick();
		admin.searchButtonInAdminPage();
		admin.enterUsernmaeInSearchField();
		admin.enterUserTypeInSearchField();
		admin.searchInSearchField();
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
		admin.adminUserTileClick();
		admin.ResetInAdminPage();
	}
	
}
