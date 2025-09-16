package testscripts;

import java.io.IOException;


import org.testng.annotations.Test;

import automationcore.Base;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base {
	@Test
	 public void verifyLogoutFromHomePage() throws IOException
	 {
		
			String usernameValue=ExcelUtility.getStringData(0, 0, "LoginPage");
			String passwordValue=ExcelUtility.getStringData(0, 1, "LoginPage");
			LoginPage login= new LoginPage(driver);
			login.enterUsernameonUsernameField(usernameValue);
			login.enterPasswordonPasswordField(passwordValue);
			login.clickOnLoginButton();
			HomePage home=new HomePage(driver);
			home.clickAdmin();
			home.logout();
	 
	}
}