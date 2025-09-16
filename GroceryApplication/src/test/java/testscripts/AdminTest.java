package testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import automationcore.Base;
import pages.AdminPage;
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
			
			admin.adminUserTileClick();
			admin.newUserButtonClick();
			admin.enterusername(newusername);
			admin.enterpassword(newpassword);
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
