package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constant.Constants;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base {
	HomePage home;
	
	@Test(description="User is able to logout from home page")
	 public void verifyLogoutFromHomePage() throws IOException
	 {
		
			String usernameValue=ExcelUtility.getStringData(0, 0,Constants.LOGINSHEET);
			String passwordValue=ExcelUtility.getStringData(0, 1, Constants.LOGINSHEET);
			LoginPage login= new LoginPage(driver);
			login.enterUsernameonUsernameField(usernameValue).enterPasswordonPasswordField(passwordValue);
			home=login.clickOnLoginButton();
			home.clickAdmin();
			login=home.logout();
			String actual=home.isLoginTextDisplayed();
			String expected="7rmart supermarket";
			Assert.assertEquals(actual, expected,Constants.VALIDCREDENTIALERROR);
			
	 
	}
}