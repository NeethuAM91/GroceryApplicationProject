package testscripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constant.Constants;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	@Test(groups= {"smoke"})
	 public void verifyUserLoginWithValidCredentials() throws IOException
	 {
		
			String usernameValue=ExcelUtility.getStringData(0, 0,Constants.LOGINSHEET);
			String passwordValue=ExcelUtility.getStringData(0, 1,Constants.LOGINSHEET);
			LoginPage login= new LoginPage(driver);
			login.enterUsernameonUsernameField(usernameValue);
			login.enterPasswordonPasswordField(passwordValue);
			login.clickOnLoginButton();
			boolean	dashboarddisplay = login.isDashboardDisplayed();
		    Assert.assertTrue(dashboarddisplay,Constants.VALIDCREDENTIALERROR);
	 
	}
	 @Test
		public void verifyUserLoginWithIvalidUsernameandValidPassword() throws IOException
		 {
			String usernameValue=ExcelUtility.getStringData(1, 0, Constants.LOGINSHEET);
			String passwordValue=ExcelUtility.getStringData(1, 1,Constants.LOGINSHEET);
			LoginPage login= new LoginPage(driver);
			login.enterUsernameonUsernameField(usernameValue);
			login.enterPasswordonPasswordField(passwordValue);
			login.clickOnLoginButton();
			String actual=login.getPageTitle();
			String expected="7rmart supermarket";
			Assert.assertEquals(actual, expected,Constants.INVALIDCREDENTIALERROR);
		}
		@Test
		public void verifyUserLoginWithValidUsernameandInvalidPassword() throws IOException
		 {
			String usernameValue=ExcelUtility.getStringData(2, 0,Constants.LOGINSHEET);
			String passwordValue=ExcelUtility.getStringData(2, 1,Constants.LOGINSHEET);
			LoginPage login= new LoginPage(driver);
			login.enterUsernameonUsernameField(usernameValue);
			login.enterPasswordonPasswordField(passwordValue);
			login.clickOnLoginButton();
			boolean	remembermedisplay = login.isRemembermeDisplayed();
		    Assert.assertTrue(remembermedisplay,Constants.INVALIDCREDENTIALERROR);
	 
		 
		}
		@Test(groups= {"smoke"})
		public void verifyUserLoginWithInvalidCredentials() throws IOException
		 {
			String usernameValue=ExcelUtility.getStringData(3, 0,Constants.LOGINSHEET);
			String passwordValue=ExcelUtility.getStringData(3, 1,Constants.LOGINSHEET);
			LoginPage login= new LoginPage(driver);
			login.enterUsernameonUsernameField(usernameValue);
			login.enterPasswordonPasswordField(passwordValue);
			login.clickOnLoginButton();
			String actual=login.isSigninButtonPresent();
			String expected="Sign In";
			Assert.assertEquals(actual, expected,Constants.INVALIDCREDENTIALERROR);
		 
		}

}
