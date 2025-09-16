package testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import automationcore.Base;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	@Test
	 public void verifyUserLoginWithValidCredentials() throws IOException
	 {
		
			String usernameValue=ExcelUtility.getStringData(0, 0, "LoginPage");
			String passwordValue=ExcelUtility.getStringData(0, 1, "LoginPage");
			LoginPage login= new LoginPage(driver);
			login.enterUsernameonUsernameField(usernameValue);
			login.enterPasswordonPasswordField(passwordValue);
			login.clickOnLoginButton();
	 
	}
	 @Test
		public void verifyUserLoginWithIvalidUsernameandValidPassword() throws IOException
		 {
			String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");
			String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");
			LoginPage login= new LoginPage(driver);
			login.enterUsernameonUsernameField(usernameValue);
			login.enterPasswordonPasswordField(passwordValue);
			login.clickOnLoginButton();
		}
		@Test
		public void verifyUserLoginWithValidUsernameandInvalidPassword() throws IOException
		 {
			String usernameValue=ExcelUtility.getStringData(2, 0, "LoginPage");
			String passwordValue=ExcelUtility.getStringData(2, 1, "LoginPage");
			LoginPage login= new LoginPage(driver);
			login.enterUsernameonUsernameField(usernameValue);
			login.enterPasswordonPasswordField(passwordValue);
			login.clickOnLoginButton();
		 
		}
		@Test
		public void verifyUserLoginWithInvalidCredentials() throws IOException
		 {
			String usernameValue=ExcelUtility.getStringData(3, 0, "LoginPage");
			String passwordValue=ExcelUtility.getStringData(3, 1, "LoginPage");
			LoginPage login= new LoginPage(driver);
			login.enterUsernameonUsernameField(usernameValue);
			login.enterPasswordonPasswordField(passwordValue);
			login.clickOnLoginButton();
		 
		}

}
